package Zadanie1;

public class VTS<T> extends ArrayStack<T> 
{
	private int cursor;
	
	public VTS()
	{
		super();
		cursor = super.topIndex;
	}
	
	public VTS(int capacity)
	{
		super(capacity);
		cursor = super.topIndex;
	}
	
	@Override
	public void push(T elem) throws FullStackException
	{
		super.push(elem);
		cursor = 0;
	}
	
	@Override
	public T pop() throws EmptyStackException
	{		
		cursor = 0;
		return super.pop();
	}
	
	@Override
	public T top() throws EmptyStackException
	{
		cursor = 0;
		return super.top();		
	}
	
	public void down() throws OutOfRangeException
	{
		if(cursor == this.size() - 1)
		{
			throw new OutOfRangeException();
		}
		
		cursor++;
	}
	
	public T peek() throws EmptyStackException, FullStackException
	{		
		ArrayStack<T> help = new ArrayStack<T>(this.size());
		int where = cursor;
		
		for(int i = 0; i < where; i++)
		{
			help.push(super.top());
			super.pop();
		}
		
		T res = super.top();
		
		for(int i = 0; i < where; i++)
		{
			super.push(help.top());
			help.pop();
		}
		
		return res;
	}
}
