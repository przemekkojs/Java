// https://codeforces.com/problemset/problem/356/C <- to ten
// https://codeforces.com/problemset/problem/644/C
// https://codeforces.com/problemset/problem/630/P

public class Main 
{
	private static int n = 1;
	private static int swappedCount = 0;
	
	private static int onesCount;
	private static int twosCount;
	private static int threesCount;
	private static int foursCount;
	
	private static byte[] tab = new byte[] {1};
	
	private static boolean[] ones;
	private static boolean[] twos;
	private static boolean[] threes;
	private static boolean[] fours;
	
	private static void GetInput(byte[] t) //Pierwsze dwie linie do wczytania, dla uproszenia w takiej formie.
	{		
		tab = t;
		n = tab.length;	
		
		WriteTab();
		
		ones = new boolean[n];
		twos = new boolean[n];
		threes = new boolean[n];
		fours = new boolean[n];		
	}
	
	private static void GetOnesTwosThreesFours()
	{		
		onesCount = 0;
		twosCount = 0;
		threesCount = 0;
		foursCount = 0;
		
		for(int i = 0; i < n; i++)
		{
			if(tab[i] == 1)
			{
				ones[i] = true;
				onesCount++;
			}
			else if(tab[i] == 2)
			{
				twos[i] = true;
				twosCount++;
			}
			else if(tab[i] == 3)
			{
				threes[i] = true;
				threesCount++;
			}
			else
			{
				fours[i] = true;
				foursCount++;
			}
		}		
	}
	
	private static void GetRidOfOnes()
	{					
		int oneIndex = 0;		
		int index = 0;
		
		while(index < n && (twosCount + threesCount) > 0 && onesCount > 0) //1+2, 1+3
		{
			if(twos[index] == true)
			{
				while(oneIndex < n && ones[oneIndex] == false)
				{
					oneIndex++;
				}
				
				tab[oneIndex] = 0;
				tab[index] = 3;
				
				twos[index] = false;
				threes[index] = true;
				ones[oneIndex] = false;
				
				onesCount--;
				twosCount--;				
				threesCount++;				
				swappedCount++;
			}
			else if(threes[index] == true)
			{
				while(oneIndex < n && ones[oneIndex] == false)
				{
					oneIndex++;
				}
				
				tab[oneIndex] = 0;
				tab[index] = 4;
				
				threes[index] = false;
				fours[index] = true;
				ones[oneIndex] = false;
				
				onesCount--;
				threesCount--;
				foursCount++;				
				swappedCount++;
			}
			
			index++;
		}		
		
		int oneIndex1 = 0;
		int oneIndex2 = 1;
		
		while(oneIndex1 < n && onesCount > 0) //1+1
		{
			if(ones[oneIndex1] == true && oneIndex1 < n && oneIndex1 != oneIndex2)
			{
				while(oneIndex2 < n && ones[oneIndex2] == false)
				{
					oneIndex2++;
				}
				
				if(oneIndex2 < n)
				{
					tab[oneIndex1] = 0;
					tab[oneIndex2] = 2;				
							
					ones[oneIndex1] = false;
					ones[oneIndex2] = false;	
					twos[oneIndex2] = true;
					
					onesCount -= 2;
					twosCount++;
					
					swappedCount++;	
				}								
			}			
			
			oneIndex1++;
			oneIndex2++;
		}
		
		WriteTab();
	}
	
	private static void GetRidOfTwos()
	{
		int twoIndex = 0;		
		int index = 0;
		
		while(index < n && (threesCount + foursCount) > 0 && twosCount > 0) //3+1 2-1, 4-1
		{
			if(threes[index] == true)
			{
				while(twoIndex < n && twos[twoIndex] == false)
				{
					twoIndex++;
				}
				
				tab[twoIndex] = 1;
				tab[index] = 4;
								
				threes[index] = false;
				fours[index] = true;
				twos[twoIndex] = false;
				ones[twoIndex] = true;
				
				onesCount++;
				twosCount--;
				threesCount--;				
				foursCount++;				
				swappedCount++;
			}
			else if(fours[index] == true)
			{
				while(twoIndex < n && twos[twoIndex] == false)
				{
					twoIndex++;
				}
				
				tab[index] = 3;
				tab[twoIndex] = 3;
				
				threes[index] = true;
				threes[twoIndex] = true;
				fours[index] = false;
				twos[twoIndex] = false;
				
				foursCount--;
				twosCount--;
				threesCount += 2;
				swappedCount++;
			}
			
			index++;
		}		
		
		int twoIndex1 = 0;
		int twoIndex2 = 1;
		
		while(twoIndex1 < n && twosCount > 0) //2+2
		{
			if(twos[twoIndex1] == true && twoIndex1 < n && twoIndex1 != twoIndex2)
			{
				while(twoIndex2 < n && twos[twoIndex2] == false)
				{
					twoIndex2++;
				}
				
				if(twoIndex2 < n)
				{
					tab[twoIndex1] = 0;
					tab[twoIndex2] = 4;				
							
					twos[twoIndex1] = false;
					twos[twoIndex2] = false;	
					fours[twoIndex2] = true;
					
					twosCount -= 2;
					foursCount++;
					
					swappedCount += 2;		
				}						
			}			
			
			twoIndex1++;
			twoIndex2++;
		}
		
		WriteTab();
	}
	
	public static void Solve(byte[] tab)
	{
		GetInput(tab);
		GetOnesTwosThreesFours();
		
		while(onesCount > 0 || twosCount > 0)
		{
			GetRidOfOnes();	
			GetRidOfTwos();								
		}
		
		System.out.println(swappedCount);
		System.out.println();
		swappedCount = 0;
	}
	
	public static void main(String[] args) 
	{
		Solve(new byte[] {1, 2, 2, 4, 3});
		Solve(new byte[] {4, 1, 1});
		Solve(new byte[] {0, 3, 0, 4});		
		Solve(new byte[] {2, 4, 2, 4});		
		Solve(new byte[] {2, 4, 2, 3});	
		Solve(new byte[] {1, 1, 1, 1, 1, 1});
		Solve(new byte[] {1, 1, 1, 1, 1, 1, 1});
		Solve(new byte[] {2, 1, 1, 1, 1, 1, 1, 1});
	}
	
	private static void WriteTab()
	{
		for(byte x : tab)
		{
			System.out.print(x);
		}
		
		System.out.printf("	1: %d, 2: %d, 3: %d, 4:%d%n", onesCount, twosCount, threesCount, foursCount);
	}
}