package Objects;

import java.util.Random;
import Constants.*;
import Observer.Observer;

public class Point extends Entity implements Observer
{
	public Point(int x, int y) 
	{
		super(x, y, Constants.POINT_BODY);
	}
	
	public void Move()
	{
		Random random = new Random();		
		
		SetX(random.nextInt(1, 9));
		SetY(random.nextInt(1, 9));
	}

	@Override
	public void Update(String arg) 
	{
		if(arg == Constants.MOVE_POINT)
		{
			System.out.println("Punkt uciek³!");
			Move();
		}
	}
}