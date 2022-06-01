package project;

import java.util.TreeSet;

public class Graph 
{
	private int size;
	private int[][] graph;
	
	private static final int START_SIZE = 10;	
	private TreeSet<Vertex> vertices;
	
	public Graph()
	{
		graph = new int[START_SIZE][START_SIZE];		
		vertices = new TreeSet<Vertex>();
		size = 0;
	}
	
	public Graph(Vertex[][] _vertices, int[] _distances)
	{		
		graph = new int[_vertices.length][_vertices.length];		
		vertices = new TreeSet<Vertex>();
		
		size = _vertices.length;
		
		for(int i = 0; i < _vertices.length; i++)
		{
			add(_vertices[i][0], _vertices[i][1], _distances[i]);
		}
	}
	
	public void add(Vertex vertex1, Vertex vertex2, int distance)
	{		
		graph[vertex1.id()][vertex2.id()] = distance;
		vertices.add(vertex1);
		vertices.add(vertex2);
		
		size = vertices.size();
	}
	
	public void writeMatrix()
	{
		for(int y = 0; y < graph.length; y++)
		{
			for(int x = 0; x < graph.length; x++)
			{
				if(graph[y][x] > 0)
				{
					System.out.printf("%d - %d; %d%n", y, x, graph[y][x]);
				}
			}
		}
	}
	
	public void writeCities()
	{
		for(Vertex v : vertices)
		{
			System.out.println(v.toString());
		}
	}
	
	public void dijkstra(Vertex source)
    {		
		System.out.println("Miasto wyjœciowe: " + source.id());		
		
		int dist[] = new int[size];
        
        Boolean sptSet[] = new Boolean[size];
 
        for (int i = 0; i < size; i++) 
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        dist[source.id()] = 0;
 
        for (int count = 0; count < size - 1; count++) 
        {          
            int u = minDistance(dist, sptSet);
 
            sptSet[u] = true;
 
            for (int v = 0; v < size; v++) 
            {
            	if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
            	{
            		dist[v] = dist[u] + graph[u][v];
            	}                    
            }                
        }
 
        for (int i = 0; i < size; i++)
        {
        	System.out.println(i + " " + dist[i]);
        }            
    }
	
	int minDistance(int dist[], Boolean sptSet[])
    {       
        int min = Integer.MAX_VALUE;
        int min_index = -1;
 
        for (int v = 0; v < size; v++)
        {       
            if (sptSet[v] == false && dist[v] <= min) 
            {
                min = dist[v];
                min_index = v;
            }
        }
        
        return min_index;
    }
	
	public int size() { return size; }
}
