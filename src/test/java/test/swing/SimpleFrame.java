package test.swing;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SimpleFrame extends JFrame{
	
	private static final long serialVersionUID = 7247284342280275172L;
	
	private final static int DEFAULT_WIDTH = 320;
	private final static int DEFAULT_HEIGHT = 220;
	
	public SimpleFrame(){
		
		setWindowSize();
	}
	
	public void setWindowSize(){
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int width = (int) (dimension.getWidth() / 2);
		int height = (int) (dimension.getHeight() / 2);
		
		if(width <=0 || height <= 0){
			setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		}else{
			setSize(width, height);
		}
		setImg();
		setLocationByPlatform(true);
	}
	
	public void setImg(){
		Image image = new ImageIcon("icon.png").getImage();
		setIconImage(image);
	}
}
