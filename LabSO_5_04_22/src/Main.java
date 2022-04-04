
public class Main 
{
	private static FIFOProcessor fifo;
	private static RANDProcessor rand;
	private static OPTProcessor opt;
	private static LRUProcessor lru;
	private static ApproximatedLRUProcessor approx;
	
	private static InputManager input;
	
	public static void main(String[] args) 
	{
		Init();
		
		fifo.Process();
		rand.Process();
		opt.Process();
		lru.Process();
		approx.Process();
	}

	private static void Init()
	{
		input = new InputManager();
		
		input.GetInput();
		
		fifo = new FIFOProcessor(input.FramesCount(), input.Pages());
		rand = new RANDProcessor(input.FramesCount(), input.Pages());
		opt = new OPTProcessor(input.FramesCount(), input.Pages());
		lru = new LRUProcessor(input.FramesCount(), input.Pages());
		approx = new ApproximatedLRUProcessor(input.FramesCount(), input.Pages());
	}
}
