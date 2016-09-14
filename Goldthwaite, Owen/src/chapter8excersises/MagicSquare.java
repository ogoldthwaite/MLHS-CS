package chapter8excersises;

public class MagicSquare 
{
private int n;
private int[][] square;
	
	public MagicSquare(int size)
	{
		n=size;
		square = new int[n][n];
	}
	public void createSquare()
	{
		int row=0; int col=0; int newval=2; int temprow, tempcol = 0;
		if(n%2 != 0)
		{
		    row=n-1; col=n/2;
		    square[row][col]=1;
		  for(int k=2; k<=n*n; k++)
		  {
			temprow=row; tempcol=col;
			if((row<square.length && col<square[0].length))
			{
				row=row+1;                   
				col=col+1;	
				if(row>=square.length)                       //Works EXCEPT for top left to bottom right diagonal. 
			    	row=0;									 //Not sure where my error lies...
			    if(col>=square[0].length)
			    	col=0;
			    if(square[row][col] != 0)
			    {
			    	row=temprow-1;
			    }
			} 
		  square[row][col] = newval;
		  newval++;
		  }

		}
	}
	public String toString()                 //Currently used for testing purposes
	{
		for(int m=0; m<square.length; m++)
		{
			for(int k=0; k<square[0].length;k++)
			{
				if(square[m][k] < 10) System.out.print(" ");
				System.out.print(square[m][k]+" ");
			} 
		System.out.println(" ");
		}
		return null;
	}
	
	
	
	
}
