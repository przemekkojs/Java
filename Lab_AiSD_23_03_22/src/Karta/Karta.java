package Karta;

public class Karta 
{
	private int kolor;
	private int wartosc;
	private boolean znacznik;
	
	public Karta()
	{
		kolor = 0;
		wartosc = 0;
		znacznik = false;
	}
	
	public Karta(int _kolor, int _wartosc, boolean _znacznik)
	{
		kolor = _kolor;
		wartosc = _wartosc;
		znacznik = _znacznik;
	}
	
	public int GetKolor()
	{
		return kolor;
	}
	
	public int GetWartosc()
	{
		return wartosc;
	}
	
	public boolean GetZnacznik()
	{
		return znacznik;
	}
	
	public String toString()
	{
		if(!znacznik)
		{
			return "()";
		}
		
		return String.format("Kolor: %d, wartoœæ: %d", kolor, wartosc);
	}
}
