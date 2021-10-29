import java.util.Random;
import java.util.Vector;

public class GameManager 
{
	public void Move(char move, Player player, String[] pool)
	{
		switch(move)
		{
		case 'w':
			if(pool[player.Y - 1].charAt(player.X) != 'X')
			{
				player.Y--;
			}			
			break;
		case 's':
			if(pool[player.Y + 1].charAt(player.X) != 'X')
			{
				player.Y++;
			}		
			break;
		case 'd':
			if(pool[player.Y].charAt(player.X + 1) != 'X')
			{
				player.X++;
			}		
			break;
		case 'a':
			if(pool[player.Y].charAt(player.X - 1) != 'X')
			{
				player.X--;
			}		
			break;		
		default:			
			break;
		}	
	}	

	public void MoveEnemy(Enemy enemy, String[] pool)
	{
		if(pool[enemy.Y + 1].charAt(enemy.X) == 'P')
		{
			enemy.Y++;
		}
		else if(pool[enemy.Y - 1].charAt(enemy.X) == 'P')
		{
			enemy.Y--;
		}
		else if(pool[enemy.Y].charAt(enemy.X + 1) == 'P')
		{
			enemy.X++;
		}
		else if(pool[enemy.Y].charAt(enemy.X - 1) == 'P')
		{
			enemy.X--;
		}
		else
		{
			Random rand = new Random();
			
			int move = rand.nextInt(2);
			int moveValue = rand.nextInt(2);

			if(moveValue == 0)
			{
				moveValue = -1;
			}
			
			switch(move)
			{
			case 0:
				if(pool[enemy.Y + moveValue].charAt(enemy.X) != 'X')
				{				
					enemy.Y += moveValue;
				}
				else 
				{
					if(pool[enemy.Y].charAt(enemy.X + 1) != 'X')
					{
						enemy.X++;
					}
					else if(pool[enemy.Y].charAt(enemy.X - 1) != 'X')
					{
						enemy.X--;
					}
				}
				break;
			case 1:
				if(pool[enemy.Y].charAt(enemy.X + moveValue) != 'X')
				{				
					enemy.X += moveValue;
				}
				else 
				{
					if(pool[enemy.Y + 1].charAt(enemy.X) != 'X')
					{
						enemy.Y++;
					}
					else if(pool[enemy.Y - 1].charAt(enemy.X) != 'X')
					{
						enemy.Y--;
					}
				}
				break;
			}		
		}				
	}
	
	public void SpawnEnemies(Vector<Enemy> enemies, String[] pool)
	{
		Random rand = new Random();
		
		for(Enemy e : enemies)
		{
			int X = rand.nextInt(pool[0].length() - 2) + 1;
			int Y = rand.nextInt(pool.length - 2) + 1;
			
			while(pool[Y].charAt(X) == 'X' || pool[Y].charAt(X) == 'P' || pool[Y].charAt(X) == '%')
			{
				X = rand.nextInt(pool[0].length());
				Y = rand.nextInt(pool.length);
			}
			
			e.X = X;
			e.Y = Y;
		}
	}
	
	public boolean PlayerInDanger(char dangerSign, Player player, String[] pool)
	{
		if(pool[player.Y].charAt(player.X) == dangerSign)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean Point(char pointSign, Player player, String[] pool)
	{
		if(pool[player.Y].charAt(player.X) == pointSign)
		{
			return true;
		}
		
		return false;
	}
}