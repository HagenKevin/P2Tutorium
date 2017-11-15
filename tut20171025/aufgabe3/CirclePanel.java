package tut20171025.aufgabe3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CirclePanel extends JPanel {

	private int rW = 50;
	private int rH = 50;
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		int w = (int) getSize().getWidth();
		int h = (int) getSize().getHeight();
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, w, h);
		
		g.setColor(Color.GREEN);
		g.fillOval(w/2-rW/2, h/2-rH/2, rW, rH);
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(200, 200);
	}
	
	public void setR(double percentage) {
		this.rW= (int) (getSize().getWidth() * (percentage/100));
		this.rH= (int) (getSize().getHeight() *  (percentage/100));
		repaint();
	}
}
