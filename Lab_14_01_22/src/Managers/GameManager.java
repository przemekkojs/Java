package Managers;

import java.util.Vector;

import Observable.Observable;
import Observer.Observer;
import Objects.Entity;

public class GameManager implements Observable 
{
	private Vector<Observer> observers = new Vector<>();
	private int turn = 0;
	
	public void MovePoint()
	{
		if(turn%15 == 0)
		{
			NotifyAll();
		}
	}
	
	public void Turn()
	{
		turn++;		
		System.out.printf("-------------------------------------%nTura:%d%n-------------------------------------%n", turn);
	}
	
	@Override
	public void Attach(Observer o) 
	{
		observers.add(o);
	}

	@Override
	public void Detach(Observer o) 
	{
		observers.remove(o);
	}
	
	@Override
	public void Notify(Observer o) 
	{
		o.Update();
	}
	
	@Override
	public void NotifyAll() 
	{		
		for(int index = 0; index < observers.size(); index++)
		{
			if(((Entity) observers.elementAt(index)).Active())
			{
				Notify(observers.elementAt(index));
			}
			else
			{
				Detach(observers.elementAt(index));
			}
		}
	}
}