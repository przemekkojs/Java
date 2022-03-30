package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager 
{
	private static BufferedReader br;
	
	public static String GetInput()
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			System.out.print("Podaj liniê: ");
			return br.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
