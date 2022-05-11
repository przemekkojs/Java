
public class BIShell extends AbstractSort
{
	//najpierw b¹belkowe, dla h = 1 wstawianie
	
	public BIShell(int[] _arr) 
	{
		super(_arr);
		name = "Bubble -> Insert ShellSort";
	}
	
	@Override
	public void Sort (int[] distances) 
	{
        int it = 0;
        int actDistance = 0;

        while (it < distances.length - 1) 
        {
        	actDistance = distances[distances.length - it - 1];
        	
            for (int i = actDistance; i < array.length; i++) 
            {
                int cur = array[i];
                int comp = i;
                
                while (comp >= actDistance) 
                {
                    if (cur < array[comp - actDistance])
                    {
                    	Sorts.Swap(array, actDistance, i);
                    }
                        
                    comp -= actDistance;
                }
            }
            
            it++;            
        }        
        
    	Sorts.InsertSort(array);                  
    }
}
