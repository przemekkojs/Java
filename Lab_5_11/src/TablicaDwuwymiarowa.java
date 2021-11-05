public class TablicaDwuwymiarowa 
{
	public static void main(String[] args)
	{
		int tab[][] = CreateArray(10);
		PrintArray(tab, 10);
	}
	
	public static int[][] CreateArray(int n)
	{
		int[][] tab = new int[n][];
		
		for(int i = 1; i <= n; i++)
		{
			tab[i - 1] = new int[i];
		}
		
		int value = 1;
		
		for(int y = 0; y < n; y++)
		{
			for(int x = 0; x < tab[y].length; x++)
			{
				tab[y][x] = value;
				value++;
			}
		}
		
		return tab;
	}
	
	public static void PrintArray(int[][] tab, int n)
	{
		for(int y = 0; y < n; y++)
		{
			for(int x = 0; x <= y; x++)
			{
				System.out.printf("%2d ", tab[y][x]);				
			}
			
			System.out.println();
		}
	}
}