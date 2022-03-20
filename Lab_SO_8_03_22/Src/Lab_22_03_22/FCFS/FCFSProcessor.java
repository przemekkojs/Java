package Lab_22_03_22.FCFS;

import Lab_22_03_22.AbstractProcessor.AbstractProcessor;

public class FCFSProcessor extends AbstractProcessor
{
	public FCFSProcessor(int _count, int _discSize, int _maxArrivalTime) 
	{
		super(_count, _discSize, _maxArrivalTime);		
	}

	@Override
	public void SortApplications() 
	{
		
	}

	@Override
	public void Serve() 
	{
		int time = 0;
		
		while(super.queue.GetQueue().size() > 0)
		{
			
			
			time++;
		}
	}	
}