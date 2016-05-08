package test.spring;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import server.entity.User;
import server.service.UserService;
import server.tools.TimeUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/springApplication.xml"})
public class SpringJunitTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testUserAction() throws Exception{
		System.out.println(userService.getUser());
		System.out.println(userService.queryUser());
		String name = "hiyond_testNamed";
		Date lastLoginTime = new Date();
		User user = new User();
		user.setName(name);
		String dateType = "yyyy-MM-dd HH:mm:ss SSS";
		lastLoginTime = TimeUtils.util_timeFormat(TimeUtils.util_timeFormat(lastLoginTime,dateType),dateType);
		user.setLastLoginTime(lastLoginTime);
		System.out.println("flag:"+userService.insertUser(user));
	}
	
	@Test
	public void testTran() throws Exception{
		String name = "hiyond_testNamed";
		Date lastLoginTime = new Date();
		User user = new User();
		user.setName(name);
		String dateType = "yyyy-MM-dd HH:mm:ss SSS";
		lastLoginTime = TimeUtils.util_timeFormat(TimeUtils.util_timeFormat(lastLoginTime,dateType),dateType);
		user.setLastLoginTime(lastLoginTime);
		System.out.println("flag:"+userService.insertUser(user));
		System.out.println("--------------");
		System.out.println("flag:"+userService.updateUser(user));
	}
	
}
