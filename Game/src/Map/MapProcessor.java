package Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import Enemy.Enemy;
import Player.Player;
import Processors.Constants;

public class MapProcessor 
{
	public static char[][] LoadStage() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(new File(Constants.MAIN_MAP_FILE)));
		List<String> lines = br.lines().toList();		
		char[][] res = new char[lines.size()][];
		
		for(int line = 0; line < lines.size(); line++)
		{			
			res[line] = lines.get(line).toCharArray();			
		}
		
		br.close();
		return res;
	}
	
	public static char[][] UpdateScene(char[][] oldScene, Player player, Enemy[] enemies)
	{
		char[][] res = oldScene;
		
		res[player.GetY()][player.GetX()] = Constants.PLAYER_BODY;
		
		for(Enemy e : enemies)
		{
			res[e.GetX()][e.GetY()] = Constants.ENEMY_BODY;
		}
		
		return res;
	}
	
	public static Enemy[] Spawn(char[][] scene, int count)
	{
		Random random = new Random();
		Enemy[] res = new Enemy[count];
		
		for(int index = 0; index < count; index++)
		{			
			int bound = scene[0].length - 1;
			
			res[index] = new Enemy(random.nextInt(bound) + 1, random.nextInt(bound) + 1);	
			System.out.println(scene[res[index].GetY()]);
			
			while(scene[res[index].GetY()][res[index].GetX()] == (Constants.SCENE_BLOCK))
			{
				res[index] = new Enemy(random.nextInt(bound) + 1, random.nextInt(bound) + 1);	
			}
		}
		
		return res;
	}
	
	public static Player Spawn(char[][] scene)
	{
		Random random = new Random();
		Player res = new Player(random.nextInt(scene[0].length) + 1, random.nextInt(scene.length) + 1);	
		
		while(scene[res.GetY()][res.GetY()] == Constants.SCENE_BLOCK)
		{
			res = new Player(random.nextInt(scene[0].length - 1) + 1, random.nextInt(scene.length - 1) + 1);	
		}
		
		return res;
	}
	
	public static void Draw(char[][] scene)
	{
		for(int y = 0; y < scene.length; y++)
		{
			System.out.println(scene[y]);
		}
	}
}
