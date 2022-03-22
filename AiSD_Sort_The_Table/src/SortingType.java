
public class SortingType 
{
	private boolean asc;
	private String poolName;
	private int poolIndex;
	
	public SortingType(String _poolName, int _poolIndex, boolean _asc)
	{
		asc = _asc;
		poolName = _poolName;
		poolIndex = _poolIndex;
	}
	
	public boolean Asc()
	{
		return asc;
	}
	
	public String GetPoolName()
	{
		return poolName;
	}
	
	public int GetPoolIndex()
	{
		return poolIndex;
	}
}