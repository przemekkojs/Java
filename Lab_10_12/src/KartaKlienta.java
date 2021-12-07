public abstract class KartaKlienta 
{
	private int numer;
	private String nazwisko;
	
	public KartaKlienta()
	{
		numer = 0;
		nazwisko = null;
	}
	
	public KartaKlienta(int _numer, String _nazwisko)
	{
		numer = _numer;
		nazwisko = _nazwisko;
	}
	
	public String ToString()
	{
		return String.format("Karta klienta numer %d, wlasciciel: %s%n", numer, nazwisko);
	}
	
	public abstract double Rabat();
}