
public class Klient 
{
	private Queue<Zamowienie> queue;
	private String nazwa;
	
	public Klient(String _n)
	{
		queue = new Queue<Zamowienie>();
		nazwa = _n;
	}
	
	public double Serve()
	{
		System.out.println("Zlecenie zrealizowane: " + nazwa);
		double res = 0;
		
		while(!queue.isEmpty())
		{
			try 
			{
				res += queue.dequeue().Serve();
			} 
			catch (EmptyQueueException e) 
			{				
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	public void Add(Zamowienie z)
	{
		queue.enqueue(z);
	}
}