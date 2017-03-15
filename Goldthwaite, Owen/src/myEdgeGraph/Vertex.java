package myEdgeGraph;

import java.util.ArrayList;

public class Vertex 
{
	public int value;
	public int distance;
	public ArrayList<Vertex> neighbors;

	public Vertex(int val)
	{
		value = val;
		distance = Integer.MAX_VALUE;
		neighbors = new ArrayList<Vertex>();
	}




}
