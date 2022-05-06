public class ShellSort extends AbstractSort
{
	//Ca³osciowy insert		
	public ShellSort(int[] _arr) 
	{
		super(_arr);
		name = "Insert ShellSort";
	}

	@Override
	public void Sort (int[] distances) 
	{
        int it = 0;
        int actDistance = distances[distances.length - 1];
        
        while (it < distances.length) 
        {
        	actDistance = distances[distances.length - 1 - it];
        	
            for (int i = actDistance; i < array.length; i++) 
            {
                int cur = array[i];
                int j;
                
                for (j = i; j >= actDistance && cur < array[j - actDistance]; j -= actDistance) 
                {
                    array[j] = array[j - actDistance];                    
                }
                
                array[j] = cur;
            }
            
            it++;
        }        
    }
}
