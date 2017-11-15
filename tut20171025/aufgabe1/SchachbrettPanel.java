package tut20171025.aufgabe1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SchachbrettPanel extends JPanel {

	public SchachbrettPanel() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(i%2==0) {
					if(j%2==0) {
						g.setColor(Color.BLACK);
					}
					else 
					{
						g.setColor(Color.WHITE);
					}
				}
				else 
				{
					if(j%2==0) {
						g.setColor(Color.WHITE);
					}
					else 
					{
						g.setColor(Color.BLACK);
					}
				}
				
				g.fillRect(20 * j , 20 * i, 20, 20);
			}
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(200, 200);
	}
}
