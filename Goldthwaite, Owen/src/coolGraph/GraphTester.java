package coolGraph;

public class GraphTester {

	public static void main(String[] args) 
	{
		Vertex a = new Vertex(1);
		
		myGraph graph = new myGraph(a);
		Vertex b = graph.createVertex(2);
		Vertex c = graph.createVertex(3);
		Vertex d = graph.createVertex(4);
		
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
				
		graph.addEdge(a, b);
		graph.addEdge(a, c);
		
		for(int i = 0; i < graph.getNeighbors(a).size(); i++)
			System.out.println(graph.getNeighbors(a).get(i).value);
		
		System.out.println();
		
		for(int i = 0; i < graph.getNeighbors(b).size(); i++)
			System.out.println(graph.getNeighbors(b).get(i).value);
		
		System.out.println(graph.isAdjacent(a, b));
		System.out.println(graph.isAdjacent(d, b));
		
		System.out.println();
		graph.removeEdge(a, c);
		
		System.out.println(graph.isAdjacent(a, c));
		System.out.println(graph.isAdjacent(a, b));
			
		System.out.println(graph.getVertexValue(d));
		
		System.out.println(graph.isAdjacent(d, c));
		graph.addEdge(d, c);
		
		System.out.println(graph.isAdjacent(d, c));
		graph.setVertexValue(d, 10);
		
		System.out.println(graph.getVertexValue(d));
		System.out.println(graph.isAdjacent(d, c));
		
		graph.removeEdge(d, c);
		System.out.println(graph.isAdjacent(d, c));
		
		
		
	}

}
