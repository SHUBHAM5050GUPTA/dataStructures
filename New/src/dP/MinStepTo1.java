package dP;

import java.util.Scanner;

public class MinStepTo1 {
	
	public static int  solutionByRecursion(int n)
	{
		if(n==1)
		{
			return 0;
		}
		 int min=1000000000;
		 int subResult[]=new int[3];
		 
		 subResult[0]=solutionByRecursion(n-1);
		 if(subResult[0]<min)
		 {
			 min=subResult[0];
		 }
		 
		 if(n%2==0)
		 {
			 subResult[1]=solutionByRecursion(n/2); 
			 if(subResult[1]<min)
			 {
				 min=subResult[1];
			 }
		 }
		 
		 
		 if(n%3==0)
		 {
			 subResult[2]=solutionByRecursion(n/3);
			 if(subResult[2]<min)
			 {
				 min=subResult[2];
			 }
		 }
		
		int result=min+1;
		return result;
		
	}

	public static int solByM(int n,int[] storage)
	{
		if(n==1)
		{
			storage[1]=0;
			return storage[1];
		}
		
		if(storage[n]!=-1)
		{
			return storage[n];
		}
		
		storage[n-1]=solByM(n-1,storage);
		int minResult=storage[n-1];
		if(n%2==0)
		{
			storage[n/2]=solByM(n/2,storage);
			if(minResult>storage[n/2])
			{
				minResult=storage[n/2];
			}
		}
		if(n%3==0)
		{
			storage[n/3]=solByM(n/3,storage);
			if(minResult>storage[n/3])
			{
				minResult=storage[n/3];
			}
		}
		
		storage[n]=1+minResult;
		return storage[n];
		
	}
	public static int solByM(int n)
	{
		int storage[]=new int [n+1];
		
		for(int i=0;i<n+1;i++)
		{
			storage[i]=-1;
		}
		
		int result=solByM(n,storage);
		return result;		
	}
	public static int solByDp(int n)
	{
		
		int[] arr=new int[n+1];
	      arr[0]=1;
	      arr[1]=1;
	      arr[2]=1;
	      arr[3]=1;
	      for(int i=4;i<=n;i++)
	      {
	        int result1=arr[i-1];
	        int result2=1000000000;
	        int result3=1000000000;
	        
	        if(n%2==0)
	        {
	          result2=arr[n/2];
	        }
	        
	        
	        if(n%3==0)
	        {
	          result3=arr[n/3];
	        }
	        
	        
	        
	        int result=Math.min(result1,Math.min(result2,result3))+1;
	        arr[i]=result;
	        
	      }
	      
	      return arr[n];
		
		
		
		
		
		/*int storage[]=new int [n+1];
		
		for(int i=2;i<n+1;i++)
		{
			int min=storage[i-1];
			
			if(i%2==0)
			{
				if(min>storage[i/2])
				{
					min=storage[i/2];
				}
			}
			if(i%3==0)
			{
				if(min>storage[i/3])
				{
					min=storage[i/3];
				}
			}
			
			storage[i]=min+1;
		}
		
		return storage[n];*/
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		int result2=solByDp(n);
		System.out.println(result2);
		
		/*int result1=solByM(n);
		System.out.println(result1);
		
		int result=solutionByRecursion(n);
		System.out.println(result);*/

	}

	
}
