package Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import Enemy.Enemy;
import Player.Player;
import Processors.Constants;
import Processors.Logger;

public class MapProcessor 
{	
	public static char[][] LoadStage()
	{
		BufferedReader br = null;
		
		try 
		{
			br = new BufferedReader(new FileReader(new File(Constants.MAIN_MAP_FILE)));
		} 
		catch (FileNotFoundException e) 
		{
			Logger.Log(String.format("%n%n", Constants.ERR_FILE_NOT_FOUND));
			Logger.Log(String.format("%n%n", Constants.ERR_LOADING_MAP));
		}
		
		List<String> lines = br.lines().toList();		
		char[][] res = new char[lines.size()][];
		
		for(int line = 0; line < lines.size(); line++)
		{			
			res[line] = lines.get(line).toCharArray();			
		}
		
		try 
		{
			br.close();
		} 
		catch (IOException e) 
		{
			Logger.Log(String.format("%n%n", Constants.ERR_CLOSE));
		}
		
		return res;
	}
	
	public static char[][] UpdateScene(char[][] oldScene, Player player, Enemy[] enemies)
	{
		char[][] res = oldScene;
		
		res[player.GetY()][player.GetX()] = Constants.PLAYER_BODY;
		res[player.GetLastY()][player.GetLastX()] = ' ';
		
		for(Enemy e : enemies)
		{
			res[e.GetLastY()][e.GetLastX()] = ' ';
			res[e.GetY()][e.GetX()] = Constants.ENEMY_BODY;			
		}
		
		return res;
	}	
	
	public static void Draw(char[][] scene)
	{
		for(int y = 0; y < scene.length; y++)
		{
			for(int x = 0; x < scene[y].length; x++)
			{
				System.out.print(scene[y][x]);
			}
			
			System.out.println();
		}
	}
}
