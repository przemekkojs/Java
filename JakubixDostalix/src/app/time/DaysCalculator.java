package app.time;

import java.time.Duration;

public class DaysCalculator 
{
	public Duration addDays(Duration duration, int daysToAdd)
	{
		return duration.plusDays(daysToAdd);
	}
}