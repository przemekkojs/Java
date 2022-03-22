package Lab_22_03_22.EDF;

import java.util.Comparator;
import java.util.Vector;

import Lab_22_03_22.AbstractProcessor.AbstractProcessor;
import Lab_22_03_22.Application.Application;

public class EDFProcessor extends AbstractProcessor
{

	public EDFProcessor(int _count, int _discSize, int _maxArrivalTime) 
	{
		super(_count, _discSize, _maxArrivalTime);		
	}

	public EDFProcessor(Vector<Application> _queue) 
	{
		super(_queue);		
	}
	
	private void SortByDeadline(Vector<Application> help)
	{
		help.sort(new Comparator<Application>() {
			
			@Override
			public int compare(Application o1, Application o2) {
				if(o1.Deadline() > o2.Deadline())
				{
					return 1;
				}
				else if (o1.Deadline() < o2.Deadline())
				{
					return -1;
				}
				
				return 0;
			}			
		});
	}
	
	private void SortByPriority(Vector<Application> help)
	{
		help.sort(new Comparator<Application>() {
			
			@Override
			public int compare(Application o1, Application o2) {
				if(o1.Priority() > o2.Priority())
				{
					return -1;
				}
				else if (o1.Priority() < o2.Priority())
				{
					return 1;
				}
				
				return 0;
			}			
		});
	}
	
	@Override
	public void Serve() 
	{
		System.out.println("EDF:");
		
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
			
			SortByDeadline(help);
			SortByPriority(help);
			
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