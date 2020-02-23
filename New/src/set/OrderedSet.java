package set;

import java.util.Scanner;
import java.util.SortedSet; 
import java.util.TreeSet;

public class OrderedSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Scanner s=new Scanner(System.in);
		
		SortedSet<Integer> set1=new TreeSet<>();
		set1.add(8);
		set1.add(5);
		set1.add(9);
		set1.add(1);
		set1.add(2);
		
		SortedSet<Integer> set2=set1.headSet(5);
		System.out.println(set2);
		SortedSet<Integer> set3=set1.tailSet(4);
		System.out.println(set3);
		
		System.out.println(set1.contains(4));
		
		if(!set3.isEmpty())
		{
			System.out.println(set3.first());
		}else
		{
			System.out.println(-1);
		}*/
		
		Scanner s=new Scanner(System.in);
		int n=10;
		int q=5;
		SortedSet<Long> set=new TreeSet<>();
		long ans=0;
		for(int i=0;i<q;i++)
		{
			int x=s.nextInt();
			long result=fin(x,n,set);
			ans=ans+result;
			System.out.println(ans);
		}

	}
	
	public static long fin(long x,long n,SortedSet<Long> set)
	{
		if(x>n)
		{
			return 0l;
		}
		
		if(set.contains(x))
		{
			return 0l;
		}
		
		set.add(x);
		if(set.size()==1)
		{
			return n+1;
		}
		
		long ans=0;
		if(set.first()==x)
		{
			SortedSet<Long> set2=set.tailSet(x+1);
			ans=set2.first()+x;
		}
		else if(set.last()==x)
		{
			SortedSet<Long> set2=set.headSet(x);
			ans= set2.last()+x;
		}
		else
		{
			ans=x+x;
		}
		return ans;
	}
	

}
