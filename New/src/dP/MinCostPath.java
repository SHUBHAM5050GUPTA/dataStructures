package dP;

import java.util.Scanner;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner s=new Scanner(System.in);
		
		
		int row=s.nextInt();
		int column=s.nextInt();
		
		int arr[][]=new int[row][column];
		
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				arr[i][j]=s.nextInt();
			}
		}
		
		int resultRec=minPathCost(arr);
		System.out.println(resultRec);
		
		int resultM=minPathCostM(arr);	
		System.out.println(resultM);
		
		int resultDp=minPathCostDp(arr);	
		System.out.println(resultDp);

	}
	
	public static int minPathCost(int[][] arr)
	{
		int i=0;
		int j=0;
		int result=minPathCostRec( arr,i,j);
		
		return result;
	}
	public static int minPathCostM(int[][] arr)
	{
		int i=0;
		int j=0;
		int storage[][]=new int[arr.length][arr[0].length];
		int result=minPathCostM( arr,i,j,storage);
		
		return result;
	}
	public static int minPathCostM(int[][] arr,int i,int j,int[][]storage)
	{
		if(i==(arr.length-1) &&j==(arr[0].length-1))
		{
			storage[arr.length-1][arr[0].length-1]=arr[arr.length-1][arr[0].length-1];
			return storage[arr.length-1][arr[0].length-1];
							
		}
		
		
		int rightResult=10000000;
		int downResult=10000000;
		int diagnalResult=1000000;
		if(j<arr[0].length-1)
		{
			if(storage[i][j+1]==0)
			{
				rightResult=minPathCostM(arr,i,j+1,storage);		
			}
			
				rightResult=storage[i][j+1];
			
		}
		
		if(i<arr.length-1)
		{
			if(storage[i+1][j]==0)
			{
				downResult=minPathCostM(arr,i+1,j,storage);
			}
			
				downResult=storage[i+1][j];
			
			
		}
		
		if(i<arr.length-1&&j<arr[0].length-1)
		{
			if(storage[i+1][j+1]==0)
			{
				diagnalResult=minPathCostM(arr,i+1,j+1,storage);
			}
			
				diagnalResult=storage[i+1][j+1];
			
			
		}
		
		storage[i][j]=Math.min(diagnalResult,Math.min(rightResult, downResult))+arr[i][j];
	
		int result=storage[i][j];
		return result;
		
	
		
	}
	public static int minPathCostRec(int[][] arr,int i,int j)
	{
		
		if(i==(arr.length-1) &&j==(arr[0].length-1))
		{
			return arr[arr.length-1][arr[0].length-1];
							
		}
		int rightResult=10000000;
		int downResult=10000000;
		int diagnalResult=10000000;
		if(j<arr[0].length-1)
		{
			rightResult=minPathCostRec(arr,i,j+1);	
		}
		
		if(i<arr.length-1)
		{
			downResult=minPathCostRec(arr,i+1,j);
		}
		if(i<arr.length-1&&j<arr[0].length-1)
		{
			diagnalResult=minPathCostRec(arr,i+1,j+1);
		}
		
		int result=Math.min(diagnalResult, Math.min(rightResult, downResult));
	
		return result+arr[i][j];
		
		
	}
	
	public static int minPathCostDp(int[][] arr)
	{
		int row=arr.length;
		int column=arr[0].length;
		int dp[][]=new int[row][column];
		
		dp[row-1][column-1]=arr[row-1][column-1];
		
		for(int i=row-1;i>=0;i--)
		{
			for(int j=column-1;j>=0;j--)
			{
				int result1=100000000;
				int result2=100000000;
				int result3=100000000;
				if(i+1<row&&j+1<column)
				{
					result1=dp[i+1][j+1];
				}
				if(i<row&&j+1<column)
				{
					result2=dp[i][j+1];
				}
				if(i+1<row&&j<column)
				{
					result3=dp[i+1][j];
				}
				
				if(i==row-1 &&j==column-1)
				{
					 result1=0;
					 result2=0;
					 result3=0;
				}
				
				
				int result=Math.min(result1, Math.min(result2,result3));
				
				dp[i][j]=result+arr[i][j];
				
			}
		}
		
		return dp[0][0];
			
			
			
			
			
			
	}

}
