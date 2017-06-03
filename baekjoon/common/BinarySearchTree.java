package baekjoon.common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BinarySearchTree {
	/* input
	    50
	    30
	    24
	    5
	    28
	    45
	    98
	    52
	    60

	    Right Node > Root(Key) Node > Left Node
	    Right Node > Left Node

	    Ctrl + Z : exit & Cancel

		전위순회 : Root -> Left -> Right
		후위순회 : Left -> Right -> Root

		0 < Node Value of Key < 10^6
		Quantity of Node <= 10,000
		
		Q. 이진 검색 트리를 전위 순회한 결과가 주어졌을 때, 이 트리를 후위 순회한 결과를 구하는 프로그램을 작성하시오.
	 */
	
	BinarySearchTree rightNode;
	BinarySearchTree leftNode;
	int value;
	BinarySearchTree(int value){
		 this.value = value;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// ArrayList의 키값을 통해 노드의 계층 파악
		// HashMap의 키 밸류로 Left, Right 노드의 값 및 판별 후 다시 HashMap의 복제사이클 진행
		List<Object> nodeHierarchy = new ArrayList<Object>();
		Map<String, Object> nodeLeftRight = new HashMap<String, Object>();
		Iterator<Object> itrnodeHierarchy;
		
		Object objvalue = new Object();
		
		// 제일 먼저 입력받는 값은 Key(Root) Node.
		nodeLeftRight.put("Root", scan.nextInt());
		nodeHierarchy.add(nodeLeftRight);
		
		while(scan.hasNext()){
			
			// for문 안에서 index+1 Key가 추가되므로 for문이 무한반복될 여지가 있으므로 for문 들어가기 전에 상수로 박아놓기.
			int nodeSize = nodeHierarchy.size();
			
			// Root Node 바로 밑에 ArrayList를 하나 추가하고 그 안에다가 HashMap Left, Right 추가
//			if(nodeHierarchy.get(index).getClass() == Integer.class){
				// 1. Root > Key ----> Key = Left (Remember : Left Node > Key(Root) Node > Right Node)
//				if((int)nodeHierarchy.get(0) > inputkey){
//					nodeLeftRight.put("Left", inputkey);
//					nodeHierarchy.add(1, nodeLeftRight);
//					
//				}// 2. Root < Key ----> Key = Right (Remember : Left Node > Key(Root) Node > Right Node)
//				else if((int)nodeHierarchy.get(0) < inputkey){
//					nodeLeftRight.put("Right", inputkey);
//					nodeHierarchy.add(1, nodeLeftRight);
//					
//				}
//			}
			
			
				
			for(int index = 0; index < nodeHierarchy.size(); index++){
				// nodeHierarchy의 nodeLeftRight의 Value가 integer인지 HashMap인지 판별
				// Integer이다 : Key(Root) Node임.
				// HashMap이다 : nodeHierarchy의 Value의 Root값과 입력된 키값은 nodeHierarchy.get(index)에서 HashMap의 get("Left" or "Right")로 얻어내야 함.
				
				// 1. Root > Key ----> Key = Left (Remember : Left Node > Key(Root) Node > Right Node)
				// 2. Root < Key ----> Key = Right (Remember : Left Node > Key(Root) Node > Right Node)
				itrnodeHierarchy = nodeHierarchy.iterator();
				
				int inputkey = scan.nextInt();
				
				/* 0. 첫째 Hierarchy */
				System.out.println("nodeHierarchy size : " + nodeHierarchy.size());
				
				/* 1. 두번째 Hierarchy */
				if(itrnodeHierarchy.hasNext()){
					for(int i=0; i<nodeHierarchy.size(); i++){
						objvalue = itrnodeHierarchy.next();	// Object형, Root(Key) Node의 정보를 담고 있음
					}
					System.out.println("objvalue : " + objvalue);
					// Key Node가 1. Right인 경우 2. Left인 경우.. 각자 비교해서 뻗어나가야..
					// Left나 Right도 또한 KeyRoot(HashMap)을 갖고 있는지 확인
					// 		└ 갖고 있다면 다음 반복때 확인하기로 하고 넘어가기.
					// 이번 사이클의 목표는 뿌리를 뻗는 게 목적이니까..
					nodeLeftRight = (Map<String, Object>) objvalue;
					System.out.println("nodeLeftRight : " + nodeLeftRight);
					
					// Root노드라면, nodeHierarchy.get(0)
					if(index==0 && ((Integer)nodeLeftRight.get("Root") > inputkey)){
						HashMap<String, Object> addNode = new HashMap<String, Object>();
						addNode.put("Left", inputkey);
						nodeHierarchy.add(index+1, addNode);
					}else if(index==0 && ((Integer)nodeLeftRight.get("Root") < inputkey)){
						HashMap<String, Object> addNode = new HashMap<String, Object>();
						addNode.put("Right", inputkey);
						nodeHierarchy.add(index+1, addNode);
					}
					else if((int)nodeLeftRight.get("Left") > inputkey){
						HashMap<String, Object> addNode = new HashMap<String, Object>();
						addNode.put("Left", inputkey);
						nodeHierarchy.add(index+1, addNode);
					}else if((int)nodeLeftRight.get("Right") > inputkey){
						HashMap<String, Object> addNode = new HashMap<String, Object>();
						addNode.put("Right", inputkey);
						nodeHierarchy.add(index+1, addNode);
					}
					
//					if(nodeLeftRight.get("Left").getClass() != HashMap.class || nodeLeftRight.get("Right").getClass() != HashMap.class){
//						if((int)nodeLeftRight.get("Left") > inputkey){
//							nodeLeftRight.put("Left", inputkey);
//							nodeHierarchy.add(index+1, nodeLeftRight);
//						}else if((int)nodeLeftRight.get("Right") > inputkey){
//							nodeLeftRight.put("Right", inputkey);
//							nodeHierarchy.add(index+1, nodeLeftRight);
//						}
//					} //end nodeLeftRight
				}else{
					// Root노드라면, nodeHierarchy.get(0)
					if(index==0 && ((Integer)nodeLeftRight.get("Root") > inputkey)){
						HashMap<String, Object> addNode = new HashMap<String, Object>();
						addNode.put("Left", inputkey);
						nodeHierarchy.add(index+1, addNode);
					}else if(index==0 && ((Integer)nodeLeftRight.get("Root") < inputkey)){
						HashMap<String, Object> addNode = new HashMap<String, Object>();
						addNode.put("Right", inputkey);
						nodeHierarchy.add(index+1, addNode);
					}
					else if((int)nodeLeftRight.get("Left") > inputkey){
						HashMap<String, Object> addNode = new HashMap<String, Object>();
						addNode.put("Left", inputkey);
						nodeHierarchy.add(index+1, addNode);
					}else if((int)nodeLeftRight.get("Right") > inputkey){
						HashMap<String, Object> addNode = new HashMap<String, Object>();
						addNode.put("Right", inputkey);
						nodeHierarchy.add(index+1, addNode);
					}
				} //end hasNext
				
				/* 2. 세번째 Hierarchy */
//				itrnodeHierarchy.next();
				
				
				System.out.println("for문의 끝.");
			} // end for
			System.out.println("hasNext? (Ctrl + Z to exit)");
		} //end while
	}

}
