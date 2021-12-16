package Player;

import Processors.Constants;

public class Player 
{
	private int X;
	private int Y;
	private int Food;
	private int Health;
	
	public Player()
	{
		X = 1;
		Y = 1;
		Food = Constants.MAX_FOOD;
		Health = Constants.MAX_HEALTH;
	}
	
	public void Action(String key, String[][] stage)
	{
		key = key.toUpperCase();
		
		switch(key)
		{
		case "W":
			Move(X, Y - 1, stage);
			break;
		case "S":
			Move(X, Y + 1, stage);
			break;
		case "D":
			Move(X + 1, Y, stage);
			break;
		case "A":
			Move(X - 1, Y, stage);
			break;
			
		}
	}
	
	private void Move(int newX, int newY, String[][] stage)
	{
		if(stage[newY][newX] != Constants.SCENE_BLOCK)
		{
			X = newX;
			Y = newY;
		}
		
		CheckPool(X, Y, stage);
	}
	
	private void CheckPool(int x, int y, String[][] stage)
	{
		switch(stage[x][y])
		{
		case Constants.FOOD_SIGN:
			Food++;
			Regenerate();
			break;
		}
	}
	
	private void Regenerate()
	{
		if(Food == Constants.MAX_FOOD && Health < Constants.MAX_HEALTH)
		{
			Health++;
		}
	}
	
	private void Regenerate(int amount)
	{
		Health += amount;
	}
}
