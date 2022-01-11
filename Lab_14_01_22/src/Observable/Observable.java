package Observable;

import Observer.Observer;

public interface Observable 
{
	public abstract void Attach(Observer o);
	public abstract void Detach(Observer o);
	public abstract void Notify(Observer o, String arg);
	public abstract void NotifyAll(String arg);
}