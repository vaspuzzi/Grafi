package modello;

public class Node {
	private int data;
	
	public enum NodeColor {BIANCO, GRIGIO, NERO	};
	
	private NodeColor color;
	
	private int distance;
	
	private Node predecessore;
	
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

	
	
	
	
	
	
	
}
