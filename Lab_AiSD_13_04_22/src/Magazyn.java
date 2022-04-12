
public class Magazyn 
{
	private Queue<Klient> queue;
	
	public Magazyn()
	{
		queue = new Queue<Klient>();
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
}
