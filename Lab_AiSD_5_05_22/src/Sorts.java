
public class Sorts 
{
	public static void InsertSort(int[] array) 
	{
        for (int i = 1, j, temp; i < array.length; ++i) 
        {
            int value = array[i];
            
            for (j = i; j > 0 && value < (temp = array[j - 1]); --j) 
            {
                array[j] = temp;
            }
            
            array[j] = value;
        }
    }
	
	public static void BubbleSort(int[] tabl)
	{
        int size = tabl.length;
        
        for (int i = 0; i < size - 1; i++) 
        {
            for (int j = 0; j < size - i - 1; j++) 
            {
                if (tabl[j] > tabl[j + 1])
                	Swap(tabl, j + 1, j);
            }
        }
    }
	
	public static void Swap(int[] tabl, int left, int right) 
	{
        int temp = tabl[left];
        tabl[left] = tabl[right];
        tabl[right] = temp;
    }
}