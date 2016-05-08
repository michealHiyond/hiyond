package test.swing;

import javax.swing.JFrame;

public class ThreadRunSwing implements Runnable{

	@Override
	public void run() {
		SimpleFrame simpleFrame = new SimpleFrame();
		simpleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		simpleFrame.setVisible(true);
	}
	
}
