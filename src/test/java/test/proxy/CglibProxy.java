package test.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private volatile static CglibProxy cglibProxy;
	
	private CglibProxy(){
	}
	
	public static CglibProxy getInstance(){
		if(cglibProxy == null){
			synchronized(CglibProxy.class){
				cglibProxy = new CglibProxy();
			}
		}
		return cglibProxy;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> clazz){
		return (T) Enhancer.create(clazz, this);
	}
	
	@Override
	public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		before();
		Object result = methodProxy.invokeSuper(object, objects);
		after();
		return result;
	}

	public void before(){
		System.out.println("before");
	}
	
	public void after(){
		System.out.println("after");
	}
	
}
