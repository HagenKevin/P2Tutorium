package tut20171018.aufg2;

import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class MyNewFrame extends JFrame {

	private File file = new File("output.txt");
	
	private JButton addButton;
	private JButton saveButton;
	private JButton loadButton;
	private JTextField textField;
	
	private DefaultListModel<Song> model = new DefaultListModel<>();
	private JList<Song> songList;
	
	private MyDialog dlg;
	
	public MyNewFrame() {
		dlg = new MyDialog(this, "Add Song", true, false);
		addButton = new JButton("Add");
		saveButton = new JButton("Save");
		loadButton = new JButton("load");
		textField = new JTextField(20);
		songList = new JList<>(model);
		JScrollPane sPane = new JScrollPane(songList);
		
		JPanel panel = new JPanel();

		Box box = Box.createVerticalBox();
		box.add(addButton);
		box.add(saveButton);
		box.add(loadButton);
		
		setLayout(new FlowLayout());
		setTitle("Song");
		
		add(sPane);
		add(box);
		textField.setEditable(false);
		
		addButton.addActionListener(e -> showDlg());
		saveButton.addActionListener(e -> save());
		loadButton.addActionListener(e -> load());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	private void save() {
		try (
				PrintWriter fw = new PrintWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
			) {
			for(Object s : model.toArray()) {
				Song song = (Song) s;
				fw.println(song.getName());
				fw.println(song.getDuration());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
	}
	
	private void load() {
		try (
				FileReader reader = new FileReader(file);
				Scanner scanner = new Scanner(reader);
				){
			model.removeAllElements();
			while(scanner.hasNextLine())
			{
				String name = scanner.nextLine();
				int dur = Integer.parseInt(scanner.nextLine());
				Song song = new Song(name, dur);
				model.addElement(song);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void showDlg() {
		dlg.setVisible(true);
		Song song = new Song(dlg.getNameField().getText(), Integer.parseInt(dlg.getDurField().getText()));
		model.addElement(song);
		songList.setModel(model);
		dlg.getNameField().setText("");
		dlg.getDurField().setText("");
	}
	
	public void setTextFieldText(String text) {
		textField.setText(text);
	}
	
	public static void main(String[] args) {
		new MyNewFrame();
	}
}
