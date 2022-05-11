import java.util.Random;
import java.util.Vector;

public class Process 
{	
	private Vector<Integer> usedPages;
	private String name;
	private int[] queue;
	private int errorCount;
	
	public Process(String _name)
	{
		name = _name;
		usedPages = new Vector<Integer>();
		queue = new int[1];
		errorCount = 0;
	}
	
	public String toString()
	{
		return String.format("%s, frames: %s", name, usedPages.toString());
	}
	
	public int[] generateQueue(int _size)
	{
		Random random = new Random();
		
		usedPages.clear();		
		
		for(int i = 0; i < _size; i++)
		{
			usedPages.add(random.nextInt(_size));
		}
		
		int[] res = new int[usedPages.size()];
		int _index = 0;
		
		for(Integer i : usedPages)
		{
			res[_index] = i;
			_index++;
		}
		
		queue = res;
		return res;
	}
	
	public int[] queue()
	{
		return queue;
	}
	
	public void error()
	{
		errorCount++;
	}
	
	public int errorCount()
	{
		return errorCount;
	}
}