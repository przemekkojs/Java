
public class Frame 
{
	private int index;	
	private boolean allocated;
	private Page memory;
	
	public Frame(int _index)
	{
		index = _index;		
		allocated = false;
		memory = null;
	}
	
	public int Index()
	{
		return index;
	}
	
	public void Allocate(Page _memory)
	{
		allocated = true;
		memory = _memory;
	}
	
	public void Deallocate()
	{
		allocated = false;
		memory = null;
	}
	
	public boolean Allocated()
	{
		return allocated;
	}
	
	public Page Memory()
	{
		return memory;
	}
	
	public String toString()
	{
		return String.format("Strona %d", index);
	}	
}
