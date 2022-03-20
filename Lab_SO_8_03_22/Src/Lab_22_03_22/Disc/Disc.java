package Lab_22_03_22.Disc;

import java.util.Vector;

import Lab_22_03_22.Application.Application;
import Lab_22_03_22.Block.Block;

public class Disc 
{
	private int head;
	private int headMovements;
	private int direction;
	
	private Block[] blocks;
	
	private Vector<Application> buffer;
	
	public Disc(int _headStart, int _blockCount)
	{
		head = 0;
		headMovements = 0;
		direction = 1;
		
		buffer = new Vector<Application>();
		blocks = new Block[_blockCount];
		
		for(int i = 0; i < _blockCount; i++)
		{
			blocks[i] = new Block(i);
		}
	}
	
	public void MoveHead()
	{
		headMovements++;
		head += 1 * direction;		
	}
	
	public void ChangeDirection()
	{
		direction *= (-1);
	}
	
	public int getHeadMovements()
	{
		return headMovements;
	}
	
	public int getHeadPosition()
	{
		return head;
	}
	
	public int getSize()
	{
		return blocks.length;
	}
	
	public void Serve()
	{
		blocks[head].Attach();
	}
	
	public Vector<Application> GetBuffer()
	{
		return buffer;
	}
}