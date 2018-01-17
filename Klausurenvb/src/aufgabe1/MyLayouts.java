package aufgabe1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyLayouts extends JFrame{

	public MyLayouts() 
	{
		JLabel helloLabel = new JLabel("Hello");
		JTextField textArea = new JTextField(10);
		JButton clickMeBtn = new JButton("Click Me");
		
//		//BorderLayout
		add(helloLabel, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(clickMeBtn, BorderLayout.SOUTH);
		
		//BoxLayout
//		Box box = Box.createVerticalBox();
//		box.add(helloLabel);
//		box.add(textArea);
//		box.add(clickMeBtn);
//		add(box);
		
//		//FlowLayout
//		setLayout(new FlowLayout());
		
		//GridLayout
//		setLayout(new GridLayout(3, 1));

//		add(helloLabel);
//		add(textArea);
//		add(clickMeBtn);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(300, 300);
	}
	
	public static void main(String[] args) {
		new MyLayouts();
	}
}

/*
 * 	Fragen:
 * 	Wie kann man mehrere Layouts in einem Fenster mit einander kombinieren? Welche
	Komponente oder welchen Container braucht man dazu?
	
	Man braucht dafür JPanels, jedes JPanel bekommt dabei ein eigenes Layout und kann in diesem
	Layout wieder ein JPanel (Container) enthalten.
	(Der Vollständigkeitshalber sei erwähnt, dass natürlich auch ein JFrame ein Layout hat und dem
	JFrame können JPanels hinzugefügt werden.)
	
	Sie möchten zwischen bestimmten Komponenten Platzhalter hinzufügen, welches Layout
	brauchen Sie und wie sieht die Anweisung aus, in der Sie einen Platzhalter hinzufügen?
	
	Man braucht das BoxLayout. Die Anweisung lautet:
	add (Box. CreateHorizonalStrut (5));
	
	Was ist eine JList?
	
	Eine graphische Liste.
	
	Wie kann man zu einer JList Elemente hinzufügen?
	
	DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> list = new JList<>(model);
	
	String elem1 = "testData";
	model.addElement(elem1);
 */
