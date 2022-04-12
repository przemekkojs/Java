import java.util.Scanner;

public class Main 
{
	private static String[] output;
	private static boolean[][] graph;
	private static int n;
	private static int q;
	
	public static void main(String[] args) 
	{		
		Scanner s = new Scanner(System.in);
		
		n = Integer.parseInt(s.next());
		q = Integer.parseInt(s.next());
		
		output = new String[q];
		graph = new boolean[n][n];		
		
		int row = 0;
	    int column = 0;
		
		for(int index = 0; index < q; index++)
	    {
	        //Podajemy 2 wierzcholki
	        row = Integer.parseInt(s.next()); //X
	        column = Integer.parseInt(s.next());; //Y
	        
	        row--;
	        column--;
	        
	        if(!graph[row][column]) //Jezeli polaczenie istnieje, to trzeba je usunac
	        {
	            graph[row][column] = true;
	            graph[column][row] = true;
	        }
	        else
	        {
	            graph[row][column] = false;
	            graph[column][row] = false;
	        }

	        boolean bipartite = true;
	        int i = 0;

	        while(i < n && bipartite)
	        {	            
	        	if(i == row || i == column)
	        	{
	        		i++;
	        		continue;
	        	}
	        	
	            if(graph[column][i]) //którykolwiek po³¹czony z B
	            {	            	
            		bipartite = false;	            	                
	            }

	            i++;
	        }

	        output[index] = bipartite ? "YES" : "NO";
	    }
		
		for(int i = 0; i < q; i++)
		{
			System.out.println(output[i]);
		}				
		
		s.close();
	}
}
