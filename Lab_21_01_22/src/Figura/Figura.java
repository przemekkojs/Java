package Figura;

public abstract class Figura
{
	private String kolor;
	private int a;
	private int b;
	
	public abstract int Obwod();
	
	public Figura()
	{
		a = 1;
		b = 1;
		kolor = "Czarny";		
	}
	
	public Figura(int _a, int _b, String _kolor)
	{
		a = _a;
		b = _b;
		kolor = _kolor;
	}
	
	public int GetA()
	{
		return a;
	}
	
	public int GetB()
	{
		return b;
	}
	
	public String GetColor()
	{
		return kolor;
	}
	
	@Override
	public String toString()
	{
		return String.format("Figura: %d x %d, kolor = %s", a, b, kolor);
	}
}