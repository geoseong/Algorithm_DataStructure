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
import java.util.List;
import java.util.StringTokenizer;

public class Main_old2 {
	
	// 1. �߰��ϰ��� �ϴ� �θ��� ���� �����ϴ� �迭
	int[] inputArr;
	// 2. �ڽĳ�� �� ������ ����ִ� �θ��� �迭
		// �� �迭�� ��ҿ� �ΰ� �̻��� ��Ұ� ������� �� �����Ƿ� Ŭ�����迭 ����
		// ex)	List<Integer> parentArr[]; �̶�� ġ��, �ڸ����� new ArrayList<>(); �� ������ ������Ѵ�.
		// parentArr[0] = new ArrayList<>(); ...;
	List<Integer>[] parentArr;
	// 3. ��� ���� �� �����ִ� �������
	List<Integer> survivedArr;
	// 4. ��Ʈ ��� ����.
	int root;
	
	Main_old2() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ������� ���� ī���� ����
		int cntLeaf=0;
		
		// line 1.
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int length = Integer.parseInt(token.nextToken());
		
		// line 2.
		token = new StringTokenizer(br.readLine(), " ");
		inputArr = new int[length];
		for(int n=0; n<length; n++){
			inputArr[n] = Integer.parseInt(token.nextToken());
		}
		
		/** # ���� �θ��带 ���� �����Ͽ� �ϼ���Ű�� # */
		// 2-1. �ڽĳ�� ������ ����ִ� �θ��� ����Ŭ���� �ʱ�ȭ
			parentArr = new ArrayList[length];
			for(int i=0; i<length; i++){
				parentArr[i] = new ArrayList<Integer>();
			}
		// 2-2. �θ��� ����Ŭ������ �ڽĳ�� ���� ���
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
		
		// 3-1. �˻��ؼ�.. ���� ����.
		survivedArr = new ArrayList<Integer>();
		for(int n=0; n<parentArr.length; n++){
			for(int loop=0; loop < parentArr[n].size(); loop++){
				int childNode = parentArr[n].get(loop);
				if(childNode == deleteNode){
					parentArr[n].remove(loop);
					continue;
				}
				survivedArr.add(childNode);
			}
		} //end for
		
		// 3-2. ���� �����ִ� Ʈ����ȣ������ �θ�Ʈ�������� ���ؼ�, �����ִ� Ʈ����ȣ�� �ڽĳ�尡 ������.. cntLeaf++
		for(int n=0; n<survivedArr.size(); n++){
			int compare = survivedArr.get(n);
			if(parentArr[compare].size() == 0){
				cntLeaf++;
			}
		}
		System.out.println(cntLeaf);
	}
	public static void main(String[] args) throws IOException{
		new Main_old2();
	}

}
