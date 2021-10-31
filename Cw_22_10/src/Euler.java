
public class Euler {

	public static void main(String[] args) 
	{
		System.out.print("Wynik: " + Approx(1, 0.0000001d));
	}
	
	public static double Approx(double x, double eps)
	{		
		double pow = 1;
		double fact = 1;
		double res = 1;
		double elem = pow/fact;
		int index = 1;
		
		while(elem >= eps)
		{			
			pow *= x;
			fact *= index;			
			elem = pow/fact;			
			res += elem;
			index++;
		}
		
		return res;		
	}
}