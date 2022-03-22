package SimpleQueue;

import Zadanie1.EmptyStackException;

import Zadanie1.ArrayStack;
import Zadanie1.FullStackException;

public class Queue<T>
{
	private ArrayStack<T> s1 = new ArrayStack<T>();
	private ArrayStack<T> s2 = new ArrayStack<T>();
	
	public void enQueue(T elem) throws FullStackException, EmptyStackException
	{
		while(!s1.IsEmpty())
		{
			s2.push(s1.top());
			s1.pop();
		}
		
		s1.push(elem);
		
		while (!s2.IsEmpty())
		{
			s1.push(s2.top());
			s2.pop();
		}
	}
	
	public T deQueue() throws EmptyStackException
	{
		T res = s1.top();
		s1.pop();
		return res;
	}
}
