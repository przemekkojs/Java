package Processors;

public class Logger 
{
	public static void Log(String output)
	{
		System.out.print(output);
	}
	
	public static void Clear()
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
