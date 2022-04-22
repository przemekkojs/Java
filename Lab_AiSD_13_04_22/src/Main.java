public class Main 
{	
	private static Firma firm;
	
	public static void main(String[] args) 
	{
		Init();
		System.out.print("Ca³kowita kwota: " + firm.Serve());
	}
	
	private static void Init()
	{
		firm = new Firma();
		
		Magazyn storage1 = new Magazyn("Magazyn 1");
		Magazyn storage2 = new Magazyn("Magazyn 2");
		Magazyn storage3 = new Magazyn("Magazyn 3");
		
		Klient k1 = new Klient("Klient 1");
		Klient k2 = new Klient("Klient 2");
		Klient k3 = new Klient("Klient 3");	
		Klient k4 = new Klient("Klient 4");	
		
		k1.Add(new Zamowienie("Deski", 10, 10.0d));
		k1.Add(new Zamowienie("P³ótno", 2, 100.0d));
		
		k2.Add(new Zamowienie("Farby", 1, 100.0d));
		k2.Add(new Zamowienie("Blok", 1, 10.0d));
		k2.Add(new Zamowienie("Pêdzle", 3, 10.0d));
		
		k3.Add(new Zamowienie("Samochód", 1, 10000.0d));
		
		k4.Add(new Zamowienie("Jacht", 1, 50000.0d));
		k4.Add(new Zamowienie("Baton", 1, 1.0d));
		
		storage1.Add(k1);
		storage1.Add(k2);
		storage2.Add(k3);
		storage3.Add(k4);
		
		firm.Add(storage1);
		firm.Add(storage2);
		firm.Add(storage3);
	}
}