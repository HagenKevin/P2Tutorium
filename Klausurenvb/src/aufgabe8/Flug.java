package aufgabe8;

import java.util.Date;

public class Flug {
	
	private Date zeit;
	private String startFH;
	private String zielFH;
	private int freieSitze;

	// hier gibt es noch weitere Methoden wie Getter und einen Konstruktor
	public boolean reservieren(int sitze) 
	{
		if (freieSitze >= sitze) {
			freieSitze -= sitze;
			return true;
		}
		return false;
	}

	public boolean equals(Flug other) 
	{
		if (!startFH.equals(other.startFH)) 
		{
			return false;
		}
		if (!zeit.equals(other.zeit)) 
		{
			return false;
		}
		if (!zielFH.equals(other.zielFH)) 
		{
			return false;
		}
		return true;
	}
}
