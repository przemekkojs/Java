//Bez duplikatów
//Klasa musi implementowaæ interfest Comparable
//Iterowanie wymaga iteratora

//Dodanie - add()
//Usuniêcie - remove()
//Usuniêcie wszystkich - clear()
//Iloœæ elementów - size()

import java.util.HashSet;
import java.util.Iterator;

public class HashSetPrzyklad 
{
	private static HashSet<Osoba> set = new HashSet<>();
	
	public static void main(String[] args) 
	{
		set.add(new Osoba("Bartek", "Nijaki", 50));
		set.add(new Osoba("Bartek", "Nijaki", 50)); 
		set.add(new Osoba("Bartek", "Nijaki", 50));
		set.add(new Osoba("Adam", "Maly", 5));
		set.add(new Osoba("Adam", "Sredni", 10));
		set.add(new Osoba("Adam", "Duzy", 15));		
		
		WriteUsingIterator();
		
		set.remove(ElementIndex(0));
		
		WriteUsingFor();
	}
	
	//Dostêp do elementu na danej pozycji
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
	
	//Wypisanie z u¿yciem iteratora
	private static void WriteUsingIterator()
	{
		Iterator<Osoba> i = set.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next().toString());
		}
	}
	
	//Wypisanie wszystkich u¿ywaj¹c foreach
	private static void WriteUsingFor()
	{			
		for(Osoba o : set)
		{
			System.out.print(o.toString() + "\n");
		}	
	}
}
