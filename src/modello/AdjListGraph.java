package modello;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import modello.Node.NodeColor;


public class AdjListGraph {
	
	int numNodes;
	Map<Node,List<Node>> vertex;
	
	public AdjListGraph(int n) {
		this.numNodes = n;
		vertex = new HashMap<Node,List<Node>>();
	}
	
	public void addEdges(Node vertex1, Node vertex2) {
		if(vertex.get(vertex1).isEmpty()) {
			List<Node> adj1 = new LinkedList<>();
			adj1.add(vertex2);
			vertex.put(vertex1,adj1);
		}
		if(vertex.get(vertex2).isEmpty()) {
			List<Node> adj = new LinkedList<>();
			adj.add(vertex1);
			vertex.put(vertex2,adj);
		}
		if(!(vertex.get(vertex1).isEmpty() && vertex.get(vertex2).isEmpty())) {
			vertex.get(vertex1).add(vertex2);
			vertex.get(vertex2).add(vertex1);
		}
	}
	
	public void printBFS(int root) {
		Set<Node> keyset = vertex.keySet();
	
		for(Node n : keyset) {
			n.setColor(NodeColor.BIANCO);
			n.setDistance(9999);
			n.setPredecessore(null);
		}
		
		vertex.j
	}
	
	
	
	
	
	
}
