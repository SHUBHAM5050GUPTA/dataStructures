package Default;

import java.util.Scanner;

public class Sorting {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++ )
		{
			arr[i]=s.nextInt();
		}
		//quickSort(0,arr.length-1,arr);
		
		quickSort(arr);
		for(int i:arr)
		{
			System.out.println(i);
		}

	}
	
	
	public static void quickSort(int[] input) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing output is handled automatically.
		 */
      
      quickSort(input,0,input.length-1);
      
		
	}
  
  public static void quickSort(int[] arr,int start,int end)
  {
    if(start>=end)
    {
      return ;
    }
    
    int pivot=partition(arr,start,end);
    quickSort(arr,start,pivot-1);
    quickSort(arr,pivot+1,end);
    
    
    
  }
  
  public static int partition(int[] arr,int start,int end)
  {
    
    int count=start;
    int element=arr[start];
    for(int i=start+1;i<=end;i++)
    {
      if(arr[i]<element)
      {
        count++;
        
      }
    }
    
    int temp=arr[start];
    arr[start]=arr[count];
    arr[count]=temp;
    
    int pivot=arr[count];
    int i=start;
    int j=end;
    
    while(!(i==count||j==count))
    {
      
      while(arr[i]<pivot)
      {
        i++;
      }
      
      while(arr[j]>pivot)
      {
        j--;
      }
      
      int temp1=arr[i];
      arr[i]=arr[j];
      arr[j]=temp1;
      
    }
    
    
    return count;
     
  }
	
	
	
	
	
	
	
/*	public static void quickSort(int start,int end,int[] arr)
	{
			
		if(start<end)
		{
			int pivotIndex=partioning(start,arr,end);
			
		
			quickSort(0,pivotIndex-1,arr);
			quickSort(pivotIndex+1,end,arr);
		}
		
		
		
		
		
		
	}

	private static int  partioning(int start, int[] arr, int end) {
		
		int pivot=start;
		start++;
		for(int i=start;i<=end;i++)
		{
			if(arr[i]<=arr[pivot])
			{
				int temp=arr[i];
				arr[i]=arr[start];
				arr[start]=temp;
				start++;
			}
		}
		
		start--;
		int temp=arr[pivot];
		arr[pivot]=arr[start];
		arr[start]=temp;
		return start;
		
	}*/
	
	

}
