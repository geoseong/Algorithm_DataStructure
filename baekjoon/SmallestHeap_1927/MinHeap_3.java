package baekjoon.SmallestHeap_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by TSPark on 2017-05-27.
 * 1. 0이 아니면 Heap 배열에 추가.
 */
public class MinHeap_3 {
    int[] heapArr;  // 전역변수는 자동으로 initialize 된다.
    int valueLength;    // Heap배열의 길이

    public static void main(String[] args) throws IOException {
        new MinHeap_3();
    }
    MinHeap_3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // Line 1
        int N = Integer.parseInt(br.readLine());    // 입력받은 값
        heapArr = new int[N];

        // 힙배열의 값 집어넣기
        for(int i=0; i<N; i++){
            int valueN = Integer.parseInt(br.readLine());
            heapArr[i] = valueN;
        }
        // 최소힙 정렬 수행.
        for(int i=(N-1)/2; i>=0; i--) {
            sortHeap(i, N);     // {4, 3, 2, 1, 0}
        }
        // 처음부터 훑으면서 정렬 마무리
        for(int i=N-1; i>0; ){
            swapArr(0, i);
            i--;
            sortHeap(0, i);
        }

        for(int i=0; i<N; i++){
            System.out.println(heapArr[i]);
        }
    } //end MinHeap_3()

    // 힙배열에 데이터 추가
    void sortHeap(int cur, int nodeQty){
        while(cur < nodeQty){
            int leftIndex=(cur*2) + 1;
            int rightIndex=(cur*2) + 2;
            int pointer;  // 힙배열 포인터
            // nodeQty가 9라면 node가 9개인데, node[9]는 존재할 수 없으므로 '=' 넣음
            if(leftIndex >= nodeQty && rightIndex >= nodeQty)   break;  // 자식 인덱스가 노드 인덱스보다 많을 수 없다.

            pointer = cur;  // 이 공식이 다음 if문을 거치고 나서도 true라면, 해당 루트노드는 정렬이 다 끝난 것.
            //(leftIndex < nodeQty) :  맨 마지막 루트노드는 우측자식이 없을수도 있으니..
            if(leftIndex < nodeQty && heapArr[pointer] > heapArr[leftIndex]){
                pointer = leftIndex;
            }
            if(rightIndex < nodeQty && heapArr[pointer] > heapArr[rightIndex]){
                pointer = rightIndex;
            }
            if(cur==pointer)    break;

            swapArr(cur, pointer);  // 부모, 좌/우 자식노드들 중 제일 작은 값이 부모노드로 가게 위치변환
            cur = pointer;  // 3, 7 / 2, 5 / 1, 3
        }
    }

    void swapArr(int cur, int pointer){
        int temp=0;     // 배열 swap을 위한 임시변수
        temp = heapArr[cur];
        heapArr[cur] = heapArr[pointer];
        heapArr[pointer] = temp;
    }
}
