package Figura;

public class Prostokat extends Figura
{
	private boolean jestKwadratem;
	
	@Override
	public int Obwod() 
	{
		return (2 * super.GetA()) + (2 * super.GetB());
	}
	
	public Prostokat()
	{
		super();
		jestKwadratem = czyJestKwadratem();
	}
	
	public Prostokat(int _a, int _b, String _kolor)
	{
		super(_a, _b, _kolor);
		jestKwadratem = czyJestKwadratem();
	}
	
	private boolean czyJestKwadratem()
	{
		if(super.GetA() == super.GetB())
		{
			return true;
		}
		
		return false;
	}
	
	public boolean GetJestKwadratem()
	{
		return jestKwadratem;
	}
	
	@Override
	public String toString()
	{
		return String.format("Prostokat: %d x %d, kolor = %s", super.GetA(), super.GetB(), super.GetColor());
	}
}