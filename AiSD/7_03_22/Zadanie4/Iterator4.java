package Zadanie4;

import java.util.Iterator;

public class Iterator4<T> implements Iterator<T>
{
	private T next;
	private Iterator4<T> iterator;
	private int index = 0;
	
	@Override
	public boolean hasNext() 
	{		
		return false;
	}

	@Override
	public T next() 
	{		
		if (index == 1)
		{
			index++;
			next = (T) iterator.next();
		}
		
		return null;
	}
	
	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}
