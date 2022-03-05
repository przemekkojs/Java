import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Biblioteka 
{
	private ArrayList<Ksiazka> ksiazki;
	private CompareAutor cAutor;
	private CompareTytul cTytul;
	private CompareRokWydania cRok;
	
	public Biblioteka()
	{
		ksiazki = new ArrayList<>();
		CreateComparators();
	}
	
	public ArrayList<Ksiazka> GetKsiazki()
	{
		return ksiazki;
	}
	
	public void Add(Ksiazka k)
	{		
		ksiazki.add(k);
	}	
	
	public void Remove(Autor a)
	{		
		for(int i = 0; i < ksiazki.size(); i++)
		{
			if(ksiazki.get(i).GetAutor().Equals(a))
			{
				ksiazki.remove(i);
			}
		}
	}	
	
	public void WriteByTitle()
	{		
		System.out.println("Wypisanie alfabetycznie po tytule:");
		Collections.sort(GetKsiazki(), GetCompareTytul());
		
		Iterator<Ksiazka> i = ksiazki.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next().ToString());
		}
		
		System.out.println();
	}
	
	public void WriteByAuthor()
	{		
		Collections.sort(GetKsiazki(), GetCompareAutor());
		System.out.println("Wypisanie alfabetycznie po autorze:");		
		
		Iterator<Ksiazka> i = ksiazki.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next().ToString());
		}
		
		System.out.println();
	}
	
	public void WriteBy(Autor a)
	{		
		Collections.sort(GetKsiazki(), GetCompareTytul());
		System.out.println("Wypisanie alfabetycznie autora " + a.ToString() + ":");		
		
		for(Ksiazka k : ksiazki)
		{
			if(k.GetAutor().Equals(a))
			{
				System.out.println(k.ToString());
			}	
		}
		
		System.out.println();
	}
	
	public void WriteDistributor(String w)
	{		
		Collections.sort(GetKsiazki(), GetCompareRokWydania());
		System.out.println("Wypisanie wg roku wydania ksiazek z wydawnictwa " + w + ":");		
		
		for(Ksiazka k : ksiazki)
		{
			if(k.GetWydawnictwo().equals(w))
			{
				System.out.println(k.ToString());
			}	
		}
		
		System.out.println();
	}
	
	public void CreateComparators()
	{
		cAutor = new CompareAutor();
		cTytul = new CompareTytul();
		cRok = new CompareRokWydania();
	}
	
	public CompareAutor GetCompareAutor()
	{
		return cAutor;
	}
	
	public CompareTytul GetCompareTytul()
	{
		return cTytul;
	}
	
	public CompareRokWydania GetCompareRokWydania()
	{
		return cRok;
	}
	
	class CompareAutor implements Comparator<Ksiazka>
	{		
		public int compare(Ksiazka k1, Ksiazka k2) 
		{
			if(k1.GetAutor().GetNazwisko().charAt(0) < k2.GetAutor().GetNazwisko().charAt(0))
			{
				return -1;
			}
			else if(k1.GetAutor().GetNazwisko().charAt(0) > k2.GetAutor().GetNazwisko().charAt(0))
			{
				return 1;
			}
			
			return 0;
		}
	}	
	
	class CompareTytul implements Comparator<Ksiazka>
	{		
		public int compare(Ksiazka k1, Ksiazka k2) 
		{
			if(k1.GetTytul().charAt(0) < k2.GetTytul().charAt(0))
			{
				return -1;
			}
			else if(k1.GetTytul().charAt(0) > k2.GetTytul().charAt(0))
			{
				return 1;
			}
			
			return 0;
		}
	}
	
	class CompareRokWydania implements Comparator<Ksiazka>
	{		
		public int compare(Ksiazka k1, Ksiazka k2) 
		{
			if(k1.GetRokWydania() > k2.GetRokWydania())
			{
				return -1;
			}
			else if(k1.GetRokWydania() < k2.GetRokWydania())
			{
				return 1;
			}
			
			return 0;
		}
	}
}