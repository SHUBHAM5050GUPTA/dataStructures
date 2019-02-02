package dP;

import java.util.HashMap;
import java.util.Scanner;

public class fibonacciDp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		System.out.println(fibDP(n));
		
		int resultM=fibMemoization(n);
		System.out.println(resultM);

		int result=fib(n);
		System.out.println(result);*/
		
		
		strr();
		

	}
	
	public static int fib(int n)
	{
		if(n==0||n==1)
		{
			return n;
		}
		return fib(n-1)+fib(n-2);
	}
	public static int fibMemoization(int n)
	{
		int storage[]=new int[n+1];
		for(int i=0;i<storage.length;i++)
		{
			storage[i]=-1;
		}
		
		return fibMemoization(n,storage);
		
	}
	public static int fibMemoization(int n,int[] storage)
	{
		if(n==0||n==1)
		{
			storage[n]=n;
			return storage[n];
		}
		if(storage[n]!=-1)
		{
			return storage[n];
		}
		
		storage[n]= fibMemoization(n-1,storage)+fibMemoization(n-2,storage);
		return storage[n];
	}
	public static int fibDP(int n)
	{
		int arr[]=new int[n+1];
		for(int i=0;i<n+1;i++)
		{
			if(i==0||i==1)
			{
				arr[i]=i;
				continue;
			}
			
			arr[i]=arr[i-1]+arr[i-2];
			
		}
		return arr[n];
		
	}
	
	
	

}
