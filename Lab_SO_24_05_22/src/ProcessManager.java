import java.util.Random;
import java.util.Vector;

public class ProcessManager 
{
	private Queue queue;
	private Processors processors;
	
	private int queueSize;
	private int processorsSize;
	private int migrationCount;
	private int callsCount;
	
	private Random random;
	
	public ProcessManager(int _queueSize, int _processorsSize)
	{
		System.out.println("Symulacja");
		System.out.println("Ilo�� procesor�w: " + _processorsSize);
		System.out.println("Ilo�� chwil: " + _queueSize);		
		System.out.println("Pytane procesory: " + Constants.ASKED_PROCESSORS);
		System.out.println("G�rny limit (p, symulacja 1, 2): " + Constants.LIMIT);
		System.out.println("Dolny limit (r, symulacja 3): " + Constants.LOWER_LIMIT);
		System.out.println("Przejmowane zadania (symulacja 3): " + Constants.RECLAIMED_TASKS);
		System.out.println();
		
		queueSize = _queueSize;
		processorsSize = _processorsSize;
		migrationCount = 0;
		callsCount = 0;
		
		queue = new Queue(_queueSize);
		processors = new Processors(_processorsSize);
		random = new Random();
	}
	
	public void strategy1()
	{
		System.out.println("----------------------------");
		System.out.println("Strategia 1");
		
		for(int i = 0; i < queue.size(); i++)
		{
			Vector<Process> queueAtTime = queue.queue().elementAt(i);		
			
			xLoop:
			for(Process process : queueAtTime)
			{
				Processor x = processors.processors().elementAt(process.processor());
				Processor y = processors.processors().elementAt(random.nextInt(Constants.PROCESSSORS_COUNT));		
				callsCount++;
				
				int ask = 0;
				while(ask < Constants.ASKED_PROCESSORS && y.usage() > Constants.LIMIT)
				{
					y = processors.processors().elementAt(random.nextInt(Constants.PROCESSSORS_COUNT));		
					callsCount++;
					ask++;
				}
				
				if(ask < Constants.ASKED_PROCESSORS)
				{
					y.attachProcess(process);							
					continue xLoop;
				}
				
				x.attachProcess(process);
			}
		}
		
		output();
	}
	
	public void strategy2()
	{
		System.out.println("----------------------------");
		System.out.println("Strategia 2");
		
		for(int i = 0; i < queue.size(); i++)
		{
			Vector<Process> queueAtTime = queue.queue().elementAt(i);		
			
			for(Process process : queueAtTime)
			{
				Processor x = processors.processors().elementAt(process.processor());					
				callsCount++;
				
				if(x.usage() > Constants.LIMIT)
				{
					Processor y = processors.processors().elementAt(random.nextInt(Constants.PROCESSSORS_COUNT));						
					callsCount++;
					
					while(y.usage() > Constants.LIMIT && y.usage() > x.usage())
					{
						y = processors.processors().elementAt(random.nextInt(Constants.PROCESSSORS_COUNT));
						callsCount++;						
					}
					
					y.attachProcess(process);
					continue;
				}
				
				x.attachProcess(process);
			}
		}
		
		output();
	}
	
	public void strategy3()
	{
		System.out.println("----------------------------");
		System.out.println("Strategia 3");
		
		for(int i = 0; i < queue.size(); i++)
		{
			Vector<Process> queueAtTime = queue.queue().elementAt(i);		
			
			yLoop:
			for(Process process : queueAtTime)
			{
				Processor x = processors.processors().elementAt(process.processor());				
				callsCount++;
				
				if(x.usage() < Constants.LOWER_LIMIT)
				{
					Processor y = processors.processors().elementAt(random.nextInt(Constants.PROCESSSORS_COUNT));					
					callsCount++;
					
					while(y.usage() < x.usage())
					{
						y = processors.processors().elementAt(random.nextInt(Constants.PROCESSSORS_COUNT));
						callsCount++;						
					}
					
					int j = 0;
					
					migrationCount++;			
					while(j < Constants.RECLAIMED_TASKS && y.migrateProcess(x))
					{
						migrationCount++;						
						j++;
					}
					
					y.attachProcess(process);	
					
					continue yLoop;
				}
				
				x.attachProcess(process);
			}
		}
		
		output();
	}
	
	public int queueSize()
	{
		return queueSize;
	}
	
	public int processorsSize()
	{
		return processorsSize;
	}
	
	private double averageUsage()
	{
		double res = 0;
		int count = 0;
		Vector<Processor> vector = processors.processors();
		
		for(Processor p : vector)
		{
			if(p.usage() > 0)
			{
				res += p.usage();
				count++;
			}			
		}
		
		res /= (count * 1.0d);
		
		return res;
	}
	
	private double averageSlip()
	{
		double avg = averageUsage();
		double res = 0;
		int count = 0;
		Vector<Processor> vector = processors.processors();
		
		for(Processor p : vector)
		{
			if(p.usage() != 0)
			{
				res += Math.abs(avg - p.usage());
				count++;
			}			
		}
		
		res /= (count * 1.0d);
		
		return res;
	}
	
	private void output()
	{
		System.out.printf("�rednie zu�ycie procesor�w: %.2f%n", averageUsage());
		System.out.printf("�rednie odchylenie: %.2f%n", averageSlip());
		System.out.println("Ilosc zapytan: " + callsCount);
		System.out.println("Ilosc migracji: " + migrationCount);
		//printProcessors();
		processors.reset();
		System.out.println();
		
		migrationCount = 0;
		callsCount = 0;
	}
	
	@SuppressWarnings("unused")
	private void printProcessors()
	{
		System.out.println(" -> Procesory: ");
		
		for(Processor p : processors.processors())
		{
			System.out.println("	-> " + p.toString());
		}
		
		System.out.println();
	}
}
