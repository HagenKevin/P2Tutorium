package tut20171122.simulation;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Simulation extends JFrame{

	private SimulationThread[] simulationThreads = new SimulationThread[4];
	private Thread[] threads = new Thread[4];
	
	public Simulation() 
	{
		Sitze sitze = new Sitze(40);
		JLabel[] seats = sitze.getSitze();
		
		JPanel gridPanel = new JPanel(new GridLayout(10, 4));
		add(gridPanel, BorderLayout.CENTER);
		
		for(int i = 0; i < seats.length; i++) {
			gridPanel.add(seats[i]);
		}
		
		JButton startBtn = new JButton("Simulation starten");
		startBtn.addActionListener(e-> {
			for(int i = 0; i < 4; i++) {
				simulationThreads[i] = new SimulationThread(sitze);
				threads[i] = new Thread(simulationThreads[i]);
				threads[i].start();
			}
		});
		
		add(startBtn, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(320, 240);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Simulation();
	}
}
