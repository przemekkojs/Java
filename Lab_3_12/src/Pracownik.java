import java.util.Random;

public class Pracownik extends Osoba
{
	private String stanowisko;
	private int pensja;
	private int stawka;
	private int[] nadgodziny;
	
	public Pracownik()
	{
		super();
		stanowisko = "brak";
		pensja = 0;
		stawka = 0;		
		
		nadgodziny = null;
	}
	
	public Pracownik(String _nazwisko, String _pesel, String _stanowisko, int _pensja, int _stawka)
	{
		super(_nazwisko, _pesel);
		stanowisko = _stanowisko;
		pensja = _pensja;
		stawka = _stawka;
		nadgodziny = new int[6];
		
		Random random = new Random();
		
		for(int index = 0; index < 6; index++)
		{
			nadgodziny[index] = random.nextInt(5);
		}
	}
	
	public void WyswietlLiczbeNadgodzin()
	{
		System.out.printf("Nadgodziny: %d%n", liczNadgodziny());
	}	
	
	public boolean JestKasjerem()
	{
		if(stanowisko == "Kasjer")
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public String ToString()
	{
		return String.format("Pracownik %s, pesel %s: stanowisko = %s, pensja = %d, stawka = %d%n", super.GetNazwisko(), super.GetPesel(), stanowisko, pensja, stawka);
	}
	
	@Override
	public double Oblicz() 
	{			
		return pensja + stawka * liczNadgodziny();
	}	
	
	private int liczNadgodziny()
	{
		int sum = 0;
		
		if(nadgodziny != null)
		{
			for(int i : nadgodziny)
			{
				sum += i;
			}
		}		
		
		return sum;
	}
	
	public String GetStanowisko()
	{
		return stanowisko;
	}
}