package dataStructure.linkedlist;

public class Node {
	private Object val;
	private Node childNode;
	
	public Node(Object val) {
		this.val = val;
		this.childNode = null;
	}
	
	public Object getVal() {
		return val;
	}
	public void setVal(Object val) {
		this.val = val;
	}
	public Node getChildNode() {
		return childNode;
	}
	public void setChildNode(Node childNode) {
		this.childNode = childNode;
	}
	
}
