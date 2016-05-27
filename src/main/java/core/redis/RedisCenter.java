package core.redis;

import java.io.Serializable;
import java.util.Properties;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import core.constant.Constant;
import core.properties.PropertiesUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @author Hiyond
 *
 */
@Component("redisCenter")
public class RedisCenter implements Serializable {

	private static final long serialVersionUID = -210844441232186492L;

	private static Logger logger = Logger.getLogger(RedisCenter.class);

	private static JedisPool jedisPool = null;

	static {
		logger.info("加载redis配置信息...");
		Properties redisProperties = PropertiesUtil.getProperties(Constant.REDIS_PATH);
		if (redisProperties != null) {
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			jedisPoolConfig.setMaxActive(NumberUtils.toInt(redisProperties.getProperty("maxActive")));
			jedisPoolConfig.setMaxIdle(NumberUtils.toInt(redisProperties.getProperty("maxIdle")));
//			jedisPoolConfig.setMaxTotal(NumberUtils.toInt(redisProperties.getProperty("maxTotal")));
			jedisPoolConfig.setMaxWait(NumberUtils.toInt(redisProperties.getProperty("maxWait")));
			String redisUrl = redisProperties.getProperty("url");
			int redisPort = NumberUtils.toInt(redisProperties.getProperty("port"));
			String password = redisProperties.getProperty("password");
			int timeout = NumberUtils.toInt(redisProperties.getProperty("timeout"));
			jedisPool = new JedisPool(jedisPoolConfig, redisUrl, redisPort, timeout, password);
			logger.info("加载redis配置信息成功！");
		}
	}

	public static JedisPool getJedisPool() {
		return jedisPool;
	}

	public static void main(String[] args) {
		JedisPool jedispool = getJedisPool();
		Jedis jedis = jedispool.getResource();
		System.out.println(jedis.ping());
		jedispool.returnResource(jedis);
	}

}
