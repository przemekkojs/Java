import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Testy4
{
	public static void main(String[] args) throws IOException 
	{		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("generated5.txt")));	
		
		for(int index = 0; index < 1000; index++)
		{
			Long start = System.nanoTime();
			try
			{
				Declared();
			}
			catch (ArithmeticException e)
			{
				Long end = System.nanoTime() - start;
				bw.write(end.intValue() + "\n");
			}			
		}
		
		bw.close();
	}
	
	private static void Declared() throws ArithmeticException
	{		
		System.out.print(1/0);		
	}
}