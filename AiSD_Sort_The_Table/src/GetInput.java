import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class GetInput 
{	
	private LineVector[] lines;
	private Vector<SortingType> sortingTypes;
	private Vector<Pool> pools;
	
	public GetInput()
	{
		lines = new LineVector[36];
		
		for(int i = 0; i < lines.length; i++)
		{
			lines[i] = new LineVector(i);
		}
		
		sortingTypes = new Vector<SortingType>();
		pools = new Vector<Pool>();
	}
	
	private void ReadPools(String line)
	{
		String[] help = line.split(" ");
		
		for(int i = 0; i < help.length; i++)
		{
			pools.add(new Pool(help[i], i));
		}
	}
	
	private void ReadSortingTypes(String line)
	{
		String[] help = line.split(", ");
		
		for(int i = 0; i < help.length; i++)
		{
			String[] red = help[i].split(" ");
			int index = 0;
			boolean asc = false;
			
			while(!pools.get(index).GetPoolName().equals(red[0]))
			{				
				index++;
			}
			
			if(red[1].equals("ASC"))
			{
				asc = true;
			}
			
			sortingTypes.add(new SortingType(pools.get(index).GetPoolName(), pools.get(index).GetPoolIndex(), asc));
		}
	}
	
	private void ReadLine(String line)
	{	
		//Wstawiamy do odpowiednich kube³ków od razu przy czytaniu z klawiatury	wed³ug pierwszego pola sortuj¹cego.		
		int charNumber = 0;
		int index = 0;
		
		while(charNumber < sortingTypes.get(0).GetPoolIndex())
		{
			if(line.charAt(index) == ' ')
			{
				charNumber++;		
			}
			
			index++;
		}

		int modifier = 65;
		int upperModifier = 90;
		int c = new Line(line).GetValues().elementAt(charNumber).charAt(0);
		
		if(c < 65)
		{
			modifier = 48;
			upperModifier = 57 + 26;
		}
		
		int pos = (int) c - modifier; //Rosn¹ce 
		
		if(!sortingTypes.get(0).Asc()) //Malej¹ce
		{
			pos = (int) (upperModifier - c);
		}
		
 		lines[pos].Add(new Line(line));
	}
	
	public void GetInfo()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			String line = br.readLine();
			ReadPools(line);
			line = br.readLine();
			ReadSortingTypes(line);
			
			line = br.readLine();
			
			while(line.length() > 0)
			{
				ReadLine(line);
				line = br.readLine();
			}
			
			System.out.println("a");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public LineVector[] GetLines()
	{
		return lines;
	}
	
	public Vector<SortingType> GetSortingTypes()
	{
		return sortingTypes;
	}
	
	public Vector<Pool> GetPools()
	{
		return pools;
	}
}
