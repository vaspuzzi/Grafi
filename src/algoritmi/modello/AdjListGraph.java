package algoritmi.modello;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;




public class AdjListGraph<NodeType extends Node> {
	
	private Map<NodeType,List<NodeType>> adjList;
	
	public AdjListGraph() {
		adjList = new HashMap<NodeType,List<NodeType>>();
	}
	
	private void addNode(NodeType vertex) {
		adjList.put(vertex, new LinkedList<>());
	}
	
	public void addEdges(NodeType vertex1, NodeType vertex2) {
		if(vertex1.equals(vertex2)) 
			throw new IllegalArgumentException();
		
		//aggiungi nodi al grafo se non presenti
		if(!adjList.containsKey(vertex1))
			addNode(vertex1);
		
		if(!adjList.containsKey(vertex2))
			addNode(vertex2);
		
		List<NodeType> adj1 = adjList.get(vertex1);
		List<NodeType> adj2 = adjList.get(vertex2);
		
		
		
		// aggiungo il vertice2 alla lista di adiacenza del vertice 2 e viceversa (non orientato)
		if(!adj1.contains(vertex2))
			adj1.add(vertex2);
		if(!adj2.contains(vertex1))
			adj2.add(vertex1);
	}
	
	public List<NodeType> getVertices() {
		List<NodeType> res = new LinkedList<>();

		Set<NodeType> verticesList = adjList.keySet();

		for(NodeType n : verticesList)
			res.add(n);
			
		return res;
	}

	public Map<NodeType, List<NodeType>> getAdjList() {
		return adjList;
	}
	
	
	
	
	
	
}
