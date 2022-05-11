import java.util.Random;

public class Process 
{	
	private int[] usedPages;
	private String name;	
	private int errorCount;
	private int processSize;
	
	private Memory memory;
	
	public Process(String _name, int _processSize)
	{
		name = _name;
		usedPages = new int[_processSize];		
		errorCount = 0;
		processSize = _processSize;
		
		memory = new Memory(_processSize);
	}
	
	public String toString()
	{
		String res = "[";
		
		for(int i = 0; i < usedPages.length - 1; i++)
		{
			res += usedPages[i] + ", ";
		}
		
		res += usedPages[usedPages.length - 1] + "]";
		
		return String.format("%s, odwolania: %s", name, res);
	}
	
	public void generateQueue(int _size)
	{
		Random random = new Random();		
		
		usedPages = new int[_size];
		int next = random.nextInt(_size);
		
		for(int i = 0; i < _size; i++)
		{
			if(random.nextBoolean())
			{
				next = random.nextInt(_size);
			}
			
			usedPages[i] = next;
		}		
	}
	
	public int[] queue()
	{
		return usedPages;
	}
	
	public void error()
	{
		errorCount++;
	}
	
	public int errorCount()
	{
		return errorCount;
	}
	
	public int processSize()
	{
		return processSize;
	}
	
	public Memory memory()
	{
		return memory;
	}
	
	public void newMemory(int newSize)
	{
		if(newSize < 1)
		{
			return;
		}
		
		Frame[] old = memory.memory();		
		Memory m = new Memory(newSize);
		processSize = newSize;
		
		for(int i = 0; i < newSize && i < old.length; i++)
		{
			m.allocate(i, old[i].index());
		}
		
		memory = m;
	}
}