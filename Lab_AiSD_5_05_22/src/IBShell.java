
public class IBShell extends AbstractSort
{
	//najpierw wstawianie, dla h = 1 b¹belkowe
	
	public IBShell(int[] _arr) 
	{
		super(_arr);
		name = "Insert -> Bubble ShellSort";
	}

	@Override
	public void Sort (int[] distances) 
	{
		int it = 0;
        int actDistance = distances[distances.length - 1];
        
        while (it < distances.length - 1) 
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
        
    	Sorts.BubbleSort(array);                  
    }
}
