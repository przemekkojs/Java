package project;

public class Node 
{
	public Word data;
	public Node left;
	public Node right;
	public Node parent;
	public Colors color;
	private int id;
	
	public Node()
	{
		left = null;
		right = null;
		data = null;
		id = -1;
		color = Colors.Black;				
	}
	
	public Node(Colors _color, Word _word, Node _left, Node _right, Node _parent)
	{
		left = _left;
		right = _right;
		data = _word;
		color = _color;
		parent = _parent;
		id = _word.id();
	}

	public String toString() { return String.format("%s", data.toString()); }
	
	public int id() { return id; }

	public void setColor(Colors _color) { color = _color; }
	public void addNumber (int _number) { data.numbers().add(_number); }
}