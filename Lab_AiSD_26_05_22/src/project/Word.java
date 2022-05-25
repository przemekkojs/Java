package project;

import java.util.Vector;

public class Word implements Comparable<Word>
{
	private String word;
	private Vector<Integer> numbers;
	private int ID;
	
	public Word(String _word, int _verse, int _id)
	{
		word = _word;
		numbers = new Vector<Integer>();
		numbers.add(_verse);
		ID = _id;
	}
	
	public void addNumber(int _number) { numbers.add(_number); }
	public String word() { return word; }
	public String toString() { return String.format("%s (%d): %s", word, ID, numbers.toString()); }
	public Vector<Integer> numbers() { return numbers; }
	public int id() { return ID; }
	
	@Override
	public int compareTo(Word w) 
	{
		int index = 0;
		int length = Math.min(w.word().length(), word.length());
		
		while(index < length)
		{
			if(word.toLowerCase().charAt(index) < w.word().toLowerCase().charAt(index)) return -1;
			else if(word.toLowerCase().charAt(index) > w.word().toLowerCase().charAt(index)) return 1;
			
			index++;
		}
		
		if(length > word.length()) return 1;
		else if (length < word.length()) return -1;
		
		return 0;
	}
}