import java.util.Arrays;

public class Main 
{
	private static DataCreator dataCreator;
	
	private static InsertSort insert;
	private static BubbleSort bubble;
	private static SelectSort select;
	private static HeapSort heap;
	private static MergeSort merge;
	private static QuickSort quick;
	
	private static int[] rising;
	private static int[] falling;
	private static int[] random;
	
	public static void main(String[] args) 
	{
		Init();
		RisingSort();
		FallingSort();
		RandomSort();
	}
	
	private static void Init()
	{				
		dataCreator = new DataCreator(10000);
		dataCreator.Init();
		
		rising = dataCreator.GetRisingArray();
		falling = dataCreator.GetFallingArray();
		random = dataCreator.GetRandomArray();		
	}
	
	private static void RisingSort()
	{
		System.out.println("Tablica rosn¹ca:");
		
		insert = new InsertSort(rising);
		bubble = new BubbleSort(rising);
		select = new SelectSort(rising);
		heap = new HeapSort(rising);
		merge = new MergeSort(rising);
		quick = new QuickSort(rising);
		
		insert.SortAndCalculateTime();
		bubble.SortAndCalculateTime();
		select.SortAndCalculateTime();
		heap.SortAndCalculateTime();
		merge.SortAndCalculateTime();
		quick.SortAndCalculateTime();
		
		System.out.println("--------------------------------------------");
	}
	
	private static void FallingSort()
	{
		System.out.println("Tablica malej¹ca:");
		
		int[] tab1 = Arrays.copyOf(falling, random.length);
		int[] tab2 = Arrays.copyOf(falling, random.length);
		int[] tab3 = Arrays.copyOf(falling, random.length);
		int[] tab4 = Arrays.copyOf(falling, random.length);
		int[] tab5 = Arrays.copyOf(falling, random.length);
		int[] tab6 = Arrays.copyOf(falling, random.length);
		
		insert = new InsertSort(tab1);
		bubble = new BubbleSort(tab2);
		select = new SelectSort(tab3);
		heap = new HeapSort(tab4);
		merge = new MergeSort(tab5);
		quick = new QuickSort(tab6);
		
		insert.SortAndCalculateTime();
		bubble.SortAndCalculateTime();
		select.SortAndCalculateTime();
		heap.SortAndCalculateTime();
		merge.SortAndCalculateTime();
		quick.SortAndCalculateTime();
		
		System.out.println("--------------------------------------------");
	}
	
	private static void RandomSort()
	{
		System.out.println("Tablica losowa:");
		
		int[] tab1 = Arrays.copyOf(random, random.length);
		int[] tab2 = Arrays.copyOf(random, random.length);
		int[] tab3 = Arrays.copyOf(random, random.length);
		int[] tab4 = Arrays.copyOf(random, random.length);
		int[] tab5 = Arrays.copyOf(random, random.length);
		int[] tab6 = Arrays.copyOf(random, random.length);
		
		insert = new InsertSort(tab1);
		bubble = new BubbleSort(tab2);
		select = new SelectSort(tab3);
		heap = new HeapSort(tab4);
		merge = new MergeSort(tab5);
		quick = new QuickSort(tab6);
		
		insert.SortAndCalculateTime();
		bubble.SortAndCalculateTime();
		select.SortAndCalculateTime();
		heap.SortAndCalculateTime();
		merge.SortAndCalculateTime();
		quick.SortAndCalculateTime();
		
		System.out.println("--------------------------------------------");
	}
}
