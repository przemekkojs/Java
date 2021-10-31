package Wielomian;

public class Wielomian 
{	
	public static double Czebyszew(int n, double x)
	{
		double T0 = 1;
		double T1 = x;		
		
		if(n == 0)
		{
			return T0;
		}
		else if(n == 1)
		{
			return T1;
		}
		else if(n >= 2)
		{
			double T = (2 * x * T1) - T0;
			
			for(int i = 2; i < n; i++)
			{
				T0 = T1;
				T1 = T;
				T = (2 * x * T1) - T0;
			}
			
			return T;
		}
		
		return 0;
	}
}