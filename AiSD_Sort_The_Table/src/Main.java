//https://codeforces.com/problemset/problem/64/I

public class Main 
{
	private static GetInput input;
	private static Sort sort;
	
	public static void main(String[] args) 
	{
		Init();	
		sort.SortInput();
		sort.Write();
	}
	
	private static void Init()
	{
		input = new GetInput();		
		input.GetInfo();
		
		sort = new Sort(input.GetLines(), input.GetSortingTypes());
	}
}