package org.dj.common.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.cache.Cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public final class MybatisRedisCache implements Cache {
	private Log log = LogFactory.getLog(getClass());

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	/*
	 * 不同的key下面的关联的表
	 */

	private static Map<String, Map<String, Object>> keysMap = new HashMap<>();

	private final String KEY_PREFIX = "mybatis:cache:";

	private String id;

	private static JedisPool pool;

	public MybatisRedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("Cache instances require an ID");
		}
		this.id = id;
		JedisConfig config = RedisConfigurationBuilder.getInstance().parseConfiguration();
		pool = new JedisPool(config, config.getHost(), config.getPort(), config.getTimeout(), config.getPassword());
	}

	private interface RedisCallback {

		Object doWithRedis(Jedis jedis);
	}

	private Object execute(RedisCallback callback) {
		Jedis jedis = pool.getResource();
		try {
			return callback.doWithRedis(jedis);
		} finally {
			jedis.close();
		}
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public int getSize() {
		return (Integer) execute(new RedisCallback() {
			public Object doWithRedis(Jedis jedis) {
				Map<byte[], byte[]> result = jedis.hgetAll(getKey().getBytes());
				return result.size();
			}
		});
	}

	@Override
	public void putObject(final Object key, final Object value) {
		execute(new RedisCallback() {
			public Object doWithRedis(Jedis jedis) {
				if (log.isDebugEnabled()) {
					log.debug("添加缓存==============>" + getKey() + "." + getHashKey(key));
				}
				jedis.hset(getKey().getBytes(), getHashKey(key).getBytes(), SerializeUtil.serialize(value));

				// 保存加入缓存的关联的表
				synchronized (keysMap) {
					// select begin : end
				}

				return null;
			}
		});
	}

	private String getKey() {
		return KEY_PREFIX + id.toString();
	}

	private String getKeys() {
		return KEY_PREFIX + "*";
	}

	private String getHashKey(Object key) {
		// HashCodeBuilder builder = new HashCodeBuilder();
		// return builder.append(key).hashCode() + "";
		return DigestUtils.md5Hex(key.toString());
	}

	@Override
	public Object getObject(final Object key) {
		return execute(new RedisCallback() {
			public Object doWithRedis(Jedis jedis) {
				if (log.isDebugEnabled()) {
					log.debug("获取缓存==============>" + getKey() + "." + getHashKey(key));
				}
				return SerializeUtil.unserialize(jedis.hget(getKey().getBytes(), getHashKey(key).getBytes()));
			}
		});
	}

	@Override
	public Object removeObject(final Object key) {
		return execute(new RedisCallback() {
			public Object doWithRedis(Jedis jedis) {
				if (log.isDebugEnabled()) {
					log.debug("删除缓存==============>" + getKey() + "." + getHashKey(key));
				}
				return jedis.hdel(getKey(), getHashKey(key));
			}
		});
	}

	@Override
	public void clear() {
		execute(new RedisCallback() {
			public Object doWithRedis(Jedis jedis) {
				if (log.isDebugEnabled()) {
					log.debug("清空缓存==============>:" + getKey());
				}
				
				 jedis.del(getKey());

//				Set<byte[]> keys = jedis.keys(getKeys().getBytes());
//				for (byte[] key : keys) {
//					jedis.del(key);
//				}
				
				return null;
			}
		});

	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	@Override
	public String toString() {
		return "Redis {" + id + "}";
	}

	public static void main(String[] args) {
		MybatisRedisCache cache = new MybatisRedisCache("abc");
		cache.putObject("acscs", "1111");
	}
}
