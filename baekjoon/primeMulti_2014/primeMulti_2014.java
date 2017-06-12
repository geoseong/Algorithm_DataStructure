package baekjoon.primeMulti_2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by TSPark on 2017-06-10.
 *** 문제 :
 * 소수들을 선택할 때에는 같은 수를 선택해도 되며, 주어지는 소수 자체도 포함시키자.
 * 세 소수가 2, 5, 7이었다면, 이러한 곱들을 오름차순으로 나타내 보면,
 * 2, 4, 5, 7, 8, 10, 14, 16, 20, 25, 28, 32, 35, 등이 된다.
 *** 입력 :
 * 첫째 줄에 K(1≤K≤100), N(1≤N≤100,000)이 주어진다. 다음 줄에는 K개의 소수들이 주어진다.
 * 첫째 줄에 N번째 Humble Number를 출력한다.
 * 4 19
 * 2 3 5 7
 */
    /*
    [생각1]
        arr[0] = 2, arr[1] = 5, arr[2] = 7
        가능한 모든 경우의수를 뽑고 곱해야..
        조합인 듯함.. n개에서 2개를 뽑아..
    [남의블로그]
        1. array와 큐 Q3,Q5,Q7 초기화
        2. 1을 array에 삽입
        3. 1*3,1*5,1*7을 각각 Q3,Q5,Q7에 삽입.
        4. x를 Q3,Q5,Q7의 최솟값으로 설정.
        5. x가 어느 큐에서 발견되느냐에 따라 다음을 수행:
            Q3에서 발견: 3*x, 5*x, 7*x를 각각 Q3,Q5,Q7에 삽입. x를 Q3에서 제거.
            Q5에서 발견: 5*x,7*x를 각각 Q5,Q7에 삽입. x를 Q5에서 제거.
            Q7에서 발견: 7*x를 Q7에 삽입. x를 Q7에서 제거.
        6. N번째를 찾을때까지 4~6반복.
    */
public class primeMulti_2014 {
    public static void main(String[] args) throws IOException {
        new primeMulti_2014();
    }
    primeMulti_2014() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 Line 1
        String[] line_one = br.readLine().split(" ");
        int K = Integer.parseInt(line_one[0]);
        int N = Integer.parseInt(line_one[1]);
        // 입력 Line 2
        String[] line_two = br.readLine().split(" ");

        Heap result = new Heap();     // 결과값을 저장하고 있는 Heap. array[0] 기본적으로 1 갖고있음.
        int[] intArr = new int[K];  // Queue 탐색하며 비교하기 위한 새로운 int[]
        int[] multiArr = new int[K];
        Heap[] queues = new Heap[K];   // 입력된소수에 대한 Queue객체 생성.

        // 입력된 소수 오름차순 정렬
        boolean switched=false;
        for(int i=0; i<line_two.length; i++){
            for(int j=0; j<line_two.length; j++){
                int a = Integer.parseInt(line_two[i]);
                int b = Integer.parseInt(line_two[j]);
                String temp=null;
                if(i!=j && a>b){
                    temp = line_two[a];
                    line_two[a] = line_two[b];
                    line_two[b] = temp;
                    switched=true;
                }
            } //end for
            if(!switched)    break;
        } //end for

        // 입력된 소수에 대한 Queue객체 내용 구성
        for(int i=0; i<line_two.length; i++){
            int queue = Integer.parseInt(line_two[i]);
            queues[i] = new Heap(queue);
            intArr[i] = queue;  multiArr[i] = queue;
        } //end for

