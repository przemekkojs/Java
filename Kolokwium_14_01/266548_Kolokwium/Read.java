package Zadanie2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

public class Read 
{		
	public static void ReadFromFile(String fileName)
	{
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));			
			BufferedWriter output = new BufferedWriter(new FileWriter("output2.txt"));		
			
			output.append("Wykaz towarow dostepnych\n");
			output.append("Lp.	Nazwa	Ilosc	Cena	Wartosc\n");
			
			int index = 0;
			
			String line = br.readLine();
			line = br.readLine();
			line = br.readLine();
			
			while(line != null && line != "")
			{				
				String[] help = line.split("\t");
				float value = Float.valueOf(help[1]) * Float.valueOf(help[2]);
				
				output.append(String.format("%d	%s	%f%n", index, line, value));				
				
				line = br.readLine();
				index++;
			}
			
			output.close();
			br.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Nie znaleziono pliku");
		} 
		catch (IOException e) 
		{
			System.out.println("Blad odczytu");
		}
	}
	
	static class CompareValue implements Comparator<String[]>
	{
		@Override
		public int compare(String[] o1, String[] o2) 
		{
			if(Integer.valueOf(o1[4]) > Integer.valueOf(o2[4]))
			{
				return 1;
			}
			else if(Integer.valueOf(o1[4]) < Integer.valueOf(o2[4]))
			{
				return -1;
			}
			
			return 0;
		}		
	}
}
