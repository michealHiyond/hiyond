package core.redis;

import org.apache.commons.lang3.StringUtils;

import core.constant.Constant;
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
	 * 获取指定的key
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		JedisPool jedispool = null;
		Jedis jedis = null;
		String result = null;
		try {
			jedispool = RedisCenter.getJedisPool();
			jedis = jedispool.getResource();
			result = jedis.get(key);
		} catch (Exception e) {
			if(jedis != null){
				jedispool.returnBrokenResource(jedis);
			}
		} finally {
			if(jedis != null){
				jedispool.returnResourceObject(jedis);
			}
		}

		return result;
	}

	/**
	 * redis存放
	 * @param key
	 * @param value
	 * @param expires 过期时间如果不设置会使用默认的  @see core.constant.Constant.REDIS_AUTH_NAME_EXPIRES
	 * @return
	 */
	public static boolean setKey(String key, String value,Integer expires) {
		JedisPool jedispool = null;
		Jedis jedis = null;
		String result = null;
		try {
			jedispool = RedisCenter.getJedisPool();
			jedis = jedispool.getResource();
			result = jedis.set(key, value);
			expires = (expires == null) ? Constant.REDIS_AUTH_NAME_EXPIRES : expires;
			jedis.expire(key, expires);
		} catch (Exception e) {
			if(jedis != null){
				jedispool.returnBrokenResource(jedis);
			}
		} finally {
			if(jedis != null){
				jedispool.returnResourceObject(jedis);
			}
		}
		return StringUtils.equals(result, "OK");
	}

}
