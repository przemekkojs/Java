package Terminal;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import Osoba.Osoba;
import Portfel.KartaDebetowa;
import Portfel.Portfel;
import Portfel.SrodekPlatnosci;
import Serializacja.Serializator;

public class Kasa 
{
	private static Osoba osoba;
	private static Random random;
	private static Scanner scanner;
	
	public static void main(String args[]) throws IOException, ClassNotFoundException
	{
		random = new Random();
		scanner = new Scanner(System.in);		
		
		String input = "";
		Vector<Integer> produkty = new Vector<Integer>();		
		
		osoba = new Osoba(
				new Portfel(new SrodekPlatnosci[] 
				{
				new KartaDebetowa(random.nextInt(1000), 200), 
				new KartaDebetowa(random.nextInt(1000), 200), 
				new SrodekPlatnosci("Gotowka", 200)
				}));		
		
		double start = osoba.GetPortfel().Lacznie();
	
		while(!osoba.GetPortfel().CzyPusty() && !input.equals("STOP"))
		{
			int cena = random.nextInt(200);
			double value = 0;
			int index = 0;
			
			System.out.print("Podaj komende: ");
			input = scanner.nextLine();
			
			switch(input)
			{
			case "Sklep":
				System.out.println("cena: " + cena);
				osoba.IdzDoSklepu(cena);
				produkty.add(cena);
				break;
				
			case "Splac":
				osoba.GetPortfel().StanPortfela();
				System.out.print("Podaj index srodka (podaj dobra wartosc): ");
				index = scanner.nextInt();
				
				while(index >= osoba.GetPortfel().GetSrodki().length)
				{
					System.out.print("Nieladnie! ");
					index = scanner.nextInt();
				}
								
				System.out.printf("Ile chcesz splacic ze srodka %s (podaj dobra wartosc): ", osoba.GetPortfel().GetSrodki()[index].Nazwa());
				value = scanner.nextDouble();
				
				while(index > osoba.GetPortfel().GetSrodki()[index].GetStan())
				{
					System.out.print("Nieladnie! ");
					value = scanner.nextDouble();
				}
				
				osoba.Splac(value);
				osoba.StanZadluzenia();
				break;
				
			case "Kredyt":
				osoba.GetPortfel().StanPortfela();
				System.out.print("Podaj index srodka (podaj dobra wartosc): ");
				index = scanner.nextInt();
				
				while(index >= osoba.GetPortfel().GetSrodki().length)
				{
					System.out.print("Nieladnie! ");
					index = scanner.nextInt();
				}
				
				System.out.print(index);
				System.out.printf("Ile chcesz wziac na srodek %s: ", osoba.GetPortfel().GetSrodki()[index].Nazwa());
				value = scanner.nextDouble();
				osoba.Kredyt(osoba.GetPortfel().GetSrodki()[index], value);
				osoba.StanZadluzenia();
				osoba.GetPortfel().StanPortfela();				
				break;
				
			case "Sprzedaj":
				System.out.println("Lista produktow: ");
				for(int i = 0; i < produkty.size(); i++)
				{
					System.out.println(i + ": " + produkty.elementAt(i));
				}
				
				System.out.print("Podaj index srodka (podaj dobra wartosc): ");
				index = scanner.nextInt();
				
				while(index >= produkty.size())
				{
					System.out.print("Nieladnie! ");
					index = scanner.nextInt();
				}
								
				osoba.Sprzedaj(produkty.elementAt(index));
				produkty.remove(index);				
				break;
				
			case "Produkty":
				for(int i = 0; i < produkty.size(); i++)
				{
					System.out.println(i + ": " + produkty.elementAt(i));
				}		
				break;
			
			case "Stan":
				osoba.GetPortfel().StanPortfela();				
				break;
				
			case "Pomoc":
				System.out.printf("Taka komenda nie istnieje. Dostepne komendy: %n"
						+ "Sklep%n"
						+ "Kredyt%n"
						+ "Sprzedaj%n"
						+ "Splac%n"
						+ "Produkty%n"
						+ "Pomoc%n"
						+ "Stan%n"
						+ "STOP%n");
				break;
			}
			
			System.out.println("-------------------------------------------");
		}		
		
		if(input.equals("STOP"))
		{
			System.out.printf("Koniec gry. Wynik: %.2f%n%n", osoba.GetPortfel().Lacznie() - start - osoba.Zadluzenie());
		}
		else
		{
			System.out.println("Portfel jest pusty. Przegrales!\n");
		}		
		
		Serializator.Zapisz(new Osoba[] {osoba}, "osoba.txt");		
		Serializator.Zapisz(new SrodekPlatnosci[] {osoba.GetPortfel().GetSrodki()[0], osoba.GetPortfel().GetSrodki()[1], osoba.GetPortfel().GetSrodki()[2]}, "srodek.txt");		
		System.out.print(Serializator.OdczytajSrodek("srodek.txt").ToString());
		System.out.print(Serializator.Odczytaj("osoba.txt").GetPortfel().ToString());
	}	
}
