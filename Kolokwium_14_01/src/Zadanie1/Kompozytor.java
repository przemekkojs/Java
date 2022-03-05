package Zadanie1;

public class Kompozytor implements Comparable<Kompozytor>
{
	private String imie;
	private String nazwisko;
	
	public Kompozytor(String i, String n)
	{
		imie = i;
		nazwisko = n;
	}
	
	public String toString()
	{
		return String.format("%s %s", imie, nazwisko);
	}
	
	public String GetNazwisko()
	{
		return nazwisko;
	}
	
	public boolean equals(Kompozytor k)
	{
		if(imie == k.imie && nazwisko == k.nazwisko)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public int compareTo(Kompozytor o) 
	{
		if(nazwisko.charAt(0) > o.nazwisko.charAt(0))
		{
			return 1;
		}
		else if(nazwisko.charAt(0) < o.nazwisko.charAt(0))
		{
			return -1;
		}
		
		return 0;
	}
}