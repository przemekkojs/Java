public class Roznica implements IDzialanie
{
	@Override
	public double Operacja(double[] liczby) 
	{
		double res = 0;
		
		for(double d : liczby)
		{
			res -= d;
		}
		
		return res;
	}
	
	@Override
	public void Wypisz(double wynik) 
	{
		System.out.printf("Wynik odejmowania: %.2f%n", wynik);
	}	
}