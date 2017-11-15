package tut20171025.aufgabe4;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageFrame extends JFrame{

	private ImagePanel panel;
	
	public ImageFrame() {
		panel = new ImagePanel();
		add(panel);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu file = new JMenu("File");
		menubar.add(file);
		
		JMenuItem openItem = new JMenuItem("Open");
		file.add(openItem);
		
		openItem.addActionListener(e -> openImage());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	private void openImage() {
		JFileChooser filechooser = new JFileChooser();
		int state = filechooser.showOpenDialog(null);
		if(state == JFileChooser.APPROVE_OPTION) {
			try {
				File file = filechooser.getSelectedFile();
				BufferedImage img = ImageIO.read(file);
				panel.setImg(img);
				setSize(panel.getPreferredSize());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new ImageFrame();
	}
}
