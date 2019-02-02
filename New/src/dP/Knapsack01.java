package dP;

public class Knapsack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] weight={6,1,2,4,5};
		int[] values={10,5,4,8,6};
		
		int W=5;
		
		int result=knapSackRec(weight,values,W);
		System.out.println(result);

	}

	private static int knapSackRec(int[] weight, int[] values, int W) {
		
		int i=0;
		return knapSack(weight,values,W,i);
	}

	private static int knapSack(int[] weight, int[] values, int W, int i) {
		
		if(i==weight.length||W==0)
		{
			return 0;
		}
		
		int result=0;
		
		if(weight[i]>W)
		{
			result= knapSack(weight,values,W,i+1);
		}
		else
		{
			
			
			
			int op1=values[i]+knapSack(weight,values,W-weight[i],i+1);
			
			int op2=knapSack(weight,values,W,i+1);
			
			result=Math.max(op1, op2);
			
			
		}
		
		return result;
		
	}

}
