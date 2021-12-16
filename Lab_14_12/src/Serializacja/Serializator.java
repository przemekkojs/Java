package Serializacja;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Osoba.Osoba;

public class Serializator 
{
	public static void Zapisz(Osoba obj, String fileName) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(fileName);		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(obj);
		
		oos.close();
	}	
	
	public static void Odczytaj(String fileName) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(fileName);		
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Osoba os = (Osoba) ois.readObject();
		
		System.out.println("Info: ");
		System.out.println("Zadluzenie: " + os.Zadluzenie());
		System.out.println("Stan Portfela: " + os.GetPortfel().ToString());
		
		ois.close();
	}
}