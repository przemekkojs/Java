package Processors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapProcessor 
{
	private String[][] Stage;
	
	public MapProcessor() throws IOException
	{
		Stage = LoadStage();
	}
	
	public String[][] LoadStage() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(new File(Constants.MAIN_MAP_FILE)));
		String input;
		int sizeY = //Ilosc wierszy w pliku
		
		while((input = br.readLine()) != null)
		{
			
		}
	}
}
