package Processors;

import java.util.Random;

import Enemy.Enemy;
import Player.Player;

public class EntityProcessor 
{
	private static Random random = new Random();
	
	public static Enemy[] Spawn(char[][] scene, int count)
	{		
		Logger.Log(String.format("%s%n", Constants.LOADING_ENEMIES));
		
		Enemy[] res = new Enemy[count];
		
		int xBound = scene[0].length - 1;
		int yBound = scene.length - 1;
		
		for(int index = 0; index < count; index++)
		{				
			res[index] = new Enemy(random.nextInt(xBound), random.nextInt(yBound));	
			
			while(scene[res[index].GetY()][res[index].GetX()] == Constants.SCENE_BLOCK)
			{
				res[index] = new Enemy(random.nextInt(xBound), random.nextInt(yBound));	
			}
		}
		
		Logger.Log(String.format("%s%n", Constants.ENEMIES_LOADED_SUCCESS));
		return res;
	}
	
	public static Player Spawn(char[][] scene)
	{
		Logger.Log(String.format("%s%n", Constants.LOADING_PLAYER));
		
		Random random = new Random();
		Player res = null;	
		
		int xBound = scene[0].length - 1;
		int yBound = scene.length - 1;
		
		res = new Player(random.nextInt(xBound), random.nextInt(yBound));	
		
		while(scene[res.GetY()][res.GetX()] == Constants.SCENE_BLOCK)
		{
			res = new Player(random.nextInt(xBound), random.nextInt(yBound));	
		}
		
		Logger.Log(String.format("%s%n%n", Constants.PLAYER_LOADED_SUCCESS));		
		return res;
	}
}