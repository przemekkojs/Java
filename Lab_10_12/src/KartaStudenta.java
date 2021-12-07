public final class KartaStudenta extends KartaKlienta
{
	public KartaStudenta(int numer, String nazwisko)
	{
		super(numer, nazwisko);
	}
	
	public KartaStudenta()
	{
		super();
	}
	
	@Override
	public double Rabat() 
	{
		return 0.1d;
	}
}