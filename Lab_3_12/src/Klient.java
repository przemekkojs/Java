import java.util.Random;

public class Klient extends Osoba
{
	private int liczbaLokat;
	private Lokata[] lokaty;
	
	public Klient()
	{
		super();
		liczbaLokat = 0;
		lokaty = null;
	}
	
	public Klient(String _nazwisko, String _pesel, int _liczbaLokat)
	{
		super(_nazwisko, _pesel);
		liczbaLokat = _liczbaLokat;
		lokaty = new Lokata[liczbaLokat];
		
		Random random = new Random();
		
		for(int index = 0; index < liczbaLokat; index++)
		{			
			lokaty[index] = new Lokata(random.nextInt(500, 10001), random.nextInt(500, 10001) + random.nextDouble(), random.nextBoolean());
		}
	}
	
	@Override
	public String ToString()
	{
		return String.format("Klient %s, pesel %s: n = %d%n", super.GetNazwisko(), super.GetPesel(), liczbaLokat);
	}
	
	public void WyswietlLokaty()
	{
		if(lokaty != null)
		{
			for(Lokata l : lokaty)
			{
				System.out.printf("%s", l.ToString());
			}
		}		
	}
	
	@Override
	public double Oblicz() 
	{
		int sum = 0;
		
		for(Lokata l : lokaty)
		{
			sum += l.GetKwota();
		}
		
		return sum;
	}
}