import java.util.Vector;

public class Sort 
{
	private LineVector[] lines;
	LineVector[] res;
	private Vector<SortingType> sortingTypes;
	
	public Sort(LineVector[] _lines, Vector<SortingType> _sortingTypes)
	{
		lines = _lines;
		sortingTypes = _sortingTypes;
		
		res = new LineVector[36];
		
		for(int i = 0; i < lines.length; i++)
		{
			res[i] = new LineVector(i);
		}
	}	
	
	public void Write()
	{		
		for(LineVector l : res)
		{			
			if(!l.Get().isEmpty())
			{
				l.Write();
				System.out.println();
			}			
		}		
	}
	
	public void SortInput()
	{			
		for(LineVector bucket : lines) //1.: Dla ka�dego kube�ka...
		{
			//...O ilo�ci element�w > 1, r�wnie� je�eli ilo�� typ�w sortuj�cych = 0 lub 1 (bo wed�ug 0. pola s� posortowane w kube�kach)
			if(bucket.Get().size() < 2 || sortingTypes.size() == 0) continue; 			
			
			int kIndex = sortingTypes.size() - 1;
			
			while(!bucket.Get().isEmpty() && kIndex >= 0) //Dop�ki w kube�ku zosta�o cokolwiek do posortowania
			{								
				int k = sortingTypes.elementAt(kIndex).GetPoolIndex();
				boolean asc = sortingTypes.elementAt(kIndex).Asc();			
				
				QuickSort(k, bucket.Get(), asc);
				
				kIndex--;
			}
			
			Append(bucket.Index(), bucket.Get());
		}
		
		System.out.println("Finished sorting");
	}
	
	private void QuickSort(int k, Vector<Line> array, boolean sortType) //Sortowanie
	{
		if(sortType)
		{
			int n = array.size();
	        for (int i = 0; i < n-1; i++)
	        {
	        	for (int j = 0; j < n-i-1; j++)
	        	{
	        		if (array.elementAt(j).Code(k) > array.elementAt(j+1).Code(k))
	                {                   
	                    Line temp = array.elementAt(j);
	                    array.setElementAt(array.elementAt(j+1), j);
	                    array.setElementAt(temp, j + 1);
	                }
	        	}                
	        }    
		}
		else
		{
			int n = array.size();
	        for (int i = 0; i < n-1; i++)
	        {
	        	for (int j = 0; j < n-i-1; j++)
	        	{
	        		if (array.elementAt(j).Code(k) < array.elementAt(j+1).Code(k))
	                {                   
	                    Line temp = array.elementAt(j);
	                    array.setElementAt(array.elementAt(j+1), j);
	                    array.setElementAt(temp, j + 1);
	                }
	        	}                
	        }    
		}		        
	}
	
	private void Append(int index, Vector<Line> array) //Dodawanie do LineVector[] do odpowiedniego kube�ka, sortuj�c wed�ug sortIndex.
	{	
		res[index].Get().addAll(array);
		return;	
	}
}