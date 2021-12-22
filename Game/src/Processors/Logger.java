package Processors;

import java.util.Vector;

import Game.UI;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Logger 
{
	private static Vector<String> logs = new Vector<String>();
	
	public static void Log(String output)
	{
		logs.add(String.format("%s: %s", java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")).toString(), output));
		System.out.print(output);
		UI.Log(output);
	}
	
	public static void Clear()
	{
		System.out.print("\033[H\033[2J");
		System.out.println();
		System.out.flush();
	}
	
	public static <T>Object[] convertVectorToArray(Vector<T> vector)
	{  
		return vector.toArray();
	}
	
	public static String[] GetLogs()
	{
		Object[] objectArray = convertVectorToArray(logs);		
		return Arrays.copyOf(objectArray, objectArray.length, String[].class);
	}
}
