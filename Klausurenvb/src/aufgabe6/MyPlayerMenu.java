package aufgabe6;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyPlayerMenu extends JFrame{

	public MyPlayerMenu()
	{
		ArrayList<Player> players = new ArrayList<>();
		
		JMenuBar myMenuBar = new JMenuBar();
		JMenu playerMenu = new JMenu("Player");
		JMenuItem addPlayer = new JMenuItem("Add Player");
		JMenuItem removePlayer = new JMenuItem("Remove Player");
		
		myMenuBar.add(playerMenu);
		playerMenu.add(addPlayer);
		playerMenu.add(removePlayer);
		
		setJMenuBar(myMenuBar);
		
		addPlayer.addActionListener(e -> {
			String name = JOptionPane.showInputDialog(this, "Add Player\nName: ");
			players.add(new Player(name));
		});
		
		removePlayer.addActionListener(e -> {
			String name = JOptionPane.showInputDialog(this, "Reomve Player\n: ");
			
			for(Player user : players)
			{
				if(user.getName().equals(name))
				{
					players.remove(user);
				}
			}
		});;
		
		
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class Player {
		
		private String name;
		
		public Player (String name) 
		{
			this.name = name;
		}
		
		public String getName() 
		{
			return name;
		}
	}
}
