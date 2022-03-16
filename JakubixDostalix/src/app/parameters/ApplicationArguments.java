package app.parameters;

import java.time.Duration;

public class ApplicationArguments 
{
	private Duration duration;
	private int daysToAdd;
	
	public ApplicationArguments() //Konstruktor domy�lny - bez parametr�w
	{
		duration = Duration.ZERO;
		daysToAdd = 0;
	}
	
	public ApplicationArguments(Duration _duration, int _daysToAdd) //Konstruktor parametryczny
	{
		duration = _duration;
		daysToAdd = _daysToAdd;
	}
	
	public void Set(Duration _duration, int _daysToAdd)
	{
		duration = _duration;
		daysToAdd = _daysToAdd;
	}
	
	public Duration getDuration()
	{
		return duration;
	}
	
	public int getDaysToAdd()
	{
		return daysToAdd;
	}
}