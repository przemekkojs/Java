
public class FIFOProcessor extends AbstractProcessor
{		
	public FIFOProcessor(int _framesCount, int _pages[])
	{		
		super(_framesCount, _pages);
	}
	
	@Override
	public void Process()
	{
		int index = 0;
		int lastAllocatedIndex = 0;
		
		for(int pageIndex : pages)
		{
			index = 0;
			
			while(index < physical.Size() && physical.Memory()[index].Index() != pageIndex)
			{
				index++;
			}
			
			if(index == physical.Size()) //Nie ma strony w pamiêci -> trzeba zaalokowaæ
			{				
				if(lastAllocatedIndex >= physical.Size())
				{
					lastAllocatedIndex = 0;
				}
				
				physical.Allocate(lastAllocatedIndex, pageIndex);
				lastAllocatedIndex++;
				errorCount++;	
			}
		}
		
		System.out.println("FIFO: " + errorCount);
	}
}