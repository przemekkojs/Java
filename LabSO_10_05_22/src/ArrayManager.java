
public class ArrayManager 
{
	public static void printArray(int[] arr)
	{
		for(int elem : arr)
		{
			System.out.print(elem + " ");
		}
		
		System.out.println();
	}
	
	public static int[] IntegerToInt(Integer[] arr)
	{
		int[] res = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++)
		{
			res[i] = arr[i];
		}
		
		return res;
	}
	
	public static boolean Contains(int elem, int[] arr)
	{
		for(int i : arr)
		{
			if(i == elem) return true;
		}
		
		return false;
	}
}