        // 결과배열에 데이터 추가
        int idx=-1;
        int multi_int = 0;
        boolean isExit = false;
        while(true){
            boolean open = false;
            for(int i=0; i<K; i++){ // Q2, Q3, Q5, Q7이 순서대로 삽입된 거라 치면..
                if(queues[i].array[0]==1){
                    queues[i].add(queues[i].array[0] * intArr[i]);
                    result.addHeap(queues[i].array[0] * intArr[i]);
                    queues[i].remove();
                    continue;
                }
                if(open || intArr[idx] == queues[i].array[0]){
                    int multi = queues[i].array[0] * multi_int;
                    queues[i].add(multi);
                    result.addHeap(multi);
                    if(i==0 || open){   // 그럼 flag가 열리게 해야할듯
                        if(intArr[i] == queues[i].remove()) {    // Queue[0] 이 제거되고 리턴됨.
                            intArr[i] = queues[i].element();
                        }
                        open = true;
                    }
                }
                // N값이 result.arraylength보다 같거나 작으면 break;
                if(N <= result.arraylength){
                    System.out.println(result.array[N-1]);    // 결과출력. 끝.
                    isExit=true;
                }
            } //end for
            if(isExit)  break;
            idx++;
            if(idx >= K){
                for(int k=0; k<K; k++)  multiArr[k] = intArr[k];
                idx=0;
            }
            multi_int = multiArr[idx];
        } //end while
    } //end Main()
} //end class

/** 결과출력을 위한 최소 힙(오름차순) */
class Heap{
    int queuevalue;
    int arraylength;
    int[] array;

    Heap() {
        this.arraylength = 1;
        this.array = new int[this.arraylength];
        this.array[0] = 1;
    }
    Heap(int queuevalue) {
        this.queuevalue = queuevalue;
        this.arraylength = 1;
        this.array = new int[this.arraylength];
        this.array[0] = 1;
    }

    void add(int value){
        // 가변길이배열 만듦
        this.arraylength++;
        int[] temp = new int[this.arraylength];

        for(int i=0; i<this.array.length; i++){
            temp[i] = this.array[i];
        }
        temp[this.arraylength-1] = value; // 마지막 자리에 새로운 요소 추가
        this.array = null;  // 길이+1 이 된 배열 영접 위한 기존 배열 초기화
        this.array = temp;   // 자리수가 늘어난 배열을 this.array에 할당.
    }

    void addHeap(int value){
        // 가변길이배열 만듦
        this.arraylength++;
        int[] temp = new int[this.arraylength];

        for(int i=0; i<this.array.length; i++){
            temp[i] = this.array[i];
        }
        temp[this.arraylength-1] = value; // 마지막 자리에 새로운 요소 추가
        this.array = null;  // 길이+1 이 된 배열 영접 위한 기존 배열 초기화
        this.array = temp;   // 자리수가 늘어난 배열을 this.array에 할당.

        // 힙배열 시전
        temp = new int[this.arraylength];
        int i = this.arraylength;
        int idx=0;
        while(true){
            i--;
            if(i<0){
                this.array = null;  this.array = temp;
                break;
            }
            // 루트노드 제외 & 배열크기 줄임
            temp[idx] = this.array[0];  idx++;
            swapArr(0, i);
            for(int j=(i-1)/2; j>=0; j--) {
                sortHeap(j, i);
            }
        }
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
            if(leftIndex < nodeQty && this.array[pointer] > this.array[leftIndex]){
                pointer = leftIndex;
            }
            if(rightIndex < nodeQty && this.array[pointer] > this.array[rightIndex]){
                pointer = rightIndex;
            }
            if(cur==pointer)    break;

            swapArr(cur, pointer);  // 부모, 좌/우 자식노드들 중 제일 작은 값이 부모노드로 가게 위치변환
            cur = pointer;
        }
    }
    void swapArr(int cur, int pointer){
        int temp=0;     // 배열 swap을 위한 임시변수
        temp = this.array[cur];
        this.array[cur] = this.array[pointer];
        this.array[pointer] = temp;
    }

    int remove(){
        int index=0;
        int target = this.array[index];
        this.arraylength--;
        int[] temp = new int[this.arraylength];  // 배열의 한자리를 줄이기 위한 임시 배열
        for(int i=0; i<this.arraylength; i++){
            temp[i] = this.array[i+1];
        }
        this.array = null;  // 길이+1 이 된 배열 영접 위한 기존 배열 초기화
        this.array = temp;   // 자리수가 줄어든 배열을 this.array에 할당.
        return target;
    }
    int element(){
        return this.array[0];
    }
}
