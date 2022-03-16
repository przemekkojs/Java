package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import Deck.Deck;
import Karta.Card;

public class Main 
{
	private static Deck deck = new Deck();
	
	private static Random random = new Random();
	
	public static void main(String[] args) 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		try 
		{
			System.out.print("Podaj komendê: ");
			String line = br.readLine();
			
			while(!line.equals("Stop"))
			{
				switch(line)
				{
				case "create":
					Create();
					break;
				case "write":
					deck.WriteDeck();
					break;
				case "size":
					deck.WriteSize();
					break;
				case "trim":
					deck.Trim();
					break;
				case "color":
					System.out.print("Podaj kolor: ");
					int number = Integer.parseInt(br.readLine());
					deck.WriteColor(number);
					break;
				case "value":
					System.out.print("Podaj wartoœæ: ");
					int value = Integer.parseInt(br.readLine());
					deck.WriteValued(value);		
					break;				
				}
				
				System.out.print("Podaj komendê: ");
				line = br.readLine();
			}
		} 
		catch (IOException e) 
		{			
			System.out.print("B³¹d wejœcia");
			e.printStackTrace();
		}			
	}
	
	private static void Create()
	{
		if(Init() > 0)
		{
			Adding();
		}		
	}
	
	private static int Init()
	{
		int value = random.nextInt(14);
		int color = random.nextInt(4);
		
		deck.Init(new Card(value, color));
		
		return value;
	}
	
	private static void Adding()
	{	
		int value = random.nextInt(14);
		int color = random.nextInt(4);
		
		while(value != 0)
		{
			deck.Add(new Card(value, color));
			
			value = random.nextInt(14);
			color = random.nextInt(4);
		}
	}
}