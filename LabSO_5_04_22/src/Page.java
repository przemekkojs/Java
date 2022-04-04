
public class Page 
{
	private int index;	
	private boolean present;
	
	private int time;
	
	public Page(int _index)
	{
		index = _index;		
		present = false;
		time = 0;
	}
	
	public int Index()
	{
		return index;
	}
	
	public boolean Present()
	{
		return present;
	}
	
	public String toString()
	{
		return String.format("Strona %d", index);
	}
	
	public void InMemory()
	{
		if(present)	time++;
	}
	
	public int Time()
	{
		return time;
	}
	
	public void Allocate()
	{
		present = true;
	}
	
	public void Deallocate()
	{
		present = false;
	}
}
