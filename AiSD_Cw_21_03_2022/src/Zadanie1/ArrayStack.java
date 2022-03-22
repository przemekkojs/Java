package Zadanie1;

public class ArrayStack<T> implements IStack<T>
{
	private static final int DEFAULT_CAPACITY = 16;
	
	private T[] array;
	protected int topIndex;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialSize)
	{
		array = (T[]) (new Object[initialSize]);
		topIndex = 0;
	}
	
	public ArrayStack()
	{
		 this(DEFAULT_CAPACITY);
	}
	
	@Override
	public boolean IsEmpty() 
	{
		return topIndex == 0;
	}

	@Override
	public boolean isFull() 
	{
		return topIndex == array.length;
	}

	@Override
	public T pop() throws EmptyStackException 
	{
		if(IsEmpty())
		{
			throw new EmptyStackException();
		}
		
		return array[--topIndex];
	}

	@Override
	public int size() 
	{
		return topIndex;
	}

	@Override
	public T top() throws EmptyStackException {
		if(IsEmpty())
		{
			throw new EmptyStackException();
		}
		
		return array[topIndex - 1];
	}

	@Override
	public void push(T elem) throws FullStackException 
	{
		if(isFull())
		{
			throw new FullStackException();
		}

		array[topIndex++] = elem;
	}
}
