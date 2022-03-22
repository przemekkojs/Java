package Zadanie1;

public interface IStack<T> 
{
	boolean IsEmpty();
	boolean isFull();
	
	T pop() throws EmptyStackException;
	T top() throws EmptyStackException;
	
	void push(T elem) throws FullStackException;
	
	int size();	
}
