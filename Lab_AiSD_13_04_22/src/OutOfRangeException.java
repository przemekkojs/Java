
public class OutOfRangeException extends Exception 
{	
	private static final long serialVersionUID = 1L;
	
	public OutOfRangeException()
	{
		System.err.println("Out of range");
		System.exit(-1);
	}
}
