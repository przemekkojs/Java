package Program;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import IteratorTablicowy.TabIterator;
import Pracownicy.PracownikEtatowy;
import Pracownicy.PracownikGodzinowy;
import Pracownik.Pracownik;

public class Main 
{
	private static Pracownik[] tab;
	
	public static void main(String args[])
	{		
		Init();
		Write(tab);
		
		WriteToFile(tab, "output.txt");
		Pracownik[] newTab = ReadFile("output.txt");
		Write(newTab);
	}
	
	private static void Init()
	{
		tab = new Pracownik[2];
		
		try
		{			
			for(int i = 0; i < tab.length; i++)
			{
				String typPracownika = getInfo("Podaj typ pracownika: ");
				
				if(!typPracownika.equals("etatowy") && !typPracownika.equals("godzinowy"))
				{
					System.out.println("Niew³aœciwy typ pracownika");
					i--;
					continue;
				}
				
				String imie = getInfo("Podaj imie: ");
				String nazwisko = getInfo("Podaj nazwisko: ");
				String stanowisko = getInfo("Podaj stanowisko: ");
				long pesel = Long.parseLong(getInfo("Podaj pesel: "));
				int staz = Integer.parseInt(getInfo("Podaj staz: "));				
				
				if(typPracownika.equals("etatowy"))
				{
					double pensja = Double.parseDouble(getInfo("Podaj pensjê: "));
					double etat = Double.parseDouble(getInfo("Podaj etat: "));
					tab[i] = new PracownikEtatowy(imie, nazwisko, stanowisko, pesel, staz, etat, pensja);
				}
				else
				{
					double stawka = Double.parseDouble(getInfo("Podaj stawkê godzinow¹: "));
					int liczbaGodzin = Integer.parseInt(getInfo("Podaj liczbê godzin: "));
					tab[i] = new PracownikGodzinowy(imie, nazwisko, stanowisko, pesel, staz, liczbaGodzin, stawka);
				}
			}
		}
		catch (IOException e)
		{			
			System.out.print("B³¹d czytania");
			e.printStackTrace();
		}
	}
	
	private static void Write(Pracownik[] t)
	{
		System.out.printf("%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s%n", "Nazwisko", "Imie", "Pesel", "Stanowisko", "Staz", "Pensja", "Etat/LG", "Stawka");
		
		TabIterator i = new TabIterator(t);
		
		while(i.hasNext())
		{
			System.out.println(i.next().toString());
		}
	}
	
	private static void WriteToFile(Pracownik[] t, String fileName)
	{
		try 
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
			
			oos.writeInt(t.length);
			
			for(int i = 0; i < t.length; i++)
			{
				oos.writeObject(t[i]);
			}
			
			oos.close();
		} 
		catch (IOException e) 
		{
			System.out.print("B³¹d wyjœcia");
			e.printStackTrace();
		}
	}
	
	private static Pracownik[] ReadFile(String fileName)
	{
		Pracownik[] res = new Pracownik[tab.length];
		
		try 
		{
			ObjectInputStream ios = new ObjectInputStream(new FileInputStream(fileName));
			
			int count = ios.readInt();
			System.out.println("Liczba pracowników: " + count);
			
			for(int i = 0; i < res.length; i++)
			{
				Pracownik p = (Pracownik) ios.readObject();
				res[i] = p;
			}
			
			ios.close();
		} 
		catch (IOException e) 
		{
			System.out.print("B³¹d odczytu");
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.print("B³¹d odczytu");
			e.printStackTrace();
		}
		
		return res;
	}
	
	private static String getInfo(String info) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print(info);
		
		return br.readLine();		
	}
}