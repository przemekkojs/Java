package Portfel;

public class Karta 
{
	private int numer;
	private double pieniadze;
	
	public Karta()
	{
		numer = 0;
		pieniadze = 0;
	}
	
	public Karta(int _numer, double _pieniadze)
	{
		numer = _numer;
		pieniadze = _pieniadze;
	}
	
	public void Zaplac(double wartosc)
	{
		if(wartosc <= pieniadze)
		{
			pieniadze -= wartosc;
			System.out.printf("Zaplacono karta. Srodkow: %.2f na karcie %d%n", pieniadze, numer);
		}
		else
		{
			System.out.printf("Brak wystarczajacych srodkow na karcie %d. Srodkow: %.2f%n", numer, pieniadze);
		}
	}
	
	public boolean CzyWystarczy(double wartosc)
	{
		if(wartosc <= pieniadze)
		{
			return true;
		}

		return false;
	}
	
	public double GetStan()
	{
		return pieniadze;
	}
	
	public String ToString()
	{
		return String.format("Karta o numerze: %d, srodkow: %.2f%n", numer, pieniadze);
	}
}