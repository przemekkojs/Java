package Map;

import java.io.IOException;

import Enemy.Enemy;
import Player.Player;
import Processors.Constants;
import Processors.Logger;

public class Map 
{
	private static char[][] stage;
	private static Enemy[] enemies;
	
	public Map() throws IOException
	{			
		
		Logger.Log(String.format("%s%n", Constants.LOADING_MAP));
		stage = MapProcessor.LoadStage();		
		Logger.Log(String.format("%s%n", Constants.MAP_LOADED_SUCCESS));	
		Logger.Log(String.format("%s%n", Constants.ERR_LOADING_MAP));			
		
		enemies = MapProcessor.Spawn(stage, Constants.ENEMIES_AT_MAP);
	}
	
	public void Update(Player player)
	{
		stage = MapProcessor.UpdateScene(stage, player, enemies);
	}
	
	public char[][] GetStage()
	{
		return stage;
	}
}
