package baekjoon.SmallestHeap_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Correct_1927 {
    int[] heapArr;  // 전역변수는 자동으로 initialize 된다.

    public static void main(String[] args) throws IOException {
        new Correct_1927();
    }

    Correct_1927() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // Line 1
        int N = Integer.parseInt(br.readLine());
        if(N%2==1){	// Heap정렬 완전이진트리 구성.
            heapArr = new int[N];
        }else{
            heapArr = new int[N+1];
        }

        int i=0;	// Heap배열의 길이
        // 입력값 배열로 넣음.
        // 입력값이 0이면: 최소힙노드의 Root값 출력 + 현재 배열에 0이 아닌 수 재정렬 + 최소힙노드삽입
        // 입력값이 0이 아니면: 현재 배열에 0이 아닌 수 재정렬 + 최소힙노드삽입
        while(N-->0){
            int valueN = Integer.parseInt(br.readLine());
            if(valueN > 0) {
                // 최소힙 삽입 후 정렬 수행.
                heapArr[i] = valueN;
                i++;
                for(int j=(i-1)/2; j>=0; j--) {
                    sortHeap(j, i);     // {4, 3, 2, 1, 0}
                }

            }else{
                i--;
                if(i<0){
                    i=0;
                    sb.append("0\n");
                    continue;
                }
                // 루트노드 제외 & 배열크기 줄임
                sb.append(heapArr[0] + "\n");
                swapArr(0, i);
                for(int j=(i-1)/2; j>=0; j--){
                    sortHeap(j, i);
                }
            }
        } //end while
        System.out.println(sb.toString());
    }

    // 힙배열에 데이터 추가
    void sortHeap(int cur, int nodeQty){
        while(cur < nodeQty){
            int leftIndex=(cur*2) + 1;
            int rightIndex=(cur*2) + 2;
            int pointer;  // 힙배열 포인터
            // nodeQty가 9라면 node가 9개인데, node[9]는 존재할 수 없으므로 '=' 넣음
            if(leftIndex >= nodeQty && rightIndex >= nodeQty)   break;  // 자식 인덱스가 노드 인덱스보다 많을 수 없다.

            pointer = cur;  // 이 공식이 다음 if문을 거치고 나서도 true라면, 해당 루트노드는 정렬이 다 끝난 것.

            // 좌측노드, 우측노드 중 하나가 없을 수도 있는 부분을 체크하는 로직.
            if(leftIndex < nodeQty && heapArr[pointer] > heapArr[leftIndex]){
                pointer = leftIndex;
            }
            if(rightIndex < nodeQty && heapArr[pointer] > heapArr[rightIndex]){
                pointer = rightIndex;
            }
            if(cur==pointer)    break;

            swapArr(cur, pointer);  // 부모, 좌/우 자식노드들 중 제일 작은 값이 부모노드로 가게 위치변환
            cur = pointer;
        }
    }

    void swapArr(int cur, int pointer){
        int temp=0;     // 배열 swap을 위한 임시변수
        temp = heapArr[cur];
        heapArr[cur] = heapArr[pointer];
        heapArr[pointer] = temp;
    }
}
