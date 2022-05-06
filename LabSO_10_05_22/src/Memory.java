public class Memory 
{
	private Frame[] frames;
	private int size;
	
	public Memory(int _size)
	{
		frames = new Frame[_size];
		
		for(int i = 0; i < _size; i++)
		{
			frames[i] = new Frame(-1);
		}		
		
		size = _size;
	}	
	
	public int size()
	{
		return size;
	}
	
	public Frame[] memory()
	{
		return frames;
	}
	
	public void allocate(int frame, int page)
	{
		frames[frame] = new Frame(page);
	}
	
	public void clear()
	{
		for(int i = 0; i < size; i++)
		{
			frames[i] = new Frame(-1);
		}		
	}
}