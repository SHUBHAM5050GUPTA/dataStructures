package heap;

import java.util.Arrays;

public class MInHeap {
	
	
	static int capacity=10;
	static int size=0;
	
	static int items[]=new int[capacity];
	
	public static int getLeftChildIndex(int index)
	{
		return (2*index)+1;
			
	}
	public static int getRightChildIndex(int index)
	{
		return (2*index)+2;
			
	}

	public static int getParentIndex(int index)
	{
		
		return (index-1)/2;
			
	}
	private static boolean hasLeftChild(int index)
	{
		return getLeftChildIndex(index)<size;
	}
	
	
	private static boolean hasRightChild(int index)
	{
		return getRightChildIndex(index)<size;
	}
	
	private static boolean hasParent(int index)
	{
		
		return getParentIndex(index)>=0;
	}
	
	
	private static int getLeftChild(int index)
	{
		return items[getLeftChildIndex(index)];
	}
	
	private static int getRightChild(int index)
	{
		return items[getRightChildIndex(index)];
	}
	
	private static int getParent(int index)
	{
		
		return items[getParentIndex(index)];
	}
	
	public static void swap(int indexOne,int indexTwo)
	{
		int temp=items[indexOne];
		items[indexOne]=items[indexTwo];
		items[indexTwo]=temp;
		

	}
	
	public static int peep()
	{
		if(size==0) throw new  IllegalStateException();
		return items[0];
	}
	
	private static int poll()
	{
		
		if(size==0) throw new  IllegalStateException();
		
		int item=items[0];
		items[0]=items[size-1];
		size--;
		heapifyDown();
		return item;
		
		
	}
	
	
	private static void add(int item)
	{
		ensureExtraCapacity();
		items[size]=item;
		size++;
		
		heapifyUp();
		
	}
	
	
	private  static void heapifyDown()
	{

		int index=0;
		
		while(hasLeftChild(index))
		{
			
			int smallestChildIndex=getLeftChildIndex(index);
			if(hasRightChild(index)&& getLeftChild(index)>getRightChild(index))
			{
				smallestChildIndex=getRightChildIndex(index);
			}
			
			if(items[index]<items[smallestChildIndex]){
				break;
			}else
			{
				swap(index,smallestChildIndex);
			}
			
			index=smallestChildIndex;
			
		}
		
		
	}
	
	private static void heapifyUp()
	{
		
		int index=size-1;
		while(hasParent(index))
		{
			
			if(items[index]>=getParent(index))
			{
				break;
			}else
			{
				swap(index,getParentIndex(index));
			}
			index=getParentIndex(index);
			
		}
		
	}
	
	private static  void printHeap(int[] items)
	{
		for(int i:items)
		{
			System.out.print(i+" ");
		}
	}
	
	private static void ensureExtraCapacity()
	{
		if(size==capacity)
		{
			items=Arrays.copyOf(items, capacity*2);
		}
		capacity*=2;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*MInHeap heap=new MInHeap();
		

		heap.add(10);
		heap.add(15);
		heap.add(20);
		heap.add(17);
		//heap.add(10);
		heap.printHeap(heap.items);*/
		
		add(10);
		
		add(15);
		add(20);
		add(17);
		add(8);
		printHeap(items);
		
		

	}
	
	

}
