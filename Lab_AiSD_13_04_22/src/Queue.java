
public class Queue<T> implements IQueue<T> 
{
	LinkedList<T> queue;
	
	public Queue()
	{
		queue = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() 
	{
		return queue.isEmpty();
	}

	@Override
	public T dequeue() throws EmptyQueueException 
	{
		T res = queue.get(0);
		queue.remove(0);
		
		return res; 
	}

	@Override
	public void enqueue(T elem) 
	{
		queue.add(elem);
	}

	@Override
	public int size() 
	{
		return queue.size();
	}

	@Override
	public T first() throws EmptyQueueException 
	{
		if(isEmpty())
		{
			throw new EmptyQueueException();
		}
		
		return queue.get(0);
	}
}
