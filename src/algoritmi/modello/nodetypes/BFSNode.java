package algoritmi.modello.nodetypes;

import algoritmi.modello.Node;

public class BFSNode extends ColoredNode {
	
	//visita BFS: distanza dal nodo sorgente
	private int distance;

	public BFSNode(int data) {
		super(data);
		
		distance = 9999;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
