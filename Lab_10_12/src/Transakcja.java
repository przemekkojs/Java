public class Transakcja 
{
	private static int numerTransakcji = 0;
	private int numer; //pomocnicza
	private double kwota;
	private KartaKlienta karta;
	
	public Transakcja()
	{		
		kwota = 0;
		karta = null;
		numer = numerTransakcji;
		numerTransakcji++;
	}
	
	public Transakcja(double _kwota, KartaKlienta _karta)
	{		
		kwota = _kwota;
		karta = _karta;
		numer = numerTransakcji;
		numerTransakcji++;
	}
	
	public String ToString()
	{
		return String.format("Numer transakcji: %d, kwota: %.2fzl, %s", numer, kwota, karta.ToString());
	}
	
	public double KwotaDoZaplaty()
	{
		return kwota - karta.Rabat() * kwota;
	}
	
	public KartaKlienta GetKarta()
	{
		return karta;
	}
}