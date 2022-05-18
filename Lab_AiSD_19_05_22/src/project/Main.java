package project;

import java.util.Vector;

public class Main 
{	
	private static final String readPath = "input.txt";
	private static final String writePath = "output.txt";
	
	private static String text;	
	private static Vector<Node> initializerList;
	
	public static void main(String[] args)
	{
		init();
		write();
	}
	
	private static void init()
	{
		text = TextReader.read(readPath);
		initializerList = TextReader.convertToNode(text);
	}
	
	private static void write()
	{
		System.out.println(text);
		
		for(Node n : initializerList)
		{
			System.out.println(n.toString());
		}
	}
}
