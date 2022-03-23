package List;

import java.util.Iterator;

public class LinkedList<E> extends AbstractList<E>
{
	private Node<E> head;
	private int size;
	
	private static class Node<E>
	{
		private E element;
		private Node<E> next;
		
		public Node(E _element)
		{
			element = _element;
			next = null;
		}
		
		public void set(E _element)
		{
			element = _element;
		}
		
		public E get()
		{
			return element;
		}
		
		public Node<E> next()
		{
			return this.next;
		}
		
		public void setNext(Node<E> _next)
		{
			next = _next;
		}
	}
	
	public LinkedList()
	{
		head = null;
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void clear()
	{
		head = null;
		size = 0;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public Node<E> elementAt(int index) throws OutOfRangeException
	{
		Node<E> res = head;
		
		if(index < 0 || index >= size)
		{
			throw new OutOfRangeException();
		}
		
		while(index > 0)
		{
			index--;
			res = res.next();
		}
		
		return res;
	}
	
	public void add(E _element)
	{	
		size++;
		Node<E> newElem = new Node<E>(_element);
		
		if(head == null)
		{
			head = newElem;
			return;
		}
		
		Node<E> current = head;
		
		while(current.next() != null)
		{
			current = current.next();
		}
		
		current.setNext(new Node<E>(_element));		
	}
	
	public void add(E _element, int index)
	{
		Node<E> newElem = new Node<E>(_element);
		size++;
		
		if(index == 0)
		{
			newElem.setNext(head);
			head = newElem;
			return;
		}
		
		Node<E> current;
		
		try 
		{
			current = elementAt(index - 1);
			newElem.setNext(current.next());
			current.setNext(newElem);			
		} 
		catch (OutOfRangeException e) 
		{
			e.printStackTrace();
		}		
	}
	
	public void remove()
	{
		if(size < 2)
		{
			head = null;
			size = 0;
			return;
		}
		
		try 
		{
			elementAt(size - 2).setNext(null);
			size--;
		} 
		catch (OutOfRangeException e) 
		{			
			e.printStackTrace();
		}
	}
	
	public void remove(int index)
	{			
		if(size < 2)
		{
			head = null;
			size = 0;
			return;
		}
		
		size--;		
		
		if(index == 0)
		{
			head = head.next();
		}
		else
		{
			try 
			{
				elementAt(index - 1).setNext(elementAt(index).next);
			} 
			catch (OutOfRangeException e) 
			{				
				e.printStackTrace();
			}
		}
	}

	public int indexOf(E _data) throws OutOfRangeException
	{
		int index = 0;
		Node<E> current = head;
		
		while(current != null)
		{
			if(current.get().equals(_data))
			{
				return index;
			}
			current = current.next();
			index++;
		}
		
		throw new OutOfRangeException();
	}
	
	public boolean contains(E _data)
	{
		try 
		{
			return indexOf(_data) >= 0;
		} 
		catch (OutOfRangeException e) 
		{			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public E get(int index)
	{
		try
		{
			return elementAt(index).get();
		}
		catch (OutOfRangeException e) 
		{			
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void set(E _data, int index)
	{
		try 
		{
			elementAt(index).set(_data);
		}
		catch (OutOfRangeException e) 
		{			
			e.printStackTrace();
		}
	}

	
	private class InnerIterator implements Iterator<E>
	{
		private Node<E> current;
		
		public InnerIterator()
		{
			current = head;
		}
		
		@Override
		public boolean hasNext() 
		{
			return current != null;
		}

		@Override
		public E next() 
		{
			E res = current.get();
			current = current.next();
			return res;
		}
		
	}
	
	@Override
	public Iterator<E> iterator() 
	{		
		return new InnerIterator();
	}
}