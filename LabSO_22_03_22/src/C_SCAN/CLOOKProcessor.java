package C_SCAN;

import java.util.Vector;
import AbstractProcessor.AbstractProcessor;
import Application.Application;

public class CLOOKProcessor extends AbstractProcessor 
{

	public CLOOKProcessor(int _count, int _discSize, int _maxArrivalTime) 
	{
		super(_count, _discSize, _maxArrivalTime);		
	}
	
	public CLOOKProcessor(Vector<Application> _queue)
	{
		super(_queue);		
	}

	@Override
	public void Serve() 
	{		
		System.out.println("C-LOOK:");
		
		while(super.queue.GetQueue().size() > 0)
		{				
			Vector<Application> help = new Vector<Application>();			
			
			help.add(queue.GetQueue().elementAt(0));
			super.queue.GetQueue().remove(0);
			
			while(super.queue.GetQueue().size() > 0 && super.queue.GetQueue().elementAt(0).ArrivalTime() == help.elementAt(0).ArrivalTime())
			{
				help.add(super.queue.GetQueue().elementAt(0));
				super.queue.GetQueue().remove(0);
			}
			
			int index = 0;
			Application lastServed = help.elementAt(index);
			disc.MoveHead(help.elementAt(index).Block());
			help.remove(index);
			System.out.println("Served: " + lastServed.toString());
			
			
			while(help.size() > 0)
			{
				if(index < help.size() && lastServed.Block() < help.elementAt(index).Block())
				{
					lastServed = help.elementAt(index);
					disc.MoveHead(help.elementAt(index).Block());
					help.remove(index);
					System.out.println("Served: " + lastServed.toString());					
				}
				else
				{
					if(index < help.size() - 1)
					{
						index++;
					}
					else
					{
						index = 0;
						
						lastServed = help.elementAt(0);
						disc.MoveHead(help.elementAt(0).Block());
						help.remove(0);
						System.out.println("Served: " + lastServed.toString());			
					}					
				}
			}			
		}
		
		System.out.println("HeadMovements: " + disc.getHeadMovements());
		System.out.println("=============================================:");
	}	

}
