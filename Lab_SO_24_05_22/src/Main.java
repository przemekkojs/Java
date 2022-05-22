
public class Main 
{
	private static ProcessManager manager;
	
	private static int queueSize;
	private static int processorsCount;
	
	public static void main(String args[])
	{
		init();
		
		manager.strategy1();
		manager.strategy2();
		manager.strategy3();
		
		System.out.println("Symulacja zakoñczona");
	}
	
	private static void init()
	{
		queueSize = Constants.QUEUE_SIZE;
		processorsCount = Constants.PROCESSSORS_COUNT;
		
		manager = new ProcessManager(queueSize, processorsCount);
	}	
}