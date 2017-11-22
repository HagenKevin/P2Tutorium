package tut20171122.simulation;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Sitze {

	private JLabel[] sitze;
	private int anzahlFreieSitze;
	
	//konstruktor: initialisiert jlabels (sitze) 
	public Sitze(int anzahlSitze) {
		sitze = new JLabel[anzahlSitze];
		
		for(int i = 0; i < anzahlSitze; i++) {
			sitze[i] = new JLabel();
			sitze[i].setBackground(Color.green);
			sitze[i].setOpaque(true);
			sitze[i].setBorder(BorderFactory.createLineBorder(Color.black));
		}
		
		anzahlFreieSitze = anzahlSitze;
	}
	
	//reservieren -> gibt bool zurück && true: -> jlabel = rot
	synchronized public boolean reservieren(int platznummer) {
		boolean isSuccesful = false;
		
		if(sitze[platznummer].getBackground() == Color.green)
		{
			isSuccesful = true;
			anzahlFreieSitze--;
			sitze[platznummer].setBackground(Color.red);
		}
		
		return isSuccesful;
	}
	
	
	public int getAnzahlFreieSitze() {
		return anzahlFreieSitze;
	}
	
	public int getAnzahlSitze() {
		return sitze.length;
	}
	
	public JLabel[] getSitze() {
		return sitze;
	}
}
