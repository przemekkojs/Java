package Zadanie2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile 
{	
	public static ArrayList<Student> Read(String fileName)
	{
		ArrayList<Student> content = new ArrayList<>();		
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
			String line = br.readLine();
			
			int index = 0;
			
			while(line != null)
			{
				if(index > 1)
				{
					String[] tab = line.split(" ");					
					content.add(new Student(Integer.valueOf(tab[0]), (String) tab[1], tab[2], Float.valueOf(tab[3]), Float.valueOf(tab[4]), Float.valueOf(tab[5])));					
				}
				
				line = br.readLine();
				index++;
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Brak pliku");
		} 
		catch (IOException e) 
		{
			System.out.println("Blad");
		}
		
		return content;
	}
}
