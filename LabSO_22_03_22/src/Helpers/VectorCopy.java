package Lab_22_03_22.Helpers;

import java.util.Vector;

public class VectorCopy 
{
	@SuppressWarnings("unchecked")
	public static <T> Vector<T> Copy(Vector<T> original)
	{		
		return (Vector<T>) original.clone();
	}
}
