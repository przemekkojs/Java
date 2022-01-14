import java.util.Random;

public class Przemyslaw_Kojs_Tab 
{
	public int[][] tab;
	
	public Przemyslaw_Kojs_Tab(int rows)
	{
		Random r = new Random();	
		
		tab = new int[rows][];
		
		for(int index = 0; index < rows; index++) 
		{
			tab[index] = new int[r.nextInt(10)];
		}
	}
	
	public void Fill(int bound)
	{
		Random r = new Random();
		
		for(int y = 0; y < tab.length; y++)
		{
			for(int x = 0; x < tab[y].length; x++)
			{
				tab[y][x] = r.nextInt(bound + 1);
			}
		}
	}
	
	public void Show(int[][] t)
	{
		for(int y = 0; y < t.length; y++)
		{
			for(int x = 0; x < t[y].length; x++)
			{
				System.out.printf("%5d", t[y][x]);
			}
			
			System.out.println();
		}
		
		System.out.println();	
	}
	
	public int[][] Convert()
	{
		int[][] res = new int[tab.length][];
		
		//Szukanie najdluzszego wiersza
		int curMax = 0;
		
		for(int y = 0; y < tab.length; y++)
		{
			if(tab[y].length > curMax)
			{
				curMax = tab[y].length;
			}
		}
		
		for(int y = 0; y < tab.length; y++)
		{
			int i = 0;
			int[] newRow = new int[curMax];
			
			while(i < tab[y].length)
			{
				newRow[i] = tab[y][i];
				i++;
			}
			
			for(int x = i; x < curMax; x++)
			{
				newRow[x] = -1;
			}
			
			res[y] = newRow;
		}
		
		return res;
	}
}
