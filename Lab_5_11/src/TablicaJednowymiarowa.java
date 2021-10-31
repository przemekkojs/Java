import java.util.Random;

public class TablicaJednowymiarowa {

	public static void main(String[] args) 
	{
		Random rand = new Random();
		int[] tab = new int[10];
		
		for(int index = 0; index < tab.length; index++)
		{
			tab[index] = rand.nextInt(50);
		}
		
		PrintTab(tab);
		System.out.println(); //Quick enter
		System.out.println("Min: " + MinValue(tab));
		System.out.println("Iloczyn nieparzystych: " + UnevenNumbersMultiplication(tab));
		System.out.println("Ilosc nieparzystych: " + UnevenNubersCount(tab));
	}
	
	public static void PrintTab(int[] tab)
	{
		for(int i = 0; i < tab.length; i++)
		{
			System.out.print(tab[i] + " ");
		}
	}
	
	public static int MinValue(int[] tab)
	{
		int curMin = Integer.MAX_VALUE;
		
		for(int i = 0; i < tab.length; i++)
		{
			if(tab[i] < curMin)
			{
				curMin = tab[i];
			}
		}
		
		return curMin;
	}
	
	public static int UnevenNumbersMultiplication(int[] tab)
	{
		int res = 1;
		
		for(int i = 0; i < tab.length; i++)
		{
			if(tab[i] % 2 == 1)
			{
				res *= tab[i];
			}
		}
		
		return res;
	}
	
	public static int UnevenNubersCount(int[] tab)
	{
		int res = 0;
		
		for(int i = 0; i < tab.length; i++)
		{
			if(tab[i] % 2 == 1)
			{
				res++;
			}
		}
		
		return res;
	}
}