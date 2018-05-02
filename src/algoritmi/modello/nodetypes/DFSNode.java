package algoritmi.modello.nodetypes;


public class DFSNode extends ColoredNode {

	//visita DFS: tempo in cui il nodo viene colorato di grigio/nero
	private int greyTime, blackTime;
	
	public DFSNode(int data) {
		super(data);
		
		setColor(NodeColor.BIANCO);
		
		predecessore = null;
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
