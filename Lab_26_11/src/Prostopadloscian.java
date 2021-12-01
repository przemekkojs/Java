public final class Prostopadloscian extends Bryla
{
	public int a;
	public int b;
	
	public Prostopadloscian()
	{
		super("Bazowy", 1);
		a = 1;
		b = 1;		
	}
	
	public Prostopadloscian(int _a, int _b, int _h, String _nazwa)
	{
		super(_nazwa, _h);
		a = _a;
		b = _b;		
	}	
	
	public boolean JestSzescianem()
	{
		if(a == b && a == super.GetWysokosc())
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public double Objetosc() 
	{		
		return a * b * super.GetWysokosc();
	}

	@Override
	public double Pole() 
	{
		return 2*(a*b + a*super.GetWysokosc() + b*super.GetWysokosc());
	}
	
	@Override
	public String ToString()
	{
		return String.format("Prostopadloscian (%s) [a = %d, b = %d, h = %d]%n", super.GetNazwa(), a, b, super.GetWysokosc());
	}	
}
