
public class JakiesDziwne {

	public static void main(String[] args) 
	{
		int a = 10;
		int b = 5;
		System.out.printf("Dla a = %d, b = %d: %f%n", a, b, T(a, b));
		System.out.printf("Dla a = %d, b = %d: %f", a, b, T(b, a));
	}
	
	public static double T(int a, int b)
	{		
		if(a >= b)
		{
			return 2*a - Math.abs(b);
		}
		else
		{
			return Math.sin(a) - b*b;
		}		
	}
}
