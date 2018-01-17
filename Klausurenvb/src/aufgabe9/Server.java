package aufgabe9;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Da das Programm unvollständig ist (beispielsweise der Verbindungsaufbau fehlt)
 * wirft es Fehler in den Zeilen 28 und 37 - das hier ist aber auch nur der 
 * in der Klausur geforderte Teil.
 */

public class Server {
	
	private HashMap<String, Socket> user = new HashMap<>();
	private boolean isRunning = false;
	private Socket socket; 
	
	public Server() 
	{
		// hier wird die Verbindung zu dem User aufgebaut etc.
	}

	public void empfangen(Socket socket) 
	{
		String from = "";
		String to = "";
		String message = "";
		PrintWriter writeToOther;
		Scanner reader = socket.getInputStream();
		
		while (isRunning) {
			try 
			{
				from = reader.nextLine();
				to = reader.nextLine();
				message = reader.nextLine();
				
				writeToOther = new PrintWriter(user.get(to)).getOutputStream());
				
				writeToOther.println(message);
				writeToOther.flush();
				writeToOther.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}

/*	Fragen
 * 
 * 	Was ist ein Serversocket? Was kann der Server damit machen? Ein ServerSocket hat zwei Parameter, wofür
	stehen diese?
	
	Ein Server erstellt einen Serversocket, um über einen angegebenen Port auf eine Verbindungsanfrage eines
	Clients zu warten. Ein Serversocket hat die Parameter (int) port und die Anzahl der möglichen Verbindungen
	(int).
	
	Über welche Schnittstelle kommunizieren Client und Server mit einander?
	
	Über Sockets, ein Client baut ein Socket direkt auf, wenn er eine Verbindungsanfrage zu dem Server
	aufbaut. Der Server bekommt das Socket als Rückgabewert der accept-Methode, wenn ein sich Client mit
	dem Server verbunden hat.
 * 
 * 
 */
