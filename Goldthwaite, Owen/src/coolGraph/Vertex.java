package coolGraph;

import java.util.ArrayList;

public class Vertex 
{
	public int value;
	public ArrayList<Vertex> neighbors;
	
	public Vertex(int val)
	{
		value = val;
		neighbors = new ArrayList<Vertex>();
	}


	
	
}
