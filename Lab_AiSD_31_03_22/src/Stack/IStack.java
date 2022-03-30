package Stack;

import Exceptions.EmptyStackException;
import Exceptions.FullStackException;

public interface IStack<T>
{
	public boolean isEmpty();
	public boolean isFull();
	public void push(T object) throws FullStackException;
	public T pop() throws EmptyStackException;
	public int size();
	public T top() throws EmptyStackException;
}