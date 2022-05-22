import java.util.Random;
import java.util.Vector;

public class Queue 
{
	private Vector<Vector<Process>> queue;
	private int size;
	private int processCount;
	
	private Random random;
	
	public Queue(int _size)
	{
		System.out.println("Inicjowanie kolejki...");
		
		size = _size;
		processCount = 0;
		queue = new Vector<Vector<Process>>();
		random = new Random();
		
		init();
		
		System.out.println("Inicjowanie kolejki zakoñczone");
		System.out.println();
	}
	
	private void init()
	{
		System.out.println(" -> Inicjowanie procesów...");
		
		int processId = 0;
		
		for(int arrivalTime = 0; arrivalTime < size; arrivalTime++)
		{
			queue.add(new Vector<Process>());
			
			int processesAtTime = random.nextInt(10);
			
			for(int i = 0; i < processesAtTime; i++)
			{
				queue.elementAt(arrivalTime).add(new Process(random.nextInt(3) + 1, processId, arrivalTime));
				processId++;
			}			
		}
		
		processCount = processId;
		
		System.out.println(" -> Inicjowanie procesów zakoñczone, liczba: " + processCount);		
	}
	
	public Vector<Vector<Process>> queue()
	{
		return queue;
	}
	
	public int size()
	{
		return size;
	}
	
	public int processCount()
	{
		return processCount;
	}
}
