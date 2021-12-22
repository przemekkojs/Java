package Processors;

public class ArrayProcessor 
{
	public static String CharArrayToString(char[][] array)
	{
		String res = "";
		
		for(int y = 0; y < array.length; y++)
		{
			for(int x = 0; x < array[y].length; x++)
			{
				res += array[y][x];
			}
			
			res += System.getProperty("line.separator");
		}
		
		return res;
	}
}
