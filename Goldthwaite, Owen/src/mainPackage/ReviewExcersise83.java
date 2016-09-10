package mainPackage;

public class ReviewExcersise83 {

	public static void main(String[] args) 
	{
	int[] maxminvalues = new int [2];
	maxminvalues=maxMin();	
		
	 System.out.print("Max Value is..");   System.out.println(maxminvalues[0]);  //max val
	 System.out.print("Min Value is..");   System.out.println(maxminvalues[1]);  //min val
	
	//MOVE THESE PRINT STATEMENT TO METHOD
	
	}

	public static int[] maxMin()
	{
	  int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE; int foo=0;
      int [] account = new int [10]; int[] maxminarr = new int [2];
        for(int i=0; i<account.length; i++)
        {
        account[i] = (int)(100*Math.random());
        if (account[i]>max) max = account[i];
        if (account[i]<min) min = account[i];
        }
		maxminarr[0]=max;
        maxminarr[1]=min;
      return maxminarr;  
	}
	
	
	public static void stringLoop()
	{
	   
		
	}
	
	
}
// ARRAYLIST SYNTAX   ArrayList <Type> <ListName> = new ArrayList <Type> ();