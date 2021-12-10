public class Main 
{
	private static Suma suma = new Suma();
	private static Roznica roznica = new Roznica();
	private static Iloczyn iloczyn = new Iloczyn();
	private static Dzielenie dzielenie = new Dzielenie();
	
	public static void main(String[] args) 
	{
		setIDzialanie('+', new double[] {1.0d, 2.0d});		
	}
	
	private static void setIDzialanie(char dzialanie, double[] liczby)
	{
		switch(dzialanie)
		{
		case '+':
			suma.Wypisz(suma.Operacja(liczby));
			break;
		
		}
	}
}