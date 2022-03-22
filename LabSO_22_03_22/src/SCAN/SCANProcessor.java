package SCAN;

import java.util.Vector;

import AbstractProcessor.AbstractProcessor;
import Application.Application;

public class SCANProcessor extends AbstractProcessor
{
	public SCANProcessor(int _count, int _discSize, int _maxArrivalTime) 
	{
		super(_count, _discSize, _maxArrivalTime);		
	}

	public SCANProcessor(Vector<Application> _queue)
	{
		super(_queue);
	}
	
	@Override
	public void Serve() 
	{		
		System.out.println("SCAN:");
		
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
				if(disc.Direction() == 1)
				{
					if(index >= 0 && index < help.size() && lastServed.Block() < help.elementAt(index).Block())
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
							disc.ChangeDirection();
						}						
					}
				}
				else
				{					
					if(index >= 0 && index < help.size() && lastServed.Block() > help.elementAt(index).Block())
					{
						lastServed = help.elementAt(index);
						disc.MoveHead(help.elementAt(index).Block());
						help.remove(index);
						System.out.println("Served: " + lastServed.toString());
					}
					else
					{
						if(index > 0)
						{
							index--;
						}
						else
						{
							disc.ChangeDirection();
						}						
					}
				}
			}
		}
		
		System.out.println("HeadMovements: " + disc.getHeadMovements());
		System.out.println("=============================================:");		
	}	
}
