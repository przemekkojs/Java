package Portfel;

public class Gotowka 
{
	private double pieniadze;
	
	public Gotowka()
	{
		pieniadze = 0;
	}
	
	public Gotowka(double wartosc)
	{
		pieniadze = wartosc;
	}
	
	public void Zaplac(double wartosc)
	{
		if(wartosc <= pieniadze)
		{
			pieniadze -= wartosc;
			System.out.printf("Zaplacono gotowka. W portfelu: %.2f%n", pieniadze);
		}
		else
		{
			System.out.printf("Brak wystarczajacych srodkow. W portfelu: %.2f%n", pieniadze);
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
	
	public String ToString()
	{
		return String.format("W portfelu srodkow: %.2f%n", pieniadze);
	}
	
	public double GetStan()
	{
		return pieniadze;
	}
}
