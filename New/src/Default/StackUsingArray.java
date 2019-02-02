package Default;

public class StackUsingArray {
	
	private int data[];
	private int top;
	
	public StackUsingArray()
	{
		data=new int[10];
		top=-1;
	}
	
	public StackUsingArray(int n)
	{
		data=new int[n];
		top=-1;
	}
	
	public boolean isEmpty()

	{
		if(top==-1)
		{
			return true; 
		}
		return false;
	}
	
	public int size()
	{
		return top+1;
	}
	
	public void push(int element) throws StackFullException
	{
		if(size()==data.length)
		{
			StackFullException e=new StackFullException();
			throw e;
		}
		top++;
		data[top]=element;
	}
	
	public int pop() throws StackEmptyException
	{
		if(size()==0)
		{
			/*StackEmptyException e=new StackEmptyException();
			throw e;*/
			doubleCapacity();
		}
		int temp=data[top];
		top--;
		return temp;
		
	}

	public void doubleCapacity()
	{
		int temp[]=data;
		data=new int[2*temp.length];
		for(int i=0;i<temp.length;i++)
		{
			data[i]=temp[i];
		}
		
	}
	
	public int top() throws StackEmptyException
	{
		if(size()==0)
		{
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
		int temp=data[top];
		return temp;
	}
}

