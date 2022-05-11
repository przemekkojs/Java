
public class ArrayManager 
{
	public static String arrayToString(String[] arr)
	{
		String res = "[";
		
		for(int i = 0; i < arr.length - 1; i++)
		{
			res += arr[i] + ", ";
		}
		
		res += arr[arr.length - 1];
		res += "]";
		
		return res;
	}
}
