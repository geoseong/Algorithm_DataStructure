package baekjoon.SmallestHeap_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by TSPark on 2017-05-27.
 */
public class Heap_N_1927 {
    int[] notZero;  // 전역변수는 initialize를 안해줘도 자동으로 null로 initialize된다.
    int lengthNotZero=0;    // 입력받은 배열들 중 0이 아닌 수의 길이
    int[] nodeArray;   // 입력받은 값 저장하는 배열

    Heap_N_1927() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // Line 1
        int N = Integer.parseInt(br.readLine());    // 입력받은 값
        nodeArray = new int[N];
        // 1. 입력값 배열로 넣음.
        // 2. 입력값이 0이면, 최소힙노드의 Root값 출력 + 현재 배열에 0이 아닌 수 재정렬 + 최소힙노드삽입
        // 3. 입력값이 0이 아니면, 현재 배열에 0이 아닌 수 재정렬 + 최소힙노드삽입
        // --> 시도1 시간초과. Main()에서 반복문 3중 도는 메소드 : arrayASC(), modifyNode()
        // arrayASC() : 2중 for문에서 1중 while문으로 개선
        // setHeapArray() : 1중 for문
        // extractNode() : 1중 for문
        // --> 시도2 시간초과. 최대 반복문 중복횟수 : 2회
        // setHeapArray(), extractNode()의 반복문을 for문에서 while문으로 변환

        for(int i=0; i<N; i++){
            int valueN = Integer.parseInt(br.readLine());
            if(valueN > 0) {    // 입력값이 0이면 rootNode출력, 0이상이면 Node 삽입
                lengthNotZero++;
                nodeArray[i] = valueN;
                nodeArray = arrayASC(nodeArray, i);  // 현재 배열 오름차순 재정렬(nodeArray[] 정렬)
                setHeapArray(nodeArray, lengthNotZero, i+1);        // 0이 아닌 수 힙배열방식으로 추가.(전역변수 notZero[])
            }else{
                int result = extractNode(nodeArray);  // 루트노드(notZero[0] 추출, 추출하는 값과 일치하는 nodeArray의 값도 비움(0으로 세팅))
                sb.append(Integer.toString(result)+'\n');
                if(result <= 0)  continue;  // 더이상의 힙트리의 value가 남아있지 않다는 뜻
                nodeArray = arrayASC(nodeArray, i);  // 현재 배열 오름차순 재정렬(nodeArray[] 정렬)
                setHeapArray(nodeArray, lengthNotZero, i+1);        // 0이 아닌 수 힙배열방식으로 추가.(전역변수 notZero[])
            }
        } //end for

        System.out.println(sb.toString());
    } //end Main()

    // 0이 아닌 수 힙배열방식으로 추가.(전역변수 notZero[])
    public void setHeapArray(int[] nodeArray, int existLength, int lengthSofar){
        notZero = null; // newZero[] 초기화
        notZero = new int[existLength]; // 0이 아닌 수를 저장하는 배열.
        int count=0;
        int duplLength = lengthSofar;
        while(lengthSofar-->0){
            int index = duplLength-(lengthSofar+1);
            if(nodeArray[index]>0){
                notZero[count] = nodeArray[index];
                count++;
            }
        }
//        for(int i=0; i<lengthSofar; i++){
//            if(nodeArray[i]>0){
//                notZero[count] = nodeArray[i];
//                count++;
//            }
//        }
    } // end setnotZeroArray()

    // 현재 배열 오름차순 재정렬(nodeArray[] 정렬)
    public int[] arrayASC(int[] nodeArray, int existLength){
        int temp=0;
        int i=0;
        int swapped=0;
        while(true){
            if (nodeArray[i] > nodeArray[i + 1]) {
                swapped++;
                temp = nodeArray[i];
                nodeArray[i] = nodeArray[i + 1];
                nodeArray[i + 1] = temp;
            }
            if(i >= existLength-1){ // 한바퀴 다 돌았으면 0부터 다시 시작.
                if(swapped==0)  break;  // 순회하면서 swap횟수가 0이면 다 정렬된 것이므로 break;
                i = 0;  swapped=0;  continue;
            }else{  i++;    }
        }
        return nodeArray;
    } // end arrayASC()

    // 루트노드(notZero[0] 추출, 추출하는 값과 일치하는 nodeArray의 값도 비움(0으로 세팅))
    public int extractNode(int[] nodeArray){
        int extractint=0;
        if(lengthNotZero <= 0)  {
            lengthNotZero=0;
        }else{
            lengthNotZero--;
        }
        if(notZero==null || notZero.length <= 0){
            return 0;
        }else{
            extractint = notZero[0];
            int nodelength = nodeArray.length;
            while(nodelength-->0){
                int index = nodeArray.length-(nodelength+1);
                if(nodeArray[index] == extractint){
                    nodeArray[index] = 0;
                    break;
                }
            }
//            for(int i=0; i<nodeArray.length; i++){
//                if(nodeArray[i] == extractint){
//                    nodeArray[i] = 0;
//                    break;
//                }
//            }
        }
        return extractint;
    } //end extractNode()

    public static void main(String[] args) throws IOException{
        new Heap_N_1927();
    }
}
