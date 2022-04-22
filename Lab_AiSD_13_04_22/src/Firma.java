public class Firma 
{	
	private Queue<Magazyn> queue;
	
	public Firma()
	{
		queue = new Queue<Magazyn>();
	}
	
	public double Serve()
	{
		double res = 0;
		
		while(!queue.isEmpty())
		{
			try 
			{
				System.out.println(queue.first().name());
				res += queue.dequeue().Serve();
			}
			catch (EmptyQueueException e)
			{				
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	public void Add(Magazyn m)
	{
		queue.enqueue(m);
	}
}