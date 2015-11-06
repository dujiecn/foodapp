package org.market.foodapp.cache;

import redis.clients.jedis.JedisPoolConfig;

public class JedisConfig extends JedisPoolConfig {

	private String host;
	private String password;
	private int port = 6379;
	private int timeout;

	public JedisConfig() {
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}

}
