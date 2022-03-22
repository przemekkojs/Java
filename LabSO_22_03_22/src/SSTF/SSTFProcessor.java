package Lab_22_03_22.SSTF;

import java.util.Vector;

import Lab_22_03_22.AbstractProcessor.AbstractProcessor;
import Lab_22_03_22.Application.Application;

public class SSTFProcessor extends AbstractProcessor
{
	public SSTFProcessor(Vector<Application> _queue) 
	{
		super(_queue);		
	}
	
	public SSTFProcessor(int _count, int _discSize, int _maxArrivalTime) 
	{
		super(_count, _discSize, _maxArrivalTime);		
	}

	@Override
	public void Serve() 
	{
		System.out.println("SSTF:");
		
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
			
			Application current = help.elementAt(0);
			
			System.out.println("Served: " + current.toString());			
			disc.MoveHead(current.Block());		
			help.remove(current);				
			
			while(help.size() > 0)
			{		
				Application nearest = help.elementAt(0);
				int curMin = Math.abs(current.Block() - nearest.Block());
				
				for(int i = 0; i < help.size(); i++)
				{
					if(Math.abs(current.Block() - help.elementAt(i).Block()) < curMin)
					{
						curMin = Math.abs(current.Block() - help.elementAt(i).Block());
						nearest = help.elementAt(i);
					}
				}
				
				System.out.println("Served: " + nearest.toString());				
				disc.MoveHead(nearest.Block());		
				help.remove(nearest);	
				
				current = nearest;
			}			
		}
		
		System.out.println("HeadMovements: " + disc.getHeadMovements());
		System.out.println("=============================================:");
	}
}