package modello;

public class Node {
	private int data;
	
	public enum NodeColor {BIANCO, GRIGIO, NERO	};
	
	private NodeColor color;
	
	private Node predecessore;
	
	//visita BFS: distanza dal nodo sorgente
	private int distance;
	
	//visita DFS: tempo in cui il nodo viene colorato di grigio/nero
	private int greyTime, blackTime;
	
	public Node(int data) {
		this.data = data;
	}
	
	public NodeColor getColor() {
		return color;
	}

	public void setColor(NodeColor color) {
		this.color = color;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Node getPredecessore() {
		return predecessore;
	}

	public void setPredecessore(Node predecessore) {
		this.predecessore = predecessore;
	}

	public int getData() {
		return data;
	}

	
	@Override
	public String toString() {
		
		return "" + data;
	}

	public int getGreyTime() {
		return greyTime;
	}

	public void setGreyTime(int greyTime) {
		this.greyTime = greyTime;
	}

	public int getBlackTime() {
		return blackTime;
	}

	public void setBlackTime(int blackTime) {
		this.blackTime = blackTime;
	}
	
	
	
	
	
}
