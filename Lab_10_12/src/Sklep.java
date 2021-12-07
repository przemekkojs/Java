import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Sklep 
{
	private static Transakcja[] transakcje = new Transakcja[100];
	
	public static void main(String[] args) 
	{
		Menu();
		Command("Dodaj");
		Command("DodajKilka");
		Command("A");
		Command("Wyswietl");
		Command("Seniorzy");
		Command("Student");
		Command("Zapisz");
	}
	
	private static void ShowAll()
	{
		int index = 0;
		while(transakcje[index] != null)
		{
			System.out.print(transakcje[index].ToString());
			index++;
		}
	}
	
	private static int HowManySenior()
	{
		int res = 0;
		int index = 0;
		
		while(transakcje[index] != null)
		{
			if(transakcje[index].GetKarta().getClass().equals(KartaSeniora.class))
			{
				res++;
			}
			
			index++;
		}
		
		return res;
	}
	
	private static void RichStudent()
	{		
		int curMaxIndex = 0;
		double curMaxValue = 0;
		int index = 0;
		
		while(transakcje[index] != null)
		{
			if(transakcje[index].GetKarta().getClass().equals(KartaStudenta.class) && curMaxValue < transakcje[index].KwotaDoZaplaty())
			{
				curMaxIndex = index;
				curMaxValue = transakcje[index].KwotaDoZaplaty();
			}
			
			index++;
		}	
		
		System.out.print(transakcje[curMaxIndex].GetKarta().ToString());
	}
	
	private static void Add(Transakcja t)
	{
		int freeIndex = 0;
		
		while(transakcje[freeIndex] != null)
		{
			freeIndex++;
		}
		
		transakcje[freeIndex] = t;
		System.out.printf("	Dodano transakcje %d, info: %s", freeIndex, t.ToString());
	}
	
	private static void Save()
	{
		BufferedWriter w = null;
		
		try 
		{
			File f = new File("output.txt");
			FileWriter file = new FileWriter(f);
			w = new BufferedWriter(file);
			
			w.write(String.format("Transakcje z uzyciem karty studenta:%n"));
			
			int index = 0;
			while(transakcje[index] != null)
			{
				if(transakcje[index].GetKarta().getClass().equals(KartaStudenta.class))
				{
					w.write(transakcje[index].ToString());
				}
				
				index++;
			}			
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
		finally
		{ 
			try
		   	{
				if(w!=null)
				{
					w.close();
				}					
		   	}
		   	catch(Exception ex)
		   	{
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}
	}
	
	private static void Menu()
	{
		System.out.printf("MENU%nOpcje:%n"
				+ " -> Dodaj - Dodaj jedna transakcje%n"
				+ " -> DodajKilka - dodaj kilka transakcji%n"
				+ " -> Wyswietl - wyswietla wszystkie transakcje%n"
				+ " -> Seniorzy - liczy ile bylo transakcji z uzyciem karty seniora%n"
				+ " -> Student - wyswietla studenta ktory zaplacil najwiecej%n"
				+ " -> Zapisz - zapisuje do pliku transakcje z karta studenta%n");
		
		System.out.println("------------------------------------------------------");
		System.out.println("Podaj komende");
	}
	
	private static void Command(String command)
	{
		System.out.println("Komenda: " + command);
		
		Random random = new Random();
		
		switch(command)
		{
		case "Dodaj":
			double kwota = random.nextInt(100) + random.nextDouble();
			int numer = random.nextInt(100);
			String nazwisko;			
			System.out.println("-> Podaj typ karty (Student, Podstawowy, Senior):");
			
			int r = random.nextInt(3);
			
			Transakcja t;
			
			switch(r)
			{
			case 0: //Student	
				nazwisko = "Student";
				t = new Transakcja(kwota, new KartaStudenta(numer, nazwisko));
				break;
			case 1: //Podstawowy
				nazwisko = "Podstawa";
				t = new Transakcja(kwota, new KartaPodstawowa(numer, nazwisko));
				break;
			default: //Senior
				nazwisko = "Senior";
				t = new Transakcja(kwota, new KartaSeniora(numer, nazwisko));
				break;
			}			
			
			Add(t);
			break;
		case "DodajKilka":
			int count = random.nextInt(5) + 1;
			
			for(int index = 0; index < count; index++)
			{
				Command("Dodaj");
			}			
			break;
		case "Wyswietl":
			System.out.println("-> Wszystkie transakcje:");
			ShowAll();
			break;
		case "Seniorzy":
			System.out.printf("-> Ilosc transakcji karta seniora: %d%n", HowManySenior());			
			break;
		case "Student":
			System.out.println("-> Student, ktory najwiecej zaplacil: ");
			RichStudent();
			break;
		case "Zapisz":
			Save();
			System.out.println("-> Zapisano do pliku");
			break;
		default:
			System.out.println("Taka komenda nie istnieje");
			break;
		}
		
		System.out.println("------------------------------------------------------");
		System.out.println("Podaj komende");
	}
}