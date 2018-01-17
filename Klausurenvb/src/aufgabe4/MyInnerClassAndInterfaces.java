package aufgabe4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyInnerClassAndInterfaces implements Comparable<MyInnerClassAndInterfaces>{

	//Innere Klasse - Deklaration
	private class InnerClass {
		public InnerClass()
		{
			System.out.println("Im an object of an inner class!");
		}
	}
	
	//Innere Klasse - Instanziierung
	InnerClass innerClass = new InnerClass();
	
	//Innere anonyme Klasse
	ActionListener eventHandler = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("This is an example for an anonymous inner class.");
		}
	};
	
	private int randomScore;
	
	public MyInnerClassAndInterfaces(int randomScore) {
		this.randomScore = randomScore;
	}
	public int getPipeScore() {
		return randomScore;
	}

	@Override
	public int compareTo(MyInnerClassAndInterfaces o) {
		// TODO Auto-generated method stub
		if (randomScore > o.randomScore)
			return -1;
		else if (randomScore < o.randomScore)
			return 1;
		else {
			return 0;
		}
	}
}
