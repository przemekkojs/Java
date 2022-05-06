
public class Main 
{
	private static Queue queue;
	
	public static void main(String[] args) 
	{
		Init();
		queue.process();
	}
	
	private static void Init()
	{
		queue = new Queue();
	}
}
