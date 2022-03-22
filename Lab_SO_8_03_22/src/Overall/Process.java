package Overall;

public class Process implements Comparable<Process>
{
	private String name;
	private int arrivalTime;
	private int burstTime;
	
	private int processTime;
	private int waitingTime;
	
	private boolean attached;
	
	public Process()
	{
		name = "P1";
		arrivalTime = 0;
		burstTime = 1;
		
		processTime = burstTime;
		waitingTime = 0;	
		
		attached = false;
	}
	
	public Process(String _name, int _arrivalTime, int _burstTime)
	{
		name = _name;
		arrivalTime = _arrivalTime;
		burstTime = _burstTime;
		
		processTime = burstTime;
		
		waitingTime = 0;
		
		attached = false;
	}
	
	public boolean Attached()
	{
		return attached;
	}
	
	public void TimeDeploy()
	{
		processTime--;
	}
	
	public void Wait()
	{
		waitingTime++;
	}
	
	public String GetName()
	{
		return name;
	}
	
	public int GetArrivalTime()
	{
		return arrivalTime;
	}
	
	public int GetBurstTime()
	{
		return burstTime;
	}
	
	public int GetTime()
	{
		return processTime;
	}
	
	public int GetWaitingTime()
	{
		return waitingTime;
	}
	
	@Override
	public int compareTo(Process p) 
	{
		if(this.arrivalTime > p.arrivalTime)
		{
			return 1; 
		}
		else if(this.arrivalTime < p.arrivalTime)
		{
			return -1; 
		}
		
		return 0;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s	%d	%d", name, arrivalTime, burstTime);
	}
	
	public boolean equals(Process p)
	{
		if(p.GetName() == name && p.GetArrivalTime() == arrivalTime && p.GetBurstTime() == burstTime)
		{
			return true;
		}
		
		return false;
	}
}
