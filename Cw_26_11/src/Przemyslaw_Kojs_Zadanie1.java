public class Przemyslaw_Kojs_Zadanie1 
{
	public static void main(String[] args) 
	{		
		System.out.println(F(3.0d, 0.01d));
		Show(new double[] {1.5d, 2.2d, 3.7d, 4.3d, 5.8d});
	}
	
	public static double F(double x, double eps)
	{		
		int i = 1;
		double l = x - 1.0d;
		double m = x;
		double res = l/m;
		double curEps = Math.abs(res - Math.ceil(res));
		//System.out.print(curEps) + " ");
		
		while(curEps > eps)
		{						
			l *= x;
			m /= i;
			m *= x;
			i++;
			m *= i;
			res += l/m;
			
			curEps = Math.abs(res - Math.ceil(res));
			
			//System.out.print(curEps) + " ");
		}
		
		return res;
	}
	
	public static void Show(double[] tab)
	{
		System.out.printf("x	|	0.01	|	0.001%n--------------------------------------%n");
		
		for(double i : tab)
		{
			System.out.printf("%.2f	|	%.2f	|	%.3f%n", i, F(i, 0.01d), F(i, 0.001d));
		}
	}
}