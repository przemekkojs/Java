package FCFS;

import java.util.Vector;

import AbstractProcessor.AbstractProcessor;
import Application.Application;

public class FCFSProcessor extends AbstractProcessor
{
	public FCFSProcessor(int _count, int _discSize, int _maxArrivalTime) 
	{
		super(_count, _discSize, _maxArrivalTime);		
	}
	
	public FCFSProcessor(Vector<Application> _queue)
	{
		super(_queue);
	}

	@Override
	public void Serve() 
	{		
		System.out.println("FCFS:");
		
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
			
			while(help.size() > 0)
			{
				System.out.println("Served: " + help.elementAt(0).toString());
				
				disc.MoveHead(help.elementAt(0).Block());		
				help.remove(0);			
			}			
		}
		
		System.out.println("HeadMovements: " + disc.getHeadMovements());
		System.out.println("=============================================:");
	}	
}