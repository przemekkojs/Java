
public abstract class AbstractSort 
{
	protected int[] array;
	protected String name;
	
	public AbstractSort(int[] _array, String _name)
	{
		array = _array;
		name = _name;
	}
	
	public void SortAndCalculateTime()
	{
		long start = System.nanoTime();
		
		Sort();
		
		long finish = System.nanoTime();
		
		System.out.printf("%s, czas: %.3f ms%n", name, (double)((finish - start) / 1000000d));
	}
	
	protected abstract void Sort();
}