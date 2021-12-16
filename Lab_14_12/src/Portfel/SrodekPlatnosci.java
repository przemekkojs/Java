package Portfel;

public class SrodekPlatnosci 
{
	private double pieniadze;
	private String nazwa;
	
	public SrodekPlatnosci()
	{
		nazwa = "";
		pieniadze = 0;
	}
	
	public SrodekPlatnosci(String _nazwa, double _pieniadze)
	{
		nazwa = _nazwa;
		pieniadze = _pieniadze;
	}
	
	public void Zaplac(double wartosc)
	{
		if(wartosc <= pieniadze)
		{
			pieniadze -= wartosc;
			System.out.printf("Zaplacono %.2f %s. Srodkow: %.2f%n", wartosc, nazwa, pieniadze);
		}
		else
		{
			System.out.printf("Zaplacono %.2f %s. Srodkow: 0%n", pieniadze, nazwa);
			pieniadze = 0;			
		}		
	}
	
	public void Zarob(double value)
	{
		pieniadze += value;
	}

	public double GetStan()
	{
		return pieniadze;
	}
	
	public String Nazwa()
	{
		return nazwa;
	}
	
	public String ToString()
	{
		return String.format("%s, srodkow: %.2f%n", nazwa, pieniadze);
	}
}