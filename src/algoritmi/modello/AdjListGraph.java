package algoritmi.modello;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import algoritmi.modello.nodetypes.BFSNode;
import algoritmi.modello.nodetypes.ColoredNode.NodeColor;




public class AdjListGraph<NodeType extends Node> {
	
	private Map<NodeType,List<NodeType>> adjList;
	private Queue<NodeType> q;
	
	public AdjListGraph() {
		adjList = new HashMap<NodeType,List<NodeType>>();
		q = new LinkedList<>();
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
	
	
	public List<Node> topologicalSort() {
		printDFS();
		
		List<Node> res = getVertices();
		
		res.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.getBlackTime() <= o2.getBlackTime() ? -1 : +1;
			}
		});
		
		return res;
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
