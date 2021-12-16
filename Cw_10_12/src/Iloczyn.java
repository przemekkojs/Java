public class Iloczyn implements IDzialanie
{
	@Override
	public double Operacja(double[] liczby) 
	{
		double res = 1;
		
		for(double d : liczby)
		{
			res *= d;
		}
		
		return res;
	}
	
	@Override
	public void Wypisz(double wynik) 
	{
		System.out.printf("Wynik mnozenia: %.2f%n", wynik);
	}	
}