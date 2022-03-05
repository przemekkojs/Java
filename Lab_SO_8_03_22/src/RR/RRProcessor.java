package RR;

import java.util.Vector;

import Overall.AbstractProcessor;
import Overall.Queue;
import Overall.Process;

public class RRProcessor extends AbstractProcessor 
{
	private int quantumTime = 0;
	
	public RRProcessor(Queue q) 
	{
		super(q);		
		SetQuantumTime(0);
	}

	@Override
	public void Process() 
	{
		System.out.println();
		System.out.println("RR for quantum time " + quantumTime + ": ");
		
		int curTime = 0;
		int totalTime = 0;
		int curElementIndex = 0;
		int count = queue.GetQueue().size();
		
		int waitingTime = 0;
		
		do
		{
			while(queue.GetQueue().size() > 0 && queue.GetQueue().firstElement().GetArrivalTime() == totalTime)
			{				
				System.out.print("Attached: " + queue.GetQueue().firstElement().GetName() + " (" + totalTime + "), ");
				
				stack.add(queue.GetQueue().firstElement());				
				queue.GetQueue().remove(0);
			}		
			
			curTime++;
			totalTime++;
			
			if(stack.size() > 0 && curElementIndex < stack.size())
			{
				stack.elementAt(curElementIndex).TimeDeploy();
				
				System.out.println("EXECUTING: " + stack.elementAt(curElementIndex).GetName() + " (" + totalTime + "), ");
				
				for(int i = 0; i < stack.size(); i++)
				{
					if(!stack.elementAt(i).equals(stack.elementAt(curElementIndex)))
					{
						stack.elementAt(i).Wait();
					}
				}
				
				if(stack.elementAt(curElementIndex).GetTime() == 0)
				{
					System.out.println(" ===> Executed: " + stack.elementAt(curElementIndex).GetName() + " (" + totalTime + ")");
					done.add(stack.elementAt(curElementIndex));
					stack.remove(stack.elementAt(curElementIndex));			
					
					curTime = 0;
				}
			}		
			
			if(curTime >= quantumTime)
			{	
				curTime = 0;
				curElementIndex++;
				
				if(curElementIndex >= stack.size())
				{
					curElementIndex = 0;
				}
			}			
		} while(queue.GetQueue().size() + stack.size() > 0);
	
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
	
	public void SetQuantumTime(int time)
	{
		quantumTime = time;
		
		if(time == 0)
		{
			quantumTime = GetSmallestProcessTime();
		}
	}
	
	private int GetSmallestProcessTime()
	{
		Vector<Process> help = queue.GetQueue();
		int min = help.elementAt(0).GetBurstTime();
		
		for(int i = 1; i < help.size(); i++)
		{
			if(help.elementAt(i).GetBurstTime() < min)
			{
				min = help.elementAt(i).GetBurstTime();
			}
		}
		
		return min;
	}
}