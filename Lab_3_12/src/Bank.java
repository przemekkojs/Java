public class Bank 
{
	private static Osoba[] osoby = new Osoba[20];
	private static int n = 5;
	
	public static void main(String[] args)
	{
		osoby[0] = new Pracownik();
		osoby[1] = new Pracownik("Dziadek Pszemek", "03230404***", "Programista", 5000, 20);
		osoby[2] = new Pracownik("Anon", "98765432109", "Kasjer", 5000, 20);
		osoby[3] = new Klient();
		osoby[4] = new Klient("Szybki Bill", "12345678901", 3);
		
		ShowAll();	
		System.out.println("------------------------------------------");
		ShowWorkers();
		System.out.println("------------------------------------------");
		ShowClients();
		System.out.println("------------------------------------------");
		System.out.println("Iloœæ kasjerow w banku: " + CountCashiers());
		System.out.println("------------------------------------------");
		TheWealthiest();
	}
	
	public static void ShowAll()
	{
		for(int index = 0; index < n; index++)
		{
			System.out.printf(osoby[index].ToString());
		}
	}
	
	public static void ShowWorkers()
	{
		for(int index = 0; index < n; index++)
		{
			if(osoby[index].getClass().equals(Pracownik.class))
			{
				System.out.print(osoby[index].ToString());
				((Pracownik) osoby[index]).WyswietlLiczbeNadgodzin();
			}
		}
	}
	
	public static void ShowClients()
	{
		for(int index = 0; index < n; index++)
		{
			if(osoby[index].getClass().equals(Klient.class))
			{
				System.out.print(osoby[index].ToString());
				((Klient) osoby[index]).WyswietlLokaty();
			}
		}
	}
	
	public static int CountCashiers()
	{
		int res = 0;
		
		for(int index = 0; index < n; index++)
		{
			if(osoby[index].getClass().equals(Pracownik.class) && ((Pracownik) osoby[index]).JestKasjerem())
			{				
				res++;
			}
		}
		
		return res;
	}
	
	public static void TheWealthiest()
	{
		double curMax = ((Pracownik) osoby[0]).Oblicz();
		int curMaxIndex = 0;
		
		for(int index = 1; index < n; index++)
		{
			if(osoby[index].getClass().equals(Pracownik.class))
			{				
				if(((Pracownik) osoby[index]).Oblicz() > curMax)
				{
					curMax = osoby[index].Oblicz();
					curMaxIndex = index;
				}
			}
		}
		
		System.out.printf("%sstanowisko: %s", osoby[curMaxIndex].ToString(), ((Pracownik) osoby[curMaxIndex]).GetStanowisko());
	}
}