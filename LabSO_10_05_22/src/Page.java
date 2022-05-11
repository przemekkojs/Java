
public class Page 
{
	private int index;
	private int time;
	
	private boolean allocated;
	
	public Page(int _index)
	{        
		index = _index;
		time = 0;
		allocated = false;
	}
	
	public int index()
	{
		return index;
	}
	
	public int time()
	{
		return time;
	}
	
	public void timeInMemory()
	{
		if(allocated) time++;
	}
	
	public void allocate()
	{
		allocated = true;
	}
	
	public void deallocate()
	{
		allocated = false;
		time = 0;
	}
	
	public boolean allocated()
	{
		return allocated;
	}
	
	public String toString()
	{
		return String.format("%d", time);
	}
}