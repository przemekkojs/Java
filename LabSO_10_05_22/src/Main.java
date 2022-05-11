
public class Main 
{
	private static Queue queue;
	
	public static void main(String[] args) 
	{
		Init();		
		queue.initGlobalQueue();
		queue.processLRU();			
		
		queue.initProcesses(Strategy.PROPORTIONAL);
		queue.process();
		
		queue.initProcesses(Strategy.EQUAL);
		queue.process();		
		queue.initProcesses(Strategy.ERROR_FREQUENCY);		
		queue.process();		
		queue.initProcesses(Strategy.DISTRICTS);		
		queue.process();
	}
	
	private static void Init()
	{
		queue = new Queue();
	}
}
