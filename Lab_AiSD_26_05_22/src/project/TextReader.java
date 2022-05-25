package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public class TextReader 
{
	private BufferedReader bufferedReader;
	
	public TextReader(String _path)
	{
		try 
		{
			bufferedReader = new BufferedReader(new FileReader(new File(_path)));
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("Nie znaleziono pliku");
			System.exit(-1);
			e.printStackTrace();
		}
	}
	
	public Vector<Word> readText()
	{
		Vector<Word> res = new Vector<Word>();
		int verse = 1;
		int id = 0;
		
		String line;
		try 
		{
			line = bufferedReader.readLine();
			
			while(line != null)
			{
				String[] words = line.split(" ");
				
				for(int i = 0; i < words.length; i++)
				{					
					words[i] = words[i].replace(",", "");
					words[i] = words[i].replace(".", "");
				}
				
				for(int i = 0; i < words.length; i++)
				{
					if(words[i].equals("-")) continue;
					int size = res.size();
					boolean added = false;
					
					for(int j = 0; j < size; j++)
					{
						if(res.elementAt(j).word().equals(words[i]))
						{
							res.elementAt(j).addNumber(verse);		
							added = true;
						}
					}
					
					if(!added) res.add(new Word(words[i], verse, id));
					id++;
				}
				
				verse++;
				line = bufferedReader.readLine();
			}
		} 
		catch (IOException e) 
		{
			System.err.println("Blad odczytu");
			System.exit(-1);
			e.printStackTrace();
		}
		
		try 
		{
			bufferedReader.close();
		} 
		catch (IOException e) 
		{
			System.err.println("B³¹d");
			System.exit(-1);
			e.printStackTrace();
		}
		
		Collections.sort(res);
		return res;
	}
}
