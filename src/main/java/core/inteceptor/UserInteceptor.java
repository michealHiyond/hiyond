package core.inteceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import core.constant.Constant;
import core.cookie.CookieUtils;
import core.redis.RedisUtils;
import core.session.SessionUtils;
import net.sf.json.JSONObject;
import server.entity.User;
import server.tools.RedisCookieKey;

/**
 * 自定义拦截器
 * 
 * @author Hiyond
 *
 */
public class UserInteceptor implements HandlerInterceptor {

	private Logger logger = Logger.getLogger(UserInteceptor.class);

	/**
	 * 登录URL
	 */
	private static final String LOGIN_URL = "/hiyond/user/login";

	/**
	 * 注册URL
	 */
	private static final String REGISTER_URL = "/hiyond/user/register";

	/**
	 * 跳转登录URL
	 */
	private static final String gotologin_URL = "/hiyond/user/gotologin";

	/**
	 * 登录成功后跳转到指定的页面URL
	 */
	private static final String gotologin_SUCCESS_URL = "/hiyond/user/views/home";

	/**
	 * 不拦截的URL
	 */
	private static Set<String> urlSet = new HashSet<String>();

	static {
		urlSet.add(LOGIN_URL);
		urlSet.add(REGISTER_URL);
		urlSet.add(gotologin_URL);
		urlSet.add(gotologin_SUCCESS_URL);
	}

	/**
	 * 执行完handler之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
	}

	/**
	 * 执行完handler之后，未返回视图
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 执行handler之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String url = request.getRequestURI();

		// 获取request中的Session信息，判断user信息
		User user = SessionUtils.getUserFromSession(request);
		if (user != null && user instanceof User) {
			logger.info(user + "访问地址，通过：" + url);
			return true;
		}

		// 根据前台的cookie信息
		String sessionKey = CookieUtils.cookieValue(request, Constant.COOKIE_AUTH_NAME);
		if (StringUtils.isBlank(sessionKey)) {
			// 特殊的URL不拦截
			if (urlSet.contains(url)) {
				logger.info("访问地址，通过：" + url);
				return true;
			}

			logger.info("访问地址，拦截：" + url);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return false;
		} else {
			String jsonStr = RedisUtils.getString(sessionKey);
			if (StringUtils.isBlank(jsonStr)) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return false;
			} else {
				user = (User) JSONObject.toBean(JSONObject.fromObject(jsonStr), User.class);
				SessionUtils.addUserToSession(request, user);
				RedisCookieKey.setCookieRedis(user, response, sessionKey);
				return true;
			}
		}

	}

}
