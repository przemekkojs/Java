package Main;

import Input.InputManager;
import Processor.MoveStackProcessor;
import Processor.PalindromProcessor;
import Processor.Processor;

public class Main 
{
	private static String line;
	private static Processor processor;
	private static PalindromProcessor palindrom;
	private static MoveStackProcessor<Integer> move;
	
	public static void main(String[] args)
	{
		Nawiasy();
		Palindrom();
		MoveWithStack();
		MoveWithVariables();
	}
	
	private static void getInput()
	{
		line = InputManager.GetInput();
	}
	
	private static void Nawiasy()
	{
		processor = new Processor();
		
		getInput();
		System.out.println(processor.NawiasyZrownowazone(line));
	}
	
	private static void Palindrom()
	{
		palindrom = new PalindromProcessor();
		getInput();
		
		System.out.println(palindrom.Process(line));
	}
	
	private static void MoveWithStack()
	{
		move = new MoveStackProcessor<Integer>();
		
		move.Push(0);
		move.Push(1);
		move.Push(2);
		move.Push(3);
		move.Push(4);
		
		move.ProcessWithStack();
	}
	
	private static void MoveWithVariables()
	{
		move = new MoveStackProcessor<Integer>();
		
		move.Push(0);
		move.Push(1);
		move.Push(2);
		move.Push(3);
		move.Push(4);
		
		move.ProcessWithVariables();
	}
}