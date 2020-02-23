package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int e=s.nextInt();
		int edges[][]=new int[n][n];
		for(int i=0;i<e;i++)
		{
			int f=s.nextInt();
			int sec=s.nextInt();
			edges[f][sec]=1;
			edges[sec][f]=1;
			
		}
		boolean[] visited=new boolean[n];
		printGraphDfs(edges,0,visited);
		//printGraphBfs(edges,0,visited);
		//printDisDfs(edges,n);
		//printDisBfs(edges,n);
		//hasPath(edges,n,s);
		//getPathDfs(edges,n,s);
		//getPathBfs(edges,n,s);
		//allConnectedcomponent(edges,n);

	}
	public static void printGraphDfs(int[][] edges,int vertex,boolean[] visited)
	{
		System.out.println(vertex);
		visited[vertex]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(i==vertex)
			{
				continue;
			}
			if(edges[vertex][i]==1 && visited[i]==false)
			{
				
				printGraphDfs(edges,i,visited);
			}
		}
		
		
	}
	public static void printGraphBfs(int[][] edges,int vertex,boolean[] visited)
	{
		
		Queue<Integer> pendingNodes=new LinkedList<>();
		pendingNodes.add(vertex);
		visited[vertex]=true;
		
		while(!pendingNodes.isEmpty())
		{
			int node=pendingNodes.remove();
			System.out.println(node);
			
			for(int i=0;i<edges.length;i++)
			{
				if(edges[node][i]==1 && visited[i]==false)
				{
					pendingNodes.add(i);
					visited[i]=true;
				}
			}
			
		}
		
	}
	public static void printDisDfs(int[][] edges,int n)
	{
		
		boolean[] visited=new boolean[n];
		
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				printGraphDfs(edges,i,visited);
			}
		}
		
	}
	public static void printDisBfs(int[][] edges,int n)
	{
		
		boolean[] visited=new boolean[n];
		
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				printGraphBfs(edges,i,visited);
			}
		}
		
	}
	
	public static void hasPath(int[][] edges,int n,Scanner s)
	{
		int v1=s.nextInt();
		int v2=s.nextInt();
		
		boolean[] visited=new boolean[n];
		
		System.out.println(hasPath(edges,n,v1,v2,visited));
		
	}
	public static boolean hasPath(int[][] edges,int n,int v1,int v2,boolean[] visited)
	{
		visited[v1]=true;
		if(edges[v1][v2]==1)
		{
			return true;
		}

		for(int i=0;i<n;i++)
		{
			if(edges[v1][i]==1 && visited[i]==false )
			{
			
				boolean result=hasPath(edges,n,i,v2,visited);
				if(result)
				{
					return true;
				}
			}
		}
		return false;
		
	}
	public static void getPathDfs(int[][] edges,int n,Scanner s)
	{
		int v1=s.nextInt();
		int v2=s.nextInt();
		
		boolean[] visited=new boolean[n];
		ArrayList<Integer> result=getPathDfs(edges,n,v1,v2,visited);
		if(result==null)
		{
			System.out.println("null");
		}else{
			for(int i=result.size()-1;i>=0;i--)
			{
				System.out.println(result.get(i));
			}
		}
		
		
	}

	public static ArrayList<Integer> getPathDfs(int[][] edges,int n,int v1,int v2,boolean[] visited)
	{
		visited[v1]=true;
		if(v1==v2)
		{
			ArrayList<Integer> list=new ArrayList<>();
			list.add(v1);
			return list;
		}
		
		for(int i=0;i<n;i++)
		{
			if(edges[v1][i]==1 && visited[i]==false)
			{
				ArrayList<Integer> result=getPathDfs(edges,n,i,v2,visited);
				if(result!=null)
				{
					result.add(v1);
					return result;
				}
			}
		}
		return null;
		
	}
	public static void getPathBfs(int[][] edges,int n,Scanner s)
	{
		int v1=s.nextInt();
		int v2=s.nextInt();
		
		boolean[] visited=new boolean[n];
		ArrayList<Integer> result=getPathBfs(edges,n,v1,v2,visited);
		if(result==null)
		{
			System.out.println("null");
		}else{
			for(int i=result.size()-1;i>=0;i--)
			{
				System.out.println(result.get(i));
			}
		}
		
		
	}
	public static ArrayList<Integer> getPathBfs(int[][] edges,int n,int v1,int v2,boolean[] visited)
	{
		boolean check=false;
		Queue<Integer> pendingNodes=new LinkedList<>();
		pendingNodes.add(v1);
		visited[v1]=true;
		ArrayList<Integer> list=new ArrayList<>();
		
		HashMap<Integer,Integer> map=new HashMap<>();
		
		while(!pendingNodes.isEmpty() && check==false)
		{
			int node=pendingNodes.remove();
			for(int i=0;i<n;i++)
			{
				if(edges[node][i]==1 && visited[i]==false)
				{
					pendingNodes.add(i);
					visited[i]=true;
					map.put(i,node);
					if(i==v2)
					{
						check=true;
						break;
					}
				}
				
			}
			
			
		}
		
		if(check==false)
		{
			
			return null;
		}
		int node=v2;
		list.add(v2);
		while(node!=v1)
		{
			list.add(map.get(node));
			node=map.get(node);
		}
		return list;
		
	}
	
	public static void isConnected(int[][] edges,int n)
	{
		
		boolean visited[]=new boolean[n];
		isConnected(edges,0,visited);
		
	}
	
	public static void isConnected(int[][] edges,int vertex,boolean[] visited)
	{
		visited[vertex]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(i==vertex)
			{
				continue;
			}
			if(edges[vertex][i]==1 && visited[i]==false)
			{
				
				isConnected(edges,i,visited);
			}
		}
		
		if(vertex==0)
		{
			for(int i=0;i<edges.length;i++)
			{
				if(!visited[i])
				{
					System.out.println(false);
					return ;
				}
			}
			System.out.println(true);
		}
		
			
	}
	public static void allConnectedcomponent(int[][] edges,int n)
	{
		boolean visited[]=new boolean[n];
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				ArrayList<Integer> list1=new ArrayList<>();
				allConnectedcomponent(edges,n,visited,i,list,list1);
				list.add(list1);
			}
		}
		
		for(int i=0;i<list.size();i++)
		{
			for(int j=0;j<list.get(i).size();j++)
			{
				System.out.print(list.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
	}
	public static void allConnectedcomponent(int[][] edges,int n,boolean visited[],int vertex,ArrayList<ArrayList<Integer>> list,ArrayList<Integer> list1)
	{
		list1.add(vertex);
		visited[vertex]=true;
		
		for(int i=0;i<n;i++)
		{
			if(edges[vertex][i]==1&& visited[i]==false)
			{
				allConnectedcomponent(edges,n,visited,i,list,list1);
			}
		}
		
		
		
		
		
	}
	
}
