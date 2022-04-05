package StackZadanie;

import Exception.EmptyStackException;

public class ListStack<T> implements IStack<T> 
{
	private LinkedList<T> stack;
	private int size;
	
	public ListStack()
	{
		stack = new LinkedList<T>();
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	@Override
	public T top() throws EmptyStackException
	{
		if(size == 0) throw new EmptyStackException();
		
		return stack.get(stack.size() - 1);
	}

	@Override
	public T pop() throws EmptyStackException
	{
		if(size == 0) throw new EmptyStackException();
		
		size--;
		
		T res = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return res;		
	}

	@Override
	public void push(T elem) 
	{
		stack.add(elem);
		size++;
	}

	@Override
	public int size() 
	{
		return size;
	}
	
	public String toString()
	{
		String res = "";
		
		for(T t : stack)
		{
			res += t.toString() + ", ";
		}
		
		return res;
	}
}