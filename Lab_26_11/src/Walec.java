public final class Walec extends Bryla
{
	private int r;
	
	public Walec()
	{
		super("Bazowy", 1);
		r = 1;		
	}
	
	public Walec(int _r, int _h, String _nazwa)
	{
		super(_nazwa, _h);
		r = _r;		
	}
	
	@Override
	public double Objetosc() 
	{
		return Math.PI * r * r * super.GetWysokosc();
	}

	@Override
	public double Pole() 
	{		
		return ((2 * Math.PI * r * (r + super.GetWysokosc())) / 100d) * 100d;
	}
	
	@Override
	public String ToString()
	{
		return String.format("Walec (%s) [r = %d, h = %d]%n", super.GetNazwa(), r, super.GetWysokosc());
	}	
	
	public boolean ObrotKwadratu()
	{
		if(2 * r == super.GetWysokosc())
		{
			return true;
		}
		
		return false;
	}
}
