
public class PageArray 
{
	private int[] frameNumbers;
	private Page[] pages;
	
	public PageArray(int _pageCount)
	{
		frameNumbers = new int[_pageCount];
		pages = new Page[_pageCount];
		
		for(int i = 0; i < _pageCount; i++)
		{
			pages[i] = new Page(_pageCount);
		}
	}
	
	public int[] FrameNumbers()
	{
		return frameNumbers;
	}
	
	public void Set(int pageIndex, int frameIndex)
	{
		frameNumbers[pageIndex] = frameIndex;
	}
	
	public Page[] Pages()
	{
		return pages;
	}	
}
