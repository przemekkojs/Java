
public class Pool 
{
	private int poolIndex;
	private String poolName;
	
	public Pool(String _poolName, int _poolIndex)
	{
		poolIndex = _poolIndex;
		poolName = _poolName;
	}
	
	public int GetPoolIndex()
	{
		return poolIndex;
	}
	
	public String GetPoolName()
	{
		return poolName;
	}
}