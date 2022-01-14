public class Przemyslaw_Kojs_Komputer 
{
	public int RAM;
	public String Firm;
	public String Mark;
	public Przemyslaw_Kojs_Procesor Processor;
	
	public Przemyslaw_Kojs_Komputer(int ram, String f, String m, int cores, double clock, String n)
	{
		RAM = ram;
		Firm = f;
		Mark = m;
		
		Processor = new Przemyslaw_Kojs_Procesor(cores, clock, n);
	}
	
	public String ToString()
	{
		return String.format("%s %s %d %s", Firm, Mark, RAM, Processor.ToString());
	}
}
