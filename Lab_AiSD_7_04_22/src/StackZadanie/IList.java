package StackZadanie;

import java.util.Iterator;

public interface IList<E> extends Iterable<E>
{
	public boolean isEmpty();
	public void clear();
	public int size();	
	public void add(E _element);
	public void add(E _element, int index);
	public void remove();
	public void remove(int index);
	public int indexOf(E _data) throws OutOfRangeException;
	public boolean contains(E _data);
	public E get(int index);
	public void set(E _data, int index);
	public Iterator<E> iterator();	
}