package test.proxy;

public class HelloImpl implements Hello{

	@Override
	public void speak(String string) {
		System.out.println(string);
	}

}
