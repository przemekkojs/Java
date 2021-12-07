public final class KartaSeniora extends KartaKlienta
{
	public KartaSeniora(int numer, String nazwisko)
	{
		super(numer, nazwisko);
	}
	
	public KartaSeniora()
	{
		super();
	}
	
	@Override
	public double Rabat()
	{
		return 0.15d;
	}
}