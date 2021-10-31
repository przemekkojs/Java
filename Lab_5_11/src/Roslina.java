
public class Roslina 
{
	public int Dlugosc;
	
	public Roslina(int dlugosc)
	{
		Dlugosc = dlugosc;
	}
	
	public void Rosnij()
	{
		RosnijDuzo(1);
	}
	
	public void RosnijDuzo(int a)
	{
		if(Dlugosc > 0)
		{
			Dlugosc += a;
		}
	}
	
	public void Pokaz()
	{
		System.out.println(Dlugosc);
	}
}
