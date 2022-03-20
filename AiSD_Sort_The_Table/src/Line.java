import java.util.Vector;

public class Line 
{
	private String content;
	private Vector<String> line;
	
	public Line(String _line)
	{
		content = _line;
		line = Convert(_line);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s |", content);
	}
	
	public Vector<String> GetValues()
	{
		return line;
	}
	
	public long Code(int pool)
	{
		long res = 0;
		String toCode = line.elementAt(pool);
		
		for(int i = toCode.length() - 1; i >= 0; i--)
		{
			res += (toCode.charAt(i) - 48) * (Math.pow(10, i));
		}
		
		return res;
	}

	private Vector<String> Convert(String _line)
	{
		Vector<String> res = new Vector<String>();
		String[] help = _line.split(" ");
		
		for(String s : help)
		{
			res.add(s);
		}
		
		return res;
	}	
}
