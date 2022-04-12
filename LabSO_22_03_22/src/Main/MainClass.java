package Main;

import java.util.Random;
import java.util.Vector;

import Application.Application;
import C_SCAN.CLOOKProcessor;
import EDF.EDFProcessor;
import FCFS.FCFSProcessor;
import SCAN.SCANProcessor;
import SSTF.SSTFProcessor;

public class MainClass 
{
	private static FCFSProcessor fcfs;
	private static SCANProcessor scan;
	private static CLOOKProcessor clook;
	private static SSTFProcessor sstf;
	private static EDFProcessor edf;
	
	private static Vector<Application> applicationTab;
	
	private static final int DISC_SIZE = 100;
	private static final int MAX_ARRIVAL_TIME = 100;
	private static final int PROCESS_COUNT = 100;
	
	public static void main(String[] args) 
	{
		Init();
		
		fcfs.Serve();
		scan.Serve();
		clook.Serve();
		sstf.Serve();
		edf.Serve();
	}
	
	private static void Init()
	{
		applicationTab = new Vector<Application>();
		
		applicationTab.add(new Application(0, 8, 0, 1));
		applicationTab.add(new Application(0, 1, 1, 3));
		applicationTab.add(new Application(0, 3, 0, 4));
		applicationTab.add(new Application(0, 4, 0, 3));
		applicationTab.add(new Application(0, 7, 1, 5));
		applicationTab.add(new Application(0, 6, 0, 4));
		applicationTab.add(new Application(0, 5, 0, 5));
		applicationTab.add(new Application(0, 9, 1, 6));
		applicationTab.add(new Application(0, 2, 0, 7));
		applicationTab.add(new Application(0, 0, 0, 4));
		
		fcfs = new FCFSProcessor(applicationTab);
		scan = new SCANProcessor(applicationTab);
		clook = new CLOOKProcessor(applicationTab);
		sstf = new SSTFProcessor(applicationTab);
		edf = new EDFProcessor(applicationTab);
	}
	
	private static void InitRandomTab()
	{
		applicationTab = new Vector<Application>();
		
		Random random = new Random();
		
		for(int i = 0; i < PROCESS_COUNT; i++)
		{
			applicationTab.add(new Application(random.nextInt(MAX_ARRIVAL_TIME), random.nextInt(DISC_SIZE), random.nextInt(2), 10));
		}
		
		fcfs = new FCFSProcessor(applicationTab);
		scan = new SCANProcessor(applicationTab);
		clook = new CLOOKProcessor(applicationTab);
		sstf = new SSTFProcessor(applicationTab);
		edf = new EDFProcessor(applicationTab);
	}
	
	private static void InitRandomValues()
	{
		fcfs = new FCFSProcessor(PROCESS_COUNT, DISC_SIZE, MAX_ARRIVAL_TIME);
		scan = new SCANProcessor(PROCESS_COUNT, DISC_SIZE, MAX_ARRIVAL_TIME);
		clook = new CLOOKProcessor(PROCESS_COUNT, DISC_SIZE, MAX_ARRIVAL_TIME);
		sstf = new SSTFProcessor(PROCESS_COUNT, DISC_SIZE, MAX_ARRIVAL_TIME);
		edf = new EDFProcessor(PROCESS_COUNT, DISC_SIZE, MAX_ARRIVAL_TIME);
	}
}
