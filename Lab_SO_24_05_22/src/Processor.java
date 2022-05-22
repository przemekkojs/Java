import java.util.Vector;

public class Processor 
{
	private int maxLoad;
	private int curLoad;
	
	private Vector<Process> attached;
	
	private String name;
	
	public Processor(int _maxLoad, String _name)
	{
		attached = new Vector<Process>();
		
		maxLoad = _maxLoad;
		name = _name;
	}
	
	public double usage()
	{
		return curLoad;
	}
	
	public boolean migrateProcess(Processor where)
	{
		if(attached.isEmpty()) return false;		
		
		where.attachProcess(attached.lastElement());
		curLoad -= attached.lastElement().load();
		attached.remove(attached.size() - 1);
		
		return true;
	}
	
	public boolean attachProcess(Process p)
	{		
		if(curLoad + p.load() > maxLoad)
		{
			System.out.printf(" -> Nie mo¿na do³¹czyæ procesu %d do procesora %s%n", p.id(), name);
			return false;
		}
		
		attached.add(p);
		curLoad += p.load();
		return true;
	}
	
	public void reset()
	{
		curLoad = 0;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s, maksymalne obci¹¿enie: %d, zu¿ycie: %.2f, iloœæ procesów: %d", name, maxLoad, usage(), attached.size());
	}
}
