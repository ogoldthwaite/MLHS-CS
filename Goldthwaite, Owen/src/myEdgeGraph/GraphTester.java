package myEdgeGraph;

public class GraphTester {

	public static void main(String[] args) 
	{
		edgeGraph eGraph = new edgeGraph();

		Vertex a = eGraph.createVertex(1);
		Vertex b = eGraph.createVertex(2);
		Vertex c = eGraph.createVertex(3);
		Vertex d = eGraph.createVertex(1);

		eGraph.addVertex(a);
		eGraph.addVertex(b);
		eGraph.addVertex(c);
		eGraph.addVertex(d);

		System.out.println(eGraph.getVertexValue(a));

		eGraph.addEdge(a, b, 100);
		eGraph.addEdge(a, c, 200);
		eGraph.addEdge(b, c, 300);

		eGraph.toString();

		System.out.println(eGraph.getEdgeValue(a, b));
		System.out.println(eGraph.getEdgeValue(a, c));
		System.out.println(eGraph.getEdgeValue(b, c));
		eGraph.setEdgeValue(a, b, 500);
		System.out.println(eGraph.getEdgeValue(a, b));
		System.out.println(eGraph.isAdjacent(a, b));
		eGraph.removeEdge(a, b);
		System.out.println(eGraph.isAdjacent(a, b));

		eGraph.toString();

	}

}
