package mainPackage;

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
		int row=0; int col=0; int newval=2;
		if(n%2 != 0)
		{
		    row=n-1; col=n/2;
		    square[row][col]=1;
		  for(int k=2; k<=n*n; k++)
		  {
			if(square[row+1][col+1]==0)
			{
				row=row+1;                   //Ask Mr. Horn!
				col=col+1;
			} 
			else
			 row = row-1;
			
		  square[row][col] = newval;
		  }

		}
	}
	public String toString()
	{
		for(int m=0; m<square.length; m++)
			for(int k=0; k<square[0].length;k++)
			{
				System.out.println(square[m][k]);
			} 
		
		return null;
	}
	
	
	
	
}
