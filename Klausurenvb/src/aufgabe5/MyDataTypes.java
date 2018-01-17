package aufgabe5;

import java.util.HashMap;

public class MyDataTypes {

	public MyDataTypes() 
	{
		HashMap<String, Integer> myMap = new HashMap<>();
		
		//2 Werte anlegen
		myMap.put("String1", 0);
		myMap.put("String2", 42);
		//Werte abfragen
		System.out.println(myMap.get("String1"));
		System.out.println(myMap.get("String2"));
		//Wert für Key 1 überschreiben
		myMap.put("String1", myMap.get("String1") + 1);
		System.out.println(myMap.get("String1"));
		
		//alle k/v paare ausgeben
		for(String key : myMap.keySet())
		{
			System.out.println("Key: " + key + ", Value: " + myMap.get(key));
		}
	}
}
/*	Fragen:
 
	Wann würden Sie eine Hashmap verwenden?
	
	Wenn ich zwei zusammenhängende Datenpaare speichern möchte und das möglichst effizient
	geschehen soll. Also z.B. ein Buch als Key und die Anzahl des Buchs in einer Bibliothek als Value.
	
	Wann würden Sie ein Array und wann eine ArrayListe verwenden?
	
	Ein Array würde ich dann verwenden, wenn die Anzahl der Elemente feststehen. Ein Array ist
	effizienter als eine ArrayListe. Steht die Anzahl der Elemente einer Liste nicht fest, nimmt man
	eine ArrayListe.
*/