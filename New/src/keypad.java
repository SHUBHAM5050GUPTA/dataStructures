import java.util.Scanner;


public class keypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String result[]=keypad(n);
		for(String i:result)
		{
			System.out.println(i);
		}

	}
	
	
	public static String[] keypad(int n){
		// Write your code here

      String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
      
      String[] result=keypad(n+"",arr);
      return result;
      
      
      
	}
  public static String[] keypad(String s,String[] arr)
  {
    
    
    if(s.length()==1)
    {
    	int i=Integer.parseInt(s.charAt(0)+"");
      String arr1[]=arr[i].split("");
      return arr1;
    }
    
    String subresult[]=keypad(s.substring(1),arr);
    
    String str=arr[Integer.parseInt(s.charAt(0)+"")];
    
    String[] result=new String[str.length()*subresult.length];
    
    int count=0;
    for(int i=0;i<str.length();i++)
    {
      
      for(int j=0;j<subresult.length;j++)
      {
        result[count]=str.charAt(i)+subresult[j];
        count++;
      }
    }
    return result;
    
    
  }

}
