//Duplikaty ok

//Dodanie elementu - add (mo¿na równie¿ dodaæ na podanej pozycji - np. add(1, "A")
//Dostêp do elementu - get()
//Ustawienie elementu - set()
//Usuniecie elementu - remove() (po index albo wartoœci)
//Usuniêcie wszystkich - clear()
//Iloœæ elementów - size()

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListPrzyklad 
{
	private static ArrayList<Osoba> list = new ArrayList<>();
	
	public static void main(String[] args) 
	{
		list.add(new Osoba("Bartek", "Nijaki", 50));
		list.add(new Osoba("Adam", "Maly", 5));
		list.add(new Osoba("Adam", "Maly", 5));
		list.add(new Osoba("Adam", "Maly", 5));
		list.add(new Osoba("Adam", "Sredni", 10));
		list.add(new Osoba("Adam", "Duzy", 15));		
		
		Write();
		
		Collections.sort(list); //Sortowanie listy - wymaga by typ implementowa³ interfejs Comparable
		
		Write();
		
		list.remove(0);
		
		Write();
	}
	
	private static void Write()
	{
		for(Osoba o : list)
		{
			System.out.println(o.toString());
		}
		
		System.out.println();
	}
}
