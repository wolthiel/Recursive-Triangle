package STriangle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class STriangle {
	static JFrame frame;
	
	public static void main(String[] args) {
		frameSetup();
		drawTriangles();
	}
	
	private static void frameSetup() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame = new JFrame("Sierpinksi Triangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.black);
		frame.setSize(screenSize.width, screenSize.height);
	}
	
	private static void drawTriangles() {
		frame.add(new SPanel());
		frame.setVisible(true);
	}
	
}
