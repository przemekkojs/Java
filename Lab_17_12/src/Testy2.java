public class Testy2
{
	public static void main(String[] args) 
	{		
		Generated();	
		
		long start = System.nanoTime();
		
		try
		{
			Declared();
		}
		catch (ArithmeticException e)
		{
			System.out.println("Czas d: " + (System.nanoTime() - start));
			e.printStackTrace();
		}		
	}
	
	private static void Generated() 
	{		
		long start = System.nanoTime();
		
		try
		{
			System.out.print(1/0);
		}
		catch (ArithmeticException e)
		{			
			System.out.println("Czas g: " + (System.nanoTime() - start));
			e.printStackTrace();
		}		
	}
	
	private static void Declared() throws ArithmeticException
	{		
		System.out.print(1/0);		
	}
}