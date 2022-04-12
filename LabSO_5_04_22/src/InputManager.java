import java.util.Random;
import java.util.Scanner;

public class InputManager 
{
	private static int pagesCount;
	private static int framesCount;
	
	private static int[] pages;
	
	private static Scanner scanner;
	
	public InputManager()
	{
		scanner = new Scanner(System.in);		
	}
	
	public int PagesCount()
	{
		return pagesCount;
	}
	
	public int FramesCount()
	{
		return framesCount;
	}
	
	public int[] Pages()
	{
		return pages;
	}
	
	public void GetInput()
	{
		System.out.print("Ilo�� ramek: ");
		framesCount = Integer.parseInt(scanner.next());
		System.out.print("Ilo�� stron: ");
		pagesCount = Integer.parseInt(scanner.next());
		System.out.print("Ilo�� odwo�a� do stron: ");		
		pages = new int[Integer.parseInt(scanner.next())];
		
		Random random = new Random();
		
		System.out.print("Ci�g: ");
		
		int r = random.nextInt(pagesCount);
		int l =	random.nextInt(pagesCount) + 2;
		
		for(int i = 0; i < pages.length; i++)
		{
			if(i%l == 0)
			{
				r = random.nextInt(pagesCount);
				l =	random.nextInt(pagesCount) + 2;
			}
			
			pages[i] = r;
			System.out.print(pages[i] + " ");
		}		
		
		System.out.println();
	}
}
