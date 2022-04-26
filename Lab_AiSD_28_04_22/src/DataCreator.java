import java.util.Random;

public class DataCreator
{
	private int[] randomArray;
	private int[] risingArray;
	private int[] fallingArray;
	
	private int size;
	
	public DataCreator(int _size)
	{
		randomArray = new int[_size];
		risingArray = new int[_size];
		fallingArray = new int[_size];
		
		size = _size;
	}
	
	public void Init()
	{
		Random random = new Random();
		
		for(int i = 0; i < size; i++)
		{
			int nextInt = random.nextInt(size);
			
			risingArray[i] = i;
			fallingArray[i] = (size - i - 1);
			randomArray[i] = nextInt;
		}
	}
	
	public int[] GetRandomArray()
	{
		return randomArray;
	}
	
	public int[] GetRisingArray()
	{
		return risingArray;
	}
	
	public int[] GetFallingArray()
	{
		return fallingArray;
	}
}
