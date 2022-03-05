package Objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Constants.*;

public class Player extends Entity 
{		
	private BufferedReader br;
	
	public Player(int x, int y)
	{
		super(x, y, Constants.PLAYER_BODY);
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	@Override
	public void Update() 
	{		
		try 
		{
			System.out.println("Twój ruch: ");
			char move = br.readLine().charAt(0);
			
			switch(move)
			{
			case 'a':
				Move(-1, 0);					
				break;
			case 'd':
				Move(1, 0);					
				break;
			case 's':
				Move(0, 1);					
				break;
			case 'w':
				Move(0, -1);					
				break;
			}
		} 
		catch (IOException e) 
		{				
			System.out.print("Blad czytania z klawiatury");
		}		
	}
}