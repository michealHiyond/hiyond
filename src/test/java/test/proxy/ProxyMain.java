package test.proxy;


public class ProxyMain {

	public static void main(String[] args) {
		ProxyMain proxyMain = new ProxyMain();
		proxyMain.DynamicProxyTest();
		proxyMain.CglibProxyTest();
	}
	
	public void DynamicProxyTest(){
		System.out.println("DynamicProxyTest:");
		Hello hello = new HelloImpl();
		DynamicProxy dynamicProxy = new DynamicProxy(hello);
		Hello helloProxy = dynamicProxy.getProxy();
		helloProxy.speak("hiyond");
	}
	
	public void CglibProxyTest(){
		System.out.println("CglibProxyTest:");
		Hello hello = CglibProxy.getInstance().getProxy(HelloImpl.class);
		hello.speak("呵呵");
	}
	
}
