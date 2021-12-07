public class Transakcja 
{
	private static int numerTransakcji = 0;
	private double kwota;
	private KartaKlienta karta;
	
	public Transakcja()
	{
		numerTransakcji++;
		kwota = 0;
		karta = null;
	}
	
	public Transakcja(double _kwota, KartaKlienta _karta)
	{
		numerTransakcji++;
		kwota = _kwota;
		karta = _karta;
	}
	
	public String ToString()
	{
		return String.format("Numer transakcji: %d, kwota: %.2fzl, %s", numerTransakcji, kwota, karta.ToString());
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