package House;

import Enemy.Enemy;
import Processors.Constants;

public class House 
{
	private Enemy[] enemies;
	
	public House()
	{		
		enemies = new Enemy[Constants.ENEMIES_AT_HOUSE];
	}
}
