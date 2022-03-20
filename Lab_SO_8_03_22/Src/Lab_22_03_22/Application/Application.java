package Lab_22_03_22.Application;

import java.util.Random;

public class Application 
{
	private int arrivalTime;
	private int block;
	private int priority; //0 - zwyk³y, 1 - aplikacja real-time
	private int deadline;
	
	public Application(int _arrivalTime, int _block, int _priority, int _bound)
	{		
		Random random = new Random();
		
		arrivalTime = _arrivalTime;
		block = _block;
		priority = _priority;
		deadline = _arrivalTime + _priority * (random.nextInt(_bound) + 1);
	}
	
	public int Block()
	{
		return block;
	}
	
	public int ArrivalTime()
	{
		return arrivalTime;
	}
	
	public int Priority()
	{
		return priority;
	}
	
	public int Deadlint()
	{
		return deadline;
	}
}