package tree;

import java.util.Scanner;

import Default.QueueEmptyException;
import Default.QueueFullException;
import Default.QueueUsingArray;

public class TreePractice {
	
	public static void inOrder(TreeNode<Integer> root)
	{
		//Only possible in binary tree
		
	}
	
	
	
	public static void postOrder(TreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		
		for(int i=0;i<root.children.size();i++)
		{
			postOrder(root.children.get(i));
		}
		
		System.out.print(root.data+" ");
	}
	
	
	public static void  preOrder(TreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		
		System.out.print(root.data+" ");
		for(int i=0;i<root.children.size();i++)
		{
			preOrder(root.children.get(i));
		}
	}
	
	public static void printLeaf(TreeNode<Integer> root)
	{
		if(root.children.size()==0)
		{
			System.out.print(+root.data+" ");
			return;
		}
		
		for(int i=0;i<root.children.size();i++)
		{
			printLeaf(root.children.get(i));
		}
		
	}
	
	public static void printNodeAtk(TreeNode<Integer> root,int k)
	{
		if(k<0)
		{
			return;
		}
		if(k==0)
		{
			System.out.print(root.data+" ");
			return;
		}
		
		
		for(int i=0;i<root.children.size();i++)
		{
			printNodeAtk(root.children.get(i),k-1);
		}
	}
	
	public static void printTree(TreeNode<Integer> root)
	{
		System.out.print(root.data+":");
		
		for(int i=0;i<root.children.size();i++)
		{
			System.out.print(+root.children.get(i).data+",");
		
		}
		System.out.println();
		
		for(int i=0;i<root.children.size();i++)
		{
			printTree(root.children.get(i));
		
		}
	}
	
	public static TreeNode<Integer> takeInput()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the data of node");
		int data=s.nextInt();
		TreeNode<Integer> root= new TreeNode<>(data);
		System.out.println("Enter the no. of children of node");
		int childNo=s.nextInt();
		
		for(int i=0;i<childNo;i++)
		{
			TreeNode<Integer> child=takeInput();
			root.children.add(child);
		}
		
		return root;
	}
	
	public static TreeNode<Integer> takeInputLevelWise()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the root");
		int rootData=s.nextInt();
		TreeNode<Integer> root=new TreeNode<Integer>(rootData);
		QueueUsingArray<TreeNode<Integer>> pendingQueue=new QueueUsingArray<TreeNode<Integer>>(20);
		try {
			pendingQueue.enqueue(root);
			while(!pendingQueue.isEmpty())
			{
				try {
					TreeNode<Integer> node=pendingQueue.dequeue();
					System.out.println("Enter the no of children of "+node.data+"th "+"node");
					int noOfChildren=s.nextInt();
					for(int i=0;i<noOfChildren;i++)
					{
						System.out.println("Enter the "+(i+1)+"th children");
						int childData=s.nextInt();
						TreeNode<Integer> childNode=new TreeNode<Integer>(childData);
						node.children.add(childNode);
						pendingQueue.enqueue(childNode);
					}
					
				} catch (QueueEmptyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
			
		} catch (QueueFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return root;
	}

	public static void printLevelWise(TreeNode<Integer> root)
	{
		QueueUsingArray<TreeNode<Integer>> pendingQueue=new QueueUsingArray<TreeNode<Integer>>(20);
		try {
			pendingQueue.enqueue(root);
			while(!pendingQueue.isEmpty())
			{
				try {
					TreeNode<Integer> node=pendingQueue.dequeue();
					System.out.print(node.data+":");
					for(int i=0;i<node.children.size();i++)
					{
						pendingQueue.enqueue(node.children.get(i));
						System.out.print(node.children.get(i).data+",");
					}
					System.out.println();
					
				} catch (QueueEmptyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (QueueFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int  countNoOfNodes(TreeNode<Integer> root)
	{
		int count =0;
		
		if(root==null)
		{
			return 0;
		}
		/*if(root.children.size()==0)
		{
			return 0;
		}*/
		//count=root.children.size();
		for(int i=0;i<root.children.size();i++)
		{
			count =count+countNoOfNodes(root.children.get(i));
		}
		//count=count+root.children.size();
		return count+1;
	}
	
	public static int largestNode(TreeNode<Integer> root)
	{
		int max=0;
		int childrenMax=0;
		for(int i=0;i<root.children.size();i++)
		{
			 int childMax=largestNode(root.children.get(i));
			 if(childMax>childrenMax)
			 {
				 childrenMax=childMax;
			 }
		}
		if(root.data>childrenMax)
		{
			max=root.data;
		}
		else
		{
			max=childrenMax;
		}
		return max;
	}
	
	public static int height(TreeNode<Integer> root)
	{
		int height=0;
		int childMaxHeight=0;
		
		for(int i=0;i<root.children.size();i++)
		{
			int childHeight=height(root.children.get(i));
			if(childHeight>childMaxHeight)
			{
				childMaxHeight=childHeight;
			}
		}
		return childMaxHeight+1;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode<Integer> root =new TreeNode<>(1);
		TreeNode<Integer> node1 =new TreeNode<>(2);
		TreeNode<Integer> node2 =new TreeNode<>(3);
		TreeNode<Integer> node3 =new TreeNode<>(4);
		TreeNode<Integer> node4 =new TreeNode<>(5);
		TreeNode<Integer> node5 =new TreeNode<>(6);
		TreeNode<Integer> node6 =new TreeNode<>(7);
		TreeNode<Integer> node7 =new TreeNode<>(8);
		TreeNode<Integer> node8 =new TreeNode<>(9);
		TreeNode<Integer> node9 =new TreeNode<>(10);
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		root.children.add(node8);
		node1.children.add(node4);
		node2.children.add(node5);
		node3.children.add(node6);
		node5.children.add(node7);
		node7.children.add(node9);
		
		//System.out.println(root.data);
		
		//TreeNode<Integer> root=takeInputLevelWise();
		
		//printLevelWise(root);
		
	//	int result=countNoOfNodes(root);
		
	//	int result=largestNode(root);
		
	//	int result=height(root);
	//	System.out.println(result);
		
	//	printNodeAtk(root,2);
		
	//	printLeaf(root);
		
	//	preOrder(root);
		
		postOrder(null);
	}
	
	

}
