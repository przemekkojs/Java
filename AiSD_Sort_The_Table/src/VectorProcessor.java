import java.util.Vector;

public class VectorProcessor 
{
	public static void Write(Vector<LineVector> vector)
	{
		for(LineVector l : vector)
		{
			System.out.println(l.toString());
		}
	}	
}
