package dataStructure.linkedlist;

public class Node_old {
	int val;
	Node_old childNode;
	int count=0;
	
	// Constructor 1
	public Node_old() {
		this.childNode = null;
	}
	// Constructor 2
	public Node_old(int val) {
		this.val = val;
		this.childNode = null;
	}
	
	// 0. Insert
	public void insertNode(int val){
		_insertNode(val);
	}
	/**  StackOverflowError */
	public void _insertNode(int val){
		Node_old temp = this;
		// �ֻ��� ����� childNode�� ������ �׳� ��ü�߰�.
		if(temp.val == 0 && temp.childNode == null){
			temp.val = val;
//			this.val = temp.val;
		}
		else if(temp.childNode == null){
			temp.childNode = new Node_old(val);
//			this.childNode = temp.childNode;
		}
		else if(temp.childNode != null){
			_insertNode(val);
		}
	}
/**  StackOverflowError */
//	public int insertNode(int val){
//		int successCode=0;
//		// �ֻ��� ����� childNode�� ������ �׳� ��ü�߰�.
//		if(this.val == 0 && this.childNode == null){
//			this.val = val;
//			successCode = 1;
//		}
//		else if(this.childNode == null){
//			this.childNode = new Node(val);
//			successCode = 1;
//		}
//		else if(this.childNode != null){
//			insertNode(val);
//		}
//		return successCode;
//	}
	
	// 1. Delete
	public void deleteNode(int val){
		searchFORdelete(this.childNode, val);
	}
	public void searchFORdelete(Node_old node, int val){
		if(node.childNode == null){
			System.out.println("������� �ϴ� Node�� �����ϴ�.");
		}
		if(node.childNode != null){
			if(node.val == val){
				node.childNode = null;
			}else{
				searchFORdelete(this.childNode, val);				
			}
		}
	}
	
	// 2. Search
	public Node_old searchNode(int val){
		Node_old returnNode;
		returnNode = searchFORsearchNode(this, val);
		return this;
	}
	public Node_old searchFORsearchNode(Node_old node, int val){
		Node_old returnNode = null;
		if(node.childNode == null){
			System.out.println("ã���� �ϴ� Node�� �����ϴ�.");
		}
		if(node.childNode != null){
			if(node.val == val){
				returnNode = node;
			}else{
				searchFORsearchNode(this.childNode, val);				
			}
		}
		return returnNode;
	}
	
	// 3. DeleteAll
	public void deleteAll(){
		searchFORdeleteAll(this);	
	}
	public void searchFORdeleteAll(Node_old node){
		if(node.childNode != null){
			searchFORdeleteAll(this.childNode);
			node.val = 0;
			node.childNode = null;
		}
	}
	
	// 4. Count
	public int getCountNode(){
		return getCountNode(this);
	}
	public int getCountNode(Node_old node){
		if(node.childNode != null){
			this.count++;
			getCountNode(node.childNode);
		}
		return this.count;
	}
}
