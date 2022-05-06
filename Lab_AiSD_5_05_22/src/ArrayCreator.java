import java.util.Vector;
import java.util.Collections;

public class ArrayCreator 
{
	public static Integer[] IteratedH(int n)
	{
		Vector<Integer> res = new Vector<Integer>();
		
		int curValue = 1;
		
		while(curValue <= n)
		{
			res.add(curValue);
			curValue = (curValue * 3) + 1;
		}
		
		return res.toArray(new Integer[res.size()]);
	}
	
	public static Integer[] TwoKMinusOne(int n)
	{
		Vector<Integer> res = new Vector<Integer>();
		
		int curValue = 1;
		int index = 0;
		
		while(curValue <= n)
		{
			res.add(curValue);
			curValue = (int) Math.pow(2, index) - 1;
			index++;
		}
		
		return res.toArray(new Integer[res.size()]);
	}
	
	public static Integer[] TwoKPlusOne(int n)
	{
		Vector<Integer> res = new Vector<Integer>();
		
		int curValue = 1;
		int index = 0;
		
		while(curValue <= n)
		{
			res.add(curValue);
			curValue = (int) Math.pow(2, index) + 1;
			index++;
		}
		
		return res.toArray(new Integer[res.size()]);
	}
	
	public static Integer[] Fibonacci(int n)
	{
		Vector<Integer> res = new Vector<Integer>();
		
		int curValue = 1;
		int lastValue = 1;
		
		while(curValue <= n)
		{
			int tmp = curValue;
			
			res.add(curValue);
			curValue += lastValue;
			lastValue = tmp;
		}
		
		return res.toArray(new Integer[res.size()]);
	}	
	
	public static Integer[] RandomArray(int size)
	{
		Vector<Integer> res = new Vector<Integer>();
		
		for(int i = 0; i < size; i++)
		{
			res.add(i);
		}
		
		Collections.shuffle(res);
		
		return res.toArray(new Integer[res.size()]);
	}
	
	public static int[] CopyArray(Integer[] arr)
	{
		int[] res = new int[arr.length];
		
		for(int index = 0; index < arr.length; index++)
		{
			res[index] = arr[index];
		}
		
		return res;
	}
	
	public static Integer[] LessonArray(int n)
	{
		Vector<Integer> res = new Vector<Integer>();
		
		int curValue = n/2;
		int index = n - 1;
		
		while(index >= 1 && curValue > 0)
		{
			res.add(curValue);
			curValue *= 3;
			curValue /= 4;
			index--;
		}
		
		return res.toArray(new Integer[res.size()]);
	}
}