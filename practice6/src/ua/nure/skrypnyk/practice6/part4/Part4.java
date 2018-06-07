package ua.nure.skrypnyk.practice6.part4;

public class Part4 {
	
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,5);
		graph.addEdge(1,5);
		graph.addEdge(2,5);
		graph.addEdge(2,4);

		System.out.println(graph);
		graph.removeEdge(2,5);
		graph.removeEdge(1,5);
		System.out.println("graph after removing edges 2-5 and 1-5: ");
		System.out.println(graph);

		System.out.println("printing edges: ");
		graph.printEdges();
		
	}

}
