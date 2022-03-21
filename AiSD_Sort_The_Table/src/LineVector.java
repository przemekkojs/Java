import java.util.Vector;

public class LineVector 
{
	private Vector<Line> content;
	private int index;
	
	public LineVector(int _index)
	{
		content = new Vector<Line>();
		index = _index;
	}
	
	public void Add(Line e)
	{
		content.add(e);
	}
	
	public Vector<Line> Get()
	{
		return content;
	}
	
	public void Set(Vector<Line> _content)
	{
		content = _content;
	}
	
	public int Index()
	{
		return index;
	}
	
	public void Write()
	{
		for(Line l : content)
		{
			System.out.printf("%s ", l.toString());
		}
	}
}
