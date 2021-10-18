public class Choinka
{
	public static void main(String[] args)
	{
		Tree(10, 3);
	}
	
	public static void Tree(int height, int barkHeight)
	{
		int frontSpaces = height;
		
		for(int index = 0; index < height; index++)
		{
			for(int s = 0; s < frontSpaces; s++)
			{
				System.out.print(" ");
			}
			
			for(int r = 0; r <= index; r++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
			frontSpaces--;
		}
		
		frontSpaces = height - 1;
		
		for(int index = 0; index < barkHeight; index++)
		{
			for(int s = 0; s < frontSpaces; s++)
			{
				System.out.print(" ");
			}
			
			System.out.println("|||");
		}
	}
}