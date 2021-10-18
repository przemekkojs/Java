public class NWW 
{ //Nie do koñca rozumia³em o co chodzi³o z metod¹ dodawania, wiêc zrobi³em tak jak umiem

	public static void main(String[] args) 
	{
		System.out.print(nww(10, 5));
	}
	
	public static int nww(int x, int y)
	{
		return (x * y)/(nwd(x, y));
	}
	
	public static int nwd(int x, int y)
	{
		int pom;
		
		while(y > 0)
		{
			pom = y;
			y = x%y;
			x = pom;
		}
		
		return x;
	}
}
