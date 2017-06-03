package baekjoon.SmallestHeap_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
최소 힙을 이용
부모노드 < 자식노드
입력
9
0
12345678
1
2
0
0
0
0
32
 */
class NodeforHeap{
    int value;
    NodeforHeap rootNode, leftNode, rightNode;

    public NodeforHeap(){}
    public NodeforHeap(int value) {
        this.value = value;
    }
}
public class Heap1927 {
    NodeforHeap nodeTemp = new NodeforHeap();
    boolean right;

    Heap1927() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // Line 1
        int N = Integer.parseInt(br.readLine());
        int lengthNotZero=0;
        NodeforHeap[] nodeArray = new NodeforHeap[N];
        // 입력값 배열로 넣음.
        // 입력값이 0이면, 최소힙노드의 Root값 출력 + 현재 배열에 0이 아닌 수 재정렬 + 최소힙노드삽입
        // 입력값이 0이 아니면, 현재 배열에 0이 아닌 수 재정렬 + 최소힙노드삽입
        // 시간초과. Main()에서 반복문 3중 도는 메소드 : arrayASC(), modifyNode()
        // arrayASC() : 2중 for문에서 1중 while문으로 개선
        for(int i=0; i<N; i++){
            int valueN = Integer.parseInt(br.readLine());
            if(valueN > 0) {    // 입력값이 0이면 rootNode출력, 0이상이면 Node 삽입
                lengthNotZero++;
                nodeArray[i] = new NodeforHeap(valueN);
                nodeArray = arrayASC(nodeArray, i+1);  // 현재 배열에 0이 아닌 수 재정렬(notZeros[], arrayAsc[] 정렬)
                initHeap();   // 힙트리 재정렬을 위해 초기화.
                for(int j=0; j<N; j++){
                    if(nodeArray[j] != null && nodeArray[j].value>0) {
                        modifyNode(nodeArray[j], lengthNotZero); // 최소힙노드삽입
                    }
                }
            }else{
                nodeArray[i] = new NodeforHeap();
                int result = extractNode(nodeArray);
                sb.append(Integer.toString(result)+'\n');
                if(result <= 0)  continue;  // 더이상의 힙트리의 value가 남아있지 않다는 뜻
                nodeArray = arrayASC(nodeArray, i+1);  // 현재 배열에 0이 아닌 수 재정렬(notZeros[], arrayAsc[] 정렬)
                initHeap();   // 힙트리 재정렬을 위해 초기화.
                for (int j = 0; j < N; j++) {
                    if (nodeArray[j] != null && nodeArray[j].value > 0) {
                        modifyNode(nodeArray[j], lengthNotZero); // 최소힙노드삽입
                    }
                }

            }
        } //end for

        System.out.println(sb.toString());
    }

    // 힙트리 초기화.
    public void initHeap(){
        nodeTemp.value = 0;
        nodeTemp.rootNode = null;
        nodeTemp.leftNode = null;
        nodeTemp.rightNode = null;
    }

    // 현재 배열에 0이 아닌 수 재정렬(notZeros[], arrayAsc[] 정렬)
    public NodeforHeap[] arrayASC(NodeforHeap[] nodeArray, int existLength){
        NodeforHeap temp=null;
        int i=0;
        int swapped=0;
        while(true){
            if(swapped==0)  break;
            if(i >= existLength-1){
                i = 0;  swapped=0;  continue;
            }else{  i++;    }
            if (nodeArray[i]==null || nodeArray[i+1]==null) continue;
            if (nodeArray[i].value > nodeArray[i + 1].value) {
                swapped++;
                temp = nodeArray[i];
                nodeArray[i] = nodeArray[i + 1];
                nodeArray[i + 1] = temp;
            }
        }
//        for(int n=0; n<existLength; n++) {
//            for (int i = 0; i < existLength-1; i++) {
//                if (nodeArray[i]==null || nodeArray[i+1]==null) continue;
//                if (nodeArray[i].value > nodeArray[i + 1].value) {
//                    temp = nodeArray[i];
//                    nodeArray[i] = nodeArray[i + 1];
//                    nodeArray[i + 1] = temp;
//                }
//            }
//        }
        return nodeArray;
    } // end arrayASC()

    public int extractNode(NodeforHeap[] nodeArray){
        int extractint=0;
        if(nodeTemp.rootNode == null){
            return 0;
        }else{
            extractint = nodeTemp.rootNode.value;
            for(int i=0; i<nodeArray.length; i++){
                if(nodeArray[i] != null && nodeArray[i].value == extractint){
                    nodeArray[i] = new NodeforHeap();
                }
            }
        }
        return extractint;
    }

    public void modifyNode(NodeforHeap nodeforHeap, int lengthNotZero){
        NodeforHeap temp = nodeTemp;
        while(lengthNotZero-->0){
            if(nodeTemp.rootNode == null){
                nodeTemp.rootNode = nodeforHeap;
                break;
            }else if(nodeTemp.leftNode == null && nodeTemp.rightNode != null){
                nodeTemp.leftNode = nodeforHeap;
                nodeTemp.leftNode.rootNode = nodeTemp;
                break;
            }else if(nodeTemp.leftNode != null && nodeTemp.rightNode == null) {
                nodeTemp.rightNode = nodeforHeap;
                nodeTemp.rightNode.rootNode = nodeTemp;
                break;
            }else if(nodeTemp.leftNode != null && nodeTemp.rightNode != null) {
                if(right){
                    right=false;    // 다음에는 leftNode로 추가
                    nodeTemp = nodeTemp.rightNode;
                }else{
                    right=true;    // 다음에는 rightNode로 추가
                    nodeTemp = nodeTemp.leftNode;
                }
            }
            else{   // nodeTemp.leftNode == null && nodeTemp.rightNode == null
                nodeTemp.leftNode = nodeforHeap;
                nodeTemp.leftNode.rootNode = nodeTemp;
                break;
            }
        }
    } //end modifyNode()

    public static void main(String[] args) throws IOException{
        new Heap1927();
    }
}
