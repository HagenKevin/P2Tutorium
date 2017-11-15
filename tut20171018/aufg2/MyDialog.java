package tut20171018.aufg2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyDialog extends JDialog {

	private JTextField nameField;
	private JTextField durField;
	private Song song;
	
	private boolean visible;
	
	public MyDialog(JFrame parent, String title, boolean modal, boolean visible) {
		super(parent, title, modal);
		this.visible = visible;
		
		JLabel nameLabel = new JLabel("Enter a songs name:");
		JLabel durLabel = new JLabel("Enter the songs duration in s:");
		JPanel centerPanel = new JPanel();		
		
		nameField = new JTextField(20);
		durField = new JTextField(20);
		JButton okButton = new JButton("Okay");
		
		centerPanel.setLayout(new GridLayout(2, 2));
		centerPanel.add(nameLabel);
		centerPanel.add(nameField);
		centerPanel.add(durLabel);
		centerPanel.add(durField);
		
		add(centerPanel, BorderLayout.CENTER);
		add(okButton, BorderLayout.SOUTH);
		
		okButton.addActionListener(e -> onClose());
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		pack();
		setVisible(visible);
	}
	
	private void onClose() {
		String name = nameField.getText();
		int duration = Integer.parseInt(durField.getText()); //falls wir einen Integer brauchen
		
		song = new Song(name, duration);
		System.out.println(song);
		
		nameField.setText("");
		durField.setText("");
		
		setVisible(false);
		dispose();
	}
	
	public Song getSong() {
		return song;
	}
}
