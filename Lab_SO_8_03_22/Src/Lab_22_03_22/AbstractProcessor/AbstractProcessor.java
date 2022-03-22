package Lab_22_03_22.AbstractProcessor;

import java.util.Comparator;
import java.util.Vector;

import Lab_22_03_22.Application.Application;
import Lab_22_03_22.Disc.Disc;
import Lab_22_03_22.Queue.Queue;

public abstract class AbstractProcessor 
{
	protected Queue queue;
	protected Disc disc;
	protected final int DEFAULT_BOUND = 10;
	protected final int DEFAULT_DISC_SIZE = 10;
	
	public AbstractProcessor(Vector<Application> _queue)
	{
		queue = new Queue(_queue);	
		disc = new Disc(0, DEFAULT_DISC_SIZE);
		SortApplications();
	}
	
	public AbstractProcessor(int _count, int _discSize, int _maxArrivalTime)
	{
		queue = new Queue(_count, _discSize, _maxArrivalTime, DEFAULT_BOUND);
		disc = new Disc(0, _discSize);
		SortApplications();
	}
	
	public void SortApplications()
	{
			queue.GetQueue().sort(new Comparator<Application>() {
			
			@Override
			public int compare(Application o1, Application o2) {
				if(o1.ArrivalTime() > o2.ArrivalTime())
				{
					return 1;
				}
				else if (o1.ArrivalTime() < o2.ArrivalTime())
				{
					return -1;
				}
				
				return 0;
			}			
		});
	}
	
	public abstract void Serve();
}