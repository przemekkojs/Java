import java.util.Random;

public class RANDProcessor extends AbstractProcessor
{
	public RANDProcessor(int _framesCount, int[] _pages) 
	{
		super(_framesCount, _pages);		
	}

	@Override
	public void Process() 
	{
		int index = 0;
		int lastAllocatedIndex = 0;
		
		Random random = new Random();
		
		for(int pageIndex : pages)
		{
			index = 0;
			
			while(index < physical.Size() && physical.Memory()[index].Index() != pageIndex)
			{
				index++;
			}
			
			if(index == physical.Size()) //Nie ma strony w pamiêci -> trzeba zaalokowaæ
			{					
				lastAllocatedIndex = random.nextInt(physical.Size());
				physical.Allocate(lastAllocatedIndex, pageIndex);				
				errorCount++;	
			}
		}
		
		System.out.println("RAND: " + errorCount);
	}
}