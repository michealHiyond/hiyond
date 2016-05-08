package core.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 自定义拦截器
 * @author Hiyond
 *
 */
public class UserInteceptor implements HandlerInterceptor{

	/**
	 * 执行完handler之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
	        throws Exception {
	}

	/**
	 * 执行完handler之后，未返回视图
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
	        throws Exception {
	}

	/**
	 * 执行handler之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		System.out.println("UserInteceptor-preHandle");
		String url = request.getRequestURI();
//		System.out.println(url);
		if(url.indexOf("user") >= 0){
			return true;
		}else if(url.indexOf("assets") >= 0){
			return true;
		}
		return false;
	}

}
