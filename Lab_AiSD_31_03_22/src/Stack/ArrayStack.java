package Stack;

import Exceptions.EmptyStackException;
import Exceptions.FullStackException;

public class ArrayStack<T> implements IStack<T>
{
	private T[] content;
	private int size;
	private static final int DEFAULT_SIZE = 16;
	private T top;

	@SuppressWarnings("unchecked")
	public ArrayStack()
	{
		size = 0;
		content =  (T[]) new Object[DEFAULT_SIZE];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int _size)
	{
		size = 0;
		content =  (T[]) new Object[_size];
	}
	
	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}

	@Override
	public boolean isFull() 
	{
		return size == content.length;
	}

	@Override
	public void push(T object) throws FullStackException 
	{
		if(size == content.length)
		{
			throw new FullStackException();
		}
		
		content[size] = object;
		size++;
		top = object;
	}

	@Override
	public T pop() throws EmptyStackException 
	{	
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		
		size--;
		T res = content[size];
		content[size] = null;
		
		if(size > 0)
		{
			top = content[size - 1];
		}
		else
		{
			top = null;
		}		
		
		return res;
	}

	@Override
	public int size() 
	{		
		return content.length;
	}

	@Override
	public T top() throws EmptyStackException 
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		
		return top;
	}

	public void reverse()
	{		
		ArrayStack<T> helpStack = new ArrayStack<T>(this.size());		
		int s = 0;
		
		for(int i = 0; i < this.size(); i++)
		{
			if(content[i] != null)
			{
				s++;
			}
		}
		
		try 
		{
			int index = 0;
			
			for(int i = 0; i < s; i++)
			{								
				T help = pop();
				index++;
				
				while(!isEmpty() && index < s)
				{				
					helpStack.push(pop());		
					index++;
				}
				
				this.push(help);
				
				while(!helpStack.isEmpty())
				{				
					push(helpStack.pop());	
					index--;
				}
			}			
		} 
		catch (FullStackException | EmptyStackException e) 
		{				
			e.printStackTrace();
		}
	}	
	
	@Override
	public String toString()
	{
		String res = "";
		int index = 0;
		
		while(content[index] != null)
		{
			res += content[index].toString() + ", ";
			index++;
		}
		
		return res;
	}
}