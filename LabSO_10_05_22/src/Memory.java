public class Memory 
{
	private Frame[] frames;
	private int size;
	
	public Memory(int _size)
	{
		frames = new Frame[_size];		
		size = _size;
		clear();	
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
	
	public boolean allocated(int frame)
	{
		return frames[frame].index() != -1;
	}
}