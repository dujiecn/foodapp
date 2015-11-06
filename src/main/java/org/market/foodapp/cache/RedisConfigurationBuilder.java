package org.market.foodapp.cache;

import java.io.IOException;
import java.util.Properties;

import org.apache.ibatis.cache.CacheException;
import org.springframework.core.io.support.PropertiesLoaderUtils;

final class RedisConfigurationBuilder {

	private static final RedisConfigurationBuilder INSTANCE = new RedisConfigurationBuilder();
	private static JedisConfig config;

	private RedisConfigurationBuilder() {
	}

	public static RedisConfigurationBuilder getInstance() {
		return INSTANCE;
	}

	public synchronized JedisConfig parseConfiguration() {
		if (config != null) {
			return config;
		}

		config = new JedisConfig();

		try {
			Properties prop = PropertiesLoaderUtils.loadAllProperties("config/redis.properties");
			config.setMinIdle(Integer.parseInt(prop.getProperty("redis.minIdle")));
			config.setMaxIdle(Integer.parseInt(prop.getProperty("redis.maxIdle")));
			config.setMaxTotal(Integer.parseInt(prop.getProperty("redis.maxTotal")));
			config.setMaxWaitMillis(Long.parseLong(prop.getProperty("redis.maxWaitMillis")));
			config.setTestOnBorrow(Boolean.parseBoolean(prop.getProperty("redis.testOnBorrow")));
			config.setTestOnReturn(Boolean.parseBoolean(prop.getProperty("redis.testOnReturn")));
			config.setPassword(prop.getProperty("redis.password"));
			config.setHost(prop.getProperty("redis.host"));
			config.setPort(Integer.parseInt(prop.getProperty("redis.port")));
			config.setTimeout(Integer.parseInt(prop.getProperty("redis.maxWait")));
			return config;
		} catch (IOException e) {
			throw new CacheException("create jedis pool error", e);
		}
	}

}
