package Overall;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

public class Queue 
{
	private Vector<Process> queue;
	private int[] arrivalTimes;
	
	public Queue()
	{
		queue = new Vector<Process>();		
	}
	
	public void Init(int processCount)
	{
		arrivalTimes = new int[processCount];
		Random random = new Random();
		
		for(int i = 0; i < processCount; i++)
		{
			arrivalTimes[i] = random.nextInt(10);
		}
		
		String processName;
		int arrivalTime;
		int burstTime;
		
		for(int i = 0; i < processCount; i++)
		{
			processName = String.format("P%d", i);
			arrivalTime = arrivalTimes[i];
			burstTime = random.nextInt(1, 11);
			
			queue.add(new Process(processName, arrivalTime, burstTime));
		}
		
		SortQueue();
	}	
	
	public void Init(Process[] tab)
	{
		for(Process p : tab)
		{
			queue.add(p);
		}
		
		SortQueue();
	}
	
	public void WriteQueue()
	{
		System.out.println("Original: ");
		System.out.println("Name	A	B");
		
		for(Process p : queue)
		{
			System.out.println(p.toString());
		}
		
		System.out.println("=========================");
	}
	
	public Vector<Process> GetQueue()
	{
		return queue;
	}
	
	public void Set(Vector<Process> q)
	{
		queue = q;
	}
	
	@Override
	public String toString()
	{
		return null;		
	}
	
	private void SortQueue()
	{
		Collections.sort(queue, new Comparator<Process>() {
			@Override
			public int compare(Process o1, Process o2) 
			{
				if(o1.GetArrivalTime() > o2.GetArrivalTime())
				{
					return 1;
				}
				else if(o1.GetArrivalTime() < o2.GetArrivalTime())
				{
					return -1;
				}
				
				return 0;
			}			
		});
	}
}