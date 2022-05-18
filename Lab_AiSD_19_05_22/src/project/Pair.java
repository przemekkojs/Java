package project;

public class Pair<T1 extends Object, T2 extends Object> 
{
	public T1 first;
	public T2 second;
	
	public Pair(T1 _first, T2 _second)
	{
		first = _first;
		second = _second;
	}	
}
