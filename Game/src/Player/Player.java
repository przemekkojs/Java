package Player;

import Items.Item;
import Items.Medkit;
import Map.Entity;
import Processors.Constants;
import Processors.KeyboardSettings;
import Processors.Logger;

public class Player extends Entity
{
	private int Food;
	
	private Item[] Inventory;
	private Medkit Medkits;
	private Item CurrentItem;
	
	public Player(int x, int y)
	{
		super.X = x;
		super.Y = y;
		super.Health = Constants.MAX_HEALTH;
		
		Food = Constants.MAX_FOOD;
		Inventory = new Item[Constants.INVENTORY_SIZE];
		Medkits = new Medkit(10);
		CurrentItem = Inventory[0];
		
		Logger.Log(String.format("%s%n%n", Constants.PLAYER_LOADED_SUCCESS));
	}
	
	public void Action(String key, char[][] stage)
	{
		key = key.toUpperCase();
		
		switch(key)
		{
		case KeyboardSettings.MOVE_UP:
			Move(X, Y - 1, stage);
			break;
		case KeyboardSettings.MOVE_DOWN:
			Move(X, Y + 1, stage);
			break;
		case KeyboardSettings.MOVE_RIGHT:
			Move(X + 1, Y, stage);
			break;
		case KeyboardSettings.MOVE_LEFT:
			Move(X - 1, Y, stage);
			break;
		case KeyboardSettings.USE_ITEM_1:
			ItemSelection(0);
			break;
		case KeyboardSettings.USE_ITEM_2:
			ItemSelection(1);
			break;
		case KeyboardSettings.USE_ITEM_3:
			ItemSelection(2);
			break;
		case KeyboardSettings.USE_ITEM_4:
			ItemSelection(3);
			break;
		case KeyboardSettings.USE_MEDKIT:
			UseMedkit();
			break;
		}
	}
	
	public boolean Alive()
	{
		if(Health > 0)
		{
			return true;
		}
		
		return false;
	}
	
	private void Move(int newX, int newY, char[][] stage)
	{
		if(stage[newY][newX] != Constants.SCENE_BLOCK)
		{
			X = newX;
			Y = newY;
		}
		
		CheckPool(X, Y, stage);
	}
	
	private void CheckPool(int x, int y, char[][] stage)
	{
		switch(stage[x][y])
		{
		case Constants.FOOD_BLOCK:
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
	
	private void UseMedkit()
	{
		if(Medkits.GetQuantity() > 0)
		{
			Health += Medkits.Regeneration();
		}	
		else
		{
			Logger.Log(String.format("%s%n", Constants.NO_MEDKITS_LEFT));
		}
	}
	
	private void ItemSelection(int item)
	{
		if(item >= 0 && item < Constants.INVENTORY_SIZE)
		{
			CurrentItem = Inventory[item];
		}
	}	
}
