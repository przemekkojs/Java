public class Main 
{
	private static ShellSort sort1;
	private static IBShell sort2;
	private static BIShell sort3;
	
	private static Integer[] elems;
	private static Integer[] distances;
	
	public static void main(String[] args) 
	{
		Test(5000);
		Test(10000);
		Test(50000);
		Test(100000);
	}
	
	private static void Init(int count)
	{
		elems = ArrayCreator.RandomArray(count);
				
		sort1 = new ShellSort(ArrayCreator.CopyArray(elems));
		sort2 = new IBShell(ArrayCreator.CopyArray(elems));
		sort3 = new BIShell(ArrayCreator.CopyArray(elems));
	}
	
	private static void Test(int count)
	{
		Init(count);
		
		distances = ArrayCreator.LessonArray(count);		
		MeasureSort(sort1, ArrayCreator.CopyArray(distances));
		MeasureSort(sort2, ArrayCreator.CopyArray(distances));
		MeasureSort(sort3, ArrayCreator.CopyArray(distances));
		
		System.out.println("-----------------------");
		System.out.println();
	}
	
	private static void MeasureSort(AbstractSort sort, int[] _distances)
	{
		long start = System.nanoTime();
		
		sort.Sort(_distances);
		
		long end = System.nanoTime();
		
		System.out.printf("%s: %.2f ms dla %d elementów%n", sort.toString(), (end - start) / 1000000d, sort.array.length);
	}
}