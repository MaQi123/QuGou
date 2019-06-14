package com.taotao.rest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.rest.dao.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientSingle implements JedisClient {
	@Autowired
	private JedisPool jedispool;

	@Override
	public String get(String key) {
		Jedis jedis=jedispool.getResource();
		String string=jedis.get(key);
		jedis.close();
		return string;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis=jedispool.getResource();
		String string=jedis.set(key, value);
		jedis.close();
		return string;
	}

	@Override
	public String hget(String hkey, String key) {
		Jedis jedis=jedispool.getResource();
		String hget = jedis.hget(hkey, key);
		jedis.close();
		return hget;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis=jedispool.getResource();
		Long result = jedis.hset(hkey, key, value);
		jedis.close();
		return result;
	}

	@Override
	public long incr(String key) {
		Jedis jedis=jedispool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	@Override
	public long expire(String key, int second) {
		Jedis jedis=jedispool.getResource();
		Long result = jedis.expire(key,second);
		jedis.close();
		return result;
	}

	@Override
	public long ttl(String key) {
		Jedis jedis=jedispool.getResource();
		Long result = jedis.pttl(key);
		jedis.close();
		return result;
	}

	@Override
	public long del(String key) {
		Jedis jedis=jedispool.getResource();
		Long result = jedis.del(key);
		jedis.close();
		return result;
	}

	@Override
	public long hdel(String hkey, String key) {
		Jedis jedis=jedispool.getResource();
		Long result = jedis.hdel(hkey, key);
		jedis.close();
		return result;
	}

}
