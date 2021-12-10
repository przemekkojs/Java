package Portfel;

public class Portfel 
{
	private Karta karta;
	private Gotowka gotowka;
	
	public Portfel()
	{
		karta = null;
		gotowka = null;
	}
	
	public Portfel(Karta _karta, Gotowka _gotowka)
	{
		karta = _karta;
		gotowka = _gotowka;
	}
	
	public void StanPortfela()
	{
		System.out.printf("Stan portfela:%n%s%s", karta.ToString(), gotowka.ToString());
	}
	
	public Karta GetKarta()
	{
		return karta;
	}
	
	public Gotowka GetGotowka()
	{
		return gotowka;
	}
}
