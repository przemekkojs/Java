package Zadanie1;

public class Utwor implements Comparable<Utwor>
{
	private float czas;
	private Kompozytor kompozytor;
	private String tytul;
	
	public Utwor(Kompozytor k, String t, float c)
	{
		czas = c;
		tytul = t;
		kompozytor = k;
	}
	
	public Kompozytor GetKompozytor()
	{
		return kompozytor;
	}
	
	public String GetTytul()
	{
		return tytul;
	}
	
	public float GetCzas()
	{
		return czas;
	}
	
	public String toString()
	{
		return String.format("%s - %s, %.2f", kompozytor.toString(), tytul, czas);
	}

	@Override
	public int compareTo(Utwor o) 
	{
		if(tytul.charAt(0) > o.tytul.charAt(0))
		{
			return 1;
		}
		else if(tytul.charAt(0) < o.tytul.charAt(0))
		{
			return -1;
		}
		
		return 0;
	}
}