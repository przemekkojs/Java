package Zadanie1;

import java.util.TreeSet;

public class Ewidencja 
{
	private static TreeSet<Plyta> plyty = new TreeSet<>();
	private static TreeSet<Utwor> wszystkieUtwory = new TreeSet<>();
	private static TreeSet<Kompozytor> kompozytorzy = new TreeSet<>();
	
	private static Utwor Bum = new Utwor(new Kompozytor("A", "A"), "Bum", 3.0f);
	private static Utwor Siup = new Utwor(new Kompozytor("A", "B"), "Siup", 4.0f); 
	private static Utwor Pyk = new Utwor(new Kompozytor("A", "A"), "Pyk", 2.0f); //
	private static Utwor Rampam = new Utwor(new Kompozytor("A", "B"), "Rampam", 3.0f);
	private static Utwor Dum = new Utwor(new Kompozytor("A", "C"), "Dum", 2.0f);
	private static Utwor Tym = new Utwor(new Kompozytor("A", "D"), "Tym", 3.0f);
	
	private static Plyta album1 = new Plyta(0);
	private static Plyta album2 = new Plyta(1);
	private static Plyta album3 = new Plyta(2);
	
	public static void main(String[] args)
	{		
		Init();
		InitUtwory();
		InitKompozytorzy();
		WriteUtwory();		
		WriteKompozytorzy();
		
		album1.ShowAll();
		album1.WriteTime();	
		album1.WriteComposersPieces(new Kompozytor("A", "A"));
		album1.WriteComposers();
		
		WritePiecesBy(new Kompozytor("A", "A"));
	}
	
	private static void Init()
	{		
		plyty.add(album1);
		plyty.add(album2);
		plyty.add(album3);
		
		album1.Add(Bum);
		album1.Add(Siup);
		album1.Add(Pyk);		
		
		album2.Add(Pyk);
		album2.Add(Rampam);
		album2.Add(Dum);		
		
		album3.Add(Tym);
		album3.Add(Rampam);
		album3.Add(Siup);
	}
	
	private static void InitUtwory()
	{
		wszystkieUtwory.addAll(album1.GetUtwory());
		wszystkieUtwory.addAll(album2.GetUtwory());
		wszystkieUtwory.addAll(album3.GetUtwory());
	}
	
	private static void WriteUtwory()
	{
		System.out.println("Wszystkie utwory na plytach:");
		
		for(Utwor u : wszystkieUtwory)
		{
			System.out.println(u.toString());
		}
		
		System.out.println();
	}
	
	private static void InitKompozytorzy()
	{
		for(Utwor u : wszystkieUtwory)
		{
			kompozytorzy.add(u.GetKompozytor());
		}
	}
	
	private static void WriteKompozytorzy()
	{
		System.out.println("Wszyscy kompozytorzy na plytach:");
		
		for(Kompozytor k : kompozytorzy)
		{
			System.out.println(k.toString());
		}
		
		System.out.println();
	}
	
	private static void WritePiecesBy(Kompozytor k)
	{
		System.out.printf("Utwory kompozytora %s:%n", k.toString());
		
		for(Utwor u : wszystkieUtwory)
		{
			if(u.GetKompozytor().equals(k))
			{
				System.out.println(u.toString());
			}
		}
		
		System.out.println();
	}
}
