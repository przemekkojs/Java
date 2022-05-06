
public class BubbleSort extends AbstractSort 
{	
	public BubbleSort(int[] _array) 
	{
		super(_array, "BubbleSort");		
	}

	@Override
	protected void Sort()
	{		
	    for (int i = 0; i < array.length - 1; i++)
	    {
	    	for (int j = 0; j < array.length - i - 1; j++)
	    	{
	    		if (array[j] > array[j + 1])
	    		{
	    			int tmp = array[i];
	    			array[i] = array[j];
	    			array[j] = tmp;	    			
	    		}	               
	    	}	            
	    }	        
	}
}