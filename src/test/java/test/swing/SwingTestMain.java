package test.swing;

import java.awt.EventQueue;

public class SwingTestMain {

	public static void main(String[] args) {
		
		ThreadRunSwing threadRunSwing = new ThreadRunSwing();
		EventQueue.invokeLater(threadRunSwing);
		
	}
	
}
