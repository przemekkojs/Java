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
			
			while(!bucket.Get().isEmpty()) //Dop�ki w kube�ku zosta�o cokolwiek do posortowania
			{
				int kIndex = 1;
				int k = sortingTypes.elementAt(kIndex).GetPoolIndex();
				boolean asc = sortingTypes.elementAt(kIndex).Asc();				
				Vector<Line> help = new Vector<Line>(); //2.: Lista pomocnicza			
				
				help.add(bucket.Get().elementAt(0)); //Dodajemy pierwszy element z kube�ka do listy pomocniczej - b�dzie to nasz wz�r.
				bucket.Get().remove(0); //A z g��wnego kube�ka usuwamy ten element (�eby nie doda� 2 razy tego samego).
				
				for(int curLine = 0; curLine < bucket.Get().size(); curLine++) //Do listy dodajemy wszystkie elementy z takimi samymi danymi jak wz�r na polu k.
				{
					if(bucket.Get().elementAt(curLine).GetValues().elementAt(kIndex).equals(help.elementAt(0).GetValues().elementAt(kIndex)))
					{
						help.add((bucket.Get().elementAt(curLine)));
						bucket.Get().remove(curLine);
						curLine--;
					}
				}		
				
				kIndex++;
				
				//Je�eli nie ma min. 2 element�w, to znaczy �e nie ma czego sortowa�, a jezeli s�, to...
				while(help.size() > 1 && kIndex < sortingTypes.size())
				{			
					k = sortingTypes.elementAt(kIndex).GetPoolIndex();
					asc = sortingTypes.elementAt(kIndex).Asc();
					
					QuickSort(k, help, asc);
					
					Vector<Line> help2 = new Vector<Line>();
					help2.add(help.elementAt(0)); //Dodajemy pierwszy element z kube�ka do listy pomocniczej - b�dzie to nasz wz�r.
					help.remove(0); //A z g��wnego kube�ka usuwamy ten element (�eby nie doda� 2 razy tego samego).
					
					for(int curLine = 0; curLine < help.size(); curLine++)
					{
						if(help.elementAt(curLine).GetValues().elementAt(sortingTypes.elementAt(kIndex - 1).GetPoolIndex()).equals(help2.elementAt(0).GetValues().elementAt(sortingTypes.elementAt(kIndex - 1).GetPoolIndex())))
						{
							help2.add((help.elementAt(curLine)));
							help.remove(curLine);
							curLine--;
						}
					}	
					
					int i = kIndex;
					int modifier = 1;
					
					int differentIndex = 1;					
					while(differentIndex < help2.size() && help2.elementAt(0).equals(help2.elementAt(differentIndex)))
					{
						differentIndex++;
					}
					
					while(i < sortingTypes.size() && help2.size() > 1)
					{		
						int sortIndex = sortingTypes.elementAt(i).GetPoolIndex();						
						
						if(!help2.elementAt(0).GetValues().elementAt(sortIndex).equals(help2.elementAt(differentIndex).GetValues().elementAt(sortIndex)))
						{
							modifier = 0;
							break;							
						}
						
						i++;						
					}					
					
					QuickSort(sortingTypes.elementAt(i - modifier).GetPoolIndex(), help2, sortingTypes.elementAt(i - modifier).Asc());
					
					//Dodajemy do odpowiedniego kube�ka w "res" wszystkie elementy, kt�re zosta�y posortowane.
					Append(bucket.Index(), help2);					
				}				
				
				QuickSort(sortingTypes.elementAt(kIndex - 1).GetPoolIndex(), help, sortingTypes.elementAt(kIndex - 1).Asc());
				
				Append(bucket.Index(), help);
				
				kIndex = 1;
			}			
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
		if(array.isEmpty()) return; //Je�eli pr�bujemy doda� nic, to nie ma to sensu.
		
		if(res[index].Get().isEmpty()) //Je�eli dodajemy do pustego kube�ka, to po prostu wystarczy doda�
		{
			res[index].Get().addAll(array);
			return;
		}
		
		//Je�eli w kube�ku ju� co� jest:		
		int addIndex = 0;
		int sortIndex = sortingTypes.elementAt(1).GetPoolIndex();
		
		if(sortingTypes.elementAt(1).Asc())
		{
			Line modelElem = array.firstElement();
			
			while(addIndex < res[index].Get().size() && res[index].Get().elementAt(addIndex).Code(sortIndex) < modelElem.Code(sortIndex))
			{
				addIndex++;
			}
		}	
		else
		{
			Line modelElem = array.lastElement();
			
			while(addIndex < res[index].Get().size() && res[index].Get().elementAt(addIndex).Code(sortIndex) > modelElem.Code(sortIndex))
			{
				addIndex++;
			}
		}
		
		res[index].Get().addAll(addIndex, array); //A nast�pnie wstawiamy posortowan� cz�stk� do wyj�ciowego kube�ka tak, jak powinno by�
	}
}