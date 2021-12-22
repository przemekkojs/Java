package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Map.Map;
import Map.MapProcessor;
import Player.Player;
import Processors.EntityProcessor;
import Processors.Logger;

public class GameManager 
{
	private static Player player;
	private static Map map;	
	
	public static void main(String[] args) 
	{					
		UI.InitializeGameArea();
		UI.InitializeLogArea();		
		Initialize();		
		UI.InitializeControls(player, map);
		UI.InitializePanels();
		UI.InitializeFrame();	
	}
	
	private static void Initialize()
	{
		Logger.Log(String.format("Welcome!%n"));		
		map = new Map();			
		player = EntityProcessor.Spawn(map.GetStage());		
	}
	
	private static void Game()
	{				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		try 
		{			
			while(player.Alive() && (input = br.readLine()) != "")
			{					
				player.Action(input, map.GetStage());	
				map.Update(player);				
				MapProcessor.Draw(map.GetStage());
				Logger.Clear();
			}
			
			br.close();
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}		
		
		Logger.Log(String.format("Thank you for playing!%n"));
	}
}