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
	 * 전위순회 : Root -> Left -> Right 후위순회 : Left -> Right -> Root
	 * 
	 * 0 < Node Value of Key < 10^6 Quantity of Node <= 10,000
	 * 
	 * Q. 이진 검색 트리를 전위 순회한 결과가 주어졌을 때, 이 트리를 후위 순회한 결과를 구하는 프로그램을 작성하시오.
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
		// START : 노드에 값 입력.
		Scanner scan = new Scanner(System.in);
		int inputValue = scan.nextInt();
		if(inputValue > 10*10*10*10*10*10 - 1){
			System.out.println("입력값이 10^6을 넘었습니다. 종료합니다.");
			System.exit(0);
		}
		Node node = new Node(inputValue);
		
		while (scan.hasNext()) {
			try {
				inputValue = scan.nextInt();
				// System.out.println("Root Node's Value : " + node.value);
				if(inputValue > 10*10*10*10*10*10 - 1){
					System.out.println("입력값이 10^6을 넘었습니다. 종료합니다.");
					break;
				}
				node = nodeInsert(node, inputValue);

			} catch (Exception e) {
//				e.printStackTrace();
				System.out.println("숫자만을 입력해야 합니다. 종료합니다.");
				break;
			}
		} // end while
			// END : 노드에 값 입력

		// START : 후위순회 출력
		// 후위순회 : Left -> Right -> Root
		BinarySearchTree2 bst = new BinarySearchTree2();
//		StringBuilder resultsb = bst.getNodesb();
		
		bst.findNode(node);
//		resultsb.append(node.value);
//		System.out.println("결과 : \n" + resultsb);
		// END : 후외순회 출력
	} // end main method

	public static Node nodeInsert(Node node, int inputValue) {
		Node currentNode = null;

		if (node == null) {
			// System.out.println("새로운 객체 생성");
			return new Node(inputValue);
		}

		if (node.value > inputValue) {
			// System.out.println("leftNode로 추가");
			// leftNode의 leftNode로 추가
			currentNode = nodeInsert(node.leftNode, inputValue);
			node.leftNode = currentNode;
		} else if (node.value < inputValue) {
			// System.out.println("rightNode로 추가");
			// leftNode의 rightNode로 추가
			currentNode = nodeInsert(node.rightNode, inputValue);
			node.rightNode = currentNode;
		}

		return node;
	} // end nodeCheck

	public Node findNode(Node node) {
		// 둘중하나만 null이면 left->Right->Root 순으로 출력하되, null값은 Stringbuilder에서 포함 안하면 된다.
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
