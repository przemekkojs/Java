package Enemy;

import Map.Entity;
import Processors.Constants;

public class Enemy extends Entity
{
	public Enemy(int x, int y)
	{
		super.X = x;
		super.Y = y;
		super.Health = Constants.MAX_ENEMY_HEALTH;
	}
}
