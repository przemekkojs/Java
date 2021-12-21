package Map;

public class Entity 
{
	protected int X;
	protected int Y;
	protected int Health;	
	
	public Entity()
	{
		X = 0;
		Y = 0;
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

	public boolean Alive()
	{
		if(Health > 0)
		{
			return true;
		}
		
		return false;
	}
}
