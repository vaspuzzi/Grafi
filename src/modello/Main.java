package modello;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		AdjListGraph graph = new AdjListGraph();
		Map<Integer ,Node> nodi = new HashMap<>();
		for(int i=1; i<7; i++)
			nodi.put(i, new Node(i));
		graph.addEdges(nodi.get(1),nodi.get(2));
		graph.addEdges(nodi.get(2),nodi.get(3));
		graph.addEdges(nodi.get(2),nodi.get(4));
		graph.addEdges(nodi.get(2),nodi.get(6));
		graph.addEdges(nodi.get(4),nodi.get(5));
		graph.addEdges(nodi.get(4),nodi.get(6));
		
				
		List<Node> nodeList = graph.getVertices();
		Node sorgente = nodeList.get(0);
		graph.printBFS(sorgente);
		
		System.out.println();
		
		graph.printDFS();
	}

}
