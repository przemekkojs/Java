import java.io.IOException;
import java.util.Vector;

public class Echo {
	
	public static ConsoleEx c = ConsoleEx.console();
	
	public static void main(String[] args)
	{			
		Pool pool = new Pool();
		GameManager manager = new GameManager();
		Player player = new Player();
		player.X = 1;
		player.Y = 1;
		
		int nOfEnemies = 20;
		
		try 
		{
			nOfEnemies = Integer.parseInt(c.readLine("How many enemies: "));
		} 
		catch (IOException e1) 
		{		
			System.out.print("Input error");
			e1.printStackTrace();
		}
		
		Vector<Enemy> enemies = new Vector<Enemy>();
		for(int i = 0; i < nOfEnemies; i++)
		{
			enemies.add(new Enemy());
		}		
		
		String[] scene;
		String move = "";
		
		int moves = 10;		
		int movePenalty = 0;
		
		scene = pool.LoadPool("C:\\Programming\\Eclipse\\Java\\KompilatorOgolny\\src\\pool.txt");	
		scene = pool.OverwriteAt(player.Body.charAt(0), player.X, player.Y, scene);
		manager.SpawnEnemies(enemies, scene);
		
		for(Enemy e : enemies)
		{
			e.Body = "%";
			scene = pool.OverwriteAt(e.Body.charAt(0), e.X, e.Y, scene);
		}
		
		pool.WritePool(scene);			
		
		while(!manager.PlayerInDanger('%', player, scene) && moves > 0)
		{
			try 
			{
				move = c.readLine();				
			} 
			catch (IOException e) 
			{
				System.out.println("Input error");
				e.printStackTrace();
			}
			
			scene = pool.OverwriteAt(' ', player.X, player.Y, scene);		
			
			if(move.length() > 0)
			{
				manager.Move(move.charAt(0), player, scene);
			}
						
			if(manager.Point('.', player, scene))
			{
				moves += 2;
				movePenalty = 0;
			}
			else
			{
				moves -= movePenalty;
				movePenalty++;
			}
			
			scene = pool.OverwriteAt(player.Body.charAt(0), player.X, player.Y, scene);	
			
			for(Enemy e : enemies)
			{
				scene = pool.OverwriteAt('.', e.X, e.Y, scene);
				manager.MoveEnemy(e, scene);
				scene = pool.OverwriteAt(e.Body.charAt(0), e.X, e.Y, scene);	
			}
			
			pool.WritePool(scene);
			System.out.println(String.format("Points: %d", moves));
		}
		
		System.out.print("GAME OVER!");
	}
}