
public class LRUProcessor 
{
	private Memory memory;
	
	private int size;
	private int errorCount;
	private int[] pages;
	
	public LRUProcessor(int _size, int[] _pages)
	{
		memory = new Memory(_size);
		
		size = _size;
		pages = _pages;
		errorCount = 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public String toString()
	{
		return String.format("LRU, ilosc stron: %d", size);
	}
	
	public int errorCount()
	{
		return errorCount;
	}
	
	public void Process() 
	{
		int index = 0;
		int allocationIndex = 0;
		int allocatedCount = 0;
		int tabIndex = 0;
		
		for(int pageIndex : pages)
		{
			index = 0;
			
			while(index < memory.size() && memory.memory()[index].index() != pageIndex)
			{
				index++;
			}
			
			if(index == memory.size()) //Nie ma strony w pamiêci -> trzeba zaalokowaæ
			{	
				if(allocatedCount < memory.size())
				{
					memory.allocate(allocatedCount, pageIndex);	
					allocatedCount++;
					errorCount++;	
				}
				else
				{
					allocationIndex = LeastNeeded(tabIndex);					
					memory.allocate(allocationIndex, pageIndex);				
					errorCount++;	
				}				
			}
			
			tabIndex++;
		}
		
		System.out.println("Bledy w zwyklym znaczeniu: " + errorCount);
	}
	
	private int LeastNeeded(int tabIndex)
	{
		int index = 0;
		int min = tabIndex;
		int res = 0;
		
		for(int check = 0; check < memory.size(); check++)
		{
			index = tabIndex;
			
			while(index >= 0)
			{
				if(memory.memory()[check].index() == pages[index])
				{
					break;
				}
				
				index--;
			}
			
			if(index < min)
			{
				min = index;
				res = check;
			}
		}
		
		return res;
	}
	
	public Memory memory()
	{
		return memory;
	}
}