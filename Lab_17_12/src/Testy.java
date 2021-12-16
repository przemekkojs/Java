public class Testy 
{
	public static void main(String[] args) 
	{		
		Generated();	
		
		long start = System.nanoTime();
		
		try
		{
			Declared();
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Czas: " + (System.nanoTime() - start));
		}		
	}
	
	private static void Generated() 
	{
		int[] tab = new int[1];
		long start = System.nanoTime();
		
		try
		{
			System.out.print(tab[1]);
		}
		catch (ArrayIndexOutOfBoundsException e)
		{			
			System.out.println("Czas: " + (System.nanoTime() - start));
			e.printStackTrace();
		}		
	}
	
	private static void Declared() throws ArrayIndexOutOfBoundsException
	{
		int[] tab = new int[1];
		System.out.print(tab[1]);		
	}
}