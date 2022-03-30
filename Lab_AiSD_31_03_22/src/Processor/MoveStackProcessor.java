package Processor;

import Exceptions.EmptyStackException;
import Exceptions.FullStackException;
import Stack.ArrayStack;

public class MoveStackProcessor<T>
{
	private ArrayStack<T> stack1;
	private ArrayStack<T> stack2;
	
	public MoveStackProcessor()
	{
		stack1 = new ArrayStack<T>();		
		stack2 = new ArrayStack<T>();		
	}
	
	public void Push(T elem)
	{
		try 
		{
			stack1.push(elem);
		} 
		catch (FullStackException e) 
		{			
			e.printStackTrace();
		}
	}
	
	public void ProcessWithVariables()
	{
		while(!stack1.isEmpty())
		{
			try 
			{
				stack2.push(stack1.pop());
			} 
			catch (FullStackException | EmptyStackException e) 
			{				
				e.printStackTrace();
			}
		}
		
		stack2.reverse();
		
		System.out.print(stack2.toString());
	}
	
	public void ProcessWithStack()
	{		
		ArrayStack<T> help = new ArrayStack<T>();
		
		while(!stack1.isEmpty())
		{
			try 
			{
				help.push(stack1.pop());
			} 
			catch (FullStackException | EmptyStackException e) 
			{				
				e.printStackTrace();
			}
		}
		
		while(!help.isEmpty())
		{
			try 
			{
				stack2.push(help.pop());
			} 
			catch (FullStackException | EmptyStackException e) 
			{				
				e.printStackTrace();
			}
		}
		
		System.out.print(stack2.toString());
	}
}
