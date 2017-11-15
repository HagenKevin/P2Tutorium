package tut20171115;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PraxisUebung {

	public static void main(String[] args) {
		
		List<String> passwords = new ArrayList<>();
		passwords.add("admin"); //false
		passwords.add("root"); //false
		passwords.add("QWEqwe!!"); //false
		passwords.add("QWEqwe!!12"); //true
		passwords.add("QWEqwe12"); //false
		passwords.add("admin12"); //false
		
		//Filtert die Liste von Strings über die Stream API nach alles was kein gültiges Passwort ist
		//Regeln für Passwort:
		//- Mindestens 8 Zeichen lang
		//- Mindestens ein Groß, klein-Buchstabe ein Sonderzeichen und eine Zahl
		
		List<String> filteredList = passwords.stream()
				.filter(value -> value.length() >= 8)
				.filter(value -> checkForASCIICode(value, 48, 57)) // check for 0-9
				.filter(value -> checkForASCIICode(value, 97, 122)) //check for a-z
				.filter(value -> checkForASCIICode(value, 65, 90)) // check for A-Z
				.filter(value -> checkForSpecialSigns(value))
				.collect(Collectors.toList());
		
		//Danach die Zahlen aus dem Passwort holen und in einer List<Integer> speichern
		//Konsolenausgabe von allen Elemente die in der gefilterten Liste sind
		
		filteredList.forEach(System.out::println);
	}

	private static boolean checkForASCIICode(String value, int lowerBoundary, int upperBoundary) 
	{
		boolean isValid = false;
		
		for(int i = 0; i < value.length(); i++) {
			int currValue = (int) value.charAt(i);
			if(currValue >= lowerBoundary && currValue <= upperBoundary)
				isValid = true;
		}
		
		return isValid;
	}
	
	private static boolean checkForSpecialSigns(String value) {
		boolean isValid = false;
		
		for(int i = 0; i < value.length(); i++) {
			int currValue = (int) value.charAt(i);
			if(currValue >= 33 && currValue <= 47
					|| currValue >= 58 && currValue <= 64 
					|| currValue >= 91 && currValue <= 96 
					|| currValue >= 123 && currValue <= 126)
				isValid = true;
		}
		
		return isValid;
	}
}
