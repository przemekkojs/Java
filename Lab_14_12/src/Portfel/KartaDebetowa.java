package Portfel;

public class KartaDebetowa extends SrodekPlatnosci
{
	private int numer;
	
	public KartaDebetowa()
	{		
		super();
		numer = 0;
	}
	
	public KartaDebetowa(int _numer, double _pieniadze)
	{
		super("Karta Debetowa", _pieniadze);
		numer = _numer;
	}
	
	@Override
	public String ToString()
	{
		return String.format("ID: %d, %s", numer, super.ToString());
	}
	
	@Override
	public double GetStan()
	{
		return super.GetStan();
	}
}