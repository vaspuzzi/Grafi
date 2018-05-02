package algoritmi.modello;

public class Node {
	private int data;
	
	protected Node predecessore;
	
	public Node(int data) {
		this.data = data;
		
		predecessore = null;
	}

	public int getData() {
		return data;
	}

	
	@Override
	public String toString() {
		
		return "" + data;
	}

	public Node getPredecessore() {
		return predecessore;
	}

	public void setPredecessore(Node predecessore) {
		this.predecessore = predecessore;
	}
	
	
	
	
	
}
