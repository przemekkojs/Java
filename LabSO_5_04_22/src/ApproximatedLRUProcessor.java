
public class ApproximatedLRUProcessor extends AbstractProcessor
{
	private boolean[] tab;
	
	public ApproximatedLRUProcessor(int _framesCount, int[] _pages) 
	{
		super(_framesCount, _pages);
		tab = new boolean[_framesCount];
		
		for(int i = 0; i < _framesCount; i++)
		{
			tab[i] = false;
		}
	}

	@Override
	public void Process() //Druga szansa
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
				
				while(tab[lastAllocatedIndex])
				{
					tab[lastAllocatedIndex] = false;
					lastAllocatedIndex++;
					
					if(lastAllocatedIndex >= physical.Size())
					{
						lastAllocatedIndex = 0;
					}
				}
				
				physical.Allocate(lastAllocatedIndex, pageIndex);		
				tab[lastAllocatedIndex] = true;
				lastAllocatedIndex++;
				errorCount++;	
			}
			else
			{
				tab[index] = true;
			}			
		}
		
		System.out.println("Approximated LRU: " + errorCount);
	}	
}