package project;

public class Main 
{
	private static IOManager io;
	private static Graph g;
	
	public static void main(String[] args)
	{
		init();
		solve();
	}
	
	private static void init()
	{
		io = new IOManager();
		io.read();		
		
		g = new Graph(io.vertexCount(), io.edgeCount());
		
		for(int index = 0; index < io.edgeCount(); index++)
		{
			g.addEdge(io.vertex1()[index], io.vertex2()[index], io.weight()[index], index);
		}
	}
	
	private static void solve()
	{
		g.KruskalMST();
	}
}
