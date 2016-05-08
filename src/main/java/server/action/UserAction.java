package server.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import server.entity.User;
import server.service.UserService;
import server.tools.TimeUtils;
import server.tools.Tools;

/**
 * 
 * @author Hiyond
 *         
 */

@Controller
@RequestMapping("/user")
public class UserAction {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/gotologin", method = { RequestMethod.POST, RequestMethod.GET })
    public String gotologin(Model model, HttpServletRequest request, HttpServletResponse response) {
        String rebackUrl = request.getHeader("referer");
        System.out.println(request.getSession().getServletContext().getRealPath("/"));
        model.addAttribute("rebackUrl", rebackUrl);
        return "user/user";
    }
    
    @RequestMapping(value = "/login", method = { RequestMethod.POST })
    public String login(Model model, HttpServletRequest request, HttpServletResponse response, User user,
            String rebackUrl) throws Exception {
        String refererUrl = rebackUrl;
        int userNum = userService.loginUser(user);
        if (userNum > 0) {
            Date lastLoginTime = new Date();
            String dateType = "yyyy-MM-dd HH:mm:ss";
            lastLoginTime = TimeUtils.util_timeFormat(TimeUtils.util_timeFormat(lastLoginTime, dateType), dateType);
            user.setLastLoginTime(lastLoginTime);
            userService.updateUser(user);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user);
            model.addAttribute(user);
            return "redirect:" + refererUrl;
        } else {
            return "views/error";
        }
    }
    
    @RequestMapping(value = "/register", method = { RequestMethod.POST })
    public String register(HttpServletRequest request, HttpServletResponse response, User user, Model model)
            throws Exception {
        int userNum = userService.findUserByName(user);
        if (userNum > 0) {
            return "";
        }
        Date lastLoginTime = new Date();
        String dateType = "yyyy-MM-dd HH:mm:ss";
        lastLoginTime = TimeUtils.util_timeFormat(TimeUtils.util_timeFormat(lastLoginTime, dateType), dateType);
        user.setLastLoginTime(lastLoginTime);
        user.setUUID(Tools.getUUID());
        userService.insertUser(user);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user", user);
        model.addAttribute("user", user);
        
        return "views/home";
    }
}
