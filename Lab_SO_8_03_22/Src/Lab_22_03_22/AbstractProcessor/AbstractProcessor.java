package Lab_22_03_22.AbstractProcessor;

import java.util.Vector;

import Lab_22_03_22.Application.Application;
import Lab_22_03_22.Disc.Disc;
import Lab_22_03_22.Queue.Queue;

public abstract class AbstractProcessor 
{
	protected Queue queue;
	protected Disc disc;
	protected final int DEFAULT_BOUND = 10;
	
	public AbstractProcessor(Vector<Application> _queue)
	{
		queue = new Queue(_queue);
	}
	
	public AbstractProcessor(int _count, int _discSize, int _maxArrivalTime)
	{
		queue = new Queue(_count, disc.getSize(), _maxArrivalTime, DEFAULT_BOUND);
	}
	
	public abstract void SortApplications();
	public abstract void Serve();
}