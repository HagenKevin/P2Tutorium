package aufgabe3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MyFileIO extends JFrame {

	public MyFileIO() 
	{
		JFileChooser fc = new JFileChooser();
		
		if(JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null))
		{
			File file = fc.getSelectedFile();
			File fileOut = new File("Output: " + file.getName());
			
			try 
			{
				FileReader in = new FileReader(file);
				BufferedReader bufRead = new BufferedReader(in);
				
				FileWriter out = new FileWriter(fileOut);
				BufferedWriter bufWrite = new BufferedWriter(out);
				
				String line = bufRead.readLine();
				
				while(line != null) 
				{
					if(line.length() > 0 && line.charAt(0) != '#')
					{
						bufWrite.write(line);
						bufWrite.newLine();
					}
					else if (line.length() == 0)
					{
						bufWrite.newLine();
					}
					
					line = bufRead.readLine();
				}
				
				in.close();
				bufRead.close();
				out.close();
				bufWrite.close();
			}
			catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		else
			System.out.println("Open File failed.");

	}
	public static void main(String[] args) {
		new MyFileIO();
	}
}
/*
Der FileWriter hat den Konstruktor FileWriter (File file, boolean append). Erklären Sie die beiden
Parameter.

Der FileWriter braucht eine Datei in die er schreiben kann, diese Datei ist der erste Parameter.
Der zweite bestimmt, ob die Datei überschrieben werden soll (false) oder ob der Inhalt an die
bestehende Datei angehängt werden soll.

Wofür ist beim JFileChooser die Konstante APPROVE_OPTION?

Wenn ein Open- oder SaveFileDialog angezeigt wird, kann der User eine Datei auswählen und
mit ok/yes den Vorgang abschließen, in diesem Fall ist der Rückgabe Wert APPROVE_OPTION.
Zur Info: Es gibt auch die Rückgabewerte CANCEL_OPTION (Cancel Button wurde gedrückt) und
ERROR_OPTION (Ein Fehler ist aufgetreten).

Wofür gibt es beim BufferedWriter die Methode newLine()?

Wenn man einen Zeilenumbruch in einer Datei haben möchte, funktioniert ein „\n“ nicht
immer. Das ist abhängig vom laufenden Betriebssystem. Manchmal muss man ein Carriage
Return „\r“ mit einem „\n“ verbinden. Um diese Problematik zu umgehen, gibt es die Methode
newLine(), die automatisch erkennt welche Steuerzeichen gesetzt werden müssen.
*/