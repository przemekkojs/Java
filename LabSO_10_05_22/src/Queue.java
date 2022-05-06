import java.util.Random;
import java.util.Vector;

public class Queue 
{
	private LRUProcessor lru;
	private Memory memory;
	private InputManager input;
	private Process[] processes;
	
	private int size;
	private int[] global;
	
	public Queue()
	{
		input = new InputManager();
		size = input.size();		
		
		initProcesses();
		initGlobalQueue();				
	}
	
	private void initProcesses()
	{
		processes = new Process[input.processCount()];
		
		for(int i = 0; i < processes.length; i++)
		{
			processes[i] = new Process(String.format("proces %d", i));
		}
	}
	
	private void initGlobalQueue()
	{
		Random random = new Random();
		
		Vector<Integer> help = new Vector<Integer>();		
		
		for(Process p : processes)
		{
			p.generateQueue(random.nextInt(input.pagesCount() - 1) + 1);			
			System.out.printf("%s%n", p.toString());			
		}
		
		for(int i = 0; i < input.pagesCount(); i++)
		{
			for(int j = 0; j < input.processCount(); j++)
			{				
				if(i < processes[j].queue().length) help.add(processes[j].queue()[i]);									
			}
		}
		
		global = ArrayManager.IntegerToInt(help.toArray(new Integer[help.size()]));
		size = global.length;
		
		System.out.println("Odwolania globalne (" + size + "): ");
		ArrayManager.printArray(global);
	}
	
	public void process()
	{
		lru = new LRUProcessor(size, global);	
		lru.Process();
		memory = lru.memory();
		memory.clear();
		
		//Teoretycznie spelniaja to sama role, ale chodzi o czytelnosc
		int allocatedCount = 0;
		int freeIndex = 0;
		
		int tabIndex = 0;
		
		for(int i = 0; i < input.processCount(); i++)
		{
			int[] currentlyAllocated = new int[input.processCount()];
			
			for(int j = 0; j < processes.length; j++)
			{
				if(i < processes[j].queue().length)
				{
					int page = processes[j].queue()[i];
					
					//Jezeli strona jest w pamieci, to nie trzeba alokowac
					if(ArrayManager.Contains(page, currentlyAllocated))
					{
						processes[j].error();
					}
					else //W przeciwnym razie
					{
						if(allocatedCount < input.framesCount()) //Jak dla lru
						{
							//Alokujemy na wolnym miejscu							
							memory.memory()[freeIndex].changePage(new Page(page));
							
							processes[j].error();
							freeIndex++;
							allocatedCount++;
						}
						else
						{
							processes[j].error();
							int allocationIndex = LeastNeeded(tabIndex);
							memory.memory()[allocationIndex].changePage(new Page(page));
						}					
					}					
					
					currentlyAllocated[j] = processes[j].queue()[i];
					tabIndex++;
				}			
			}
		}		
		
		//Wypisanie ilosci bledow kazdego procesu		
		int count = 0;
		
		System.out.print("Bledy dla ka¿dego procesu: ");
		
		for(Process p : processes)
		{
			System.out.print(p.errorCount() + " ");
			count += p.errorCount();
		}
		
		System.out.println();
		System.out.println("Laczna iloœæ b³êdów: " + count);
	}
	
	private int LeastNeeded(int tabIndex)
	{
		int index = 0;
		int min = tabIndex;
		int res = 0;
		
		for(int check = 0; check < memory.size(); check++)
		{
			index = tabIndex;
			
			while(index >= 0)
			{
				if(memory.memory()[check].index() == global[index])
				{
					break;
				}
				
				index--;
			}
			
			if(index < min)
			{
				min = index;
				res = check;
			}
		}
		
		return res;
	}
}