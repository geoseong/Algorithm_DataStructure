package baekjoon.Tree_1068;
/*
- 리프 노드 : 자식의 개수가 0인 노드
- 트리가 주어졌을 때, 노드 중 하나를 제거할 것이다. 그 때, 남은 트리에서 리프 노드의 개수를 구하는 프로그램을 작성하시오.
 
# 입력
 첫째 줄에 트리의 노드의 개수 N이 주어진다. N은 50보다 작거나 같은 자연수이다.
 둘째 줄에는 0번 노드부터 N-1번 노드까지, 각 노드의 부모가 주어진다. 
 	만약 부모가 없다면 (루트) -1이 주어진다. 
셋째 줄에는 지울 노드의 번호가 주어진다.
5
-1 0 0 1 1
2

# 출력
첫째 줄에 입력으로 주어진 트리에서 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수를 출력한다.
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
	
	// 1. 추가하고자 하는 부모노드 값을 저장하는 배열
	int[] inputArr;
	// 2. 자식노드 값 정보를 담고있는 부모노드 배열
		// 한 배열의 요소에 두개 이상의 요소가 들어있을 수 있으므로 클래스배열 정의
		// ex)	List<Integer> parentArr[]; 이라고 치면, 자리마다 new ArrayList<>(); 을 일일이 해줘야한다.
		// parentArr[0] = new ArrayList<>(); ...;
	List<Integer>[] parentArr;
	// 3. 리프노드 검사대상인지 아닌지 정보를 저장하는 배열.
	boolean[] checkLeafNode;
	// 4. 루트 노드 저장.
	int root;
	
	public static void main(String[] args) throws IOException{
		new Main();
	}
	
	Main() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// line 1.
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int length = Integer.parseInt(token.nextToken());
		// 리프노드 검사대상 배열크기정의
		checkLeafNode = new boolean[length];
		
		// line 2.
		token = new StringTokenizer(br.readLine(), " ");
		inputArr = new int[length];
		for(int n=0; n<length; n++){
			inputArr[n] = Integer.parseInt(token.nextToken());
		}
		
		// 2-1. 자식노드 정보를 담고있는 부모노드 ArrayList클래스 초기화
			parentArr = new ArrayList[length];
			for(int i=0; i<length; i++){
				parentArr[i] = new ArrayList<Integer>();
			}
		// 2-2. 부모노드 ArrayList클래스에 자식노드 정보 담기
			for(int n=0; n<length; n++){
				int parentNodeVal = inputArr[n];
				// 입력된값의 n번째 노드의 값이 -1이면 그 노드번호를 가진 노드가 최상위노드임.
				if(parentNodeVal == -1){
					root = n;
				}else{
					parentArr[parentNodeVal].add(n);
				}
			} //end for
		
		// line 3.
		token = new StringTokenizer(br.readLine(), " ");
		int deleteNode = Integer.parseInt(token.nextToken());
		
		// 3-1. 제거하고자하는 노드는 리프노드 검사대상에서 제외시킨다.
		searchAndCountLeadTree(deleteNode);
		
		// 3-2. 리프노드 검사를 하기 위해 부모노드트리의 전체값 검사를 하기 위해 최상위 노드번호를 넣는다.
		int cntLeaf = searchAndCountLeadTree(root);
		
		System.out.println(cntLeaf);
	}
	
	public int searchAndCountLeadTree(int index){
		// 리프노드 수 헤아리는 변수
		int cntLeaf=0;
		// Queue : 심문대상 수용소
		Queue<Integer> investigationArea = new LinkedList<Integer>();
		
		// 인자로 받은 노드인덱스가 심문을 이미 받거나 제거대상이라면 true일 것이니 리프노드를 셀 필요가 없다.
		if(checkLeafNode[index]){
			return 0;
		}else{
			// 심문대상을 할 예정이므로 미리 심문받았다는 표시를 해둔다.
			checkLeafNode[index] = true;
			// 심문장소에 노드인덱스를 집어넣는다.
			investigationArea.add(index);
		}
		
		// while문 : 심문대상이 없을때까지 심문
		while(!investigationArea.isEmpty()){
			// 심문대상을 호출해 낸다.
			int object = investigationArea.poll();
			// 노드 안에 자식이 있는지 판별하는 변수 ( 이 부분이 있어야 정답 인정됨 )
			boolean hasChild = false;
			// 심문대상의 트리인덱스 값들을 끄집어 낸다.
			for(int target : parentArr[object]){
				// 부모노드 안의 자식노드번호는 심문을 했는지 체크. 심문이력 없으면(checkLeafNode[]), 심문대상에 넣는다.
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
