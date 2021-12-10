public class Dzielenie implements IDzialanie
{
	@Override
	public double Operacja(double[] liczby) 
	{
		double res = 1;
		
		for(double d : liczby)
		{
			res /= d;
		}
		
		return res;
	}
	
	@Override
	public void Wypisz(double wynik) 
	{
		System.out.printf("Wynik dzielenia: %.2f%n", wynik);
	}	
}