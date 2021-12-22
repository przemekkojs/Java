package Game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Processors.Constants;
import Processors.Logger;

public class Pause 
{
	public static void SaveGame()
	{
		Logger.Log(String.format("%s%n", Constants.GAME_SAVE));		
		
		BufferedWriter bw = null;
		
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File(Constants.LOGS_FILE)));
			
			for(String s : Logger.GetLogs())
			{
				bw.write(s);
			}			
		} 
		catch (IOException e) 
		{
			Logger.Log(String.format("%s%n", Constants.ERR_SAVE));			
		}	
		
		try 
		{
			bw.close();
		} 
		catch (IOException e) 
		{
			Logger.Log(String.format("%s%n", Constants.ERR_SAVE));
		}
	}
	
	public static void LoadGame(String path)
	{
		
	}
}