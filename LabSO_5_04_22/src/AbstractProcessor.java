
public abstract class AbstractProcessor 
{
	protected PhysicalMemory physical;	
	protected int errorCount;		
	protected int[] pages;
	
	public AbstractProcessor(int _framesCount, int _pages[])
	{		
		physical = new PhysicalMemory(_framesCount);		
		errorCount = 0;		
		pages = _pages;
	}
	
	public abstract void Process();
}