package test.spring;

import java.util.Date;
import org.springframework.context.ApplicationContext;

import server.entity.User;
import server.service.UserService;
import server.tools.ApplicationTest;
import server.tools.SpringTest;
import server.tools.SpringTestAuto;
import server.tools.TimeUtils;

public class SpringMainTest {

	public static void main(String[] args) throws Exception{
		String path = "classpath:springApplication.xml";
		ApplicationContext applicationContext = ApplicationTest.getInstance().getApplicationContext(path);
		test1(applicationContext);
//		test2(applicationContext);
//		test3(applicationContext);
//		test4();
//		test5(applicationContext);
	}
	
	public static void test1(ApplicationContext applicationContext) throws Exception{
		UserService userService = (UserService) applicationContext.getBean("userService");
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
	
	public static void test2(ApplicationContext applicationContext) {
		 SpringTest springTest = (SpringTest) applicationContext.getBean("springTest");
		 springTest.test();
	}
	
	public static void test3(ApplicationContext applicationContext) {
		SpringTest springTest1 = (SpringTest) applicationContext.getBean("springTest1");
		springTest1.test1();
	}
	
	public static void test4(){
		int a,b,c;
		a = 10;
		b = 20;
		c = 30;
		
		int z;
		
		z = (a > b ? a : b) > c ? (a > b ? a : b) : c;
		System.out.println(z);
	}
	
	public static void test5(ApplicationContext applicationContext){
		SpringTestAuto springTestAuto = (SpringTestAuto) applicationContext.getBean("springTestAuto");
		springTestAuto.test();
	}
	
}
