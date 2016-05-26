package core.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import server.entity.User;

/**
 * 
 * @author admin
 *
 */
public class SessionUtils {

	private static final String SESSION_USER = "user";
	
	public static void addUserToSession(HttpServletRequest request ,User user){
		HttpSession session = request.getSession();
		session.setAttribute(SESSION_USER, user);
	}
	
	public static User getUserFromSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		return (User) session.getAttribute(SESSION_USER);
	}
	
}
