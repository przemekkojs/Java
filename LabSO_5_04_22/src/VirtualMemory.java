
public class VirtualMemory 
{
	private Page[] memory;
	private int size;
	
	public VirtualMemory(int _size)
	{
		memory = new Page[_size];
		size = _size;
		
		for(int i = 0; i < _size; i++)
		{
			memory[i] = new Page(i);
		}
	}
	
	public int Size()
	{
		return size;
	}
	
	public Page[] Memory()
	{
		return memory;
	}	
}
