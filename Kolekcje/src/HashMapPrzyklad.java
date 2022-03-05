//Sortowanie wg. klucza - klasa nie musi implementowaæ interfejsu Comparable

//Dodanie - put(K, V)
//Usuniecie - remove(K)
//Usuniêcie wszystkich - clear()
//Dostêp do elementu - get(K)
//Ile elementów - size()

//klucze - keySet()
//wartoœci - values()

import java.util.HashMap;

public class HashMapPrzyklad 
{
	private static HashMap<Integer, Osoba> map = new HashMap<Integer, Osoba>();
	
	public static void main(String[] args) 
	{
		map.put(0, new Osoba("Adam", "Maly", 5));
		map.put(1, new Osoba("Adam", "Sredni", 10));
		map.put(2, new Osoba("Adam", "Duzy", 15));
		map.put(3, new Osoba("Bartek", "Nijaki", 50));		
		
		Write();
	}
	
	private static void Write()
	{
		for(Osoba o : map.values())
		{
			System.out.println(o.toString());
		}
		
		System.out.println();
	}
}
