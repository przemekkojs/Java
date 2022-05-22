import java.util.Vector;

public class Processors 
{
	private Vector<Processor> processors;
	private int size;
	
	public Processors(int _size)
	{
		System.out.println("Inicjowanie procesorów...");
		
		size = _size;
		processors = new Vector<Processor>();
		
		init();
		
		System.out.println("Inicjowanie procesorów zakoñczone");
		System.out.println();
	}
	
	private void init()
	{
		System.out.println(" -> generowanie...");
		
		for(int i = 0; i < size; i++)
		{
			processors.add(new Processor(100, String.format("Procesor %d", i)));
		}
		
		System.out.println(" -> generowanie zakoñczone");		
	}
	
	public Vector<Processor> processors()
	{
		return processors;
	}
	
	public void reset()
	{
		System.out.println(" -> Resetowanie procesorów...");
		
		for(Processor p : processors)
		{
			p.reset();
		}
		
		System.out.println(" -> Resetowanie procesorów zakoñczone");		
	}
	
	public int size()
	{
		return size;
	}
}
