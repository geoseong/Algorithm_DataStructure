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

		������ȸ : Root -> Left -> Right
		������ȸ : Left -> Right -> Root

		0 < Node Value of Key < 10^6
		Quantity of Node <= 10,000
		
		Q. ���� �˻� Ʈ���� ���� ��ȸ�� ����� �־����� ��, �� Ʈ���� ���� ��ȸ�� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 */
	
	BinarySearchTree rightNode;
	BinarySearchTree leftNode;
	int value;
	BinarySearchTree(int value){
		 this.value = value;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// ArrayList�� Ű���� ���� ����� ���� �ľ�
		// HashMap�� Ű ����� Left, Right ����� �� �� �Ǻ� �� �ٽ� HashMap�� ��������Ŭ ����
		List<Object> nodeHierarchy = new ArrayList<Object>();
		Map<String, Object> nodeLeftRight = new HashMap<String, Object>();
		Iterator<Object> itrnodeHierarchy;
		
		Object objvalue = new Object();
		
		// ���� ���� �Է¹޴� ���� Key(Root) Node.
		nodeLeftRight.put("Root", scan.nextInt());
		nodeHierarchy.add(nodeLeftRight);
		
		while(scan.hasNext()){
			
			// for�� �ȿ��� index+1 Key�� �߰��ǹǷ� for���� ���ѹݺ��� ������ �����Ƿ� for�� ���� ���� ����� �ھƳ���.
			int nodeSize = nodeHierarchy.size();
			
			// Root Node �ٷ� �ؿ� ArrayList�� �ϳ� �߰��ϰ� �� �ȿ��ٰ� HashMap Left, Right �߰�
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
				// nodeHierarchy�� nodeLeftRight�� Value�� integer���� HashMap���� �Ǻ�
				// Integer�̴� : Key(Root) Node��.
				// HashMap�̴� : nodeHierarchy�� Value�� Root���� �Էµ� Ű���� nodeHierarchy.get(index)���� HashMap�� get("Left" or "Right")�� ���� ��.
				
				// 1. Root > Key ----> Key = Left (Remember : Left Node > Key(Root) Node > Right Node)
				// 2. Root < Key ----> Key = Right (Remember : Left Node > Key(Root) Node > Right Node)
				itrnodeHierarchy = nodeHierarchy.iterator();
				
				int inputkey = scan.nextInt();
				
				/* 0. ù° Hierarchy */
				System.out.println("nodeHierarchy size : " + nodeHierarchy.size());
				
				/* 1. �ι�° Hierarchy */
				if(itrnodeHierarchy.hasNext()){
					for(int i=0; i<nodeHierarchy.size(); i++){
						objvalue = itrnodeHierarchy.next();	// Object��, Root(Key) Node�� ������ ��� ����
					}
					System.out.println("objvalue : " + objvalue);
					// Key Node�� 1. Right�� ��� 2. Left�� ���.. ���� ���ؼ� �������..
					// Left�� Right�� ���� KeyRoot(HashMap)�� ���� �ִ��� Ȯ��
					// 		�� ���� �ִٸ� ���� �ݺ��� Ȯ���ϱ�� �ϰ� �Ѿ��.
					// �̹� ����Ŭ�� ��ǥ�� �Ѹ��� ���� �� �����̴ϱ�..
					nodeLeftRight = (Map<String, Object>) objvalue;
					System.out.println("nodeLeftRight : " + nodeLeftRight);
					
					// Root�����, nodeHierarchy.get(0)
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
					// Root�����, nodeHierarchy.get(0)
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
				
				/* 2. ����° Hierarchy */
//				itrnodeHierarchy.next();
				
				
				System.out.println("for���� ��.");
			} // end for
			System.out.println("hasNext? (Ctrl + Z to exit)");
		} //end while
	}

}
