public class Maksimum {

	public static void main(String[] args)
	{		
		double a = 1, b = 2, c = 3;		
		double x = Max(a, b, c);
		
		System.out.printf("Dla a = %f, b = %f, c = %f Max(a,b,c) = %f%n", a, b, c, x);
		
		//Sprawdzenie dla wszystkich przypadkow 3 liczb
		System.out.println(Max(1, 2, 3));
		System.out.println(Max(1, 3, 2));
		System.out.println(Max(2, 1, 3));
		System.out.println(Max(2, 3, 1));
		System.out.println(Max(3, 1, 2));
		System.out.println(Max(3, 2, 1));
		System.out.println(Max(3, 2, 2));
		System.out.println(Max(2, 3, 2));
		System.out.println(Max(2, 2, 3));
		System.out.println(Max(3, 3, 3));
	}
	
	public static double Max(double a, double b, double c)
	{		
		//Jest to optymalne rozwiazanie poniewaz nawet w najgorszym przypadku wykonane sa maksymalnie 2 sprawdzenia if()
		
		if(a > b)
		{
			if(c > a)
			{
				return c;
			}
			
			return a;
		}
		else if(c > b)
		{
			return c;
		}
		
		return b;		
	}
}
