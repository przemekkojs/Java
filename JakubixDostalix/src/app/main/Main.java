package app.main; //ISO-8601 = 2022-03-14

import java.time.Duration;

import app.parameters.ApplicationArguments;
import app.parameters.ArgumentParser;
import app.time.DaysCalculator;

public class Main 
{
	public static void main(String[] args) 
	{
		Zadanie1();
		Zadanie2();
		Zadanie3();
	}
	
	private static void Zadanie1()
	{
		ArgumentParser argumentParser = new ArgumentParser();
		ApplicationArguments parsedArguments = argumentParser.parse(new String[] {"PT20S", "5"}); //Zamiast new String[] daj args[] z main
		
		System.out.println("First arg = " + parsedArguments.getDuration().toString());
		System.out.println("Second arg = " + parsedArguments.getDaysToAdd());
		System.out.println(parsedArguments.toString());
		System.out.println();
	}
	
	private static void Zadanie2()
	{
		ArgumentParser argumentParser = new ArgumentParser();
		ApplicationArguments parsedArguments = argumentParser.parse(new String[] {"PT20S", "5"});
		
		System.out.println("First arg = " + parsedArguments.getDuration().toString());
		System.out.println("Second arg = " + parsedArguments.getDaysToAdd());
		System.out.println();
	}
	
	private static void Zadanie3()
	{
		ArgumentParser argumentParser = new ArgumentParser();
		ApplicationArguments parsedArguments = argumentParser.parse(new String[] {"PT20S", "5"});
		Duration result = new DaysCalculator().addDays(parsedArguments.getDuration(), 
				parsedArguments.getDaysToAdd());
		
		System.out.println("First arg = " + parsedArguments.getDuration().toString());
		System.out.println("Second arg = " + parsedArguments.getDaysToAdd());
		System.out.println("Result = " + result.toString());
	}
}
