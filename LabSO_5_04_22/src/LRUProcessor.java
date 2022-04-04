
public class LRUProcessor extends AbstractProcessor
{
	public LRUProcessor(int _framesCount, int[] _pages) 
	{
		super(_framesCount, _pages);		
	}

	@Override
	public void Process() 
	{
		int index = 0;
		int allocationIndex = 0;
		int allocatedCount = 0;
		int tabIndex = 0;
		
		for(int pageIndex : pages)
		{
			index = 0;
			
			while(index < physical.Size() && physical.Memory()[index].Index() != pageIndex)
			{
				index++;
			}
			
			if(index == physical.Size()) //Nie ma strony w pamiêci -> trzeba zaalokowaæ
			{	
				if(allocatedCount < physical.Size())
				{
					physical.Allocate(allocatedCount, pageIndex);	
					allocatedCount++;
					errorCount++;	
				}
				else
				{
					allocationIndex = LeastNeeded(tabIndex);
					
					physical.Allocate(allocationIndex, pageIndex);				
					errorCount++;	
				}				
			}
			
			tabIndex++;
		}
		
		System.out.println("LRU: " + errorCount);
	}
	
	private int LeastNeeded(int tabIndex)
	{
		int index = 0;
		int min = tabIndex;
		int res = 0;
		
		for(int check = 0; check < physical.Size(); check++)
		{
			index = tabIndex;
			
			while(index >= 0)
			{
				if(physical.Memory()[check].Index() == pages[index])
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
}