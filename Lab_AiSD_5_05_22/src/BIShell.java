
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
        int it = 1;
        int actDistance = distances[distances.length - it];

        while (actDistance > 1) 
        {
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
            
            actDistance = distances[distances.length - ++it];
        }
        
        if (actDistance == 1)
        {
        	Sorts.InsertSort(array);
        }            
    }
}
