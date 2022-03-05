public class Osoba implements Comparable<Osoba>
{
	public String Imie;
	public String Nazwisko;
	public int Wiek;
	
	public Osoba(String _imie, String _nazwisko, int _wiek)
	{
		Imie = _imie;
		Nazwisko = _nazwisko;
		Wiek = _wiek;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s, %d", Nazwisko, Imie, Wiek);
	}
	
	//Sami decydujemy wed³ug czego chcemy sortowaæ
	@Override
	public int compareTo(Osoba o) 
	{
		if(Nazwisko.charAt(0) > o.Nazwisko.charAt(0))
		{
			return 1;
		}
		else if(Nazwisko.charAt(0) < o.Nazwisko.charAt(0))
		{
			return -1;
		}
		
		return 0;
	}
	
	public boolean Equals(Osoba o)
	{
		if(Wiek == o.Wiek && Imie == o.Imie && Nazwisko == o.Nazwisko)
		{
			return true;
		}
		
		return false;
	}
	
	public int Compare(Osoba o1, Osoba o2)
	{
		if(o1.Nazwisko.charAt(0) > o2.Nazwisko.charAt(0))
		{
			return 1;
		}
		else if(o1.Nazwisko.charAt(0) < o2.Nazwisko.charAt(0))
		{
			return -1;
		}
		
		return 0;
	}
}