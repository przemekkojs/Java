import java.util.Random;
import java.util.Vector;

public class Queue 
{
	private LRUProcessor lru;
	private InputManager input;
	private Process[] processes;
	private static Random random;
	
	private int size;
	private int[] global;	
	
	Strategy strategy;
	
	public Queue()
	{		
		random = new Random();
		
		input = new InputManager();
		size = input.size();		
	}
	
	public void initProcesses(Strategy _strategy)
	{
		strategy = _strategy;
		
		int[] processSizeTab = new int[input.processCount()];		
		int processSize = input.framesCount() / input.processCount();
				
		switch(strategy)
		{
		case EQUAL:						
			for(int i = 0; i < input.processCount(); i++)
			{
				processSizeTab[i] = processSize;
			}			
			break;
			
		case PROPORTIONAL:		
			
			System.out.println("Ilosc stron procesow: ");
			float modifier = (input.processCount() * 1.0f) / (input.framesCount() * 1.0f);
			int framesLeft = input.framesCount();
			
			if(modifier == 0) modifier = 1;
			
			for(int i = 0; i < input.processCount(); i++)
			{				
				int a = Math.round(processes[i].processSize() * modifier);
				processSizeTab[i] = a;							
				System.out.println("Proces " + i + ": " + processes[i].processSize());
				framesLeft -= a;
			}			
			
			int processIndex = 0;
			
			while(framesLeft >= 0)
			{
				processSizeTab[processIndex]++;
				processIndex++;
				
				if(processIndex >= input.processCount())
				{
					processIndex = 0;
				}
				
				framesLeft--;
			}
			
			break;	
			
		case ERROR_FREQUENCY:					
			for(int i = 0; i < input.processCount(); i++)
			{
				processSizeTab[i] = processSize;
			}
			break;
			
		default:			
			for(int i = 0; i < input.processCount(); i++)
			{
				processSizeTab[i] = processSize;
			}
			break;
		}
		
		for(int i = 0; i < processes.length; i++)
		{
			String processName = String.format("proces %d", i);
			processes[i] = new Process(processName, processSizeTab[i]);
		}			
	}
	
	public void initGlobalQueue()
	{	
		processes = new Process[input.processCount()];
		
		for(int i = 0; i < processes.length; i++)
		{
			String processName = String.format("proces %d", i);
			processes[i] = new Process(processName, random.nextInt(input.framesCount()));
		}	
		
		for(Process p : processes)
		{
			p.generateQueue(random.nextInt(input.pagesCount() - 1) + 1);	
			System.out.println(p.toString());
		}
		
		Vector<Integer> help = new Vector<Integer>();			
		
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
		switch(strategy)
		{
		case EQUAL:			
			System.out.println("Strategia: podzia³ równy");			
			break;
			
		case PROPORTIONAL:			
			System.out.println("Strategia: podzia³ proporcjonalny");			
			break;	
			
		case ERROR_FREQUENCY:		
			System.out.println("Strategia: zliczanie iloœci b³êdów");			
			break;
			
		default:
			System.out.println("Strategia: model strefowy");
			break;
		}
		
		int errorCount = 0;
		int processIndex = 0;
		
		for(int i = 0; i < global.length; i++)
		{
			int allocationIndex = 0;
			
			while(allocationIndex < processes[processIndex].processSize())
			{
				if(!processes[processIndex].memory().allocated(allocationIndex))
				{					
					break;
				}
				
				allocationIndex++;
			}
			
			if(allocationIndex >= processes[processIndex].processSize())
			{
				processes[processIndex].error();
				errorCount++;
				allocationIndex = LeastNeeded(i % (processIndex + 1), processIndex);
			}			
			else
			{
				processes[processIndex].memory().allocate(allocationIndex, global[i]);		
			}			
			
			processIndex++;			
			if(processIndex >= input.processCount()) 
			{
				processIndex = 0;
				
				if(strategy == Strategy.ERROR_FREQUENCY || strategy == Strategy.DISTRICTS)
				{
					int a = random.nextInt(input.processCount());
					int b = random.nextInt(input.processCount());
											
					processes[a].newMemory(processes[a].memory().size() + 1);
					processes[b].newMemory(processes[b].memory().size() - 1);
				}			
			}
		}
		
		int e = errorCount;
		if(strategy == Strategy.DISTRICTS) 
		{
			e = errorCount - input.processCount();		
		}
		
		System.out.println("Bledy lacznie: " + e);
		System.out.print("Bledy dla kazdego procesu: ");
		
		for(Process p : processes)
		{
			System.out.print((p.errorCount()) + "(" + p.processSize() + "), ");
		}
		
		System.out.println();
		System.out.println("------------------------------");
		System.out.println();
	}
	
	public int maxErrorCountIndex()
	{
		int res = 0;
		int curMax = 0;
		
		for(int i = 0; i < input.processCount(); i++)
		{
			if(processes[i].errorCount() > curMax)
			{
				curMax = processes[i].errorCount();
				res = i;
			}
		}
		
		return res;
	}
	
	public int minErrorCountIndex(int skip)
	{
		int res = 0;
		int curMin = processes[0].errorCount();
		
		for(int i = 1; i < input.processCount(); i++)
		{
			if(processes[i].errorCount() < curMin && i != skip)
			{
				curMin = processes[i].errorCount();
				res = i;
			}
		}
		
		return res;
	}
	
	public int LeastNeeded(int tabIndex, int processIndex)
	{
		int index = 0;
		int min = tabIndex;
		int res = 0;
		
		for(int check = 0; check < processes[processIndex].memory().size(); check++)
		{
			index = tabIndex;
			
			while(index >= 0)
			{
				if(processes[processIndex].memory().memory()[check].index() == global[index])
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
	
	public void processLRU() 
	{
		lru = new LRUProcessor(size, global);	
		lru.Process();
	}	
}