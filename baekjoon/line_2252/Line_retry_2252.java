package baekjoon.line_2252;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HeightList {
    int value;  // 진입차수
    int cnt_next;
    Integer[] next;  // 인접리스트 : A학생 앞의 B학생 (키 : A>B)

    HeightList() {    }

    public void to(Integer taller){
        // 가변길이배열 만듦
        this.cnt_next++;
        Integer[] temp = new Integer[this.cnt_next];
        if(this.next == null){
            this.next = new Integer[this.cnt_next];
            this.next[0] = taller;
        }else{
            for(int i=0; i<this.next.length; i++){
                temp[i] = this.next[i];
            }
            temp[this.cnt_next-1] = taller; // 마지막 자리에 추가
            this.next = null;
            this.next = temp;   // 자리수가 늘어난 배열을 this.next에 할당.
        }
    }

    public int pop(){
        int target = this.next[this.next.length-1];
        int index=0;
        this.cnt_next--;
        Integer[] temp = new Integer[this.cnt_next];  // 배열의 한자리를 줄일 거니까..
        while(index < this.cnt_next){
            if(this.next[index] != target)  {
                temp[index] = this.next[index];
                index++;
            }
        }
        this.next = null;
        this.next = temp;   // 자리수가 줄어든 배열을 this.next에 할당.
        return target;
    }
}

public class Line_retry_2252 {
    HeightList[] heights;
    Integer[] printVal;

    // 우선순위 큐 : 힙정렬로 진행하는 것이 퍼포먼스 제일 
    Line_retry_2252() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N : 인원, M : 비교횟수
        String inputStr = br.readLine();
        int N = Integer.parseInt(inputStr.split(" ")[0]);
        int M = Integer.parseInt(inputStr.split(" ")[1]);
        heights = new HeightList[N];	// Heap정렬
        for(int i=0; i<N; i++){
            heights[i] = new HeightList();
        }
        printVal = new Integer[N];

        for(int i=0; i<M; i++){
            String nextStr = br.readLine();
            int stuA = Integer.parseInt(nextStr.split(" ")[0]);
            int stuB = Integer.parseInt(nextStr.split(" ")[1]);
            // 1. 키가 stuA > stuB 인 것으로 하자. 키 작은 사람이 노드의 꼭대기로 정하자..
            // 2. 그러면 키작은사람의 진출간선은 키큰사람을 향하고, 진입간선은 없다.
            // 1-2. 틀림. 반대로해서 맞았음.
            heights[stuA-1].to(stuB-1);  // stuA가 stuB에게 진출간선 추가, LinkedList개념으로 추가.
            heights[stuB-1].value++;   // stuB는 stuA로부터 진입간선 추가됨.
        }

        // 1. 진입간선이 없는 학생(검사해서 value=0인 학생)은,
        // 2. 출력큐에 추가시킨다.
        // 3. 진출간선과의 연결을 모두 끊는다.(next[i].length 하나줄이고 heights[next[i]]의 value도 하나줄인다)
        // 4. 1~3이 진행된 이후에 다시 1번부터 과정을 반복한다.
        int added=0;
        boolean[] isAdded = new boolean[heights.length];
        while(added < heights.length){
            for(int i=0; i<heights.length; i++) {
                if (heights[i].value == 0 && !isAdded[i]) {    // 1.
                    printVal[added] = i+1;  // 2.
                    isAdded[i] = true;	// printVal에 추가된 정점은 flag=true 
                    added++;
                    int nextlength = (heights[i].next==null? 0 : heights[i].next.length);
                    for (int j = 0; j < nextlength; j++) { // 3.
                        int next = heights[i].pop();  // Stack처럼 구현한 next에서 가장 최근에 쌓인 놈을 꺼낸다.
                        heights[next].value--;
                    }
                }
            }
        }

        for(int j=0; j<printVal.length; j++){
            if(j<printVal.length-1){
            	System.out.print(printVal[j]+" ");
            }else{
            	System.out.print(printVal[j]);
            }
        	
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Line_retry_2252();
    }
}
