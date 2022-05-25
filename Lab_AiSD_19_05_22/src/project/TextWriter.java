package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter 
{
	private BufferedWriter bw;
	
	public TextWriter(String path, String line)
	{
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File(path)));			
			bw.append(line);			
			bw.close();
		} 
		catch (IOException e) 
		{
			System.err.println("B³¹d zapisu");
			System.exit(-1);
			e.printStackTrace();
		}
	}
}
