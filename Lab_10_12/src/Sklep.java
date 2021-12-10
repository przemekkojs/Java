import java.io.BufferedWriter;
import java.io.FileWriter;

public class Sklep 
{
	public static void main(String[] args)
	{	
		try
		{
			FileWriter file = new FileWriter("C:/output.txt");
			BufferedWriter writer = new BufferedWriter(file);
			
			writer.append("abc");			
			writer.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}
}