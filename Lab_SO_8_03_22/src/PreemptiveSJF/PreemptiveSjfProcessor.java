package PreemptiveSJF;

import java.util.Vector;

import Overall.AbstractProcessor;
import Overall.Queue;
import Overall.Process;

public class PreemptiveSjfProcessor extends AbstractProcessor
{	
	public PreemptiveSjfProcessor(Queue q)
	{
		super(q);
	}

	@Override
	public void Process() 
	{
		System.out.println();
		System.out.println("Preemptive SJF: ");
		
		int count = queue.GetQueue().size();
		int waitingTime = 0;
		int totalTime = 0;
		
		do
		{
			while(queue.GetQueue().size() > 0 && queue.GetQueue().firstElement().GetArrivalTime() == totalTime)
			{				
				System.out.print("Attached: " + queue.GetQueue().firstElement().GetName() + " (" + totalTime + "), ");
				
				stack.add(queue.GetQueue().firstElement());				
				queue.GetQueue().remove(0);				
			}			
			
			if(stack.size() > 0)
			{
				Process shortest = shortestProcess(stack);
				shortest.TimeDeploy();				
				
				for(int i = 0; i < stack.size(); i++)
				{
					if(!stack.elementAt(i).equals(shortest))
					{
						stack.elementAt(i).Wait();
					}
				}
				
				if(shortest.GetTime() == 0)
				{								
					System.out.println("Executed: " + shortest.GetName() + " (" + totalTime + ")");
					done.add(shortest);
					stack.remove(shortest);					
				}
			}	
			
			totalTime++;
			
		} while(stack.size() + queue.GetQueue().size() > 0);
		
		System.out.println();		
		System.out.println("Waiting times: ");		
		
		for(Process p : done)
		{
			waitingTime += p.GetWaitingTime();
			System.out.println(p.GetWaitingTime());
		}	
		
		System.out.println("Avg waiting time: " + waitingTime * 1.0f / count * 1.0f);
		System.out.println("Total process time: " + totalTime);		
		System.out.println("=================================================================");	
	}
	
	private Process shortestProcess(Vector<Process> list)
	{
		int min = list.firstElement().GetBurstTime();
		
		Process res = null;
		
		for(Process p : list)
		{
			if(p.GetTime() <= min)
			{
				res = p;
				min = p.GetTime();
			}
		}
		
		return res;
	}
}