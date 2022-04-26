
public class QuickSort extends AbstractSort 
{	
	public QuickSort(int[] _array) 
	{
		super(_array, "QuickSort");		
	}

	private void swap(int i, int j)
	{
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
	
	private int partition(int low, int high)
	{
	    int pivot = array[high];	   
	    int i = (low - 1);
	 
	    for(int j = low; j <= high - 1; j++)
	    {
	        if (array[j] < pivot)
	        {	           
	            i++;
	            swap(i, j);
	        }
	    }
	    
	    swap(i + 1, high);
	    return (i + 1);
	}
	
	private void quickSort(int low, int high)
	{
	    if (low < high)
	    {		       
	        int pi = partition(low, high);	 
	        quickSort(low, pi - 1);
	        quickSort(pi + 1, high);
	    }
	}
	
	@Override
	protected void Sort() 
	{
		quickSort(0, array.length - 1);
	}
}