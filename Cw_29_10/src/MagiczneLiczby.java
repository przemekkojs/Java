
public class MagiczneLiczby 
{
	public static void main(String[] args)
	{			
		for(int i = 1; i < Integer.MAX_VALUE; i++)
		{
			Check(i);
			System.out.println("a: " + i);
		}
	}
	
	public static void Check(int liczba)
	{
		int sumaDzielnikow = 1;
		int modifier = 1;
		
		if(liczba%2 == 1)
		{
			modifier = 2;
		}
		
		for(int i = 2; i <= liczba / 2; i += modifier)
		{
			if(liczba%i == 0)
			{
				sumaDzielnikow += i;
			}
		}
		
		if(sumaDzielnikow == liczba)
		{
			System.out.println(liczba);
		}
	}
}
