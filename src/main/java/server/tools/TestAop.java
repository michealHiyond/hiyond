package server.tools;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * @author Hiyond
 *        
 */
public class TestAop {
	
	public void testBefore() {
		System.out.println("AOP : testBefore");
	}
	
	public void testAfter() {
		System.out.println("AOP : testAfter");
	}
	
	public void testAround(ProceedingJoinPoint proceedingJoinPoint){
		try {
			System.out.println("AOPAround : testBefore");
			proceedingJoinPoint.proceed();
			System.out.println("AOPAround : testAfter");
		} catch (Throwable e) {
			System.out.println("Around : Error");
			e.printStackTrace();
		}
	}
	
	public void testPara(String string){
		System.out.println("testPara : "+string);
	}
}
