package server.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Hiyond
 *
 */
public class ApplicationTest {
	
	private volatile static ApplicationTest applicationTest;
	
	private ApplicationTest(){
	}
	
	public static ApplicationTest getInstance(){
		if(applicationTest == null){
			synchronized(ApplicationTest.class){
				applicationTest = new ApplicationTest();
			}
		}
		return applicationTest;
	}
	
	/**
	 * 加载ApplicationContext
	 * @param path ：Spring 上下文xml文件路径
	 * @return
	 */
	public ApplicationContext getApplicationContext(String path){
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
		
		return applicationContext;
	}
}
