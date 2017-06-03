package baekjoon.Line_2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Heap {
    int index;
    int value;  // 진입차수
    StringBuilder prev = new StringBuilder();
    StringBuilder next = new StringBuilder();

    public Heap(int index, int value) {
        this.index = index;
        this.value += value;
    }
}
public class Line_2252 {
    Heap[] heap;
    String[] printVal;

    // 우선순위 큐 : 힙정렬로 진행하는 것이 퍼포먼스 제일 
    Line_2252() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N : 인원, M : 비교횟수
        String inputStr = br.readLine();
        int N = Integer.parseInt(inputStr.split(" ")[0]);
        int M = Integer.parseInt(inputStr.split(" ")[1]);
        heap = new Heap[N];	// Heap정렬
        printVal = new String[N];

        for(int i=0; i<M; i++){
            String nextStr = br.readLine();
            int stuA = Integer.parseInt(nextStr.split(" ")[0]);
            int stuB = Integer.parseInt(nextStr.split(" ")[1]);
            if(heap[stuA-1]==null)	heap[stuA-1] = new Heap(stuA, 1);	// i번학생 우선순위 1 증
            if(heap[stuB-1]==null)	heap[stuB-1] = new Heap(stuB, 0);	// i+1번학생은 i번학생 뒤이므로 우선순위 부여 안함.

            heap[stuA-1].prev.append(heap[stuB-1].index+",");
            heap[stuB-1].next.append(heap[stuA-1].index+",");
        }

        int i=0, added=0;
        while(added < heap.length){
            if(heap[i] != null && heap[i].prev.length() == 0){
                if(heap[i].next.length() > 0) {
                    String temp="";
                    for (int n = 0; n < heap[i].next.length(); n++) {    // 진출간선 없앰.
                        if(heap[i].next.charAt(n)==',') {
                            int prev = Integer.parseInt(temp) - 1;    // 진출간선으로 뻗어있는 next의 index를 찾는다. index이기 때문에 1을 뺌.
                            heap[prev].prev.delete(0, heap[prev].prev.length());    // 해당 heap이 갖고 있던 next의 포인터값을 꺼내어 그 포인터 자리의 heap의 prev을 없앰(진입간선 없앰)
                            temp="";
                            continue;
                        }
                        temp+=heap[i].next.charAt(n);
                    }
                }
                printVal[added] = Integer.toString(heap[i].index);	// 결과출력 String에 스택처럼 쌓아둠.
                heap[i] = null;	// 진출간선 없앰.
                added++;
            }
            i++;
            if(i >= heap.length)	i=0;
        }

        for(int j=printVal.length-1; j>=0; j--){
            System.out.print(printVal[j]+" ");
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Line_2252();
    }
}
