package tut20171122;

import java.util.Scanner;

public class ClockTask implements Runnable{

	private boolean stopRequest = false;
	private float seconds;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stopRequest) {
			try {
				Thread.sleep(100);
				seconds++;
				System.out.println(seconds/10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		stopRequest = true;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ClockTask uhr = new ClockTask();
		Thread thread = new Thread(uhr);
		scanner.nextLine();
		thread.start();		
		
		while(scanner.hasNextLine()) {
			uhr.stop();
		}
		
	}
}
