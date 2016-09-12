package mainPackage;
import java.util.*;
public class ReviewExersiceChap8 {

	public static void main(String[] args)       // Non-Code review questions in comments at bottom of this page
	{
   Purse purseOne = new Purse(); Purse purseTwo = new Purse();
   Square squareOne = new Square();
   MagicSquare magicSquareOne = new MagicSquare(3);
   Scanner scan = new Scanner(System.in);
		System.out.println("1 for Review 8.3, 2 for Review 8.4, 3 for Program 8.2, 4 for Program 8.3");
		System.out.print("5 for Program 8.4, 6 for Program 8.5, 7 for Program 8.6, 8 for Program 8.18, 9 for Program 8.19:  ");
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
	     purseOne.addCoin("Quarter"); 
	     purseOne.addCoin("Nickel");   
	     
	     purseOne.addCoin("Dime");  
	     purseOne.addCoin("Penny"); 
	      
	  	   purseOne.transfer(purseTwo);
	  	   System.out.println(purseOne.toString());
	    }
	    if (foo==6)
	    {
	    	purseOne.addCoin("Quarter"); 
	    	purseOne.addCoin("Dime"); 
	    	purseOne.addCoin("Nickel");  
	    	
	    	purseTwo.addCoin("Quarter");  
	    	purseTwo.addCoin("Dime"); 
	    	purseTwo.addCoin("Nickel");  
	    purseOne.sameContents(purseTwo);
	    System.out.println( purseOne.sameContents(purseTwo));
	    }
	    if (foo==7)
	    {
	    	purseOne.addCoin("Quarter"); 
	    	purseOne.addCoin("Dime"); 
	    	purseOne.addCoin("Nickel");  
	    	
	    	purseTwo.addCoin("Quarter");  
	    	purseTwo.addCoin("Dime"); 
	    	purseTwo.addCoin("Nickel");  
	    purseOne.sameCoins(purseTwo);
	    System.out.println( purseOne.sameCoins(purseTwo));
	    }
	    if (foo==8)
	    {  
	    	squareOne.add();
	    	//squareOne.printTest();
	    	System.out.println(squareOne.isMagic());
	    }
	    if (foo==9)
	    {
	    	magicSquareOne.createSquare();
	    	magicSquareOne.toString();
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

/* R8.10 - Not really sure what to do for this one.
 *
 * R8.5 - This method is less efficient because you have to test if LargestYet is null everytime the loop actually loops. This is an
 * pointless thing to do as it can be easily stopped by using the original method or setting largest yet to MIN.VALUE
 * R8.6 - I'm not positive, but I'm guessing it has something to do with the fact that the value x is most likely an int while max is a
 * double. This means that whenever you set max = x it loses precision that it would've had otherwise.
 * 8.11 - A: for(int x=0; x<data.length; x++) sum = sum + x
 * 	      B: for(int x=0; x<data.length; x++) if(x==target) return true;
 *        C: int i = 0;
 *           for(int x=0; x<data.length; x++) {data[i]=2*x; i++}
 * 8.12 - A: for(int i : data) sum=sum+data[i]
 *        B: int i = 1;
 *           for(i : data) sum=sum+data[i];
 *        C: for(int i : data) if (data[i]==target} return i;         
 * 8.13 - A: Any constructor that takes an array of integers as a parameter
 * 		  B: A method that takes in an array of accounts for example and makes a modification to each one, much more efficient than
 *           not using an array
 *        C: A method to that returns takes say the amount of people attending a play and then returns a list of possible seats
 * 8.15 - A: Parallel arrays are arrays that store related information and are the same size, but are separate from one another,
 *           they are an indicator of bad programming because they make it a lot less efficient to locate necessary information.
 *           They can be avoided by using more classes and structure to better maintain data. Or use 2D arrays
 * 8.16 - A: Just use a if statement in a for loop to compare each location in the array.
 *        B: In a for loop just set array1[var] = to array2[var]
 *        C: Same thing as B but use 0 instead of array2
 *        D: Just use ArrayList.clear();
 * 8.17 - A: True; B: True; C: False; D: True; E: True; F: False; G: True; H: False; I: False;
 * 8.18 - A: False; B: False; C: True; D: True;
 *            
 *                       
 *                       
 *                       */




