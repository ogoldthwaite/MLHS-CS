package coolGraph;

import java.util.*;

public class myGraph 
{
	private ArrayList<Vertex> vertList;
	private Set<Integer> valSet;

	public myGraph()
	{
		this.vertList = new ArrayList<Vertex>();
		valSet = new HashSet<Integer>();
	}

	public Vertex createVertex(int value)
	{
		Vertex newVert = new Vertex(value);
		return newVert;
	}

	public void addVertex(Vertex toAdd) //may need to check if the vertex is already there or not
	{
		if(!(valSet.contains(toAdd.value)))
		{
			System.out.println("Added" + toAdd.value);
			this.vertList.add(toAdd);
			valSet.add(toAdd.value);
		}
	}

	public boolean removeVertex(Vertex toRemove)
	{
		if(vertList.contains(toRemove))
			vertList.remove(toRemove);

		return true;
	}

	public List<Vertex> getNeighbors(Vertex toTest)
	{
		List<Vertex> neighbors = toTest.neighbors;
		return neighbors;
	}

	public boolean isAdjacent(Vertex x, Vertex y) //Only currently works for bidirectional graph
	{
		List<Vertex> neighbors = x.neighbors;

		if(neighbors.contains(y))
			return true;
		else
			return false;
	}

	public void addEdge(Vertex x, Vertex y)
	{
		if(!(x.neighbors.contains(y)))
			x.neighbors.add(y);

		if(!(y.neighbors.contains(x)))
			y.neighbors.add(x);
	}

	public boolean removeEdge(Vertex x, Vertex y)
	{
		x.neighbors.remove(y);
		y.neighbors.remove(x);

		return true;
	}

	public int getVertexValue(Vertex x)
	{
		return x.value;
	}

	public void setVertexValue(Vertex x, int value)
	{
		x.value = value;
	}
	
	public Vertex getVertex(int value)
	{
		Vertex temp = null;
		
		for(int i = 0; i < vertList.size(); i++)
			if(vertList.get(i).value == value)
				temp = vertList.get(i);
		
		return temp;
	}

	public String toString()
	{

		for(int i = 0; i < vertList.size(); i++)
		{
			System.out.print(vertList.get(i).value + ":");
			
			for(int j = 0; j < vertList.get(i).neighbors.size(); j++)
			{
				 System.out.print(vertList.get(i).neighbors.get(j).value +" ");
			}
			System.out.println();
		}
		return "";
	}




}
