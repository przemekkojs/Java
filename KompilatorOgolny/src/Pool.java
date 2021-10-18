import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Vector;

public class Pool
{	
	public int sceneLength = 10;
	
	public String[] LoadPool(String file)
	{
		Vector<String> pool = new Vector<String>();
		
		try
		{
			File myObj = new File(file);
			Scanner myReader = new Scanner(myObj);
			
			while(myReader.hasNextLine())
			{
				pool.add(myReader.nextLine());				
			}
			myReader.close();
		}
		catch (FileNotFoundException exception)
		{
			System.out.print("File not found");
			exception.printStackTrace();
		}	
		
		sceneLength = pool.size();
		return pool.toArray(new String[pool.size()]);
	}
	
	public void WritePool(String pool[])
	{
		for(int i = 0; i < sceneLength; i++)
		{
			System.out.println(pool[i]);
		}
	}
	
	public String[] OverwriteAt(char sign, int x, int y, String[] pool)
	{			
		char[] myNameChars = pool[y].toCharArray();
		myNameChars[x] = sign;
		pool[y] = String.valueOf(myNameChars);
		
		return pool;
	}
}
