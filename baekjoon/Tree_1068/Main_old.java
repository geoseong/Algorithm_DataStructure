/*
- ���� ��� : �ڽ��� ������ 0�� ���
- Ʈ���� �־����� ��, ��� �� �ϳ��� ������ ���̴�. �� ��, ���� Ʈ������ ���� ����� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 
# �Է�
 ù° �ٿ� Ʈ���� ����� ���� N�� �־�����. N�� 50���� �۰ų� ���� �ڿ����̴�.
 ��° �ٿ��� 0�� ������ N-1�� ������, �� ����� �θ� �־�����. 
 	���� �θ� ���ٸ� (��Ʈ) -1�� �־�����. 
��° �ٿ��� ���� ����� ��ȣ�� �־�����.
5
-1 0 0 1 1
2

# ���
ù° �ٿ� �Է����� �־��� Ʈ������ �Է����� �־��� ��带 ������ ��, ���� ����� ������ ����Ѵ�.
2

# comment
�Էµ� n��...
n�� -1 �̶�� node�� ���� �߰�.(new Node)
	���� �߰��� ��忡�� ��ȣ�� �ο�.(int)
n�� -1 �ʰ���� n�� ��ȣ�� ������ �߰��� ����� ��ȣ�� ������ Ȯ��.(if int...) ��ȣ�� ���ٸ� �� ���� ������尡 �ƴϴ�(boolean)

�����ϰ����ϴ� ����ȣ n�� �־�����...
1. 
- �� ���� ������ ���´�.
2.
- [n]�� �� ������ ���� �����ִ� �ڸ������ٰ� (-1 or 0)�� ���� ��Ƹ���. : -1�� ���� ������ �ڽŰ� ������ ������ ��尡 ���� ��쿡 -1�� ����.
 */
package baekjoon.Tree_1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_old {
	
	public static void main(String[] args) throws IOException {
        
		new Main_old();
		
		
	} //end main()
	
	Main_old() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ���� �ð�
		long startTime = System.currentTimeMillis();
		// line 1.
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int nodes = Integer.parseInt(token.nextToken());
		
		// line 2.
		token = new StringTokenizer(br.readLine(), " ");
		Node[] nodeArr = new Node[nodes];
		for(int n=0; n<nodes; n++){
			int elementVal = Integer.parseInt(token.nextToken());
			nodeArr[n] = new Node(n);
			if(elementVal > -1){
				if(nodeArr[elementVal].left == null){
					nodeArr[elementVal].left = nodeArr[n];
				}else{
					nodeArr[elementVal].right = nodeArr[n];
				}
			} // end if
		} //end for
		
		// line 3.
		token = new StringTokenizer(br.readLine(), " ");
		int delNode = Integer.parseInt(token.nextToken());
		int cntLeafNode=0;

		// ���� ����ȣ�� ���ڷ��Ͽ� ������ ������ ����
		nodeArr[delNode]=null;
		deConnectNode(nodeArr[0], delNode);
		// ���� Ʈ���� ������� ���ϱ�
		cntLeafNode = searchNode(nodeArr[0], 0);
		
		System.out.println(cntLeafNode);
		
		// ���� �ð�
        long endTime = System.currentTimeMillis();
        System.out.println("##  �ҿ�ð�(ms) : " + ( endTime - startTime ) + "(ms)"); 
	} //end Main_1()
	
	public int searchNode(Node node, int cntLeafNode){
		if(node.left == null && node.right == null){
			cntLeafNode++;
			return cntLeafNode;
		}else if(node.left == null && node.right != null){
			return searchNode(node.right, cntLeafNode);
		}else if(node.right == null && node.left != null){
			return searchNode(node.left, cntLeafNode);
		}else{
			cntLeafNode = searchNode(node.right, cntLeafNode);
			cntLeafNode = searchNode(node.left, cntLeafNode);
		}
		return cntLeafNode;
	} //end searchNode()
	
	public void deConnectNode(Node node, int delNode){
		if(node.right != null && node.right.val == delNode){
			node.right = null;
		}else if(node.left != null && node.left.val == delNode){
			node.left = null;
		}else{
			if(node.right != null)		searchNode(node.right, delNode);
			if(node.left != null)       searchNode(node.left, delNode);
		}
	} //end deConnectNode()
}
