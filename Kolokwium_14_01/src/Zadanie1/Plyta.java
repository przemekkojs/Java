package Zadanie1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Plyta implements Comparable<Plyta>
{
	private ArrayList<Utwor> utwory;
	
	private int numer;
	
	private CompareTytul cTytul;
	
	public Plyta(int n)
	{
		numer = n;
		utwory = new ArrayList<>();
		
		cTytul = new CompareTytul();
	}
	
	public void Add(Utwor u)
	{
		utwory.add(u);
	}
	
	public void WriteTime()
	{
		System.out.printf("Czas plyty: %.2f%n", calculateTime());
		System.out.println();
	}
	
	public void WriteComposersPieces(Kompozytor k)
	{
		System.out.printf("(Alfabetycznie) Utwory kompozytora %s na plycie o numerze %d:%n", k.toString(), numer);
		
		ArrayList<Utwor> help = utwory;		
		Collections.sort(help, cTytul);
		
		for(Utwor u : help)
		{
			if(u.GetKompozytor().equals(k))
			{
				System.out.println(u.toString());
			}
		}
		
		System.out.println();
	}
	
	public void WriteComposers()
	{
		System.out.printf("(Alfabetycznie) kompozytorzy na plycie o numerze %d:%n", numer);
		
		TreeSet<Kompozytor> help = new TreeSet<>();
		
		for(Utwor u : utwory)
		{
			help.add(u.GetKompozytor());
		}
		
		for(Kompozytor k : help)
		{
			System.out.println(k.toString());
		}
		
		System.out.println();
	}
	
	public void ShowAll()
	{
		System.out.printf("Wszystkie utwory na plycie o numerze %d:%n", numer);
		
		for(Utwor u : utwory)
		{
			System.out.println(u.toString());
		}
		
		System.out.println();
	}
	
	public ArrayList<Utwor> GetUtwory()
	{
		return utwory;
	}
	
	private float calculateTime()
	{
		float res = 0;
		
		for(Utwor u : utwory)
		{
			res += u.GetCzas();
		}
		
		return res;
	}

	@Override
	public int compareTo(Plyta o) 
	{
		if(numer > o.numer)
		{
			return 1;
		}
		else if(numer < o.numer)
		{
			return -1;
		}
		
		return 0;
	}
	
	class CompareTytul implements Comparator<Utwor>
	{
		@Override
		public int compare(Utwor o1, Utwor o2) 
		{
			if(o1.GetTytul().charAt(0) > o2.GetTytul().charAt(0))
			{
				return 1;
			}
			else if(o1.GetTytul().charAt(0) < o2.GetTytul().charAt(0))
			{
				return 1;
			}
			
			return 0;
		}		
	}
	
	class CompareKompozytor implements Comparator<Utwor>
	{
		@Override
		public int compare(Utwor o1, Utwor o2) 
		{
			if(o1.GetKompozytor().GetNazwisko().charAt(0) > o2.GetKompozytor().GetNazwisko().charAt(0))
			{
				return 1;
			}
			else if(o1.GetKompozytor().GetNazwisko().charAt(0) < o2.GetKompozytor().GetNazwisko().charAt(0))
			{
				return 1;
			}
			
			return 0;
		}		
	}
}
