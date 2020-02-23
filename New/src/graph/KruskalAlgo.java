package graph;

import java.util.Scanner;

import java.util.*;

public class KruskalAlgo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        ArrayList<Edges> list=new ArrayList<>();
        for(int i=0;i<E;i++)
        {
            Edges e=new Edges();
            e.v1=s.nextInt();
            e.v2=s.nextInt();
            e.w=s.nextInt();
            list.add(e);
            

        }
        
        Collections.sort(list,new Comparator<Edges>()
                        {
                            public int compare(Edges e1,Edges e2)
                            {
                                return e1.w-e2.w;
                            }
                        });
        
        int parent[]=new int[V];
        
        for(int i=0;i<V;i++)
        {
            parent[i]=i;
        }
        
        int count=1;
        
        
        ArrayList<Edges> result=new ArrayList<>();
       for(int i=0;i<list.size();i++)
       {
           if(count==V)
           {
               break;
           }
           
           int v1=list.get(i).v1;
           int v2=list.get(i).v2;
           
           int top_parent_v1=topParent(v1,parent);
           int top_parent_v2=topParent(v2,parent);
           
           if(top_parent_v1!=top_parent_v2)
           {
               result.add(list.get(i));
               parent[top_parent_v2]=top_parent_v1;
               count++;
           }
           
       }
        
        for(int i=0;i<result.size();i++)
        {
            System.out.println(result.get(i).v1+" "+result.get(i).v2+" "+result.get(i).w);
        }
        
        
	}
    
    public static int topParent(int v,int[] parent)
    {
       while(v!=parent[v])
       {
           v=parent[v];
       }
        
        return v;
    }
    
}

class Edges
{
    int v1;
    int v2;
    int w;
}
