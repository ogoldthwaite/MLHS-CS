package myEdgeGraph;

public class GraphTester {

	public static void main(String[] args) 
	{
		edgeGraph eGraph = new edgeGraph();

		Vertex a = eGraph.createVertex(1);
		Vertex b = eGraph.createVertex(2);
		Vertex c = eGraph.createVertex(3);
		Vertex d = eGraph.createVertex(4);
		Vertex e = eGraph.createVertex(5);

		eGraph.addVertex(a);
		eGraph.addVertex(b);
		eGraph.addVertex(c);
		eGraph.addVertex(d);
		eGraph.addVertex(e);
		
		eGraph.addEdge(a, b, 1);
		eGraph.addEdge(a, c, 3);
		eGraph.addEdge(b, c, 1);
		eGraph.addEdge(c, d, 3);
		eGraph.addEdge(b, e, 5);
		eGraph.addEdge(d, e, 4);
		
		System.out.println(eGraph.isAdjacent(c, b));
		//System.out.println(b.distance);
		
		eGraph.setDistances(a);
		
		System.out.println();
		
		for(int i = 0; i < c.shortestPath.size(); i++)
			System.out.println(c.shortestPath.get(i).value + " z");
		
		System.out.println();
		System.out.println(a.distance);
		System.out.println(b.distance);
		System.out.println(c.distance);
		System.out.println(d.distance);
		System.out.println(e.distance);

//		System.out.println(eGraph.getVertexValue(a));
//
//		eGraph.addEdge(a, b, 100);
//		eGraph.addEdge(a, c, 200);
//		eGraph.addEdge(b, c, 300);
//
//		eGraph.toString();
//
//		System.out.println(eGraph.getEdgeValue(a, b));
//		System.out.println(eGraph.getEdgeValue(a, c));
//		System.out.println(eGraph.getEdgeValue(b, c));
//		eGraph.setEdgeValue(a, b, 500);
//		System.out.println(eGraph.getEdgeValue(a, b));
//		System.out.println(eGraph.isAdjacent(a, b));
//		eGraph.removeEdge(a, b);
//		System.out.println(eGraph.isAdjacent(a, b));
//
//		eGraph.toString();

	}

}
