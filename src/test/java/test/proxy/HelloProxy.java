package test.proxy;

public class HelloProxy implements Hello{

	private Hello hello;
	
	public HelloProxy(){
		hello = new HelloImpl();
	}

	
	
	@Override
	public void speak(String string) {
		hello.speak(string);
	}
	
	public static void main(String[] args) {
		new HelloProxy().speak("hiyond");
	}
}
