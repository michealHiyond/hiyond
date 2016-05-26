package core.redis;

import redis.clients.jedis.Jedis;

/**
 * redis常用操作
 * 
 * @author hiyond
 *
 */
public class RedisUtils {

	private static Jedis jedis = RedisCenter.getJedis();

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		String result = jedis.get(key);
		jedis.close();
		return result;
	}
	
	

}
