package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter 
{
	private static BufferedWriter bw;
	
	public static void write(String text, String path)
	{
		System.out.println("Zapisywanie...");
		
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File(path)));
			bw.append(text + "\n");
			bw.close();
		} 
		catch (IOException e) 
		{
			System.err.println("B³¹d zapisu");
			System.exit(-1);
			e.printStackTrace();
		}
		
		System.out.print("Zapisano");
	}
}