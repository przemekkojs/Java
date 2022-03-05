public class Przemyslaw_Kojs_KomputerTab 
{	
	Przemyslaw_Kojs_Komputer[] Komp;
	
	public Przemyslaw_Kojs_KomputerTab(int n)
	{
		Komp = new Przemyslaw_Kojs_Komputer[n];
	}
	
	public void Add(String firm, String mark, int RAM, int cores, double clock, String name)
	{
		int empty = 0;
		
		while(Komp[empty] != null && empty < Komp.length)
		{
			empty++;
		}
		
		Komp[empty] = new Przemyslaw_Kojs_Komputer(RAM, firm, mark, cores, clock, name);
	}
	
	public void Show()
	{
		System.out.println("Informacje o komputerach:");
		
		int y = 0;
		
		while(Komp[y] != null)
		{			
			System.out.print(Komp[y].ToString());
			y++;
		}
	}
	
	public void Show(String firm, double clock, String name)
	{
		System.out.printf("Informacje o komputerach firmy %s o nazwie procesora %s:%n", firm, name);
		
		int y = 0;
		
		while(Komp[y] != null)
		{
			if(Komp[y].Firm == firm && Komp[y].Processor.Clock == clock && Komp[y].Processor.Name == name)
			{
				System.out.print(Komp[y].ToString());				
			}
			
			y++;
		}
	}
}