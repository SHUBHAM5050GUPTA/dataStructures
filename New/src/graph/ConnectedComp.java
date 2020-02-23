package graph;

import java.util.Scanner;
import java.util.*;

public class ConnectedComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		
		int V=s.nextInt();
		int E=s.nextInt();
		
		ArrayList<ArrayList<Integer>> edgeslist=new ArrayList<>();
		
		for(int i=0;i<V;i++)
		{
			edgeslist.add(new ArrayList<Integer>());
			
		}
		
		for(int i=0;i<E;i++)
		{
			int v1=s.nextInt();
			int v2=s.nextInt();
			
			edgeslist.get(v1).add(v2);
			edgeslist.get(v2).add(v1);
			
		}
		
		ArrayList<HashSet<Integer>> result=findConnectedComponents(edgeslist,V);
		
		for(int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i));
		}
		
		

	}
	
	public static ArrayList<HashSet<Integer>> findConnectedComponents(ArrayList<ArrayList<Integer>> edgeslist,int V)
	{
		
		boolean visited[]=new boolean[V];
		
		ArrayList<HashSet<Integer>> result=new ArrayList<>();
		for(int i=0;i<visited.length;i++)
		{
			if(!visited[i])
			{
				HashSet<Integer> set1=new HashSet<Integer>();
				dfs(edgeslist,i,visited,set1);
				result.add(set1);
			}
		}
		
		return result;
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> edgeslist,int vertex,boolean visited[],HashSet<Integer> set1)
	{
		visited[vertex]=true;
		set1.add(vertex);
		for(int i=0;i<edgeslist.get(vertex).size();i++)
		{
			if(!visited[edgeslist.get(vertex).get(i)])
			{
				
				dfs(edgeslist,edgeslist.get(vertex).get(i),visited,set1);
			}
		}
		
	}
	

}
