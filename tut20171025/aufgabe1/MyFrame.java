package tut20171025.aufgabe1;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	private SchachbrettPanel panel;
	
	public MyFrame() {
		
		panel = new SchachbrettPanel();
		
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
