import java.util.Random;

public class Main 
{
	private static Player player;
	private static String[] scene;
	private static String row;
	
	public static int sceneSize = 10;
	
	public static void main(String[] args) 
	{
		player = new Player();
		scene = new String[sceneSize];
		
		CreateScene();
		SpawnPlayer();
		UpdateScene();
		WriteScene();
		
		player.Move('w');	
		UpdateScene();
		WriteScene();
		
		player.Move('d');	
		UpdateScene();
		WriteScene();
	}
	
	//Done
	private static void CreateScene()
	{
		scene[0] = "";
		scene[sceneSize - 1] = "";
		
		for(int index = 0; index < sceneSize; index++)
		{
			scene[0] += "X";
			scene[sceneSize - 1] += "X";
		}
		
		for(int y = 1; y < sceneSize - 1; y++)
		{
			scene[y] = "X";
			
			for(int x = 1; x < sceneSize - 1; x++)
			{
				scene[y] += " ";
			}
			
			scene[y] += "X";
		}
		
		row = scene[1];
	}
	
	private static void UpdateScene()
	{
		for(int y = 1; y < sceneSize - 1; y++)
		{
			scene[y] = row;
			
			for(BodyCell b : player.body)
			{
				if(b.Y == y)
				{
					scene[y] = "X";
					
					for(int x = 1; x < sceneSize - 1; x++)
					{
						if(x != b.X)
						{
							scene[y] += " ";
						}
						else
						{
							scene[y] += "O";
						}
					}
					
					scene[y] += "X";
				}
			}
		}
	}
	
	private static void WriteScene()
	{
		System.out.println(player.X);
		System.out.println(player.Y);
		
		for(String s : scene)
		{
			System.out.println(s);
		}
	}
	
	private static void SpawnPlayer()
	{
		Random random = new Random();
		player.Y = random.nextInt(sceneSize - 1) + 1;
		player.X = random.nextInt(sceneSize - 1) + 1;
		
		System.out.println("Player spawned at: " + player.X + " " + player.Y);
	}
}