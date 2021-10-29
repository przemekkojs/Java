public class Funkcja {

	public static void main(String[] args) 
	{		
		System.out.print(S(10, 10));
	}
	
	public static double S(int n, double x)
	{
		if(x < -1)
		{
			return 2/3;
		}
		else if(x >= -1 && x <= 1)
		{
			return Math.sin(x) + x*x;
		}

		return Sum(n, x);
	}
	
	public static double Sum(int n, double x)
	{
		double res = 0;
		int fact = 1;
		
		for(int i = 0; i < n; i++)
		{
			res += (x + i)/fact;			
			fact *= (i + 1);
		}
		
		return res;
	}	
}
