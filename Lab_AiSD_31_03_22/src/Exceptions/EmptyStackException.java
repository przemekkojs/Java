package Exceptions;

public class EmptyStackException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public EmptyStackException()
	{
		System.err.print("Exception: stack empty");
		System.exit(-1);
	}
}
