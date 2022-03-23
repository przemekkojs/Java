package Lab_8_03_22.Overall;

import Lab_8_03_22.FCFS.FcfsProcessor;
import Lab_8_03_22.PreemptiveSJF.PreemptiveSjfProcessor;
import Lab_8_03_22.RR.RRProcessor;
import Lab_8_03_22.SJF.SjfProcessor;

public class Main 
{
	private static Queue queue = new Queue();
	private static FcfsProcessor FCFS;
	private static SjfProcessor SJF;
	private static PreemptiveSjfProcessor pSJF;
	private static RRProcessor RR;
	
	public static void main(String[] args) 
	{		
		/*queue.Init(new Process[] {new Process("P1", 2, 6), 
				new Process("P2", 5, 2), 
				new Process("P3", 1, 8), 
				new Process("P4", 0, 3), 
				new Process("P5", 4, 4)});*/
		
		queue.Init(20);
		
		/*queue.Init(new Process[] {new Process("P1", 0, 4), 
		new Process("P2", 0, 3), 
		new Process("P3", 0, 5)});*/
		
		queue.WriteQueue();
				
		FCFS = new FcfsProcessor(queue);
		SJF = new SjfProcessor(queue);
		pSJF = new PreemptiveSjfProcessor(queue);
		RR = new RRProcessor(queue);
		
		FCFS.Process();
		SJF.Process();
		pSJF.Process();
		
		RR.SetQuantumTime(5);
		RR.Process();
	}
}