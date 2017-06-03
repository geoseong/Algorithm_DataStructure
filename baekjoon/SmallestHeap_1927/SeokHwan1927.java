package baekjoon.SmallestHeap_1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 최소힙
 * @author SukHwan Yoon
 *
 */
public class SeokHwan1927 {
    int[] heap;
    int heapPointer;

    public SeokHwan1927() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        initHeap();
        int op;
        for(int i=0;i<count;i++){
            op = Integer.parseInt(br.readLine());
            if(op == 0){
                System.out.println(deleteHeap());
            }else{
                insertHeap(op);
            }
        }

    }

    void initHeap(){
        heap = new int[200000];
        heapPointer = 1;
    }

    void insertHeap(int number){
        heap[heapPointer] = number;
        if(heapPointer != 1){
            int rootBuf = heapPointer/2;
            int currentPos = heapPointer;
            while(currentPos > 1 && rootBuf>= 1 && heap[rootBuf] > heap[currentPos]){
                //swap
                swap(rootBuf,currentPos);

                currentPos = rootBuf;
                rootBuf = rootBuf / 2;

            }
        }
        heapPointer++;
    }

    void swap(int index1,int index2){
        int temp;
        temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    int deleteHeap(){
        if(heapPointer == 1){
            return 0;
        }
        int returnVal = heap[1];
        heap[1] = heap[heapPointer-1];
        heap[heapPointer-1] = 0;
        int rootBuf = 1;
        while(true){
            if(heap[rootBuf*2] == 0){
                break;
            }
            else if(heap[rootBuf*2+1] == 0){
                if(heap[rootBuf*2] < heap[rootBuf]){
                    swap(rootBuf,rootBuf*2);
                }
                break;
            }else if(heap[rootBuf*2] < heap[rootBuf] && heap[rootBuf*2+1] > heap[rootBuf]){
                swap(rootBuf,rootBuf*2);
                rootBuf = rootBuf*2;
            }else if(heap[rootBuf*2+1] < heap[rootBuf] && heap[rootBuf*2] > heap[rootBuf]){
                swap(rootBuf,rootBuf*2+1);
                rootBuf = rootBuf *2 +1;
            }else if(heap[rootBuf] < heap[rootBuf*2+1] && heap[rootBuf] < heap[rootBuf *2]){
                break;
            }else{
                if(heap[rootBuf*2+1] < heap[rootBuf*2]){
                    swap(rootBuf,rootBuf*2+1);
                    rootBuf = rootBuf*2+1;
                }else{
                    swap(rootBuf,rootBuf*2);
                    rootBuf = rootBuf*2;
                }
            }
        }
        heapPointer--;
        return returnVal;
    }

    public static void main(String[] args) throws Exception {
        new SeokHwan1927();
    }
}
