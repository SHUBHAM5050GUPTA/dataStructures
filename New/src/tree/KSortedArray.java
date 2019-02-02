import java.util.PriorityQueue;
import java.util.Scanner;


public class KSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int k=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextInt();
		}
		
		/*PriorityQueue<Integer> pq=new PriorityQueue();
		int j=0;
		int pointer=0;
		int x=0;
		while(j<=n-k)
		{
			for(int i=j;i<j+k;i++)	{
				
				pq.add(arr[i]);
				
			}
			
			int smallestElement=pq.poll();
			arr[pointer]=smallestElement;
			while(!pq.isEmpty())
			{
				arr[x]=pq.poll();
				x++;
			}
		
			x=0;
			pointer++;
			x=x+pointer;
			j++;
				
		}*/
		
		arr=Ksort(arr,k);
		
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		
		
	}
	
	public static int[] Ksort(int arr[],int k)
	{
		PriorityQueue<Integer> pq=new PriorityQueue();
		
		for(int i=0;i<k;i++)
		{
			pq.add(arr[i]);
		}
		
		int start=0;
		for(int i=k;i<arr.length;i++)
		{
			arr[start]=pq.remove();
			pq.add(arr[i]);
			start++;
		}
		
		while(!pq.isEmpty())
		{
			arr[start]=pq.remove();
			start++;
		}
		
		
		return arr;
		
	}
	

}
