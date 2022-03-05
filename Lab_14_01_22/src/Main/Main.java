package Main;

import java.util.Random;

import Managers.GameManager;
import Managers.SceneManager;
import Objects.BigEnemy;
import Objects.Entity;
import Objects.MediumEnemy;
import Objects.Player;
import Objects.Point;
import Objects.SmallEnemy;

public class Main 
{
	private static Player player;
	private static SmallEnemy small;
	private static MediumEnemy medium;
	private static BigEnemy big;

	private static Point point;	
	
	private static GameManager gameManager;
	private static SceneManager sceneManager;
	
	private static Entity[] help;
	
	private static Random random = new Random();
	
	public static void main(String[] args) 
	{
		InitializeObjects();
		
		while(small.Active() || medium.Active() || big.Active())
		{			
			gameManager.Turn();
			gameManager.NotifyAll();
			gameManager.MovePoint();			
			sceneManager.WriteStage(help);
		}
		
		System.out.println("Wyniki:");
		System.out.printf("B: %d%n", big.GetPoints());
		System.out.printf("M: %d%n", medium.GetPoints());
		System.out.printf("S: %d%n", small.GetPoints());
		System.out.printf("P: %d%n", player.GetPoints());		
	}
	
	private static void InitializeObjects()
	{		
		player = new Player(random.nextInt(1, 9), random.nextInt(1, 9));
		small = new SmallEnemy(random.nextInt(1, 9), random.nextInt(1, 9));
		medium = new MediumEnemy(random.nextInt(1, 9), random.nextInt(1, 9));
		big = new BigEnemy(random.nextInt(1, 9), random.nextInt(1, 9));
		
		point = new Point(random.nextInt(1, 9), random.nextInt(1, 9));		
		
		gameManager = new GameManager();
		sceneManager = new SceneManager(point);
		
		gameManager.Attach(player);		
		gameManager.Attach(small);		
		gameManager.Attach(medium);		
		gameManager.Attach(big);
		
		help = new Entity[] {player, small, medium, big};
	}
}
