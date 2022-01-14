public class Przemyslaw_Kojs_Procesor 
{
	public int Cores;
	public String Name;
	public double Clock;
	
	public Przemyslaw_Kojs_Procesor(int cores, double clock, String name)
	{
		Cores = cores;
		Clock = clock;
		Name = name;
	}	
	
	public String ToString()
	{
		return String.format("Procesor: %s %d rdzeni(e) %.2f Hz%n", Name, Cores, Clock);
	}
	
	public boolean Equals(int cores, int clock, String name)
	{
		if(cores == Cores && clock == Clock && name == Name)
		{
			return true;
		}
		
		return false;
	}
}