package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOManager 
{
	private int[] vertex1;
	private int[] vertex2;
	private int[] weight;
	private int vertexCount;
	private int edgeCount;
	
	private BufferedReader bufferedReader;
	
	public IOManager()
	{
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void read()
	{
		try 
		{
			String line = bufferedReader.readLine();	
			String[] items = line.split(" ");
			
			vertexCount = Integer.parseInt(items[0]);
			edgeCount = Integer.parseInt(items[1]);
			
			vertex1 = new int[edgeCount];
			vertex2 = new int[edgeCount];
			weight = new int[edgeCount];
			
			line = bufferedReader.readLine();
			int lineIndex = 0;
			
			while(lineIndex < edgeCount && !line.equals(""))
			{
				items = line.split(" ");
				
				vertex1[lineIndex] = Integer.parseInt(items[0]) - 1;
				vertex2[lineIndex] = Integer.parseInt(items[1]) - 1;
				weight[lineIndex] = Integer.parseInt(items[2]);
				
				lineIndex++;
				line = bufferedReader.readLine();
			}
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
	}
	
	public int[] vertex1 () { return vertex1; }
	public int[] vertex2 () { return vertex2; }
	public int[] weight() { return weight; }
	public int vertexCount() { return vertexCount; }
	public int edgeCount() { return edgeCount; }
}