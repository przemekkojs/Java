package Zadanie2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Write 
{
	public static void WriteToFile(String fileName)
	{	
		try 
		{
			File file = new File(fileName);		
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output = new BufferedWriter(new FileWriter(file));			
			String line;
			try 
			{
				line = input.readLine();
				output.append("Wykaz towarów nr 12/2020\n");
				output.append("Nazwa_towaru	Ilosc_sztuk	Cena\n");
				
				while(line != null && line.length() > 0 && line != "stop")
				{
					output.append(line + "\n");
					line = input.readLine();
				}			
				
				output.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Blad czytania z klawiatury");
			}	
			
			input.close();
			output.close();
		} 
		catch (IOException e1) 
		{
			System.out.println("Blad");
		}		
	}
}
