
public class PhysicalMemory 
{
	private Frame[] memory;
	private int size;
	
	public PhysicalMemory(int _frameCount)
	{
		memory = new Frame[_frameCount];
		size = _frameCount;
		
		for(int i = 0; i < _frameCount; i++)
		{
			memory[i] = new Frame(-1);
		}
	}
	
	public int Size()
	{
		return size;
	}	
	
	public Frame[] Memory()
	{
		return memory;
	}
	
	public void Allocate(int index, int value)
	{
		memory[index] = new Frame(value);
	}
}