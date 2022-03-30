package Processor;

import Exceptions.EmptyStackException;
import Exceptions.FullStackException;
import Stack.ArrayStack;

public class Processor 
{
	private ArrayStack<Character> stack;
	
	public Processor()
	{
		stack = new ArrayStack<Character>();
	}
	
	public boolean NawiasyZrownowazone(String line)
	{
		try
		{
			for(int index = 0; index < line.length(); index++)
			{
				char sign = line.charAt(index);
				
				if(nawiasOtwierajacy(sign))
				{
					stack.push(sign);
				}
				else if(nawiasZamykajacy(sign))
				{			
					if(!dobryNawias(sign))
					{
						return false;
					}
				}
			}
		}
		catch (FullStackException e)
		{
			e.printStackTrace();
		}		
		
		return stack.isEmpty();
	}
	
	private boolean nawiasOtwierajacy(char sign)
	{
		return (sign == '(' || sign == '[' || sign == '{');		
	}
	
	private boolean nawiasZamykajacy(char sign)
	{
		return (sign == ')' || sign == ']' || sign == '}');		
	}
	
	private boolean dobryNawias(char sign)
	{		
		if(stack.isEmpty())
		{
			return false;
		}
		
		try 
		{			
			if(sign == ')' && stack.pop() == '(')
			{
				return true;
			}
			
			if(sign == ']' && stack.pop() == '[')
			{
				return true;
			}
			
			if(sign == '}' && stack.pop() == '{')
			{
				return true;
			}
		} 
		catch (EmptyStackException e) 
		{			
			e.printStackTrace();
		}
		
		return false;
	}
}