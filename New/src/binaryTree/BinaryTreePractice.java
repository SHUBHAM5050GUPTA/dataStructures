package binaryTree;

import java.util.Scanner;

import Default.QueueEmptyException;
import Default.QueueFullException;
import Default.QueueUsingArray;

public class BinaryTreePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		/*BinaryTreeNode<Integer> root=takeInput(s);
		print(root); */
		
		
		//BinaryTreeNode<Integer> root=takeInputLevelWise();
		//printLevelWise(root);
		
		
		
		/*BinaryTreeNode<Integer> root=takeInput2(s);
		printInput2(root); */
		
		BinaryTreeNode<Integer> root=takeInputLevel2(s);
		printLevel2(root);
	}
	
	
	
	 public static BinaryTreeNode<Integer> takeInput2 (Scanner s) {

	        System.out.println("Enter the root data:");
	        int data=s.nextInt();
	        if(data==-1)
	        {
	            return null;
	        }

	       BinaryTreeNode<Integer> root=new BinaryTreeNode<>(data);
	       root.left=takeInput2(s);
	       root.right= takeInput2(s);
	       return root;

	    }

	 public static void  printInput2(BinaryTreeNode<Integer> root)
	    {
	        if(root==null)
	        {
	            return ;
	        }
	        
	        String str=root.data+":";
	        
	        if(root.left!=null)
	        {
	        	str=str+"L:"+root.left.data+",";
	        	
	        }
	        
	        if(root.right!=null)
	        {
	        	str=str+"R:"+root.right.data;
	        	
	        }
	        
	        System.out.println(str);
	        printInput2(root.left);
	        printInput2(root.right);

	    }

	 public static BinaryTreeNode<Integer> takeInputLevel2(Scanner s)
	    {
	    	
	    	System.out.println("Enter the root data");
	    	int rootData=s.nextInt();
	    	if(rootData==-1)
	    	{
	    		return null;
	    	}
	    	BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
	    	
	    	QueueUsingArray<BinaryTreeNode<Integer>> pendingNodes=new QueueUsingArray<>();
	    	
	    	try {
				pendingNodes.enqueue(root);
				
				while(!pendingNodes.isEmpty())
		    	{
		    		try {
						BinaryTreeNode<Integer> node=pendingNodes.dequeue();
						
						System.out.println("Enter the " +node.data+" left children");
						int leftData=s.nextInt();
						System.out.println("Enter the " +node.data+" right children");
						int rightData=s.nextInt();
			    		if(leftData!=-1)
			    		{
			    			BinaryTreeNode<Integer> leftNode=new BinaryTreeNode<>(leftData);
			    			pendingNodes.enqueue(leftNode);
			    			
			    			node.left=leftNode;
			    			
			    		}
			    		if(rightData!=-1)
			    		{
			    			BinaryTreeNode<Integer> rightNode=new BinaryTreeNode<>(rightData);
			    			pendingNodes.enqueue(rightNode);
			    			
			    			node.right=rightNode;
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
	
	public static void printLevel2(BinaryTreeNode<Integer> root) 
	{
		
		QueueUsingArray<BinaryTreeNode<Integer>> pendingNodes=new QueueUsingArray<>();
		
		try {
			pendingNodes.enqueue(root);
			
			while(!pendingNodes.isEmpty())
			{
				BinaryTreeNode<Integer> node;
				try {
					node = pendingNodes.dequeue();
					
					String str=node.data+"";
					
					if(node.left!=null)
					{
						pendingNodes.enqueue(node.left);
						str=str+"L:"+node.left.data+",";
					}
					
					if(node.right!=null)
					{
						pendingNodes.enqueue(node.right);
						str=str+"R:"+node.right.data;
					}
					
				  System.out.println(str)	;
					
					
					
					
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
	
	public static BinaryTreeNode<Integer> takeInput(Scanner s)
	{
		System.out.println("Enter the node data");
		int rootData=s.nextInt();
		
		if(rootData==-1)
		{
			return null;
		}
		BinaryTreeNode<Integer> root =new BinaryTreeNode<Integer>(rootData);
		root.left=takeInput(s);
		root.right=takeInput(s);
		return root;
		
		
	}
	
	public static void print(BinaryTreeNode<Integer> root )
	{
		if(root==null)
		{
			return;
		}
		String printData=root.data+":";
		if(root.left!=null)
		{
			printData=printData+"L:"+root.left.data+", ";
		}
		if(root.right!=null)
		{
			printData=printData+"R:"+root.right.data+",";
		}
		System.out.println(printData);
		print(root.left);
		print(root.right);
	}

	public static BinaryTreeNode<Integer> takeInputLevelWise()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the root");
		int rootData=s.nextInt();
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
		QueueUsingArray<BinaryTreeNode<Integer>> pendingNode=new QueueUsingArray<BinaryTreeNode<Integer>>(20);
		try {
			pendingNode.enqueue(root);
			while(!pendingNode.isEmpty())
			{
				try {
					BinaryTreeNode<Integer> node=pendingNode.dequeue();

					System.out.println("Enter the "+node.data+"  left children");
					int leftData=s.nextInt();
					BinaryTreeNode<Integer> leftChild=new BinaryTreeNode<Integer>(leftData);
					System.out.println("Enter the "+node.data+"  right children");
					int rightData=s.nextInt();
					BinaryTreeNode<Integer> rightChild=new BinaryTreeNode<Integer>(rightData);
					if(leftData!=-1)
					{
						pendingNode.enqueue(leftChild);
						node.left=leftChild;
					}

					if(rightData!=-1)
					{
						pendingNode.enqueue(rightChild);
						node.right=rightChild;
					}

				} catch (QueueEmptyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		catch (QueueFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return root;

	}
		
	public static void printLevelWise(BinaryTreeNode<Integer> root)
	{
		QueueUsingArray<BinaryTreeNode<Integer>> pendingNodes=new QueueUsingArray(20);
		try {
			pendingNodes.enqueue(root);
			while(!pendingNodes.isEmpty())
			{
				try {
					BinaryTreeNode<Integer> node=pendingNodes.dequeue();
					
					String s=node.data+": ";
					if(node.left!=null)
					{
						pendingNodes.enqueue(node.left);
						s=s+"L:"+node.left.data+", ";
					}
					if(node.right!=null)
					{
						pendingNodes.enqueue(node.right);
						s=s+"R:"+node.right.data;
					}
					System.out.println(s);
					
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

}
