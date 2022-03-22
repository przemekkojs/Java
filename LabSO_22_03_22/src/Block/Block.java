package Block;

public class Block 
{
	private int number;
	private boolean free;
	
	public Block(int _number)
	{
		number = _number;
		free = true;
	}
	
	public void Attach()
	{
		free = false;
	}
	
	public void Detach()
	{
		free = false;
	}
	
	public boolean IsFree()
	{
		return free;
	}
	
	public int GetNumber()
	{
		return number;
	}
}
