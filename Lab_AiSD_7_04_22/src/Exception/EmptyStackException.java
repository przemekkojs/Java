package Exception;

public class EmptyStackException extends Exception
{
	private static final long serialVersionUID = 1L;

	public EmptyStackException()
	{
		System.err.print("Empty stack exception");
		System.exit(-1);
	}
}
