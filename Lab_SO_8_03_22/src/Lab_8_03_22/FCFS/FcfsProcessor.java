package Lab_8_03_22.FCFS;
import Lab_8_03_22.Overall.AbstractProcessor;
import Lab_8_03_22.Overall.Queue;
import Lab_8_03_22.Overall.Process;

//W jakiej kolejnoœci procesy siê pojawi¹, w takiej zostan¹ wykonane

public class FcfsProcessor extends AbstractProcessor
{		
	public FcfsProcessor(Queue q)
	{
		super(q);
	}	
	
	public void Process()
	{		
		System.out.println();
		System.out.println("FCFS: ");
		
		int waitingTime = 0;	
		int totalTime = 0;		
		int count = queue.GetQueue().size();
		
		do
		{
			while(queue.GetQueue().size() > 0 && queue.GetQueue().firstElement().GetArrivalTime() == totalTime)
			{				
				System.out.print("Attached: " + queue.GetQueue().firstElement().GetName() + " (" + totalTime + "), ");
				
				stack.add(queue.GetQueue().firstElement());				
				queue.GetQueue().remove(0);		
			}
			
			totalTime++;
			
			if(stack.size() > 0)
			{
				stack.elementAt(0).TimeDeploy();
				
				for(int i = 1; i < stack.size(); i++)
				{
					stack.elementAt(i).Wait();
				}
				
				if(stack.elementAt(0).GetTime() == 0)
				{					
					System.out.println("Executed: " + stack.elementAt(0).GetName() + " (" + totalTime + ")");
					done.add(stack.elementAt(0));
					stack.remove(0);					
				}
			}					
			
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
}