public class NWW 
{ //Nie do ko�ca rozumia�em o co chodzi�o z metod� dodawania, wi�c zrobi�em tak jak umiem

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
