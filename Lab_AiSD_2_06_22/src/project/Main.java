package project;

public class Main 
{
	private static Graph graph;
		
	private static Vertex wroclaw;
	private static Vertex olawa;
	private static Vertex brzeg;
	private static Vertex nysa;
	private static Vertex opole;
	
	public static void main(String[] args) 
	{
		init();
		
		System.out.println("miasta:");
		graph.writeCities();
		System.out.println();		
		System.out.println("dane:");
		graph.writeMatrix();
		System.out.println();
		
		graph.dijkstra(wroclaw);
	}
	
	private static void init()
	{
		wroclaw = new Vertex(0, "Wroc³aw");
		olawa = new Vertex(1, "O³awa");
		brzeg = new Vertex(2, "Brzeg");
		nysa = new Vertex(3, "Nysa");
		opole = new Vertex(4, "Opole");
		
		Vertex[][] v = new Vertex[][] {{wroclaw, olawa}, {wroclaw, nysa}, {wroclaw, opole}, {olawa, brzeg}, {brzeg, opole}, {nysa, brzeg}, {nysa, opole}};
		int[] d = new int[] {10, 30, 100, 50, 10, 20, 60};
		
		graph = new Graph(v, d);
	}
}
