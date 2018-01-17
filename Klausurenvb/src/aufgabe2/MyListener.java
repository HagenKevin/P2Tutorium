package aufgabe2;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MyListener extends JFrame {

	
	public MyListener() 
	{
		JCheckBox checkBox1 = new JCheckBox("Option A");
		JCheckBox checkBox2 = new JCheckBox("Option B");

		JRadioButton radioBtn1 = new JRadioButton("Radio1");
		JRadioButton radioBtn2 = new JRadioButton("Radio2");
		
		radioBtn1.addActionListener(e-> actionAlert(radioBtn1.getText()));
		radioBtn2.addActionListener(e-> actionAlert(radioBtn2.getText()));
		checkBox1.addActionListener(e-> actionAlert(checkBox1.getText()));
		checkBox2.addActionListener(e-> actionAlert(checkBox2.getText()));
		
		radioBtn1.addItemListener(e-> itemAlert(radioBtn1.getText()));
		radioBtn2.addItemListener(e-> itemAlert(radioBtn2.getText()));
		checkBox1.addItemListener(e-> itemAlert(checkBox1.getText()));
		checkBox2.addItemListener(e-> itemAlert(checkBox2.getText()));
		
		//Hier ist der Unterschied: In einer Buttongroup wird bei einem Wechsel von einem zum anderen Button
		//Der ItemListener an BEIDEN (altem + neuen Objekt), der ActionListener nur am neuen getriggert.
		ButtonGroup myGroup = new ButtonGroup();
		myGroup.add(checkBox1);
		myGroup.add(checkBox2);
		myGroup.add(radioBtn1);
		myGroup.add(radioBtn2);
		
		Box box = Box.createHorizontalBox();
		
		box.add(radioBtn1);
		box.add(radioBtn2);
		box.add(checkBox1);
		box.add(checkBox2);
		
		add(box);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyListener();
	}
	
	private void actionAlert(String name)
	{
		System.out.println("ActionListener for " + name + "!");
	}
	
	private void itemAlert(String name)
	{
		System.out.println("ItemListener for " + name + "!");
	}
}

/*
 * Wo könnte man einen FocusListener nutzen?
 * 
 * Beispielsweise, wenn der User in einem Textfeld zuerst einen Hinweis für den Input kriegen soll.
 * Sobald er es anwählt, löscht sich die Schrift und er kann reinschreiben. Dafür brauch man den FocusListener
 */
