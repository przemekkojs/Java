public class Rysunki 
{
	private static Bryla[] bryly = new Bryla[20];
	private static int n = 6;
	
	public static void main(String[] args) 
	{		
		bryly[0] = new Walec();		
		bryly[1] = new Walec(1, 2, "Obrot Kwadratu");
		bryly[2] = new Walec(10, 20, "Duzy");
		bryly[3] = new Prostopadloscian();
		bryly[4] = new Prostopadloscian(2, 2, 2, "Szescian");		
		bryly[5] = new Prostopadloscian(3, 2, 3, "Prostopadloscian");
		
		MaxPool();
		ShowAll();
		ShowCylinders();
		ShowCubes();
		
		System.out.println("----------------------------------------");
		System.out.printf("Ilosc szescianow: %d%nIlosc walcow powstalych przez obrot kwadratu: %d%n", CubesCount(), CylindersCount());
	}
	
	public static void MaxPool()
	{
		double maxValue = bryly[0].Pole();
		int maxIndex = 0;
		
		String type = "Prostopadloscian";		
		
		for(int index = 1; index < n; index++)
		{
			if(bryly[index].Pole() > maxValue)
			{
				maxIndex = index;
				maxValue = bryly[index].Pole();
			}
		}
		
		if(bryly[maxIndex].getClass().equals(Walec.class))
		{
			type = "Walec";
		}
		
		System.out.printf("%s o najwiekszym polu: pozycja i = %d, pole = %.2f%n", type, maxIndex, maxValue);
	}
	
	public static void ShowAll()
	{
		System.out.println("----------------------------------------");
		System.out.println("Pokazuje wszystkie bryly:");
		
		for(int index = 0; index < n; index++)
		{			
			System.out.print(bryly[index].ToString());
		}
	}
	
	public static void ShowCylinders()
	{
		System.out.println("----------------------------------------");
		System.out.println("Pokazuje wszystkie walce:");
		
		for(int index = 0; index < n; index++)
		{
			if(bryly[index].getClass().equals(Walec.class))
			{
				System.out.print(bryly[index].ToString());
			}
		}
	}
	
	public static void ShowCubes()
	{
		System.out.println("----------------------------------------");
		System.out.println("Pokazuje wszystkie prostopadlosciany:");
		
		for(int index = 0; index < n; index++)
		{
			if(bryly[index].getClass().equals(Prostopadloscian.class))
			{
				System.out.print(bryly[index].ToString());
			}
		}
	}	
	
	public static int CubesCount()
	{
		int res = 0;
		
		for(int index = 0; index < n; index++)
		{
			if(bryly[index].getClass().equals(Prostopadloscian.class))
			{
				Prostopadloscian p = (Prostopadloscian)bryly[index];
				
				if(p.JestSzescianem())
				{
					res++;
				}
			}
		}
		
		return res;
	}
	
	public static int CylindersCount()
	{
		int res = 0;
		
		for(int index = 0; index < n; index++)
		{
			if(bryly[index].getClass().equals(Walec.class))
			{
				Walec w = (Walec)bryly[index];
				
				if(w.ObrotKwadratu())
				{
					res++;
				}
			}
		}
		
		return res;
	}
}