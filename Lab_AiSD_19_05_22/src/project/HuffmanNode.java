package project;

public class HuffmanNode 
{
	public int item;
	public char c;
	public HuffmanNode left;
	public HuffmanNode right;
	public String code;
	
	public HuffmanNode(int _item, char _c, HuffmanNode _left, HuffmanNode _right)
	{
		item = _item;
		c = _c;
		left = _left;
		right = _right;
		code = "";
	}
	
	public String toString()
	{
		return String.format("%s %d", c, item);
	}
}