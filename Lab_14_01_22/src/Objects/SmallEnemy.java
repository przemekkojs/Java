package Objects;

import Constants.*;

public class SmallEnemy extends Entity
{
	public SmallEnemy(int x, int y) 
	{
		super(x, y, Constants.SMALL_ENEMY_BODY);		
	}
	
	@Override
	public void Update() 
	{		
		super.Update();
		super.Update();
	}
}