package StackZadanie;

import java.util.Scanner;

import Exception.EmptyStackException;

public class Main 
{
	private static ListStack<Integer> stack;
	
	public static void main(String[] args) throws EmptyStackException 
	{
		ListStack<Integer> help = new ListStack<Integer>();
		Scanner scanner = new Scanner(System.in);
		
		stack = new ListStack<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.print("Samochody: " + stack.toString());
		
		int toGetOut = Integer.parseInt(scanner.next());
		
		while(toGetOut >= 0)
		{
			System.out.print("Aby móg³ wyjechaæ " + toGetOut + " wyjechaæ musz¹: ");
			
			while(stack.top() != toGetOut && stack.size() > 0)
			{
				help.push(stack.top());
				System.out.print(stack.pop() + ", ");
			}
			
			if(stack.size() == 0)
			{
				System.out.println();
				System.out.print("Nie ma takiego samochodu");
			}
			
			while(!help.isEmpty())
			{
				stack.push(help.pop());
			}
			
			toGetOut = Integer.parseInt(scanner.next());
		}		
	}
}