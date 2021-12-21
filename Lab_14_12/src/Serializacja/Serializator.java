package Serializacja;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Osoba.Osoba;
import Portfel.SrodekPlatnosci;

public class Serializator 
{
	public static void Zapisz(Osoba[] obj, String fileName) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(fileName);		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for(Osoba o : obj)
		{
			oos.writeObject(o);	
		}
			
		oos.close();
	}	
	
	public static void Zapisz(SrodekPlatnosci[] obj, String fileName) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(fileName);		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for(SrodekPlatnosci s : obj)
		{
			oos.writeObject(s);		
		}	
		
		oos.close();
	}	
	
	public static Osoba Odczytaj(String fileName) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(fileName);		
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Osoba os = (Osoba) ois.readObject();
		ois.close();
		return os;
	}
	
	public static SrodekPlatnosci OdczytajSrodek(String fileName) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(fileName);		
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		SrodekPlatnosci os = (SrodekPlatnosci) ois.readObject();
		ois.close();
		return os;
	}
}