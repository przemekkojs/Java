package Map;

public class Entity 
{
	protected int X;
	protected int Y;
	protected int LastX;
	protected int LastY;
	protected int Health;	
	
	public Entity()
	{
		X = 0;
		Y = 0;
		LastX = 0;
		LastY = 0;
		Health = 0;
	}
	
	public int GetX()
	{
		return X;
	}
	
	public int GetY()
	{
		return Y;
	}	
	
	public int GetLastX()
	{
		return LastX;
	}
	
	public int GetLastY()
	{
		return LastY;
	}
	
	public void SetLastPosition(int lastX, int lastY)
	{
		LastX = lastX;
		LastY = lastY;
	}
	
	public boolean Alive()
	{
		if(Health > 0)
		{
			return true;
		}
		
		return false;
	}
}
