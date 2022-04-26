
public class HeapSort extends AbstractSort 
{	
	public HeapSort(int[] _array) 
	{
		super(_array, "HeapSort");		
	}
 
	private void heapify(int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
 
        if (l < n && array[l] > array[largest])
        {
        	largest = l;
        }            
 
        if (r < n && array[r] > array[largest])
        {
        	largest = r;
        }
           
        if (largest != i) 
        {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
 
            heapify(n, largest);
        }
    }
	
	@Override
	protected void Sort()
	{
		int n = array.length;
		 
        for (int i = n / 2 - 1; i >= 0; i--)
        {
        	heapify(n, i);
        }
           
 
        for (int i = n - 1; i > 0; i--) 
        {            
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
 
            heapify(i, 0);
        }
	}
}