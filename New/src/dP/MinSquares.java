package dP;

import java.util.Scanner;

public class MinSquares {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		int result4=getMinSquares(n);
		System.out.println(result4);
		
		int result3=solByDP(n);
		System.out.println(result3);
		
		/*int result2=solByM(n);
		System.out.println(result2);*/
		
		//int result1=solByRec(n);
	//	System.out.println(result1);
		
		

	}
	
	public static int  solByRec(int n) 
	{
		
		if(n==0)
		{
			return 0;
		}
		
		int result[]=new int[n+1];
		int min=1000000000;
		for(int i=1;(i*i)<=n;i++)
		{
			result[i]=solByRec(n-(i*i));
			if(min>result[i])
			{
				min=result[i];
			}
			
		}
		
		return min+1;
		
		
	}
	
	public static int  solByM(int n)
	{
		int storage[]=new int[n+1];
		int result=solByM(n,storage);
		return result;
	}
	
	public static int  solByM(int n, int storage[]) 
	{
		
		if(n==0)
		{
			return 0;
		}
		
		int result[]=new int[n+1];
		
		int min=1000000000;
		for(int i=1;(i*i)<=n;i++)
		{
			if(storage[n-(i*i)]==0)
			{
				storage[n-(i*i)]=solByM(n-(i*i),storage);
				result[i]=storage[n-(i*i)];
			}
			else
			{
				result[i]=storage[n-(i*i)];
			}
			
			if(min>result[i])
			{
				min=result[i];
			}
			
		}
		
		return min+1;
		
		
	}
	
	public static int solByDP(int n)
	{
		int storage[]=new int[n+1];
		
		storage[1]=1;
		for(int i=2;i<n+1;i++)
		{
			
			int min=i;
			for(int j=1;(j*j)<=i;j++)
			{
				min=Math.min(min,1+storage[i-(j*j)]);
					
			}
			
			storage[i]=min;
			
		}
		
		return storage[n];
	
	}
	
	 static int getMinSquares(int n) 
	    { 
	        // Create a dynamic programming table 
	        // to store sq 
	        int dp[] = new int[n+1]; 
	       
	        // getMinSquares table for base case entries 
	        dp[0] = 0; 
	        dp[1] = 1; 
	        dp[2] = 2; 
	        dp[3] = 3; 
	       
	        // getMinSquares rest of the table using recursive 
	        // formula 
	        for (int i = 4; i <= n; i++) 
	        { 
	            // max value is i as i can always be represented 
	            // as 1*1 + 1*1 + ... 
	            dp[i] = i; 
	       
	            // Go through all smaller numbers to 
	            // to recursively find minimum 
	            for (int x = 1; x <= i; x++) { 
	                int temp = x*x; 
	                if (temp > i) 
	                    break; 
	                else dp[i] = Math.min(dp[i], 1+dp[i-temp]); 
	            } 
	        } 
	       
	        // Store result and free dp[] 
	        int res = dp[n]; 
	       
	        return res; 
	    } 
	

}
