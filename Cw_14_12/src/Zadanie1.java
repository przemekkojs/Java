import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Zadanie1 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj nazwe pliku: ");
		
		FileReader file = new FileReader(new File(scanner.nextLine()));
		BufferedReader br = new BufferedReader(file);		 
		 
		Vector<String> lines = new Vector<String>();
		String line = br.readLine();
		 
		while(line != null)
		{
			lines.add(line);
			line = br.readLine();			 
		}
		
		System.out.println("Ilosc znakow w pliku: " + Length(lines));
		System.out.println("Ilosc znakow (bez spacji) w pliku: " + Length(lines, " "));
		System.out.println("Ilosc slow w pliku: " + Words(lines));
		 
		System.out.print("Jakiego wyrazu szukasz: ");		 
		System.out.println(CountWord(lines, scanner.nextLine()) + " Wystopien");
		
		scanner.close();
		br.close();
	}
	
	private static int Length(Vector<String> lines)
	{
		int res = 0;
		
		for(String s : lines)
		{
			res += s.length();
		}
		
		return res;
	}
	
	private static int Length(Vector<String> lines, String ignore)
	{
		int res = 0;
		
		for(String s : lines)
		{
			for(int i = 0; i < s.length(); i++)
			{
				if(s.charAt(i) != ignore.charAt(0))
				{
					res++;
				}
			}
		}
		
		return res;
	}
	
	private static int Words(Vector<String> lines)
	{
		int res = 0;
		
		for(String s : lines)
		{			
			res += s.split("\\s+").length;
		}
		
		return res;
	}
	
	private static int CountWord(Vector<String> lines, String word)
	{
		int res = 0;
		
		for(String s : lines)
		{			
			String[] tab = s.split(" ");
			
			for(String a : tab)
			{
				if(a.equals(word))
				{
					res++;
				}
			}
		}
		
		return res;
	}
}
