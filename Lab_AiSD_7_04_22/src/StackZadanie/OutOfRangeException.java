package StackZadanie;

public class OutOfRangeException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public OutOfRangeException()
	{		
		System.err.print("Index out of range");
		System.exit(-1);
	}
}