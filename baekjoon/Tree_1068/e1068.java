package baekjoon.Tree_1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class e1068 {
	
    int tree[];
    Vector<Integer> childTree[];
    int treeSize;
    int aryIndex;
    int root;
    boolean checkMeet[];

    e1068() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /** Line 1. 트리 길이 */
        treeSize = Integer.parseInt(br.readLine());
        // 아래 세 개의 배열 : 트리 길이만큼 배열길이를 정의함
        // tree(들어가야 할 부모노드정보)
        // , childTree(부모및 자식트리정보)
        // , checkMeet(부모노드배열의 값이 제거하려는 노드의 값과 같은지(true/false) 체크.)
        tree = new int[treeSize];
        childTree = new Vector[treeSize];
        checkMeet = new boolean[treeSize];

        // childTree : 각 배열요소마다 벡터객체 할당 
        for(int i=0;i<treeSize;i++){
            childTree[i] = new Vector<Integer>(10);
        }

        // intBuf : tree[]에 넣을 값 및 tree[] 값을 담을 변수
        int intBuf;
        // aryIndex : tree[] 인덱스 담당
        aryIndex = 0;
        /** Line 2. 노드번호에 따른 노드연결정보 넣기 */
        StringTokenizer st = new StringTokenizer(br.readLine(),	" ");

        // tree[]배열에 2번째 라인에 입력된 원하는 부모노드값이 적힌 값을 넣기.
        while(st.hasMoreTokens()){
            intBuf = Integer.parseInt(st.nextToken());
            tree[aryIndex] = intBuf;
            aryIndex++;
        }

        // treeSize : 트리길이만큼 반복
        for(int i=0;i<treeSize;i++){
        	// 원하는 부모노드값이 적힌 배열의 인덱스를 하나씩 뒤지면서..
            intBuf = tree[i];
            // 1. 부모노드 트리의 Root를 알아내고
            if(intBuf == -1){
                root = i;
                continue;
            }
            // 2. 부모노드가 갖고있는 자식노드를 넣는다.
            childTree[tree[i]].add(i);
           }

        /** Line 3. 제거하고자 하는 노드의 값 */
        int deleteAryNum = Integer.parseInt(br.readLine());

        // DFS메소드에서..
        // 1. 노드값 제거
        // 2. 리프노드 알아내기.
        
        // DFS메소드 - 1. 인자 : 제거하고자하는 노드번호
        DFS(deleteAryNum);
    	
        // DFS메소드 - 2. 인자 :  최상위 노드인 root의 값
        System.out.println(DFS(root));

    }

    public int DFS(int deleteAryNum){
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;	// 리프노드 헤아리는 변수

        // 해당 인덱스의 노드가 리프노드인지 심문했으면, 혹은 리프노드심문할 필요가 없다면(노드제거된 인덱스) true, 아니면 false 
        if(checkMeet[deleteAryNum]){
            return 0;
        }

        // 부모노드배열 중 제거하려는 혹은 Root 노드번호 인덱스의 boolean을 true로 변환
        // 또한 로직상에서 다룰 노드번호를 한번 스쳐가면 true로 변환함.
        checkMeet[deleteAryNum] = true;
        // 큐에 심문하려는 노드번호를 넣고, while문에서 이 노드번호가 리프노드인지 심판한다.
        queue.add(deleteAryNum);

        boolean flag;	// 리프노드를 세기 위한 boolean

        while(!queue.isEmpty()){	// 심문하고자 하는 노드가 있으면 while문 진행
            deleteAryNum = queue.poll();
            flag = false;
            for (int aryNum : childTree[deleteAryNum]) {	// childTree(부모및 자식트리정보)
                if(!checkMeet[aryNum]){
                    flag = true;
                    queue.add(aryNum);		// 해당 노드 안에 자식노드가 있는지 심판하기 위해 큐에 추가
                    checkMeet[aryNum] = true;	// 이번 반복분에서 다룬 노드번호는 true로 변환.
                }

            }
            if(!flag){

                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        new e1068();
    }

}