
public abstract class AbstractSort 
{
	protected int[] array;
	protected String name;
	
	public AbstractSort(int[] _arr)
	{
		array = _arr;
	}
	
	public abstract void Sort(int[] distances);
	
	@Override
	public String toString()
	{
		return name;
	}
}
