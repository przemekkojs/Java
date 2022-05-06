
public class Frame 
{
	private Page usedPage;
	private int index;
	
	public Frame(int _index)
	{
		index = _index;
	}
	
	public void changePage(Page p)
	{
		usedPage = p;
		index = p.index();
	}
	
	public void Deallocate()
	{
		usedPage = null;
		index = -1;
	}
	
	public Page page()
	{
		return usedPage;
	}
	
	public boolean allocated()
	{
		return (index == -1);
	}
	
	public int index()
	{
		return index;
	}
}
