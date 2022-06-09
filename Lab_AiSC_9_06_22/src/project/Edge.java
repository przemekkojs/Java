package project;

public class Edge implements Comparable<Edge> 
{
	private int vertex1;
	private int vertex2;
	private int weight;
	
	public Edge()
	{
		vertex1 = 0;
		vertex2 = 0;
		weight = 0;
	}
	
	public Edge(int _vertex1, int _vertex2, int _weight)
	{
		vertex1 = _vertex1;
		vertex2 = _vertex2;
		weight = _weight;
	}
	
	public int vertex1() { return vertex1; }
	public int vertex2() { return vertex2; }
	public int weight() { return weight; }
	
	public void setVertex1(int _vertex1) { vertex1 = _vertex1; }
	public void setVertex2(int _vertex2) { vertex2 = _vertex2; }
	public void setWeight(int _weight) { weight = _weight; }
	
	@Override
	public int compareTo(Edge edge) { return weight - edge.weight(); }
}