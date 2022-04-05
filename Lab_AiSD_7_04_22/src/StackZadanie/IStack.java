package StackZadanie;

import Exception.EmptyStackException;

public interface IStack<T> 
{
	public boolean isEmpty();
	public T top() throws EmptyStackException;
	public T pop() throws EmptyStackException;
	public void push(T elem);
	public int size();	
}
