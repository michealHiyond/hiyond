package server.tools;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import core.constant.Constant;
import core.cookie.CookieUtils;
import core.redis.RedisUtils;
import net.sf.json.JSONObject;
import server.entity.User;

/**
 * 
 * @author Hiyond
 *
 */
public class RedisCookieKey {
	private static Logger log = Logger.getLogger(RedisCookieKey.class);

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public static String getKey(String userName) {
		String key = userName + UUIDTools.getUUID();
		System.out.println("生成的key:" + key);
		return key;
	}

	/**
	 * 在redis与cookie中存放用户信息
	 * 
	 * @param user
	 * @param response
	 * @param redisKey 如果不设置会生成一个key
	 * @return
	 */
	public static boolean setCookieRedis(User user, HttpServletResponse response, String redisKey) {
		try {
			String jsonUser = JSONObject.fromObject(user).toString();
			redisKey = StringUtils.isBlank(redisKey) ? RedisCookieKey.getKey(user.getName()) : redisKey;
			RedisUtils.setKey(redisKey, jsonUser, Constant.REDIS_AUTH_NAME_EXPIRES);
			// cookie操作
			CookieUtils.setCookie(response, Constant.COOKIE_AUTH_NAME, redisKey, Constant.COOKIE_PATH,
					Constant.COOKIE_AUTH_NAME_EXPIRES, Constant.COOKIE_DOMAIN);
			log.info("写入cookie与redis成功");
			return true;
		} catch (Exception e) {
			log.error("写入cookie与redis失败：" + e);
			return false;
		}
	}

}
