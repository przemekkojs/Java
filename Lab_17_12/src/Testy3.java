import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Testy3
{
	public static void main(String[] args) throws IOException 
	{		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("generated3.txt")));	
		
		for(int index = 0; index < 10000; index++)
		{
			bw.write(Generated().intValue() + "\n");
		}
		
		bw.close();
	}
	
	private static Long Generated() 
	{		
		long start = System.nanoTime();
		
		try
		{
			System.out.print(1/0);
		}
		catch (ArithmeticException e)
		{			
			return System.nanoTime() - start;
		}		
		
		return null;
	}	
}