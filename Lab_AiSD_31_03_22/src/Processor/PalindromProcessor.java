package Processor;

import Exceptions.EmptyStackException;
import Exceptions.FullStackException;
import Stack.ArrayStack;

public class PalindromProcessor 
{
	private ArrayStack<Character> stack;
	private ArrayStack<Character> reverse;
	
	public PalindromProcessor()
	{
		stack = new ArrayStack<Character>();
		reverse = new ArrayStack<Character>();
	}
	
	public boolean Process(String line)
	{			
		Init(line);
		
 		reverse.reverse();
		
		while(!stack.isEmpty())
		{
			try 
			{
				if(reverse.pop() != stack.pop())
				{
					return false;
				}
			} 
			catch (EmptyStackException e) 
			{				
				e.printStackTrace();
			}
		}
		return true;
	}
	
	private void Init(String line)
	{
		for(int i = 0; i < line.length(); i++)
		{
			try 
			{
				stack.push(line.charAt(i));
				reverse.push(line.charAt(i));
			} 
			catch (FullStackException e) 
			{				
				e.printStackTrace();
			}
		}
	}
}
