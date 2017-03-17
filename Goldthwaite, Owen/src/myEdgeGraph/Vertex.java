package myEdgeGraph;

import java.util.*;

public class Vertex implements Comparable<Vertex>
{
	public int value;
	public int distance;
	public List<Vertex> shortestPath;
	public ArrayList<Vertex> neighbors;

	public Vertex(int val)
	{
		value = val;
		distance = Integer.MAX_VALUE;
		neighbors = new ArrayList<Vertex>();
		shortestPath = new LinkedList<Vertex>();
	}

	public int compareTo(Vertex o) 
	{
		return this.distance - o.distance;
	}




}
