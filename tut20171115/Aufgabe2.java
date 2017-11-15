package tut20171115;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Aufgabe2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bitte einen Text eingeben:");
		
		String text = scanner.nextLine();
		
		String[] splitted = text.split(" ");
	
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		for(int i = 0; i < splitted.length; i++) {
			
			if(splitted[i].length() > 0)
			{
				if(dictionary.containsKey(splitted[i])) {
					dictionary.put(splitted[i], dictionary.get(splitted[i]) + 1);
				}
				else
				{
					dictionary.put(splitted[i], 1);
				}
			}
		}
		
		for(String s : dictionary.keySet()) {
			System.out.println(s + ": " + dictionary.get(s));
		}
		
		ArrayList<String> list = new ArrayList<String>(dictionary.keySet());
		
		Collections.sort(list, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(dictionary.get(s1), dictionary.get(s2));
			}
		});
		
		System.out.println(list);
	}
}
