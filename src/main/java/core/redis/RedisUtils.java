package core.redis;

import org.apache.commons.lang3.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis常用操作
 * 
 * @author hiyond
 *
 */
public class RedisUtils {

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		JedisPool jedispool = RedisCenter.getJedisPool();
		Jedis jedis = jedispool.getResource();
		String result = null;
		try {
			result = jedis.get(key);
		} catch (Exception e) {
		} finally {
			jedispool.returnResourceObject(jedis);
		}

		return result;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static boolean setKey(String key, String value) {
		JedisPool jedispool = RedisCenter.getJedisPool();
		Jedis jedis = jedispool.getResource();
		String result = null;
		try {
			result = jedis.set(key, value);
		} catch (Exception e) {
		} finally {
			jedispool.returnResourceObject(jedis);
		}
		return StringUtils.equals(result, "OK");
	}

}
