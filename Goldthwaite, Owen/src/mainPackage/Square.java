package mainPackage;

import java.util.Scanner;

public class Square 
{
private int n=3; //Square size; Only works for n = 3 currently
private int[][] square = new int[n][n];

   public Square()
   {
	
   }
   public void add()
   {
	  System.out.println("Enter a "+n+" by "+n+" square!");
	  Scanner scan = new Scanner(System.in);
	   for(int m=0; m<square.length; m++)
	   {
		for(int k=0; k<square[0].length;k++)
		{
			square[m][k]=scan.nextInt();
		} 
   System.out.println(" ");
	 }
   }
   public boolean isMagic()
   {
	   int goodvalue = 0; int sum = 0;
	   boolean tester=true;
	   int[] appeared = new int[(n*n+1)];
	  for(int i=1; i<appeared.length; i++)
          appeared[i]=0;
	   for(int m=0; m<square.length; m++)
			for(int k=0; k<square[0].length; k++)
			{
	         if(square[m][k]<1 || square[m][k]>(n*n))
	        	 tester=false;
			appeared[square[m][k]]=+1;
			}
	   for(int o=1; o<appeared.length; o++)
		   if(appeared[o]!=1) 
			   tester=false;
	   
	   if (n==3) goodvalue=15; if (n==4) goodvalue=34; if (n==5) goodvalue=65; //row values for different square sizes
	   for(int m=0; m<square.length; m++)
	   {  sum=0;
			for(int k=0; k<square[0].length; k++)
			{
				sum+=square[m][k];   
			}
			 if(sum!=goodvalue) 
				 tester=false;
	   }
	   for(int k=0; k<square.length; k++)
	   {  sum=0;
			for(int m=0; m<square[0].length; m++)
			{
				sum+=square[m][k];   
			}
			 if(sum!=goodvalue) 
				 tester=false;
	   }
	  if(square[0][0]+square[1][1]+square[2][2]!=goodvalue || square[0][2]+square[1][1]+square[2][0]!=15) //Only works for size 3 right now
		  tester=false;                                                 //Not sure to to implement working for all sizes

	   return tester;  
   }
   public void printTest() //not important
   {
	   System.out.println(square[1][2]);
   }
	
	
	
	
}



   