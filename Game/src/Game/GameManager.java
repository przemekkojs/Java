package Game;

import java.io.IOException;
import java.util.Scanner;

import Map.Map;
import Map.MapProcessor;
import Player.Player;
import Processors.Constants;
import Processors.Logger;

public class GameManager 
{
	private static Player player;
	private static Map map;	
	
	public static void main(String[] args) throws IOException 
	{
		Initialize();
		Game();
	}
	
	private static void Initialize() throws IOException
	{
		Logger.Log(String.format("Welcome!%n"));
		Logger.Log(String.format("%s%n%n", Constants.LOADING_PLAYER));
		
		map = new Map();		
		player = MapProcessor.Spawn(map.GetStage());
	}
	
	private static void Game()
	{		
		Scanner scanner = new Scanner(System.in);
		String input;
		
		while(player.Alive() && (input = scanner.next()) != null && input.length() > 0)
		{
			MapProcessor.Draw(map.GetStage());
			player.Action(input, map.GetStage());	
			map.Update(player);
			Logger.Clear();
		}
		
		scanner.close();
		Logger.Log(String.format("Thank you for playing!%n"));
	}
}