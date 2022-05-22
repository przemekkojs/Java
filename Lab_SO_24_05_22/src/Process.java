import java.util.Random;

public class Process 
{
	private int load;
	private int id;
	private int arrivalTime;
	private int processor;
	
	private Random random;
	
	public Process(int _load, int _id, int _arrivalTime)
	{
		id = _id;
		load = _load;
		arrivalTime = _arrivalTime;
		
		random = new Random();
		
		processor = random.nextInt(Constants.PROCESSSORS_COUNT);
	}
	
	public int id()
	{
		return id;
	}
	
	public int load()
	{
		return load;
	}
	
	public int arrivalTime()
	{
		return arrivalTime;
	}
	
	public int processor()
	{
		return processor;
	}
	
	public String toString()
	{
		return String.format("Proces %d, u¿ywane zasoby: %d", id, load);
	}
}