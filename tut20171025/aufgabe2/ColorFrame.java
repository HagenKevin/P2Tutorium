package tut20171025.aufgabe2;

import javax.swing.JFrame;

public class ColorFrame extends JFrame {

	public ColorFrame() {
		
		ColorPanel panel = new ColorPanel();
		
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ColorFrame();
	}
}
