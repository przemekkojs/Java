package project;

public class Subset 
{
	private int parent;
	private int rank;
	
	public Subset(int _parent, int _rank)
	{
		parent = _parent;
		rank = _rank;
	}
	
	public Subset()
	{
		parent = 0;
		rank = 0;
	}
	
	public int parent() { return parent; }
	public int rank() { return rank; }
	
	public void setParent(int _parent) { parent = _parent; }
	public void setRank(int _rank) { rank = _rank; }
}
