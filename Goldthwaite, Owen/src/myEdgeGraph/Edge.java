package myEdgeGraph;

public class Edge 
{
	public int weight;
	public Vertex conA;
	public Vertex conB;

	public Edge(Vertex a, Vertex b, int value)
	{
		conA = a;
		conB = b;
		weight = value;
	}

}
