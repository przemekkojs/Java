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
		
		for(int i = 0; i < pages.length; i++)
		{
			pages[i] = random.nextInt(pagesCount);
			System.out.print(pages[i] + " ");
		}		
		
		System.out.println();
	}
}
