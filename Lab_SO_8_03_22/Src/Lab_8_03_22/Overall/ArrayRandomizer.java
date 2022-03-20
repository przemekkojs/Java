package Lab_8_03_22.Overall;
import java.util.Random;

public class ArrayRandomizer 
{
	public static int[] RandomizeArray(int[] array)
	{		
        Random random = new Random();
        
        for (int i = array.length - 1; i > 0; i--) 
        {          
            int j = random.nextInt(i+1);
           
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }    
        
        return array;
	}
}
