package baekjoon.Tree_1068;
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
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	// 1. �߰��ϰ��� �ϴ� �θ��� ���� �����ϴ� �迭
	int[] inputArr;
	// 2. �ڽĳ�� �� ������ ����ִ� �θ��� �迭
		// �� �迭�� ��ҿ� �ΰ� �̻��� ��Ұ� ������� �� �����Ƿ� Ŭ�����迭 ����
		// ex)	List<Integer> parentArr[]; �̶�� ġ��, �ڸ����� new ArrayList<>(); �� ������ ������Ѵ�.
		// parentArr[0] = new ArrayList<>(); ...;
	List<Integer>[] parentArr;
	// 3. ������� �˻������� �ƴ��� ������ �����ϴ� �迭.
	boolean[] checkLeafNode;
	// 4. ��Ʈ ��� ����.
	int root;
	
	public static void main(String[] args) throws IOException{
		new Main();
	}
	
	Main() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// line 1.
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int length = Integer.parseInt(token.nextToken());
		// ������� �˻��� �迭ũ������
		checkLeafNode = new boolean[length];
		
		// line 2.
		token = new StringTokenizer(br.readLine(), " ");
		inputArr = new int[length];
		for(int n=0; n<length; n++){
			inputArr[n] = Integer.parseInt(token.nextToken());
		}
		
		// 2-1. �ڽĳ�� ������ ����ִ� �θ��� ArrayListŬ���� �ʱ�ȭ
			parentArr = new ArrayList[length];
			for(int i=0; i<length; i++){
				parentArr[i] = new ArrayList<Integer>();
			}
		// 2-2. �θ��� ArrayListŬ������ �ڽĳ�� ���� ���
			for(int n=0; n<length; n++){
				int parentNodeVal = inputArr[n];
				// �ԷµȰ��� n��° ����� ���� -1�̸� �� ����ȣ�� ���� ��尡 �ֻ��������.
				if(parentNodeVal == -1){
					root = n;
				}else{
					parentArr[parentNodeVal].add(n);
				}
			} //end for
		
		// line 3.
		token = new StringTokenizer(br.readLine(), " ");
		int deleteNode = Integer.parseInt(token.nextToken());
		
		// 3-1. �����ϰ����ϴ� ���� ������� �˻��󿡼� ���ܽ�Ų��.
		searchAndCountLeadTree(deleteNode);
		
		// 3-2. ������� �˻縦 �ϱ� ���� �θ���Ʈ���� ��ü�� �˻縦 �ϱ� ���� �ֻ��� ����ȣ�� �ִ´�.
		int cntLeaf = searchAndCountLeadTree(root);
		
		System.out.println(cntLeaf);
	}
	
	public int searchAndCountLeadTree(int index){
		// ������� �� ��Ƹ��� ����
		int cntLeaf=0;
		// Queue : �ɹ���� �����
		Queue<Integer> investigationArea = new LinkedList<Integer>();
		
		// ���ڷ� ���� ����ε����� �ɹ��� �̹� �ްų� ���Ŵ���̶�� true�� ���̴� ������带 �� �ʿ䰡 ����.
		if(checkLeafNode[index]){
			return 0;
		}else{
			// �ɹ������ �� �����̹Ƿ� �̸� �ɹ��޾Ҵٴ� ǥ�ø� �صд�.
			checkLeafNode[index] = true;
			// �ɹ���ҿ� ����ε����� ����ִ´�.
			investigationArea.add(index);
		}
		
		// while�� : �ɹ������ ���������� �ɹ�
		while(!investigationArea.isEmpty()){
			// �ɹ������ ȣ���� ����.
			int object = investigationArea.poll();
			// ��� �ȿ� �ڽ��� �ִ��� �Ǻ��ϴ� ���� ( �� �κ��� �־�� ���� ������ )
			boolean hasChild = false;
			// �ɹ������ Ʈ���ε��� ������ ������ ����.
			for(int target : parentArr[object]){
				// �θ��� ���� �ڽĳ���ȣ�� �ɹ��� �ߴ��� üũ. �ɹ��̷� ������(checkLeafNode[]), �ɹ���� �ִ´�.
				if(!checkLeafNode[target]){
					hasChild = true;
					checkLeafNode[target] = true;
					investigationArea.add(target);
				}
			} //end for
			if(!hasChild){
				cntLeaf++;
			}
		} //end while
		
		return cntLeaf; 
	}
}
