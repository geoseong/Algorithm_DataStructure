package baekjoon.primeMulti_2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by TSPark on 2017-06-17.
 */
public class prime_2014_Success {
    public static void main(String[] args) throws IOException {
        new prime_2014_Success();
    }

    prime_2014_Success() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 Line 1
        String[] line_one = br.readLine().split(" ");
        int K = Integer.parseInt(line_one[0]);
        int N = Integer.parseInt(line_one[1]);
        // 입력 Line 2 - 소수 모음
        String[] line_two = br.readLine().split(" ");

        int[] prime = new int[K];  // Queue 탐색하며 비교하기 위한 int[]
        int[] prime_index = new int[K]; // 각 Queue의 배열값들 중 비교대상을 정하기 위한 인덱스 저장
        int[] print = new int[N+1];   // 출력을 위한 배열

        // 입력된 소수에 대한 Queue객체 내용 구성 ( line_two = String배열 )
        for (int i = 0; i < line_two.length; i++) {
            int queue = Integer.parseInt(line_two[i]);
            prime[i] = queue;    // Q2, Q3, Q5, Q7..
        } //end for

        int num = 1;
        print[0] = 1;
        while(num != N + 1){
            int min = Integer.MAX_VALUE;
            int m = -1;
            for(int i = 0; i < K; i++){
                while(prime[i] * print[prime_index[i]] <= print[num - 1])
                    prime_index[i]++;
                if(prime[i] * print[prime_index[i]] < min){
                    min = prime[i] * print[prime_index[i]];
                    m = i;
                }
            }
            print[num] = min;
            num++;
            prime_index[m]++;
        }
        System.out.println(print[N]);
    } //end prime_2014_Success
} //end class