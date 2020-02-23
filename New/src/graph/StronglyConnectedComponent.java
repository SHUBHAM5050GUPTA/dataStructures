package graph;

import java.util.*;

public class StronglyConnectedComponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Scanner s=new Scanner(System.in);
		int V=s.nextInt();
		int E=s.nextInt();

		ArrayList<ArrayList<Integer>> edgelist=new ArrayList<>();
		ArrayList<ArrayList<Integer>> rev_edgelist=new ArrayList<>();

		for(int i=0;i<V;i++)
		{
			edgelist.add(new ArrayList<Integer>());
			rev_edgelist.add(new ArrayList<Integer>());
		}

		for(int i=0;i<E;i++)
		{
			int v1=s.nextInt();
			int v2=s.nextInt();

			edgelist.get(v1).add(v2);
			rev_edgelist.get(v2).add(v1);
		}

		ArrayList<HashSet<Integer>> result=stronglyConnComponent(edgelist,rev_edgelist,V);
		System.out.println(result.size());
		for(int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i));
		}*/
		indegree();


	}

	public static ArrayList<HashSet<Integer>> stronglyConnComponent(ArrayList<ArrayList<Integer>> edgelist,
			ArrayList<ArrayList<Integer>> rev_edgelist,int V)
			{
		boolean visited[]=new boolean[V];
		System.out.println();
		Stack<Integer> stack=new Stack<>();

		for(int i=0;i<V;i++)
		{
			if(!visited[i])
			{
				dfs(edgelist,visited,i,stack);

			}
		}

		visited=new boolean[V];

		ArrayList<HashSet<Integer>> result=new ArrayList<>();


		while(!stack.isEmpty())
		{
			int vertex=stack.pop();
			if(!visited[vertex])
			{
				HashSet<Integer> set1=new HashSet<Integer>();
				dfs_rev(rev_edgelist,visited,vertex,set1);
				result.add(set1);
			}

		}

		return result;

			}

	public static void dfs(ArrayList<ArrayList<Integer>> edgelist,boolean[] visited,int v1,Stack<Integer> stack)
	{
		visited[v1]=true;
		for(int i=0;i<edgelist.get(v1).size();i++)
		{
			if(!visited[edgelist.get(v1).get(i)])
			{
				dfs(edgelist,visited,edgelist.get(v1).get(i),stack);
			}
		}

		stack.push(v1);
	}

	public static void dfs_rev(ArrayList<ArrayList<Integer>> rev_edgelist,boolean[] visited,int v1,HashSet<Integer> set1)
	{
		visited[v1]=true;
		set1.add(v1);
		for(int i=0;i<rev_edgelist.get(v1).size();i++)
		{
			if(!visited[rev_edgelist.get(v1).get(i)])
			{
				dfs_rev(rev_edgelist,visited,rev_edgelist.get(v1).get(i),set1);
			}
		}


	}

	public static void indegree() {
		// Write your code here
		Scanner s=new Scanner(System.in);

		int t=s.nextInt();

		for(int k=0;k<t;k++)
		{

			int V=s.nextInt();
			int E=s.nextInt();

			ArrayList<ArrayList<Integer>> edgelist=new ArrayList<>();
			//  ArrayList<ArrayList<Integer>> edgelist_rev=new ArrayList<>();

			for(int i=0;i<V;i++)
			{
				edgelist.add(new ArrayList<Integer>());
				//  edgelist_rev.add(new ArrayList<Integer>());

			}

			for(int i=0;i<E;i++)
			{
				int v1=s.nextInt();
				int v2=s.nextInt();

				edgelist.get(v1-1).add(v2-1);
				//edgelist_rev.get(v2-1).add(v1-1);
			}

			int indegree[]=new int[V];


			for(int i=0;i<V;i++)
			{
				for(int j=0;j<edgelist.get(i).size();j++)
				{
					indegree[edgelist.get(i).get(j)]=indegree[edgelist.get(i).get(j)]+1;
				}
			}

			int count=0;  
			for(int i=0;i<V;i++)
			{
				if(indegree[i]==0)
				{
					count++;
				}
			}
			System.out.println(count);


		}

	}


}
