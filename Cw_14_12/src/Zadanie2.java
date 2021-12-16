import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Zadanie2 
{
	private static int x;
	private static int y;
	private static int[][] tab;
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		WithScanner();
		WithBufferedReader();
	}
	
	private static void WithBufferedReader() throws NumberFormatException, IOException
	{
		System.out.println("BufferedWriter:");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Podaj x: ");
		x = Integer.parseInt(br.readLine());
		System.out.print("Podaj y: ");
		y = Integer.parseInt(br.readLine());
		
		tab = new int[y][x];
		
		double avg = 0;
		
		for(int index = 0; index < y; index++)
		{
			for(int j = 0; j < x; j++)
			{
				System.out.print("Podaj element ("+ x + ", " + index + "): ");
				tab[index][j] = Integer.parseInt(br.readLine());
				avg += tab[index][j];
			}			
		}
		
		System.out.println("Srednia: " + (avg / (x*y)));
		System.out.println();
		
		for(int i = 0; i < y; i++)
		{
			for(int j = 0; j < x; j++)
			{
				System.out.print(tab[i][j] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < y; i++)
		{
			for(int j = 0; j < x; j++)
			{
				System.out.print(tab[j][i] + " ");
			}
			
			System.out.println();
		}
	}
	
	private static void WithScanner()
	{
		System.out.println("Scanner:");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Podaj x: ");
		x = scanner.nextInt();
		System.out.print("Podaj y: ");
		y = scanner.nextInt();
		
		tab = new int[y][x];
		
		double avg = 0;
		
		for(int index = 0; index < y; index++)
		{
			for(int j = 0; j < x; j++)
			{
				System.out.print("Podaj element ("+ x + ", " + index + "): ");
				tab[index][j] = scanner.nextInt();
				avg += tab[index][j];
			}			
		}
		
		System.out.println("Srednia: " + (avg / (x*y)));
		System.out.println();
		
		for(int i = 0; i < y; i++)
		{
			for(int j = 0; j < x; j++)
			{
				System.out.print(tab[i][j] + " ");
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < y; i++)
		{
			for(int j = 0; j < x; j++)
			{
				System.out.print(tab[j][i] + " ");
			}
			
			System.out.println();
		}
	}	
}
