package Managers;

import Objects.Entity;
import Objects.Point;

public class SceneManager 
{
	private char[][] stage = new char[10][];
	private Point point;
	
	public SceneManager(Point p)
	{
		stage[0] = "XXXXXXXXXX".toCharArray();
		stage[9] = "XXXXXXXXXX".toCharArray();
		
		ClearScene();
		
		point = p;
	}
	
	public void ClearScene()
	{
		for(int index = 1; index < 9; index++)
		{
			stage[index] = "X        X".toCharArray();
		}
	}
	
	public void WriteStage(Entity[] entities)
	{
		System.out.println("Scena: ");
		
		ClearScene();
		
		stage[point.GetY()][point.GetX()] = '*';
		
		for(Entity o : entities)
		{
			if(stage[o.GetY()][o.GetX()] == ' ')
			{
				stage[o.GetY()][o.GetX()] = o.GetBody();
			}
			else if(stage[o.GetY()][o.GetX()] == '*')
			{
				stage[o.GetY()][o.GetX()] = o.GetBody();
				point.Move();
				o.Point();
			}
			else if(o.GetBody() != 'X')
			{
				o.Deactivate();
			}			
		}
		
		for(int y = 0; y < 10; y++)
		{
			for(int x = 0; x < 10; x++)
			{
				System.out.print(stage[y][x]);
			}
			
			System.out.println();
		}
	}
}
