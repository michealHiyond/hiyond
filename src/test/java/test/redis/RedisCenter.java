package test.redis;


import java.io.Serializable;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author Hiyond
 *
 */
public class RedisCenter implements Serializable{

	private static final long serialVersionUID = -210844441232186492L;

	private volatile static RedisCenter redisCenter = null;
	
	private Jedis jedis;
	
	/**
	 * 构造方法
	 */
	private RedisCenter(){
		this.jedis = initJedisPool().getResource();
//		this.jedis.auth("hiyond123");
		this.jedis.auth("hiyond");
	}
	
	/**
	 * 初始化redis连接池
	 */
	private JedisPool initJedisPool(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(100);
		jedisPoolConfig.setMaxTotal(500);
		jedisPoolConfig.setMaxWaitMillis(1000*60);
		
//		String redisUrl = "192.168.1.165";
		String redisUrl = "127.0.0.1";
		int redisPort = 6379;
		JedisPool jedisPool = new JedisPool(jedisPoolConfig,redisUrl,redisPort);
		return jedisPool;
	}

	/**
	 * @return 返回jedis
	 */
	public static Jedis getJedis(){
		if(redisCenter == null){
			synchronized (RedisCenter.class) {
				if(redisCenter == null){
					redisCenter = new RedisCenter();
				}
			}
		}
		return redisCenter.jedis;
	}
	
}
