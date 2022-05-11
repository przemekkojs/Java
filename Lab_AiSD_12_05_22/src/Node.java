
public class Node<T> 
{
	private T value;
	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;
	
	public Node()
	{
		value = null;
		left = null;
		right = null;
		parent = null;
	}
	
	public Node(T _value)
	{
		value = _value;
		left = null;
		right = null;
		parent = null;
	}
	
	public T value()
	{
		return value;
	}
	
	public Node<T> left()
	{
		return left;
	}
	
	public Node<T> right()
	{
		return right;
	}
	
	public Node<T> parent()
	{
		return parent;
	}
	
	public void setLeft(Node<T> _left)
	{
		left = _left;
	}
	
	public void setRight(Node<T> _right)
	{
		right = _right;
	}
	
	public void setParent(Node<T> _parent)
	{
		parent = _parent;
	}
	
	public boolean isLeaf()
	{
		return (left == null && right == null);
	}
	
	public String toString()
	{
		return String.format("%s", value.toString());
	}
}
