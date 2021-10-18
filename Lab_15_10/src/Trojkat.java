public class Trojkat 
{
	public static void main(String[] args) 
	{
		int a = 10;
		int b = 5;
		int c = 7;
		
		double p = (a+b+c)/2;
		
		if(Exists(a,b,c))
		{
			System.out.printf("Pole = %f%nObwod: %d", Math.sqrt(p*(p-a)*(p-b)*(p-c)), a+b+c);			
		}
		else
		{
			System.out.println("Nie istnieje taki trojkat");
		}
	}
	
	public static boolean Exists(int a, int b, int c)
	{
		if(Math.abs(b-a) < a && b + c > a)
		{
			return true;
		}
		
		return false;
	}
}