package myEdgeGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class edgeGraph 
{
	private ArrayList<Vertex> vertList;
	private ArrayList<Edge> edgeList;
	private Set<Integer> valSet; 

	public edgeGraph()
	{
		this.vertList = new ArrayList<Vertex>();
		this.edgeList = new ArrayList<Edge>();
		this.valSet = new HashSet<Integer>();
	}

	public Vertex createVertex(int value)
	{
		Vertex newVert = new Vertex(value);
		return newVert;
	}

	public void addVertex(Vertex toAdd) 
	{
		if(!(valSet.contains(toAdd.value))) //makes sure each vertex is different
		{
			System.out.println("Added " + toAdd.value);
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

	public void addEdge(Vertex x, Vertex y, int weight)
	{
		if(!(x.neighbors.contains(y)))
			x.neighbors.add(y);

//		if(!(y.neighbors.contains(x)))  //COMMENT OUT FOR DIRECTIONAL!!!
//			y.neighbors.add(x);

		Edge temp = new Edge(x, y, weight);
		edgeList.add(temp);	
	}

	public boolean removeEdge(Vertex x, Vertex y) //Removes if directional no matter which way vertices are put in, change?
	{
		x.neighbors.remove(y);    
		y.neighbors.remove(x);

		edgeList.remove(getEdge(x, y));
		return true;
	}

	public int getVertexValue(Vertex x) //Maybe change so only returns if vertex is in graph, but maybe no ;)
	{		
		return x.value;
	}

	public void setVertexValue(Vertex x, int value)
	{
		x.value = value;
	}

	public int getEdgeValue(Vertex a, Vertex b)
	{
		return getEdge(a,b).weight;
	}

	public void setEdgeValue(Vertex a, Vertex b, int value)
	{
		getEdge(a,b).weight = value;
	}

	public Vertex getVertex(int value)
	{
		Vertex temp = null;

		for(int i = 0; i < vertList.size(); i++)
			if(vertList.get(i).value == value)
				temp = vertList.get(i);

		return temp;
	}

	public Edge getEdge(Vertex a, Vertex b)
	{
		Edge temp = null;

		for(int i = 0; i < edgeList.size(); i++)
		{
			if( (edgeList.get(i).conA.equals(a)) && (edgeList.get(i).conB.equals(b)) )
				temp = edgeList.get(i);
		}

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