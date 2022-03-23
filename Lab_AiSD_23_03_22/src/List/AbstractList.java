package List;

import java.util.Iterator;

public abstract class AbstractList<E> implements IList<E>
{
	@Override
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		
		if(!isEmpty())
		{
			for(E element : this)
			{
				buffer.append(element).append(", ");
			}
			
			buffer.setLength(buffer.length() - 2);
		}
		
		return buffer.toString();
	}
	
	@Override
	public int hashCode()
	{
		int hashCode = 0;
		
		for(E element : this)
		{
			hashCode ^= element.hashCode();
		}
		
		return hashCode;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object object) 
	{
		if(object == null || getClass() != object.getClass())
		{
			return false;
		}		
		
		return equals((IList<E>) object);
	}
	
	public boolean equals(IList<E> other) 
	{
		if (other == null || size() != other.size())
		{
			return false;
		}
		
		Iterator<E> i = iterator();
		Iterator<E> j = other.iterator();
		
		boolean has1 = i.hasNext();
		boolean has2=j.hasNext();
		
		for(; has1 && has2 && i.next().equals(j.next()); )
		{
			has1 = i.hasNext();
			has2 = j.hasNext();
		}
		
		return !has1 && !has2; 
	}
}