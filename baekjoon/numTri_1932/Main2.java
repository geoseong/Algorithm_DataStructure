/*
# ����
�� �׸��� ũ�Ⱑ 5�� ���� �ﰢ���� �� ����̴�.
�� ���� 7���� �����ؼ� �Ʒ��� �ִ� �� �� �ϳ��� �����Ͽ� �Ʒ������� ������ ��, 
�������� ���õ� ���� ���� �ִ밡 �Ǵ� ��θ� ���ϴ� ���α׷��� �ۼ��϶�. 
�Ʒ����� �ִ� ���� ���� ������ ���õ� ���� �밢�� ���� �Ǵ� �밢�� �����ʿ� �ִ� �� �߿����� ������ �� �ִ�.
�ﰢ���� ũ��� 1 �̻� 500 �����̴�. �ﰢ���� �̷�� �ִ� �� ���ڴ� ��� �����̸�, ������ 0 �̻� 99 �����̴�.

# �Է�
ù° �ٿ� �ﰢ���� ũ�� n(1��n��500)�� �־�����, ��° �ٺ��� n+1�ٱ��� ���� �ﰢ���� �־�����.

# ���
ù° �ٿ��� �ִ밡 �Ǵ� ���� ����Ѵ�.

# ���� �Է�
5
7
3 8
8 1 0 
2 7 4 4
4 5 2 6 5

# ���� ���
30
*/
package baekjoon.numTri_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	Main2()  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// line 1.
		StringTokenizer token = new StringTokenizer(br.readLine());
		int lines = Integer.parseInt(token.nextToken());
		Tree nodeTree = null;
		
		// line 2 ~ : ����Ʈ���� ������Ű��
		// �ڽ�Ʈ�� �¿� �� �� ū ��� �����ؼ� �� ���� �������鼭 ����� ���� sum�� ���س����� �� ���������� ������������ ������ sum�� ��.
		for(int line = 0; line < lines; line++){
			// line XX
			token = new StringTokenizer(br.readLine());
			for(int i=0; i<token.countTokens(); i++){
				int nodeValue = Integer.parseInt(token.nextToken());
				nodeTree = insertNodeData(nodeTree, nodeValue);
			}
		} //end for
		System.out.println("hi");
	} //end Main_1()
	
	public static void main(String[] args)  throws IOException{
		new Main2();
	} //end main()
	
	public Tree insertNodeData(Tree nodeTree, int nodeValue){
		Tree temp = null;
		if(nodeTree==null){
			return new Tree(nodeValue);
		}
		if(nodeTree.value>nodeValue){
			temp = insertNodeData(nodeTree.leftChild, nodeValue);
			nodeTree.leftChild = temp;
		}else{
			temp = insertNodeData(nodeTree.rightChild, nodeValue);
			nodeTree.rightChild = temp;
		}		
		return nodeTree;
	} //end insertNodeData()
	
	public Tree findNode(Tree node) {
		Tree currentNode = null;
		
		if (node.leftChild != null && node.rightChild != null) {
			node.leftChild = findNode(node.leftChild);
			node.rightChild = findNode(node.rightChild);
		}
		if(node.leftChild == null && node.rightChild == null){
			node = null;
		}else if(node.leftChild==null && node.rightChild!=null){
			findNode(node.rightChild);
			node = null;
		}else if(node.leftChild!=null && node.rightChild==null){
			findNode(node.leftChild);
			node = null;
		}
//		setNodesb(nodesb);
		return node;
	} //end findNode()
}
