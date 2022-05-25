package morse;

public class Node 
{
	public String code;	
	public char letter;
	public Node left;
	public Node right;
	
	public Node(String _code, Node _left, Node _right, char _letter)
	{
		code = _code;
		left = _left;
		right = _right;
		letter = _letter;
	}
	
	public String toString()
	{
		return String.format("%1s: %-5s", letter, code);
	}
}
