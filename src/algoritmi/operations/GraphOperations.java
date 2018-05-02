package algoritmi.operations;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import algoritmi.modello.AdjListGraph;
import algoritmi.modello.Node;
import algoritmi.modello.nodetypes.BFSNode;
import algoritmi.modello.nodetypes.ColoredNode.NodeColor;

public class GraphOperations {

	public GraphOperations() {
	}
	
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

}
