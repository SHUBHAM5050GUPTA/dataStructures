package dP;

import java.util.Scanner;

import binaryTree.BinaryTreeNode;
import binaryTree.BinaryTreePractice;

public class BalanceBinaryTree {

	public static void main(String[] args) {

				Scanner s=new Scanner(System.in);
				int h=s.nextInt();
				
				/*BinaryTreeNode<Integer> root=BinaryTreePractice.takeInputLevelWise();
				
				findpathToN(root,10);*/
				
				
				int result3=solByDp(h);
				System.out.println(result3);
				
				int result2=solByM(h);
				System.out.println(result2);
				
				int result1=solByRec(h);
				System.out.println(result1);

	}
	
	public static int solByRec(int h)
	{
		if(h==1||h==0)
		{
			return 1;
			
		}
		
		int x=solByRec(h-1);
		int y=solByRec(h-2);
		
		long value1=((long)x*x) ;
		long value2=(2*(long)x*y);
		
		int result1=mod(value1);
		int result2=mod(value2);
		return mod((long)result1+result2);
		
	}
	
	
	public static int solByM(int h)
	{
		if(h==1||h==0)
		{
			return 1;
			
		}
		int storage[]=new int[h+1];
		
		int result=solByM(h,storage);
		return result;
		
	}
	public static int solByM(int h,int[] storage)
	{
		if(h==1||h==0)
		{
			storage[0]=1;
			storage[1]=1;
			return storage[h];
			
		}
		
		if(storage[h]!=0)
		{
			return storage[h];
		}
		int x=solByM(h-1,storage);
		int y=solByM(h-2,storage);
		
		long value1=((long)x*x) ;
		long value2=(2*(long)x*y);
		
		int result1=mod(value1);
		int result2=mod(value2);
		
		storage[h]=mod((long)result1+result2);
		
		return storage[h];
		
	}
	
	public static int solByDp(int h)
	{
		int arr[]=new int[h+1];
		arr[0]=1;
		arr[1]=1;
		
		for(int i=2;i<arr.length;i++)
		{
			int x=arr[i-1];
			int y=arr[i-2];
			
			long value1=((long)x*x) ;
			long value2=(2*(long)x*y);
			
			int result1=mod(value1);
			int result2=mod(value2);
			
			arr[i]=mod((long)result1+result2);
			
		}
		
		return arr[h];
		
	}
	
	public static int mod(long value)
	{
		int modu=(int)Math.pow(10,9)+7;
		int result=(int)(value%modu);
		return result;
		
	}
	
	public static void  findpathToN(BinaryTreeNode<Integer> root,int n)
	{
		
		int path[]=new int[1000];
		
		findpathToN(root,n,path,0);
		
		
	}
	
	public static void  findpathToN(BinaryTreeNode<Integer> root,int n,int[] path,int pathLength)
	{
		if(root==null)
		{
			return ;
		}
		
		path[pathLength]=root.data;
		pathLength++;
		
		if(root.data==n)
		{
			printpath(path,pathLength);
		}
		
		findpathToN(root.left,n-root.data,path,pathLength);
		findpathToN(root.right,n-root.data,path,pathLength);
		
		
	}
	public static void  printpath(int[] path,int pathLength)
	{
		for(int i=0;i<pathLength;i++)
		{
			System.out.print(path[i]+"->");
		}
		
	}

}
