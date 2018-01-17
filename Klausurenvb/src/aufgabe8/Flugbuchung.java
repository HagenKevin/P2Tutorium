package aufgabe8;

import java.util.ArrayList;

public class Flugbuchung {

	private ArrayList<Flug> fluege;
	
	public Flugbuchung() 
	{
		fluege = new ArrayList<>();
	}
	
	public synchronized boolean buchen (Flug flug, int anzahlSitze) 
	{
		if (fluege.contains(flug)) 
		{
			int index = fluege.indexOf(flug);
			return fluege.get(index).reservieren(anzahlSitze);
		}
		
		return false;
		
	}
}
