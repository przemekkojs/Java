public class Magazyn 
{
	private Queue<Klient> queue;
	private String nazwa;
	
	public Magazyn(String n)
	{
		queue = new Queue<Klient>();
		nazwa = n;
	}
	
	public void Add(Klient k)
	{
		queue.enqueue(k);
	}
	
	public double Serve()
	{		
		double res = 0;
		
		try 
		{
			while(!queue.isEmpty())
			{
				res += queue.dequeue().Serve();
			}			
		} 
		catch (EmptyQueueException e) 
		{			
			e.printStackTrace();
		}
		
		return res;
	}
	
	public String name()
	{
		return nazwa;
	}
}