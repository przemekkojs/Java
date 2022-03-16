package app.parameters;

import java.time.Duration;

public class ArgumentParser 
{
	public ApplicationArguments parse(String args[])
	{	
		ApplicationArguments a = new ApplicationArguments(Duration.parse(args[0]), Integer.parseInt(args[1]));
		return a;
	}
}
