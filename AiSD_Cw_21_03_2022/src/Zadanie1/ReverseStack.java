package Zadanie1;

public class ReverseStack<T> extends ArrayStack<T>
{
	public ReverseStack()
	{
		super();
	}
	
	public ReverseStack(int capacity)
	{
		super(capacity);
	}
	
	public void Reverse() throws FullStackException, EmptyStackException
	{
		ArrayStack<T> help = new ArrayStack<T>();
		ArrayStack<T> help2 = new ArrayStack<T>();
		
		while(!super.IsEmpty())
		{
			help.push(super.top());
			super.pop();
		}
		
		while(!help.IsEmpty())
		{
			help2.push(help.top());
			help.pop();
		}
		
		while(!help2.IsEmpty())
		{
			super.push(help2.top());
			help2.pop();
		}
	}
}
