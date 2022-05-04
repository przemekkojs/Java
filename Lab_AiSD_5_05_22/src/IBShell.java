
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
        int it = 1;
        int actDistance = distances[distances.length - it];

        while (actDistance > 1) 
        {            
            for (int i = actDistance; i < array.length; i++)
            {
                int cur = array[i];
                int comp = i;
                
                while (comp >= actDistance && cur < array[comp - actDistance]) 
                {
                    array[comp] = array[comp - actDistance];
                    comp -= actDistance;
                }
                
                array[comp] = cur;
            }
            
            actDistance = distances[distances.length - ++it];
        }
        
        if (actDistance == 1)
        {
        	Sorts.BubbleSort(array);
        }            
    }
}
