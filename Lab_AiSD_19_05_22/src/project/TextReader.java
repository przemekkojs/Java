package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReader 
{
	private BufferedReader br;
	private int[] quantities;
	private char[] characters;
	private String text;
	
	public TextReader(String path)
	{
		try 
		{
			br = new BufferedReader(new FileReader(new File(path)));
			
			String line = br.readLine();
			text = line;
			int count = 0;
			
			int[] array = new int[256];
			
			for(int i = 0; i < line.length(); i++)
			{				
				if(array[line.charAt(i)]++ == 0) count++;
			}
			
			quantities = new int[count];
			characters = new char[count];
			
			int index = 0;			
			for(int i = 0; i < 256; i++)
			{
				if(array[i] > 0)
				{
					quantities[index] = array[i];
					characters[index] = (char) i;
					index++;
				}
			}
			
			br.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("Nie znaleziono pliku");
			System.exit(-1);
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.err.println("B³¹d odczytu");
			System.exit(-1);
			e.printStackTrace();
		}
	}
	
	public String text() { return text; }
	public int[] quantities() { return quantities; }	
	public char[] characters() { return characters; }
}
