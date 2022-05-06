import java.util.Scanner;

public class InputManager 
{	
	private int pagesCount;
	private int framesCount;
	private int processCount;
	private int size;
	
	public InputManager()
	{
		Scanner scanner = new Scanner(System.in);		
		
		System.out.print("Ilosc stron: ");
		pagesCount = Integer.parseInt(scanner.next());
		System.out.print("Ilosc ramek: ");
		framesCount = Integer.parseInt(scanner.next());
		System.out.print("Ilosc procesow: ");
		processCount = Integer.parseInt(scanner.next());		
		
		scanner.close();
	}
		
	public int pagesCount()
	{
		return pagesCount;
	}
	
	public int framesCount()
	{
		return framesCount;
	}
	
	public int processCount()
	{
		return processCount;
	}
	
	public int size()
	{
		return size;
	}
}
