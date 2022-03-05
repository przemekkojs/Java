package Overall;

import java.util.Vector;

public abstract class AbstractProcessor
{
	protected Queue queue;
	protected Vector<Process> stack;
	protected Vector<Process> done;
	
	public AbstractProcessor(Queue q)
	{
		stack = new Vector<Process>();		
		done = new Vector<Process>();		
		queue = CopyQueue(q);
	}
	
	public static Queue CopyQueue(Queue q)
	{
		Queue newQueue = new Queue();
		Vector<Process> ts = new Vector<Process>();
		
		for(Process p : q.GetQueue())
		{
			ts.add(new Process(p.GetName(), p.GetArrivalTime(), p.GetBurstTime()));
		}
		
		newQueue.Set(ts);	
		
		return newQueue;
	}
	
	protected abstract void Process();
}
