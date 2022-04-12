
public class Main 
{
	private static Magazyn storage;
	
	public static void main(String[] args) 
	{
		Init();
		System.out.print("Ca³kowita kwota: " + storage.Serve());
	}
	
	private static void Init()
	{
		storage = new Magazyn();
		
		Klient k1 = new Klient("Klient 1");
		Klient k2 = new Klient("Klient 2");
		Klient k3 = new Klient("Klient 3");		
		
		k1.Add(new Zamowienie("Deski", 10, 10.0d));
		k1.Add(new Zamowienie("P³ótno", 2, 100.0d));
		
		k2.Add(new Zamowienie("Farby", 1, 100.0d));
		k2.Add(new Zamowienie("Blok", 1, 10.0d));
		k2.Add(new Zamowienie("Pêdzle", 3, 10.0d));
		
		k3.Add(new Zamowienie("Samochód", 1, 10000.0d));
		
		storage.Add(k1);
		storage.Add(k2);
		storage.Add(k3);
	}
}