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
import java.util.List;
import java.util.StringTokenizer;

public class Main_old2 {
	
	// 1. 추가하고자 하는 부모노드 값을 저장하는 배열
	int[] inputArr;
	// 2. 자식노드 값 정보를 담고있는 부모노드 배열
		// 한 배열의 요소에 두개 이상의 요소가 들어있을 수 있으므로 클래스배열 정의
		// ex)	List<Integer> parentArr[]; 이라고 치면, 자리마다 new ArrayList<>(); 을 일일이 해줘야한다.
		// parentArr[0] = new ArrayList<>(); ...;
	List<Integer>[] parentArr;
	// 3. 노드 제거 후 남아있는 노드정보
	List<Integer> survivedArr;
	// 4. 루트 노드 저장.
	int root;
	
	Main_old2() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 리프노드 갯수 카운팅 변수
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
		
		/** # 실제 부모노드를 값을 참고하여 완성시키기 # */
		// 2-1. 자식노드 정보를 담고있는 부모노드 벡터클래스 초기화
			parentArr = new ArrayList[length];
			for(int i=0; i<length; i++){
				parentArr[i] = new ArrayList<Integer>();
			}
		// 2-2. 부모노드 벡터클래스에 자식노드 정보 담기
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
		
		// 3-1. 검색해서.. 연결 제거.
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
		
		// 3-2. 현재 남아있는 트리번호정보와 부모트리정보를 비교해서, 남아있는 트리번호에 자식노드가 없으면.. cntLeaf++
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
