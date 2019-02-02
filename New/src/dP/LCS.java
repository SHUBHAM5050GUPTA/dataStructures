package dP;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		
		String string1=s.next();
		String string2=s.next();
		
		/*int resultRec=longestComSubSequenceRec(string1,string2);
		
		System.out.println(resultRec);*/
		
		int resultRec2=longestComSubSequenceRec2(string1,string2);
		System.out.println(resultRec2);
		
		int resultDp=longestComSubSequenceDp(string1,string2);
		System.out.println(resultDp);
		
		int resultM=longestComSubSequenceM(string1,string2);
		System.out.println(resultM);
		

	}
	
	public static int longestComSubSequenceRec(String s1,String s2)
	{
		HashMap<String,Integer> map1=new HashMap<>();
		HashMap<String,Integer> map2=new HashMap<>();
		
		map1=subSequences(s1);
		map2=subSequences(s2);
		
		int length=0;
			for(Map.Entry<String, Integer> entry:map1.entrySet())
			{
				if(map2.containsKey(entry.getKey()))
				{
					length=Math.max(length, entry.getKey().length());
				}
			}
		
		
		return length;
	
		
		
		
		
	}
	
	public static int longestComSubSequenceRec2(String s1,String s2)
	{
		if(s1.length()==0||s2.length()==0)
		{
			return 0;
		}
		
		int result=Integer.MAX_VALUE;
		
		if(s1.charAt(0)==s2.charAt(0))
		{
			result=1+longestComSubSequenceRec2(s1.substring(1),s2.substring(1));
		}
		else
		{
			
			int result1=longestComSubSequenceRec2(s1,s2.substring(1));
			int result2=longestComSubSequenceRec2(s1.substring(1),s2);
			
			result=Math.max(result1, result2);
		}
		
		return result;
		
	}
	
	public static int longestComSubSequenceM(String s1,String s2)
	{
		int[][] storage=new int[s1.length()+1][s2.length()+1];
		
		for(int i=0;i<=s1.length();i++)
		{
			for(int j=0;j<=s2.length();j++)
			{
				storage[i][j]=-1;
			}
		}
		
		int result=longestComSubSequenceM(s1,s2,storage);
		
		return result;
		
	}
	
	public static int longestComSubSequenceM(String s1,String s2,int[][] storage)
	{
		int m=s1.length();
		int n=s2.length();
		if(s1.length()==0||s2.length()==0)
		{
			
			storage[m][n]=0;
			return storage[m][n];
		}
		
		if(storage[m][n]!=-1)
		{
			return storage[m][n];
		}
		
		int result=Integer.MAX_VALUE;
		
		
			if(s1.charAt(0)==s2.charAt(0))
			{
					result=1+longestComSubSequenceM(s1.substring(1),s2.substring(1),storage);
					
			}
			else
			{
				int result1=longestComSubSequenceM(s1,s2.substring(1),storage);
				int result2=longestComSubSequenceM(s1.substring(1),s2,storage);
				
				result=Math.max(result1, result2);
			}
			
			storage[m][n]=result;
				
		return storage[m][n];
		
	}
	
	
	
	public static int longestComSubSequenceDp(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int arr[][]=new int[m+1][n+1];
		
		/*for(int i=0;i<m;i++)
		{
			if(s1.charAt(i)==s2.charAt(0))
			{
				for(int k=i;k<m;k++)
				{
					arr[k][0]=1;
				}
				break;
			}
			
		}
		for(int i=0;i<n;i++)
		{
			if(s1.charAt(0)==s2.charAt(i))
			{
				for(int k=i;k<n;k++)
				{
					arr[0][k]=1;
				}
				break;
			}
			
		}*/
		
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(i==0||j==0)
				{
					arr[i][j]=0;
				}
				
				else if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					arr[i][j]=1+arr[i-1][j-1];
				}
				else
				{
					arr[i][j]=Math.max(arr[i][j-1],arr[i-1][j]);
				}

			}
		}
		return arr[m][n];
		
		
		
	}
	
	
	
	public static HashMap<String ,Integer> subSequences(String s)
	{
		HashMap<String,Integer> map=new HashMap<>();
		if(s.length()==0)
		{
			map.put("",1);
			return map;
		}
		
		HashMap<String,Integer> subResult=subSequences(s.substring(1));
		
		HashMap<String,Integer> result=new HashMap<>();
		
		for(Map.Entry<String, Integer> entry:subResult.entrySet())
		{
			result.put(entry.getKey(),1);
			result.put(s.charAt(0)+entry.getKey(),1);
		}
		
		return result;
		
	}

}
