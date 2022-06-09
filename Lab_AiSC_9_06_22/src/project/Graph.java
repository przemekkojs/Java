package project;

import java.util.Arrays;

public class Graph 
{
	private Edge[] edges;
	private int vertexCount;
	private int edgeCount;
	
	public Graph(int _vertexCount, int _edgeCount)
	{
		edges = new Edge[_edgeCount];
		
		for(int index = 0; index < _edgeCount; index++)
		{	
			edges[index] = new Edge();
		}
		
		edgeCount = _edgeCount;
		vertexCount = _vertexCount;
	}
	
	public int vertexCount() { return vertexCount; }
	public int edgeCount() { return edgeCount; }	
	
	public void addEdge(int v1, int v2, int w, int index) { edges[index] = new Edge(v1, v2, w); }
	
	//Szukanie rodzica + kompresja sciezki
	public int find(Subset subsets[], int i)
    {        
        if (subsets[i].parent() != i) subsets[i].setParent(find(subsets, subsets[i].parent()));  
        return subsets[i].parent();
    }
	
	//Laczenie poddrzew w jedno
	public void union(Subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        //Dolaczamy mniejsze poddrzewo do wiekszego
        if (subsets[xroot].rank() < subsets[yroot].rank()) subsets[xroot].setParent(yroot); 
        else if (subsets[xroot].rank() > subsets[yroot].rank()) subsets[yroot].setParent(xroot);
 
        else //Podzbiory o tym samym rzedzie traktujemy tak:
        {
            subsets[yroot].setParent(xroot); //Jeden bedzie nowym korzeniem
            subsets[xroot].setRank(subsets[xroot].rank() + 1); //Zwiekszamy jego rzad o 1
        }
    }
	
	public void KruskalMST()
    {       
        Edge result[] = new Edge[vertexCount];            
        for (int i = 0; i < vertexCount; i++) result[i] = new Edge(); //Tworzymy nowa tablice na wyniki 
        
        Subset subsets[] = new Subset[vertexCount];        
        for (int i = 0; i < vertexCount; i++) subsets[i] = new Subset(); //Tablica na podzbiory - tyle ile mamy wierzholkow        
        
        Arrays.sort(edges); //Krok 1. algorytmu - sortujemy krawedzie
 
        //Tworzymy tyle zbiorow ile mamy wierzcholkow
        for (int v = 0; v < vertexCount; ++v)
        {
            subsets[v].setParent(v);
            subsets[v].setRank(0);
        }
 
        int i = 0;
        int e = 0; 
        
        while (e < vertexCount - 1)
        {           
            Edge next_edge = edges[i++];
 
            int x = find(subsets, next_edge.vertex1());
            int y = find(subsets, next_edge.vertex2());
 
            if (x != y) //Musimy pomijac cykle
            {
                result[e++] = next_edge;
                union(subsets, x, y);
            }           
        }
 
        int minimumCost = 0;
        for (int index = 0; index < e; index++) minimumCost += result[index].weight();
        
        System.out.println("Wynik: " + minimumCost);
    }
}