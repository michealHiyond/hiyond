package core.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import core.constant.Constant;

/**
 * 
 * @author hiyond
 *
 */
public class CookieUtils {

	/**
	 * 获取指定的cookie
	 * 
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String cookieValue(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = getCookies(request);
		for (Cookie cookie : cookies) {
			if (StringUtils.equals(cookieName, cookie.getName())) {
				return cookie.getValue();
			}
		}
		return null;
	}

	/**
	 * 获取Cookie数组
	 * 
	 * @param request
	 * @return
	 */
	public static Cookie[] getCookies(HttpServletRequest request) {
		return request.getCookies();
	}

	/**
	 * 设置cookie
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param path 路径，如果不设置默认为"/"
	 * @param expiry
	 * @param domain 作用域：默认为 @see {@link Constant.COOKIE_DOMAIN}
	 */
	public static void setCookie(HttpServletResponse response, 
			String cookieName, String cookieValue, String path,
			Integer expiry, String domain) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		path = StringUtils.isNoneBlank(path) ? path : "/";
		cookie.setPath(path);
		cookie.setMaxAge(expiry);
		if(StringUtils.isNoneBlank(domain)){
			cookie.setDomain(domain);
		}
		// cookie.setSecure(flag);
		response.addCookie(cookie);
	}
	
//	public boolean CookieIsExpire(Cookie cookie){
//		int flag = cookie.getMaxAge();
//	}

}
