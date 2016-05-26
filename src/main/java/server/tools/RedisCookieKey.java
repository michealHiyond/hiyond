package server.tools;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

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
		String key = userName + UUID.randomUUID().toString();
		System.out.println("生成的key:"+key);
		return key;
	}
	
	public static boolean setCookieRedis(User user,HttpServletResponse response){
		try {
			String jsonUser = JSONObject.fromObject(user).toString();
			String key = RedisCookieKey.getKey(user.getName());
			RedisUtils.setKey(key, jsonUser);
			//cookie操作
			CookieUtils.setCookie(response, Constant.COOKIE_AUTH_NAME, key, "", Constant.COOKIE_AUTH_NAME_EXPIRES);
			log.info("写入cookie与redis成功");
			return true;
		} catch (Exception e) {
			log.error("写入cookie与redis失败："+e);
			return false;
		}
	}

}
