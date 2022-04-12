public interface IQueue<T>
{
	public boolean isEmpty();	
	public T dequeue() throws EmptyQueueException;
	public void enqueue(T elem);
	public int size();
	public T first() throws EmptyQueueException;	
}
