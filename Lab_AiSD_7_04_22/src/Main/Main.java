package Main;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import List.List;
import Pracownik.Pracownik;

public class Main 
{
	private static List<Pracownik> list;
	private static String fileName;
	private static Scanner scanner;		
	
	public static void main(String[] args) 
	{		
		init();	
		
		System.out.println("MENU");
		System.out.println("Opcje: CREATE - stwórz now¹ bazê danych"
				+ "\nOPEN - otwór"
				+ "\nREAD_BASE - odczytaj bazê danych"
				+ "\nWRITE_ALL - wypisz wszystkie rekordy"
				+ "\nWRITE - wypisz wybranego pracownika"
				+ "\nADD - dodaj pracownika do bazy"
				+ "\nUPDATE - zaktualizuj dane pracownika"
				+ "\nREMOVE - usuñ pracownika z bazy"
				+ "\nAVG - œrednia pensja w firmie"
				+ "\nUNDER - ilu pracowników zarabia poni¿ej œredniej"
				+ "\nSAVE - zapisz do pliku");
		
		
		String command = Command();
		
		while(!command.equals("STOP"))
		{
			switch(command)
			{
			case "CREATE":
				command = Command("Nazwa pliku: ");
				Create(command);
				Save(fileName);
				break;
			case "OPEN":
				command = Command("Nazwa pliku: ");
				fileName = command;
				break;
			case "READ_BASE":
				Read(fileName);
				break;
			case "WRITE_ALL":
				Write();
				break;
			case "WRITE":
				command = Command("Index: ");
				Write(Integer.parseInt(command));
				break;
			case "REMOVE":
				command = Command("Index: ");
				Remove(Integer.parseInt(command));
				break;
			case "AVG":
				System.out.print("Œrednia pensja w firmie: " + Avg());
				break;
			case "UNDER":
				System.out.print("Poni¿ej œredniej zarabia: " + HowManyUnderAvg());
				break;
			case "SAVE":
				Save(fileName);
				break;
			case "ADD":
				Add(new Pracownik(Long.parseLong(Command("PESEL: ")), 
						Command("Imie i nazwisko: "), 
						Command("Data urodzenia: "), 
						Command("Stanowisko: "), 
						Integer.parseInt(Command("Pensja: ")), 
						Integer.parseInt(Command("Sta¿: "))));
				break;
			case "UPDATE":				
				int index = Integer.parseInt(Command("Index: "));
				Update(index, Long.parseLong(Command("PESEL: ")), 
						Command("Imie i nazwisko: "), 
						Command("Data urodzenia: "), 
						Command("Stanowisko: "), 
						Integer.parseInt(Command("Pensja: ")), 
						Integer.parseInt(Command("Sta¿: ")));
				break;
			default:				
				break;			
			}
			
			command = Command();
		}		
	}
	
	private static void init()
	{
		list = new List<Pracownik>();
		fileName = "base.txt";
		scanner = new Scanner(System.in);
	}
	
	private static String Command()
	{
		System.out.print("Opcja: ");
		return scanner.next();
	}
	
	private static String Command(String line)
	{
		System.out.print(line);
		return scanner.next();
	}
	
	private static void Write()
	{
		for(Pracownik p : list)
		{
			System.out.println(p.toString());
		}
	}
	
	private static void Write(int index)
	{
		System.out.println(list.get(index).toString());
	}
	
	private static void Create(String newFile)
	{
		fileName = newFile;
	}
	
	private static double Avg()
	{
		double res = 0;
		int count = 0;
		
		for(Pracownik p : list)
		{
			res += p.Salary();
			count++;
		}
		
		res /= count;
		
		return res;
	}
	
	private static int HowManyUnderAvg()
	{
		int res = 0;
		double avg = Avg();
		
		for(Pracownik p : list)
		{
			if(p.Salary() < avg)
			{
				res++;
			}
		}
		
		return res;
	}
	
	private static void Read(String path)
	{
		try 
		{
			FileInputStream fis = new FileInputStream(new File(path));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object o = null;
			while((o = ois.readObject()) != null)
			{
				list.add((Pracownik) o);		
			}						
			
			ois.close();
		} 
		catch (ClassNotFoundException e) 
		{			
			e.printStackTrace();
		}
		catch (EOFException exc)
		{
		    // end of stream
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
	}
	
	private static void Save(String path)
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream(new File(path));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			for(Pracownik p : list)
			{
				oos.writeObject(p);
			}
			
			oos.close();
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
	}
	
	private static void Add(Pracownik p)
	{
		long pesel = p.Pesel();
		int index = 0;
		
		while(index < list.size() && list.get(index).Pesel() < pesel)
		{
			index++;
		}
		
		list.add(index, p);
	}	
	
	private static void Remove(int index)
	{
		list.remove(index);		
	}
	
	private static void Update(int index, long PESEL, String initials, String birthDate, String position, int salary, int hours)
	{
		list.set(index, new Pracownik(PESEL, initials, birthDate, position, salary, hours));
	}
}