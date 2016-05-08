package test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

	private Object object;

	public DynamicProxy(Object object) {
		super();
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object result = method.invoke(object, args);
		after();
		return result;
	}

	public void before(){
		System.out.println("before");
	}
	
	public void after(){
		System.out.println("after");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(){
		return (T) Proxy.newProxyInstance(
				this.object.getClass().getClassLoader(),
				this.object.getClass().getInterfaces(),
				this
			);
	}

}
