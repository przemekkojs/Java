package SJF;

import java.util.Vector;

import Overall.AbstractProcessor;
import Overall.Queue;
import Overall.Process;

//Wykonywany jest proces o najkrótszym czasie wykonania spoœród mo¿liwych

public class SjfProcessor extends AbstractProcessor
{	
	public SjfProcessor(Queue q)
	{
		super(q);
	}

	@Override
	public void Process() 
	{
		System.out.println();
		System.out.println("SJF: ");
		
		int waitingTime = 0;		
		int totalTime = 0;
		int count = queue.GetQueue().size();
		
		Process activeProcess = queue.GetQueue().firstElement();
		
		do
		{
			while(queue.GetQueue().size() > 0 && queue.GetQueue().firstElement().GetArrivalTime() == totalTime)
			{				
				System.out.print("Attached: " + queue.GetQueue().firstElement().GetName() + " (" + totalTime + "), ");				
				
				stack.add(queue.GetQueue().firstElement());				
				queue.GetQueue().remove(0);		
				
				if(totalTime == 0)
				{
					activeProcess = shortestProcess(stack);
				}
			}			
			
			if(stack.size() > 0)
			{					
				activeProcess.TimeDeploy();
				
				for(int i = 0; i < stack.size(); i++)
				{
					if(!stack.elementAt(i).equals(activeProcess))
					{
						stack.elementAt(i).Wait();
					}
				}
				
				if(activeProcess.GetTime() <= 0)
				{							
					if(activeProcess.GetTime() == 0)
					{						
						System.out.println("Executed: " + activeProcess.GetName() + " (" + totalTime + ")");
						done.add(activeProcess);
						stack.remove(activeProcess);						
					}						
					
					if(stack.size() > 0)
					{						
						activeProcess = shortestProcess(stack);
					}					
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
		if(list.size() > 0)
		{
			int min = list.firstElement().GetBurstTime();
			
			Process res = null;
			
			for(Process p : list)
			{
				if(p.GetTime() <= min)
				{
					res = p;
					min = p.GetBurstTime();
				}
			}
			
			return res;
		}
		
		return null;
	}
}
