package myEdgeGraph;

import java.util.*;

public class edgeGraph 
{
	private ArrayList<Vertex> vertList;
	private ArrayList<Edge> edgeList;
	private Set<Integer> valSet; 
	private PriorityQueue<Vertex> unvisited;

	public edgeGraph()
	{
		this.vertList = new ArrayList<Vertex>();
		this.edgeList = new ArrayList<Edge>();
		this.valSet = new HashSet<Integer>();
		this.unvisited = new PriorityQueue<Vertex>();
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

	public boolean isAdjacent(Vertex x, Vertex y) 
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

	public void setDistances(Vertex initial)
	{		
		for(Vertex vert : vertList)
		{
			vert.distance = Integer.MAX_VALUE;
		}
		initial.distance = 0;
		initial.shortestPath.add(initial);

		unvisited.addAll(vertList);

		Vertex closest = new Vertex(-1);
		setDistancesPriv(initial, closest);
	}

	private void setDistancesPriv(Vertex initial, Vertex closest)
	{

		for(int i = 0; i < initial.neighbors.size(); i++)
		{
			Vertex temp = initial.neighbors.get(i);

			if(temp.distance > (initial.distance + getEdgeValue(initial, temp)))
			{	
				initial.neighbors.get(i).distance = initial.distance + getEdgeValue(initial, temp);

				initial.neighbors.get(i).shortestPath.clear();
				initial.neighbors.get(i).shortestPath.addAll(initial.shortestPath);

				initial.neighbors.get(i).shortestPath.add(initial.neighbors.get(i)); 

			}

			if(unvisited.contains(initial))
			{
				unvisited.remove(initial);
				setDistancesPriv(initial.neighbors.get(i), closest);
			}
		}

	}

	public List<Integer> getShortestPath(Vertex v)
	{
		List<Integer> toReturn = new LinkedList<Integer>();

		for(Vertex a : v.shortestPath)
			toReturn.add(a.value);

		return toReturn;
	}

	public void printDistances()
	{
		for(Vertex v : vertList)
			System.out.println(v.distance);
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
