package project;

public class Node implements Comparable<Node>
{
	private Node left;
	private Node right;
	private Node next;
	private char key;
	private int weight;
	private String code;
	
	public Node()
	{
		left = null;
		right = null;
		key = '?';
		weight = 0;
		code = "0";
	}
	
	public Node(char _key, int _weight)
	{
		left = null;
		right = null;
		key = _key;
		weight = _weight;
		code = "0";
	}
	
	public Node(Node _right, Node _left, char _key, int _weight)
	{
		left = _left;
		right = _right;
		key = _key;
		weight = _weight;
		code = "0";
	}
	
	public Node left() { return left; }	
	public Node right() { return right; }	
	public Node next() { return next; }	
	public char key() { return key; }	
	public int weight() { return weight; }	
	public String code() { return code; }
	
	public void setLeft(Node _left) { left = _left; }	
	public void setRight(Node _right) { right = _right; }	
	public void setNext(Node _next) { next = _next; }	
	public void setKey(char _key) { key = _key; }	
	public void setWeight(int _weight) { weight = _weight; }
	public void setCode(String _code) { code = _code; }
	
	public String toString() { return String.format("%-5s| %-5d", key, weight); }
	
	@Override
	public int compareTo(Node o) 
	{
		if(weight < o.weight) return -1;
		else if(weight > o.weight) return 1;		
		return 0;
	}
}