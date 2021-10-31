import java.util.Vector;

public class LiczbaNaturalna {

	public static void main(String[] args) 
	{
		int value = 1234567890;
		
		Write(new Object[] {"Liczba 1234567890: ", SumaCyfr(value), LiczbaCyfr(value), Left(value), Exists(value, 5), Exists(value, 4), MaxDigit(value)});
		MostFrequentDigit(value);
	}
	
	public static void Write(Object[] value)
	{
		for(Object s : value)
		{			
			System.out.println(s);
		}
	}
	
	public static int SumaCyfr(int value)
	{
		int res = 0;
		
		while(value > 0)
		{			
			res += value%10;
			value /= 10;
		}
		
		return res;
	}
	
	public static int LiczbaCyfr(int value)
	{
		int res = 0;
		
		while(value > 0)
		{
			value /= 10;
			res++;
		}
		
		return res;
	}
	
	public static int Left(int value)
	{
		while(value > 10)
		{
			value /= 10;
		}
		
		return value;
	}
	
	public static boolean Exists(int value, int digit)
	{
		while(digit != value%10 && value > 0)
		{
			value /= 10;
		}
		
		if(value > 0)
		{
			return true;
		}
		
		return false;
	}
	
	public static int MaxDigit(int value)
	{
		int max = 0;
		
		while(value > 0 && max < 9)
		{
			int digit = value%10;
			
			if(digit > max)
			{
				max = digit;				
			}
			
			value /= 10;		
		}
		
		return max;
	}
	
	public static void MostFrequentDigit(int value)
	{
		int[] tab = new int[10];
		int curMax = 0;
		Vector<Integer> res = new Vector<Integer>();
		
		while(value > 0)
		{
			int i = value%10;
			value /= 10;
			tab[i]++;
		}
		
		for(int i = 0; i < 10; i++)
		{
			if(tab[curMax] < tab[i])
			{
				curMax = i;
				res.clear();
				res.add(i);
			}			
			else if(tab[curMax] == tab[i])
			{
				res.add(i);
			}
		}
		
		Write(new Object[]{"Najczêstsze cyfry: "});
		
		for(int e : res)
		{
			Write(new Object[] {e});
		}
	}
}