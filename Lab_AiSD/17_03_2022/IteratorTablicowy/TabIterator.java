package IteratorTablicowy;

import java.util.Iterator;
import java.util.NoSuchElementException;

import Pracownik.Pracownik;

public class TabIterator implements Iterator<Pracownik>
{
	private int current;
	private Pracownik[] array;
	
	public TabIterator(Pracownik[] _array)
	{
		array = _array;
		current = 0;
	}
	
	@Override
	public boolean hasNext() 
	{		
		return current < array.length;
	}

	@Override
	public Pracownik next() throws NoSuchElementException
	{		
		if(hasNext())
		{
			return array[current++];
		}
		else
		{
			throw new NoSuchElementException();
		}
	}
}
