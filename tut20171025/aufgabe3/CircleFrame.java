package tut20171025.aufgabe3;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;

public class CircleFrame extends JFrame {

	private CirclePanel panel;
	
	public CircleFrame () {
		panel = new CirclePanel();
		JSlider slider = new JSlider(0, 100, 50);
		
		slider.addChangeListener(e -> resizeCircle(slider.getValue()));
		
		add(panel, BorderLayout.CENTER);
		add(slider, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	private void resizeCircle(double percentage) {
		panel.setR(percentage);
	}
	
	public static void main(String[] args) {
		new CircleFrame();
	}
}
