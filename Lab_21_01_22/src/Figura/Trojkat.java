package Figura;

public class Trojkat extends Figura
{
	private int c;	
	private boolean jestTrojkatem;
	
	public Trojkat()
	{
		super();
		c = 1;
		jestTrojkatem = czyJestTrojkatem();
	}
	
	public Trojkat(int _a, int _b, int _c, String _kolor)
	{
		super(_a, _b, _kolor);
		c = _c;
		jestTrojkatem = czyJestTrojkatem();
	}
	
	@Override
	public int Obwod() 
	{		
		return super.GetA() + super.GetB() + c;
	}
	
	private boolean czyJestTrojkatem()
	{
		if(Math.abs(super.GetB() - c) < super.GetA() && super.GetA() < super.GetB() + c)
		{
			return true;
		}
		
		return false;
	}
	
	public int GetC()
	{
		return c;
	}
	
	public boolean GetJestTrojkatem()
	{
		return jestTrojkatem;
	}
	
	@Override
	public String toString()
	{
		return String.format("Trojkat: %d, %d, %d, kolor = %s", super.GetA(), super.GetB(), c, super.GetColor());
	}
}