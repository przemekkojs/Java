
public class SelectSort extends AbstractSort 
{	
	public SelectSort(int[] _array) 
	{
		super(_array, "SelectSort");		
	}

	@Override
	protected void Sort() 
	{		 	   
	    for (int i = 0; i < array.length - 1; i++) 
	    { 	        
	        int minIndex = i; 
	        
	        for (int j = i + 1; j < array.length; j++) 
	        {
	        	if (array[j] < array[minIndex]) minIndex = j; 
	        }
	        
	        int tmp = array[i];
	        array[i] = array[minIndex];
	        array[minIndex] = tmp;
	    } 
	}
}