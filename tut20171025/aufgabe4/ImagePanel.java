package tut20171025.aufgabe4;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private BufferedImage img;
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		if(img != null)
			g.drawImage(img, 0, 0, null);
	}
	
	public void setImg(BufferedImage img) {
		this.img = img;
		repaint();
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		if(img != null) {
			return new Dimension(img.getWidth(), img.getHeight());
		}
		else 
			return new Dimension(250,250);
	}
}
