package tut20171025.aufgabe2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	private Random random = new Random();
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		int w = (int) getSize().getWidth();
		int h = (int) getSize().getHeight();
		
		for(int i = 0; i < 1000; i++) {
			g.setColor(choseColor());
			
			g.fillOval(random.nextInt(w-20), random.nextInt(h-20), 20, 20);
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(250, 250);
	}
	
	private Color choseColor() {
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		
		return new Color(r,g,b);
	}
}
