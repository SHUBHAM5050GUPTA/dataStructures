package graph;

import java.util.*;

public class DetectCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		
		int V=s.nextInt();
		int E=s.nextInt();
		
		ArrayList<ArrayList<Integer>> edgelist=new ArrayList<>();
		
		for(int i=0;i<V;i++)
		{
			edgelist.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<E;i++)
		{
			int v1=s.nextInt();
			int v2=s.nextInt();
			edgelist.get(v1).add(v2);
			edgelist.get(v2).add(v1);
		}
		
		boolean result=detectCycle(edgelist,V);
		
		System.out.println(result);
		
		

	}
	
	public static boolean detectCycle(ArrayList<ArrayList<Integer>> edgelist,int V)
	{
		boolean visited[]=new boolean[V];
		
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
			{
				ArrayList<Integer> result1=new ArrayList<>();
				boolean result=dfs(edgelist,visited,0,0,result1);
				if(result)
				{
					for(int j:result1)
					{
						System.out.print(j);
					}
					return true;
				}
			}
			
			
			
		}
		
		return false;
	}
	
	public static boolean dfs(ArrayList<ArrayList<Integer>> edgelist,boolean[] visited,int parent,int vertex,ArrayList<Integer> arr)
	{
		visited[vertex]=true;
		for(int i=0;i<edgelist.get(vertex).size();i++)
		{
			if(edgelist.get(vertex).get(i)!=parent)
			{
				if(visited[edgelist.get(vertex).get(i)])
				{
					System.out.println(parent+""+vertex+" "+edgelist.get(vertex).get(i));
					arr.add(edgelist.get(vertex).get(i));
					return true;
				}
				boolean result=dfs(edgelist,visited,vertex,edgelist.get(vertex).get(i),arr);
				if(result)
				{
					arr.add(edgelist.get(vertex).get(i));
					return true;
				}
				
				
			}
		}
		return false;
	}
	

}
