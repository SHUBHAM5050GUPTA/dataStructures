package dP;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		
		String string1=s.next();
		String string2=s.next();
		
		/*int result=editDistanceRec(string1,string2);
		System.out.println(result);*/
		
		int resultM=editDistanceM(string1,string2);
		System.out.println(resultM);
		
		int resultDp=editDistanceDp(string1,string2);
		System.out.println(resultDp);
				

	}
	public static int editDistanceRec(String s1,String s2)
	{
		
		if(s1.length()==0||s2.length()==0)
		{
			return Math.max(s1.length(), s2.length());
		}
		
		int result=Integer.MIN_VALUE;
		if(s1.charAt(0)==s2.charAt(0))
		{
			result=editDistanceRec(s1.substring(1),s2.substring(1));
		}
		else
		{
			int op1=editDistanceRec(s1,s2.substring(1));
			int op2=editDistanceRec(s1.substring(1),s2);
			int op3=editDistanceRec(s1.substring(1),s2.substring(1));
			
			result=1+Math.min(op3, Math.min(op1, op2));
				
		}
		
		return result;
			
	}
	public static int editDistanceM(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int storage[][]=new int[m+1][n+1];
		
		for(int i=0;i<=s1.length();i++)
		{
			for(int j=0;j<=s2.length();j++)
			{
				storage[i][j]=-1;
			}
		}
		
		int result=editDistanceM(s1,s2,storage);
		return result;
			
	}
	public static int editDistanceM(String s1,String s2,int[][] storage)
	{
		int m=s1.length();
		int n=s2.length();
		if(m==0||n==0)
		{
			storage[m][n]=Math.max(s1.length(), s2.length());
			return storage[m][n];
		}
		if(storage[m][n]!=-1)
		{
			return storage[m][n];
		}
		
		int result=Integer.MIN_VALUE;
		if(s1.charAt(0)==s2.charAt(0))
		{
			result=editDistanceM(s1.substring(1),s2.substring(1),storage);
		}
		else
		{
			int op1=editDistanceM(s1,s2.substring(1),storage);
			int op2=editDistanceM(s1.substring(1),s2,storage);
			int op3=editDistanceM(s1.substring(1),s2.substring(1),storage);
			
			result=1+Math.min(op3, Math.min(op1, op2));
				
		}
		storage[m][n]=result;
		return storage[m][n];
			
	}
	public static int editDistanceDp(String s1,String s2)
	{
		int arr[][]=new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<=s1.length();i++)
		{
			for(int j=0;j<=s2.length();j++)
			{
				
				if(i==0||j==0)
				{
					if(i==0&&j==0)
					{
						arr[i][j]=0;
					}
					else
					{
						if(i==0)
						{
							arr[i][j]=j;
						}
						else
						{
							arr[i][j]=i;
						}
					}
				}
				
				else if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					arr[i][j]=arr[i-1][j-1];
				}
				else
				{
					
					arr[i][j]=1+Math.min(arr[i-1][j-1],Math.min(arr[i-1][j],arr[i][j-1]));
					
				}
			}
		}
		
		return arr[s1.length()][s2.length()];
		
		
	}
	
	
	

}
