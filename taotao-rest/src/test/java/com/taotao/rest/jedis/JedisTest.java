package com.taotao.rest.jedis;

import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	/**
	 * 单redis连接
	 */
	@Test
	public void testJedisSingle() {
		//创建一个jedis对象
			 Jedis jedis=new Jedis("192.168.117.117", 6379);
		//调用jedis对象的方法，方法名称和redis的命令一致
			 jedis.set("key1", "jedis Test");
			 String string=jedis.get("key1");
		System.out.println(string);	 
		//关闭jedis
		jedis.close();
	}
	
	/**
	 * 使用连接池
	 */
	@Test
	public void testJedisPool() {
		//创建jedis连接池
		JedisPool pool=new JedisPool("192.168.117.117", 6379);
		//从连接池中获得jedis对象
		Jedis jedis=pool.getResource();
		String string = jedis.get("key1");
		System.out.println(string);
		//关闭jedis
		jedis.close();
	}
	/**
	 * 连接集群redis
	 */
	@Test
	public void testJedisCluster() {
		HashSet<HostAndPort> nodes=new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("192.168.117.117", 7001));
		nodes.add(new HostAndPort("192.168.117.117", 7002));
		nodes.add(new HostAndPort("192.168.117.117", 7003));
		nodes.add(new HostAndPort("192.168.117.117", 7004));
		nodes.add(new HostAndPort("192.168.117.117", 7005));
		nodes.add(new HostAndPort("192.168.117.117", 7006));
		JedisCluster cluster=new JedisCluster(nodes);
		cluster.set("key1", "10000");
		String string = cluster.get("key1");
		System.out.println(string);
		cluster.close();
	}
	
	/**
	 * Spring中配置redis单机测试
	 */
	@Test
	public void testSpringJedisSingle() {
		//读取spring配置
		ApplicationContext JeapplicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisPool pool = (JedisPool) JeapplicationContext.getBean("redisClient1");
		Jedis jedis = pool.getResource();
		String string = jedis.get("key1");
		System.out.println(string);
		jedis.close();
		pool.close();
		
	}
	
	/**
	 * Spring中配置redis集群模式
	 */
	@Test
	public void testSpringJedisCluster() {
		
		ApplicationContext JeapplicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisCluster jedisCluster = (JedisCluster) JeapplicationContext.getBean("redisClient2");
		String string = jedisCluster.get("key1");
		System.out.println(string);
		jedisCluster.close();
	}
}
