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
        int actDistance = distances[distances.length - it - 1];
        
        while (actDistance > 1) 
        {
            for (int i = actDistance, comp, cur; i < array.length; i++) 
            {
                cur = array[i];
                comp = i;
                
                while (comp >= actDistance && cur < array[comp - actDistance]) 
                {
                    array[comp] = array[comp - actDistance];
                    comp -= actDistance;
                }
                
                array[comp] = cur;
            }
            
            actDistance = distances[distances.length - it - 1];
            it++;
        }        
    }
}
