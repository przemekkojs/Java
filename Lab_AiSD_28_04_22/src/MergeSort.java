
public class MergeSort extends AbstractSort 
{	
	public MergeSort(int[] _array) 
	{
		super(_array, "MergeSort");		
	}

	void merge(int l, int m, int r)
    {        
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int i = 0, j = 0, k = l;        
        
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        for (i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (j = 0; j < n2; ++j)
            R[j] = array[m + 1 + j];
  
        
        i = 0;
        j = 0;
        
        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) 
            {
            	array[k] = L[i];
                i++;
            }
            else 
            {
            	array[k] = R[j];
                j++;
            }
            
            k++;
        }
  
        while (i < n1) 
        {
        	array[k] = L[i];
            i++;
            k++;
        }
  
        while (j < n2) 
        {
            array[k] = R[j];
            j++;
            k++;
        }
    }
  
    void sort(int l, int r)
    {
        if (l < r) 
        {            
            int m = l + (r-l)/2;
  
            sort(l, m);
            sort(m + 1, r);
  
            merge(l, m, r);
        }
    }
	
	@Override
	protected void Sort()
	{
		sort(0, array.length - 1);
	}
}