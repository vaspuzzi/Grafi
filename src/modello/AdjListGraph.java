package modello;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import modello.Node.NodeColor;


public class AdjListGraph {
	
	private Map<Node,List<Node>> adjList;
	private Queue<Node> q;
	
	public AdjListGraph() {
		adjList = new HashMap<Node,List<Node>>();
		q = new LinkedList<>();
	}
	
	private void addNode(Node vertex) {
		adjList.put(vertex, new LinkedList<>());
	}
	
	public void addEdges(Node vertex1, Node vertex2) {
		if(vertex1.equals(vertex2)) 
			throw new IllegalArgumentException();
		
		//aggiungi nodi al grafo se non presenti
		if(!adjList.containsKey(vertex1))
			addNode(vertex1);
		
		if(!adjList.containsKey(vertex2))
			addNode(vertex2);
		
		List<Node> adj1 = adjList.get(vertex1);
		List<Node> adj2 = adjList.get(vertex2);
		
		
		
		// aggiungo il vertice2 alla lista di adiacenza del vertice 2 e viceversa (non orientato)
		if(!adj1.contains(vertex2))
			adj1.add(vertex2);
		if(!adj2.contains(vertex1))
			adj2.add(vertex1);
	}
	
	public void printBFS(Node root) {
		
		
		Set<Node> keyset = adjList.keySet();
	
		
		
		for(Node n : keyset) {
			n.setColor(NodeColor.BIANCO);
			n.setDistance(9999);
			n.setPredecessore(null);
		}
		
		root.setColor(NodeColor.GRIGIO);
		root.setDistance(0);
		root.setPredecessore(null);
		
		q.add(root);
		// da qui q contiene solo i vertici grigi
		while(!q.isEmpty()) {
			Node testa = q.element();
			
			// scorre la lista di adiacenza del nodo estratto dalla coda
			for(Node listElem : adjList.get(testa) ) {
				if(listElem.getColor() == NodeColor.BIANCO) {
					listElem.setColor(NodeColor.GRIGIO);
					listElem.setDistance(testa.getDistance() + 1);
					listElem.setPredecessore(testa);
					q.add(listElem);
				}	
			}
		
			Node estratto = q.remove();
			estratto.setColor(NodeColor.NERO);
			System.out.print(estratto + ",");
		}
	}

	public void printDFS() {
		Set<Node> keyset = adjList.keySet();
		
		int time = 0;
		
		for(Node n : keyset) {
			n.setColor(NodeColor.BIANCO);
			n.setPredecessore(null);
		}
		
		time = 0;
		
		for(Node n : keyset) {
			if(n.getColor() == NodeColor.BIANCO) 
				visitaDFS(n, time);
		}
		
		
	}
	
	private void visitaDFS(Node n, int time) {
		n.setColor(NodeColor.GRIGIO);
		
		System.out.print(n + ",");
		
		n.setGreyTime(time);
		time++;
		
		List<Node> adj = adjList.get(n);
		
		for(Node x : adj) {
			if(x.getColor() == NodeColor.BIANCO) {
				x.setPredecessore(n);
				
				visitaDFS(x, time);
			}
		}
		
		n.setColor(NodeColor.NERO);
		n.setBlackTime(time);
		time++;
		
	}
	
	
	public List<Node> getVertices() {
		List<Node> res = new LinkedList<>();

		Set<Node> verticesList = adjList.keySet();

		for(Node n : verticesList)
			res.add(n);
			
		return res;
	}
	
	
	
	
	
	
}
