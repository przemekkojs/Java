package Ver2;

import java.util.Random;

public class Main 
{
	private static int n;
	private static int solution;
	
	private static byte[] a;
	
	private static int onesCount;
	private static int twosCount;
	private static int threesCount;
	private static int foursCount;
	
	private static int modifier;
	
	private static void Input(byte[] tab)
	{
		a = tab;
		n = tab.length;
		
		onesCount = 0;
		twosCount = 0;
		threesCount = 0;
		foursCount = 0;
		
		for(int x : tab)
		{
			switch(x)
			{
			case 0:				
				break;
			case 1:
				onesCount++;
				break;
			case 2:
				twosCount++;
				break;
			case 3:
				threesCount++;
				break;
			default:
				foursCount++;
				break;
			}			
		}
		
		solution = 0;
		modifier = 0;
	}
	
	private static void Solve(byte[] tab)
	{
		Input(tab);
		Write("Oryginalna");
		
		int sum = onesCount + (2 * twosCount) + (3 * threesCount) + (4 * foursCount);
		int index = 0;
		long startTime = System.nanoTime();		
		
		if(sum < 3 || sum == 5)
		{
			solution = -1;
		}
			
		while(onesCount + twosCount > 0 && solution != -1)
		{			
			DealWithOnes();
			DealWithTwos();		
			
			index++;
		}	
		
		long endTime = System.nanoTime();
		
		System.out.println("WYNIK: " + solution + "<==========");
		System.out.println("ILOŒÆ POWTÓRZEÑ PÊTLI: " + index);
		System.out.println("CZAS: " + ((endTime - startTime)/1000000f) + " ms");
		System.out.println();
	}
	
	private static void Write(String info)
	{
		System.out.print(info + ": ");
		
		for(int x : a)
		{
			System.out.print(x);
		}
		
		System.out.println("(" + solution + ", -" + modifier + ")");
	}
	
	private static void DealWithOnes()
	{
		int oneIndex = 0;
		int oneIndex2 = 0;
		int twoIndex = 0;
		int threeIndex = 0;		
		int fourIndex = 0;
				
		if(onesCount > 0 && twosCount > 0) //Sumujemy jedynki z dwójkami
		{
			while(oneIndex < n && a[oneIndex] != 1)
			{
				oneIndex++;
			}
			
			while(twoIndex < n && a[twoIndex] != 2)
			{
				twoIndex++;
			}
			
			a[oneIndex] = 0;
			a[twoIndex] = 3;
			
			onesCount--;
			twosCount--;
			threesCount++;
			
			solution++;
			
			Write("1,2 -> 0,3");	
		}			
		
		if(onesCount > 0 && threesCount > 0) //Sumujemy jedynki z trójkami
		{
			while(oneIndex < n && a[oneIndex] != 1)
			{
				oneIndex++;
			}
			
			while(threeIndex < n && a[threeIndex] != 3)
			{
				threeIndex++;
			}
			
			a[oneIndex] = 0;
			a[threeIndex] = 4;			
			
			modifier++;
			
			onesCount--;
			threesCount--;
			foursCount++;		
			
			solution++;
			
			Write("1,3 -> 0,4");
		}				
		
		if(twosCount == 0)
		{
			if(onesCount > 1) //Sumujemy jedynki z jedynkami
			{
				while(oneIndex < n && a[oneIndex] != 1)
				{
					oneIndex++;
				}
				
				while(oneIndex2 < n && (a[oneIndex2] != 1 || oneIndex == oneIndex2))
				{
					oneIndex2++;
				}
				
				a[oneIndex] = 0;
				a[oneIndex2] = 2;
				
				onesCount -= 2;
				twosCount++;
				
				solution++;
				
				Write("1,1 -> 0,2");
			}		
			
			if(onesCount > 0 && foursCount > 1) //Tworzymy 2,3 z 4,1
			{
				while(oneIndex < n && a[oneIndex] != 1)
				{
					oneIndex++;
				}
				
				while(fourIndex < n && a[fourIndex] != 4)
				{
					fourIndex++;
				}
				
				a[oneIndex] = 2;
				a[fourIndex] = 3;
				
				onesCount--;
				foursCount--;
				threesCount++;
				twosCount++;
				
				solution++;
				
				if(modifier > 0)
				{
					solution--;
					modifier--;
				}		
				
				Write("1,4 -> 2,3");		
			}	
		}		
	}
	
	private static void DealWithTwos()
	{		
		int twoIndex = 0;
		int twoIndex2 = 0;		
		int threeIndex = 0;
		int fourIndex = 0;			
		
		if(twosCount > 0 && foursCount >= twosCount && onesCount == 0) //Z 2, 4 tworzymy 3, 3
		{
			while(twoIndex < n && a[twoIndex] != 2)
			{
				twoIndex++;
			}
			
			while(fourIndex < n && a[fourIndex] != 4)
			{
				fourIndex++;
			}
			
			a[twoIndex] = 3;
			a[fourIndex] = 3;
			
			twosCount--;
			foursCount--;
			threesCount += 2;
			
			solution++;
			
			if(modifier > 0)
			{
				solution--;
				modifier--;
			}			
			
			Write("2,4 -> 3,3");
		}		
		
		if(twosCount > 0 && threesCount > 0 && onesCount == 0) //Z 2, 3 tworzymy 1, 4
		{
			while(twoIndex < n && a[twoIndex] != 2)
			{
				twoIndex++;
			}
			
			while(threeIndex < n && a[threeIndex] != 3)
			{
				threeIndex++;
			}
			
			a[twoIndex] = 1;
			a[threeIndex] = 4;
			
			twosCount--;
			threesCount--;
			foursCount++;
			onesCount++;
			
			solution++;			
			modifier++;
			
			Write("2,3 -> 1,4");
		}			
		
		if(twosCount > 1) //Dodajemy dwójki do siebie
		{
			while(twoIndex < n && a[twoIndex] != 2)
			{
				twoIndex++;
			}
			
			while(twoIndex2 < n && (a[twoIndex2] != 2 || twoIndex == twoIndex2))
			{
				twoIndex2++;
			}
			
			a[twoIndex] = 0;
			a[twoIndex2] = 4;
			
			modifier++;
			
			twosCount -= 2;
			foursCount++;
						
			solution++;
			
			Write("2,2 -> 4");
		}		
	}
	
	private static byte[] RandomTab(int length)
	{
		Random random = new Random();
		
		byte[] tab = new byte[length];	

		for(int i = 0; i < tab.length; i++)
		{
			tab[i] = (byte)random.nextInt(5);
		}
		
		return tab;
	}
	
	public static void main(String[] args) 
	{		
		//Random random = new Random();
		//Solve(RandomTab(random.nextInt(1, 21)));
		Solve(RandomTab(30));
	}
}