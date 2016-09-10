package mainPackage;
import java.util.*;
public class ReviewExersiceChap8 {

	public static void main(String[] args)       // REVIEW 8.10 HELP?
	{
   Purse purseOne = new Purse(); Purse purseTwo = new Purse();
   Scanner scan = new Scanner(System.in);
		System.out.print("1 for Review 8.3, 2 for Review 8.4, 3 for Program 8.2, 4 for Program 8.3: ");
	    int foo=scan.nextInt();
		if (foo==1) maxMin();	
	    if (foo==2) stringLoop();
	    if (foo==3) 
	    {
	    for(int b=0; b<=5; b++) 
	      purseOne.addCoin(scan.nextLine());
	      
	       System.out.println(purseOne.toString());
	    }
	    if (foo==4)
	    {
	     for(int b=0; b<=5; b++) 
	  	   purseOne.addCoin(scan.nextLine());
	       System.out.println("Normal Order " + purseOne.toString());
	  	   purseOne.reverse();
	  	   System.out.println("Reverse Order " + purseOne.toString());
	    }
	    if (foo==5)
	    {
	     System.out.println("2 things for first purse!");
	     for(int k=0; k<=2; k++) 
	     { 
	    	purseOne.addCoin(scan.nextLine()); 
	     }
	     System.out.println("3 things for second purse!"); 
	     for(int b=0; b<=2; b++) 
	     { purseTwo.addCoin(scan.nextLine()); }
	       System.out.println("Normal Order " + purseTwo.toString());
	  	   purseOne.transfer(purseTwo);
	    }
	    if (foo==6)
	    {
	    // System.out.print("2 things for first purse!");
	     for(int k=0; k<2; k++) 
	         {  
	    	 String a = scan.nextLine();
	    	 purseOne.addCoin(a); 
	         }
	    // System.out.print("3 things for second purse!"); 
	     for(int b=0; b<2; b++) 
	  	     { 
	    	 String a = scan.nextLine();
	    	 purseTwo.addCoin(a); 
	    	 }
	      // System.out.println("Normal Order " + purseTwo.toString());
	  	   purseOne.sameContents(purseTwo);
	    }
	    
	    
	}
	public static void maxMin()
	{
	  int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
      int [] account = new int [10]; int[] maxminarr = new int [2];
        for(int i=0; i<account.length; i++)
        {
        account[i] = (int)(100*Math.random());
        if (account[i]>max) max = account[i];
        if (account[i]<min) min = account[i];
        }
		maxminarr[0]=max;
        maxminarr[1]=min;
        System.out.print("Max Value is..");   System.out.println(maxminarr[0]);  //max val
   	    System.out.print("Min Value is..");   System.out.println(maxminarr[1]);  //min val
	}
	
	
	public static void stringLoop()
	{
	   ArrayList<String> dankstrings = new ArrayList <String>();
	   Scanner loopadd = new Scanner(System.in);
       System.out.println("Enter 10 Strings!!!");
	     for(int a=0; a<10; a++)
	     {
	    	 dankstrings.add(loopadd.nextLine());
	     }
	     for(int c=dankstrings.size()-1; c>=0; c--)
	     {
	    	 System.out.println(dankstrings.get(c));
	     }
	}
	
	
}
// ARRAYLIST SYNTAX   ArrayList <Type> <ListName> = new ArrayList <Type> ();