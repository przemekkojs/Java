package Ver2;

public class Main 
{
	private static int n;
	private static int solution;
	
	private static byte[] a;
	
	private static byte onesCount;
	private static byte twosCount;
	private static byte threesCount;
	private static byte foursCount;
	
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
			if(x == 1) onesCount++;
			else if(x == 2) twosCount++;
			else if(x == 3) threesCount++;
			else if(x == 4) foursCount++;
		}
		
		solution = 0;
		modifier = 0;
	}
	
	private static void Solve(byte[] tab)
	{
		Input(tab);
		Write("Oryginalna");
		
		int sum = onesCount + (2 * twosCount) + (3 * threesCount) + (4 * foursCount);
		
		if(sum < 3 || sum == 5)
		{
			solution = -1;
		}
			
		while(onesCount + twosCount > 0 && solution != -1)
		{			
			DealWithOnes();
			DealWithTwos();			
		}	
		
		System.out.println("WYNIK: " + solution + "<==========");
		System.out.println();
	}
	
	private static void Write(String info)
	{
		System.out.print(info + ": ");
		
		for(int x : a)
		{
			System.out.print(x);
		}
		
		System.out.println("(" + solution + ", " + modifier + ")");
	}
	
	private static void DealWithOnes()
	{
		int oneIndex = 0;
		int oneIndex2 = 0;
		int twoIndex = 0;
		int threeIndex = 0;		
		int fourIndex = 0;
				
		if(onesCount > 0 && twosCount > 0) //Sumujemy jedynki z dw�jkami
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
			
			Write("1 -> 2");	
		}			
		
		if(onesCount > 0 && threesCount > 0) //Sumujemy jedynki z tr�jkami
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
			
			if(foursCount == 0)
			{
				modifier++;
			}
			
			onesCount--;
			threesCount--;
			foursCount++;		
			
			solution++;
			
			Write("1 -> 3");
		}				
		
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
			
			Write("1 -> 1");
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
			
			Write("4 -> 1");		
		}	
	}
	
	private static void DealWithTwos()
	{		
		int twoIndex = 0;
		int twoIndex2 = 0;			
		int fourIndex = 0;
		
		if(twosCount > 0 && foursCount > 0) //Z 2, 4 tworzymy 3, 3
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
			solution -= modifier;
			
			Write("4 -> 2");
		}		
		
		if(twosCount > 1) //Dodajemy dw�jki do siebie
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
			
			if(foursCount == 0)
			{
				modifier++;
			}
			
			twosCount -= 2;
			foursCount++;
						
			solution += 2;
			
			Write("2,2 -> 4");
		}		
	}
	
	public static void main(String[] args) 
	{
		Solve(new byte[] {1, 1, 1, 1, 1, 1});
		Solve(new byte[] {1, 1, 1, 1, 1, 1, 1});
		Solve(new byte[] {1, 1, 1, 1, 1, 1, 1, 1});
		Solve(new byte[] {1, 2, 2, 4, 3});
		Solve(new byte[] {4, 1, 1});
		Solve(new byte[] {0, 3, 0, 4});
		Solve(new byte[] {1});
		Solve(new byte[] {1, 2});
		Solve(new byte[] {2, 2, 1, 1});		
		Solve(new byte[] {2, 2, 3});
		Solve(new byte[] {4, 1});
		Solve(new byte[] {4, 3, 2});
		Solve(new byte[] {2, 3, 2, 3, 2});
		Solve(new byte[] {2, 2, 2});
	}
}