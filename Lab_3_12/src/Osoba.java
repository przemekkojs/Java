public abstract class Osoba 
{
	private String nazwisko;
	private String pesel;
	
	public Osoba()
	{
		nazwisko = "";
		pesel = "";
	}
	
	public Osoba(String n, String p)
	{
		nazwisko = n;
		pesel = p;
	}
	
	public String ToString()
	{
		return String.format("%s, pesel: %s%n", nazwisko, pesel);
	}
	
	public String GetNazwisko()
	{
		return nazwisko;
	}
	
	public String GetPesel()
	{
		return pesel;
	}
	
	public abstract double Oblicz();
}