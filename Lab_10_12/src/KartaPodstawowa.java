public final class KartaPodstawowa extends KartaKlienta
{
	public KartaPodstawowa(int numer, String nazwisko)
	{
		super(numer, nazwisko);
	}
	
	public KartaPodstawowa()
	{
		super();
	}
	
	@Override
	public double Rabat() 
	{
		return 0;
	}
}