package tut20171122.simulation;

import java.util.Random;

public class SimulationThread implements Runnable {

	private Sitze sitze;
	private Random random;
	private int maxSeatplaceNumber;
	
	public SimulationThread(Sitze sitze) {
		this.sitze = sitze;
		maxSeatplaceNumber = this.sitze.getSitze().length;
		random = new Random();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(sitze.getAnzahlFreieSitze() > 0) 
		{
			try {
				Thread.sleep(random.nextInt(1000));
				int zuBuchendePlatznummer = random.nextInt(maxSeatplaceNumber);
				if(sitze.reservieren(zuBuchendePlatznummer))
					System.out.println("Platznummer: " + zuBuchendePlatznummer + " wurde gebucht");
				else
					System.out.println("Platz ist belegt: " + zuBuchendePlatznummer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
