import java.util.Vector;

public class Processors 
{
	private Vector<Processor> processors;
	private int size;
	
	public Processors(int _size)
	{
		System.out.println("Inicjowanie procesor�w...");
		
		size = _size;
		processors = new Vector<Processor>();
		
		init();
		
		System.out.println("Inicjowanie procesor�w zako�czone");
		System.out.println();
	}
	
	private void init()
	{
		System.out.println(" -> generowanie...");
		
		for(int i = 0; i < size; i++)
		{
			processors.add(new Processor(100, String.format("Procesor %d", i)));
		}
		
		System.out.println(" -> generowanie zako�czone");		
	}
	
	public Vector<Processor> processors()
	{
		return processors;
	}
	
	public void reset()
	{
		System.out.println(" -> Resetowanie procesor�w...");
		
		for(Processor p : processors)
		{
			p.reset();
		}
		
		System.out.println(" -> Resetowanie procesor�w zako�czone");		
	}
	
	public int size()
	{
		return size;
	}
}
