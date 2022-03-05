import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Dla plików typu obrazek

public class FOS 
{
	public static void main(String[] args) 
	{
		WriteToFile(OpenFile("AnalizaCw_16_12_2021.png"), "Kopia.png");
	}
	
	private static byte[] OpenFile(String fileName)
	{
		byte[] res = null;
		
		File file = new File(fileName);
		try (FileInputStream ifs = new FileInputStream(file))
		{
			res = ifs.readAllBytes();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print("Nie znaleziono pliku");
		} 
		catch (IOException e1) 
		{
			System.out.print("Blad");
		}
		
		return res;
	}
	
	private static void WriteToFile(byte[] data, String fileName)
	{
		File file = new File(fileName);
		try (FileOutputStream fos = new FileOutputStream(file))
		{
			fos.write(data);
			System.out.print("Zapisano");
		}
		catch (IOException e)
		{
			System.out.print("B³¹d Zapisu");
		}
	}
}
