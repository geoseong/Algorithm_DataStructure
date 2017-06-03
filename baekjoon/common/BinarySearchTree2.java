package baekjoon.common;

import java.util.Scanner;

class Node {
	Node rightNode;
	Node leftNode;
	int value;

	Node(int value) {
		this.value = value;
	}
}

public class BinarySearchTree2 {
	/*
	 * input 50 30 24 5 28 45 98 52 60
	 * 
	 * Right Node > Root(Key) Node > Left Node Right Node > Left Node
	 * 
	 * Ctrl + Z : exit & Cancel
	 * 
	 * ������ȸ : Root -> Left -> Right ������ȸ : Left -> Right -> Root
	 * 
	 * 0 < Node Value of Key < 10^6 Quantity of Node <= 10,000
	 * 
	 * Q. ���� �˻� Ʈ���� ���� ��ȸ�� ����� �־����� ��, �� Ʈ���� ���� ��ȸ�� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 */
	
	
//	StringBuilder nodesb = new StringBuilder();
//	
//	public StringBuilder getNodesb() {
//		return nodesb;
//	}
//
//	public void setNodesb(StringBuilder nodesb) {
//		this.nodesb = nodesb;
//	}

	public static void main(String[] args) {
		// START : ��忡 �� �Է�.
		Scanner scan = new Scanner(System.in);
		int inputValue = scan.nextInt();
		if(inputValue > 10*10*10*10*10*10 - 1){
			System.out.println("�Է°��� 10^6�� �Ѿ����ϴ�. �����մϴ�.");
			System.exit(0);
		}
		Node node = new Node(inputValue);
		
		while (scan.hasNext()) {
			try {
				inputValue = scan.nextInt();
				// System.out.println("Root Node's Value : " + node.value);
				if(inputValue > 10*10*10*10*10*10 - 1){
					System.out.println("�Է°��� 10^6�� �Ѿ����ϴ�. �����մϴ�.");
					break;
				}
				node = nodeInsert(node, inputValue);

			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("���ڸ��� �Է��ؾ� �մϴ�. �����մϴ�.");
				break;
			}
		} // end while
			// END : ��忡 �� �Է�

		// START : ������ȸ ���
		// ������ȸ : Left -> Right -> Root
		BinarySearchTree2 bst = new BinarySearchTree2();
//		StringBuilder resultsb = bst.getNodesb();
		
		bst.findNode(node);
//		resultsb.append(node.value);
//		System.out.println("��� : \n" + resultsb);
		// END : �Ŀܼ�ȸ ���
	} // end main method

	public static Node nodeInsert(Node node, int inputValue) {
		Node currentNode = null;

		if (node == null) {
			// System.out.println("���ο� ��ü ����");
			return new Node(inputValue);
		}

		if (node.value > inputValue) {
			// System.out.println("leftNode�� �߰�");
			// leftNode�� leftNode�� �߰�
			currentNode = nodeInsert(node.leftNode, inputValue);
			node.leftNode = currentNode;
		} else if (node.value < inputValue) {
			// System.out.println("rightNode�� �߰�");
			// leftNode�� rightNode�� �߰�
			currentNode = nodeInsert(node.rightNode, inputValue);
			node.rightNode = currentNode;
		}

		return node;
	} // end nodeCheck

	public Node findNode(Node node) {
		// �����ϳ��� null�̸� left->Right->Root ������ ����ϵ�, null���� Stringbuilder���� ���� ���ϸ� �ȴ�.
		if (node.leftNode != null && node.rightNode != null) {
			node.leftNode = findNode(node.leftNode);
			node.rightNode = findNode(node.rightNode);
		}
		
		if(node.leftNode == null && node.rightNode == null){
//			nodesb.append(node.value + "\n");
			System.out.println(node.value);
			node = null;
		}else if(node.leftNode==null && node.rightNode!=null){
			findNode(node.rightNode);
//			nodesb.append(node.value + "\n");
			System.out.println(node.value);
			node = null;
		}else if(node.leftNode!=null && node.rightNode==null){
			findNode(node.leftNode);
//			nodesb.append(node.value + "\n");
			System.out.println(node.value);
			node = null;
		}
		/*	
		}else{// node.leftNode!=null && node.rightNode!=null
			nodesb.append(node.leftNode.value+"\n");
			nodesb.append(node.rightNode.value+"\n");
			
		}*/
//		setNodesb(nodesb);

		return node;
	}
}
