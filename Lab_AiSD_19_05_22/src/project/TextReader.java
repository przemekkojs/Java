package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

public class TextReader 
{
	private static BufferedReader br;
	
	public static String read(String path)
	{		
		try 
		{
			br = new BufferedReader(new FileReader(new File(path)));			
			return br.readLine();			
		} 
		catch (FileNotFoundException e) 
		{			
			System.err.println("Nie znaleziono pliku " + path);
			System.exit(-1);
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.err.println("Pusty plik");
			System.exit(-1);
			e.printStackTrace();
		}
		
		return "";
	}
	
	public static Vector<Node> convertToNode(String text)
	{
		Vector<Node> res = new Vector<Node>();
		
		int[] arr = new int[256];
		int length = 0;
		
		for(int i = 0; i < text.length(); i++)
		{
			if(arr[text.charAt(i)] == 0)
			{
				length++;
			}
			
			arr[text.charAt(i)]++;			
		}
		
		int curMin = Integer.MAX_VALUE;
		int curMinIndex = 0;
		
		for(int j = 0; j < length; j++)
		{
			for(int i = 0; i < arr.length; i++)
			{
				if(arr[i] < curMin && arr[i] != 0)
				{
					curMin = arr[i];
					curMinIndex = i;
				}
			}
			
			res.add(new Node((char) curMinIndex, curMin));
			arr[curMinIndex] = 0;
			curMin = Integer.MAX_VALUE;
			curMinIndex = 0;
		}
		
		Collections.sort(res);
		
		return res;
	}
}
