package project;

public class Vertex implements Comparable<Vertex> 
{	
	private int id;
	private String name;
	
	public Vertex(int _id, String _name)
	{		
		id = _id;
		name = _name;
	}
	
	public int id() { return id; }
	public String name() { return name; }	
	public String toString() { return String.format("%d - %s", id, name); }

	@Override
	public int compareTo(Vertex o) { return id - o.id; }	
}
