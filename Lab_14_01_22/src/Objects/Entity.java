package Objects;

import java.util.Random;

import Constants.Constants;
import Observer.Observer;

public class Entity implements Observer
{
	private int X;
	private int Y;
	private int Points;	
	
	private char Body;
	
	private boolean active = true;
		
	public Entity(int x, int y, char body)
	{
		X = x;
		Y = y;		
		Body = body;
		Points = 0;
	}
	
	public void Move(int xIncrement, int yIncrement)
	{
		if(X + xIncrement > 0 && X + xIncrement < 9)
		{
			X += xIncrement;
		}
		
		if(Y + yIncrement > 0 && Y + yIncrement < 9)
		{
			Y += yIncrement;
		}
	}
	
	public boolean Active()
	{
		return active;
	}
	
	public void Deactivate()
	{
		System.out.printf("%s [%d] wyeliminowany!%n", Body, Points);
		active = false;
		Body = 'X';		
		X = 0;
		Y = 0;
	}
	
	public void Point()
	{
		Points++;
		System.out.printf("%s zdoby³ punkt! £¹cznie: %d%n", Body, Points);
	}
	
	public int GetPoints()
	{
		return Points;
	}
	
	public int GetX()
	{
		return X;
	}
	
	public int GetY()
	{
		return Y;
	}
	
	public char GetBody()
	{
		return Body;
	}
	
	public void SetX(int x)
	{
		X = x;
	}
	
	public void SetY(int y)
	{
		Y = y;
	}

	@Override
	public void Update(String arg) 
	{
		switch(arg)
		{
		case Constants.MOVE_ENEMIES:
			Random random = new Random();
			int moveX = random.nextInt(-1, 2);
			int moveY = random.nextInt(-1, 2);			
			
			Move(moveX, moveY);
			break;
		default:
			System.out.printf("%s: %s mnie nie dotyczy%n", GetBody(), arg);
			break;
		}		
	}
}