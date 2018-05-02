package algoritmi.modello.nodetypes;

import algoritmi.modello.Node;

public class ColoredNode extends Node {

	public enum NodeColor {BIANCO, GRIGIO, NERO	};
	
	protected NodeColor color;
	
	public ColoredNode(int data) {
		super(data);
		
		color = NodeColor.BIANCO;
	}

	public NodeColor getColor() {
		return color;
	}

	public void setColor(NodeColor color) {
		this.color = color;
	}

	
	
}
