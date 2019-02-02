package backTracking;

import java.util.Scanner;

public class soduko {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		
		int[][] arr=new int[9][9];
		
		for(int i=0;i<9;i++)
		{
			String str=s.nextLine();
			String strArray[]=str.split("");
			
			for(int j=0;j<strArray.length;j++)
			{
				arr[i][j]=Integer.parseInt(strArray[j]);
			}
			
		}
		
		boolean result=fillSoduko(arr);
		
		
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					System.out.print(arr[i][j]);
				}
				System.out.println();

			}
			
		
		

	}
	
	public static boolean fillSoduko(int[][] arr)
	{
		int rowColumn[]=findEmptySpace(arr);
		
		if(rowColumn.length==0)
		{
			return true;
		}
		//System.out.println(rowColumn[0]+" "+rowColumn[1]);
		
		int row=rowColumn[0];
		int column=rowColumn[1];
		
		for(int i=1;i<10;i++)
		{
			if(checkRow(i,column,arr) &&checkColumn(i,row,arr)&&checkBox(i,row,column,arr))
			{
				arr[row][column]=i;
				boolean  subResult =fillSoduko(arr);
				
				//System.out.println(subResult);
				
				if(subResult)
				{
					return true;
				}
				else
				{
					arr[row][column]=0;
				}
			}
		}
		
		
		return false;
		
	}
	

	public static int[] findEmptySpace(int[][] arr)
	{
		int[] rowColumn={};
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(arr[i][j]==0)
				{
					rowColumn=new int[2];
					rowColumn[0]=i;
					rowColumn[1]=j;
					return rowColumn;
				}
			}
		}
		
		return rowColumn;
		
	}
	
	public static boolean checkRow(int number,int column,int[][] arr)
	{
		for(int i=0;i<9;i++)
		{
			if(arr[i][column]==number)
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkColumn(int number,int row,int[][] arr)
	{
		for(int j=0;j<9;j++)
		{
			if(arr[row][j]==number)
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkBox(int number,int row,int column,int[][] arr)
	{
		int arr1[]=new int[4];
		arr1[0]=0;
		arr1[1]=3;
		arr1[2]=6;
		arr1[3]=9;
		
		row=row/3;
		column=column/3;
		
		
		for(int i=arr1[row];i<arr1[row+1];i++)
		{
			for(int j=arr1[column];j<arr1[column+1];j++)
			{
				if(arr[i][j]==number)
				{
					return false;
				}
			}
		}
		
		return true;
		
	}

}
