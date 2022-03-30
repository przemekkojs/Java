package Exceptions;

public class FullStackException extends Exception
{
	private static final long serialVersionUID = 1L;

	public FullStackException()
	{
		System.err.print("Exception: stack full");
		System.exit(-1);
	}
}
