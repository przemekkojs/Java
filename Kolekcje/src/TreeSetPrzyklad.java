//Bez duplikat�w
//Klasa musi implementowa� interfest Comparable
//Iterowanie wymaga iteratora

//Dodanie - add()
//Usuni�cie jednego - remove()
//Usuni�cie wszystkich - clear()
//Ile jest - size()
//Czy zawiera - contains()
//Pierwszy element - first()
//Ostatni elememt - last()

//Elementy przed podanym wg danego sortowania: lower()
//Elementy po podanym wg danego sortorania: higher()

//Usuni�cie pierwszego - pollFirst()
//Usuni�cie ostatniego - pollLast()

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetPrzyklad 
{
	private static TreeSet<Osoba> set = new TreeSet<>();
	
	public static void main(String[] args) 
	{		
		set.add(new Osoba("Bartek", "Nijaki", 50));
		set.add(new Osoba("Adam", "Maly", 5));
		set.add(new Osoba("Adam", "Maly", 5)); //Duplikaty zostan� pomini�te
		set.add(new Osoba("Adam", "Maly", 5)); //Duplikaty zostan� pomini�te
		set.add(new Osoba("Adam", "Sredni", 10));
		set.add(new Osoba("Adam", "Duzy", 15));		
		
		Write();		
		
		set.remove(ElementIndex(0));
		
		WriteUsingFor();	
		
		System.out.print(set.contains(new Osoba("A", "B", 1)));
	}
	
	//Dost�p do elementu na danej pozycji
	private static Osoba ElementIndex(int index)
	{
		Iterator<Osoba> i = set.iterator();
		int a = 0;
		
		Osoba res = null;
		
		while(i.hasNext() && a < index + 1)
		{
			a++;
			res = i.next();
		}
		
		return res;
	}
	
	//Wypisanie wszystkich u�ywaj�c iteratora
	private static void Write()
	{
		Iterator<Osoba> i = set.iterator();		
		while(i.hasNext())
		{
			System.out.print(i.next().toString() + "\n");
		}	
	}
	
	//Wypisanie wszystkich u�ywaj�c foreach
	private static void WriteUsingFor()
	{			
		for(Osoba o : set)
		{
			System.out.print(o.toString() + "\n");
		}	
	}
}