package algoritmi.operations;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import algoritmi.modello.AdjListGraph;
import algoritmi.modello.Node;
import algoritmi.modello.nodetypes.BFSNode;
import algoritmi.modello.nodetypes.ColoredNode.NodeColor;
import algoritmi.modello.nodetypes.DFSNode;

public class GraphOperations {
	
	public static AdjListGraph<DFSNode> toDFSGraph(AdjListGraph<Node> graph) {
		AdjListGraph<DFSNode> res = new AdjListGraph<>();
		
		for(Node n : graph.getVertices()) {
			for(Node x : graph.getAdjList().get(n))
				res.addEdges(new DFSNode(n.getData()), new DFSNode(x.getData())); 
		}
		
		return res;
	}
	
	
	// TODO: fixare la lista di adiacenza: cambiare metodo inserimento grafo????
	public static AdjListGraph<BFSNode> toBFSGraph(AdjListGraph<Node> graph) {
		AdjListGraph<BFSNode> res = new AdjListGraph<>();
		
		List<BFSNode> tmpNodeList = new LinkedList<>();
		
		for(Node n : graph.getVertices() )
			tmpNodeList.add(new BFSNode(n.getData()));
		
		for(BFSNode n : tmpNodeList) {
			for(Node x : graph.getAdjList().get(n))
				res.addEdges(n , new BFSNode(x.getData())); 
		}
		
		return res;
	}

	//BFS----------------------------------------------------------------------------
	public static void printBFS(AdjListGraph<BFSNode> bfsGraph , BFSNode root) {
		
		Map<BFSNode,List<BFSNode>> adjList = bfsGraph.getAdjList();
		Queue<BFSNode> q = new LinkedList<>();
		
		root.setColor(NodeColor.GRIGIO);
		root.setDistance(0);
		root.setPredecessore(null);
		
		q.add(root);
		// da qui q contiene solo i vertici grigi
		while(!q.isEmpty()) {
			BFSNode testa = q.element();
			
			// scorre la lista di adiacenza del nodo estratto dalla coda
			for(BFSNode listElem : adjList.get(testa) ) {
				if(listElem.getColor() == NodeColor.BIANCO) {
					listElem.setColor(NodeColor.GRIGIO);
					listElem.setDistance(testa.getDistance() + 1);
					listElem.setPredecessore(testa);
					q.add(listElem);
				}	
			}
		
			BFSNode estratto = q.remove();
			estratto.setColor(NodeColor.NERO);
			System.out.print(estratto + ",");
		}
	}
	
	//DFS---------------------------------------------------------------
	public static void printDFS(AdjListGraph<DFSNode> DFSGraph ) {
		Map<DFSNode,List<DFSNode>> adjList = DFSGraph.getAdjList();
		
		int time = 0;
		
		for(DFSNode n : adjList.keySet()) {
			if(n.getColor() == NodeColor.BIANCO) 
				visitaDFS(adjList, n, time);
		}
		
		
	}
	
	private static void visitaDFS(Map<DFSNode,List<DFSNode>> adjList, DFSNode n, int time) {
		
		n.setColor(NodeColor.GRIGIO);
		
		System.out.print(n + ",");
		
		n.setGreyTime(time);
		time++;
		
		List<DFSNode> adj = adjList.get(n);
		
		for(DFSNode x : adj) {
			if(x.getColor() == NodeColor.BIANCO) {
				x.setPredecessore(n);
				
				visitaDFS(adjList, x, time);
			}
		}
		
		n.setColor(NodeColor.NERO);
		n.setBlackTime(time);
		time++;
		
	}
	
	//TOPOLOGICAL SORT
	public static List<DFSNode> topologicalSort(AdjListGraph<DFSNode> DFSGraph) {
		printDFS(DFSGraph);
		
		List<DFSNode> res = DFSGraph.getVertices();
		
		res.sort(new Comparator<DFSNode>() {
			@Override
			public int compare(DFSNode o1, DFSNode o2) {
				return o1.getBlackTime() <= o2.getBlackTime() ? -1 : +1;
			}
		});
		
		return res;
	}

}
