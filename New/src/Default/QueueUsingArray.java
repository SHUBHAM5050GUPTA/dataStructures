package Default;

public class QueueUsingArray <T>{
	
	private T data[];
	private int rear;
	private int front;
	private int size;
	
	@SuppressWarnings("unchecked")
	public QueueUsingArray()
	{
		data=(T[])new Object[10];
		rear=-1;
		front=-1;
		size=0;
	}
	
	@SuppressWarnings("unchecked")
	public QueueUsingArray(int n)
	{
		data=(T[])new Object[n];
		rear=-1;
		front=-1;
		size=0;
	}

	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		if(size==0)
		{
			return true;
		}
		return false;
	}
	
	public int front() throws QueueEmptyException
	{
		if(size==0)
		{
			QueueEmptyException e=new QueueEmptyException();
			throw e;
		}
		return front+1;
	}
	
	public void enqueue(T element) throws QueueFullException
	{
		if(size==data.length)
		{
			QueueFullException e=new QueueFullException();
			throw e;
		}
		rear++;
		data[rear]=element;
		size++;
	}
	
	public T dequeue() throws QueueEmptyException
	{
		if(size==0)
		{
			QueueEmptyException e=new QueueEmptyException();
			throw e;
		}
		front++;
		T temp=(T)new Object();
		temp=data[front];
		size--;
		/*
		 * if size is size then set parameter to the initial state
		 * */
		if(size==0)
		{
			rear=-1;
			front=-1;
			
		}
		return temp;
	}
}
