package StackZadanie;

import Exception.EmptyStackException;

public class Main 
{
	private static ListStack<Integer> stack;
	
	public static void main(String[] args) throws EmptyStackException 
	{
		stack = new ListStack<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.print("Samochody: " + stack.toString());
		
		int toGetOut = 0;
		
		System.out.print("Aby móg³ wyjechaæ " + toGetOut + " wyjechaæ musz¹: ");
		
		while(stack.top() != toGetOut)
		{
			System.out.print(stack.pop() + ", ");
		}
	}
}