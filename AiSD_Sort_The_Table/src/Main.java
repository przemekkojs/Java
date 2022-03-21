import java.time.Duration;
import java.time.Instant;

//https://codeforces.com/problemset/problem/64/I

public class Main 
{
	private static GetInput input;
	private static Sort sort;
	
	public static void main(String[] args) 
	{
		Init();	
		
		Instant a = Instant.now();
		sort.SortInput();
		sort.Write();
		Instant b = Instant.now();
		
		System.out.print(Duration.between(a, b).toString());
	}
	
	private static void Init()
	{
		input = new GetInput();		
		input.GetInfo();
		
		sort = new Sort(input.GetLines(), input.GetSortingTypes());
	}
}