import java.util.Vector;

public class Player 
{
	public int X;
	public int Y;	
	
	public Vector<BodyCell> body = new Vector<BodyCell>();
	
	public Player()
	{		
		X = 1;
		Y = 1;
		body.add(new BodyCell(X, Y));
	}
	
	public void Increase(int x, int y)
	{		
		body.add(0, new BodyCell(x, y));		
	}
	
	private void UpdateBody(int x, int y)
	{
		for(int index = 1; index < body.size(); index++)
		{
			body.elementAt(index).X = body.elementAt(index - 1).X;
			body.elementAt(index).Y = body.elementAt(index - 1).Y;
		}
		
		body.elementAt(0).X = x;
		body.elementAt(0).Y = y;
		
		X = x;
		Y = y;
		
		System.out.println("New position: " + X + " " + Y);
	}
	
	public void Move(char move)
	{
		if(move == 'w' && this.Y > 1)
		{
			UpdateBody(this.X, this.Y - 1);
		}
		else if(move == 's' && this.Y < Main.sceneSize - 1)
		{
			UpdateBody(this.X, this.Y + 1);
		}
		else if(move == 'd' && this.X < Main.sceneSize - 1)
		{
			UpdateBody(this.X - 1, this.Y);
		}
		else if(move == 'a' && this.X > 1)
		{
			UpdateBody(this.X + 1, this.Y);
		}
		else
		{
			System.out.println("This is not a valid move");
		}
	}
}