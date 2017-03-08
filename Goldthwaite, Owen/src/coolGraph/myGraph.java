package coolGraph;

import java.util.*;

public class myGraph 
{
	private Vertex initial;
	private ArrayList<Vertex> vertList;

	public myGraph(Vertex coolVert)
	{
		this.initial = coolVert;
		this.vertList = new ArrayList<Vertex>();
		vertList.add(initial);
	}

	public Vertex createVertex(int value)
	{
		Vertex newVert = new Vertex(value);
		return newVert;
	}

	public void addVertex(Vertex toAdd) //may need to check if the vertex is already there or not
	{
		if(!(vertList.contains(toAdd)))
			this.vertList.add(toAdd);
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

	public String toString()
	{
		String toReturn = "";

		for(int i = 0; i < vertList.size(); i++)
		{
			toReturn += vertList.get(i).value;
			//change some stuff so this looks cooler
			
			for(int j = 0; j < vertList.get(i).neighbors.size(); j++)
			{
				toReturn += vertList.get(i).neighbors.get(j).value +"-";
			}

		}
		return toReturn;
	}




}
