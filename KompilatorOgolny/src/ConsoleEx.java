import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleEx 
{
	private static volatile ConsoleEx cons;
	
	private Console systemConsole;
	
	private ConsoleEx()
	{
		systemConsole = System.console();
	}
	
	public static ConsoleEx console() 
	{
        ConsoleEx c;
        
        if ((c = cons) == null) 
        {
            synchronized (System.class) 
            {
                if ((c = cons) == null) 
                {
                    cons = c = new ConsoleEx();
                }
            }
        }
        
        return c;
    }
	
	public String readLine(String label) throws IOException
	{
		if (systemConsole != null)
		{			
			return systemConsole.readLine("system console - " + label);
		}
		
		System.out.print(label);
		return readLine();
	}
	
	public String readLine() throws IOException
	{
		if (systemConsole != null)
		{
			System.out.print("system console: ");
			return systemConsole.readLine();
		}
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		return bufferedReader.readLine();
	}
}
