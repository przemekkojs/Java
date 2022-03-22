package Lab_22_03_22.Queue;

import java.util.Random;
import java.util.Vector;

import Lab_22_03_22.Application.Application;
import Lab_22_03_22.Helpers.VectorCopy;

public class Queue 
{
	private Vector<Application> queue;
	
	public Queue(int _count, int _discSize, int _maxArrivalTime, int _bound)
	{
		queue = new Vector<Application>();
		Init(_count, _discSize, _maxArrivalTime, _bound);
	}
	
	public Queue(Vector<Application> _queue)
	{
		queue = VectorCopy.Copy(_queue);
	}
	
	public void Init(int count, int discSize, int maxArrivalTime, int bound)
	{
		Random random = new Random();
		
		for(int i = 0; i < count; i++)
		{
			queue.add(new Application(random.nextInt(maxArrivalTime), random.nextInt(discSize), random.nextInt(2), bound));
		}
	}
	
	public Vector<Application> GetQueue()
	{
		return queue;
	}
}
