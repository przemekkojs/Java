package Bankowosc;

import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		Konto[] bank = new Konto[10];
		
		Random random = new Random();
		
		for(int index = 0; index < bank.length; index++)
		{
			bank[index] = new Konto(Math.abs(random.nextInt(50)), Math.round((1000d*random.nextDouble()) * 100d) / 100d);
		}
		
		Show(bank);
		System.out.printf("Bogacz: numer konta %2d, saldo %3.2f%n", Bogacz(bank).GetNumerKonta(), Bogacz(bank).GetSaldo());
	}
	
	public static void Show(Konto[] bank)
	{
		for(int index = 0; index < bank.length; index++)
		{
			bank[index].GetStan();
		}
	}
	
	public static Konto Bogacz(Konto[] bank)
	{
		double curMax = bank[0].GetSaldo();
		int index = 0;
		
		for(int i = 0; i < bank.length; i++)
		{
			if(curMax < bank[i].GetSaldo())
			{
				curMax = bank[i].GetSaldo();
				index = i;
			}			
		}
		
		return bank[index];
	}
}
