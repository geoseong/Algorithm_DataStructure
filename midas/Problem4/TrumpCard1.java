package midas.Problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Case 1
2 3 4 5 6 7 8 9 10 J Q K A
3 J 2 Q 10 K 4 9 5 8 6 A 7
Case 2
7 5 6 10 4 Q 8 J K 3 2 9 A
3 2 5 8 A Q 9 J 10 4 6 K 7
 */
public class TrumpCard1 {
    // 0.	int M, int max(M의 max값 판별)하는 변수 정의
    int M=0,
        max=0,
        ind_Bef_aft=0;  // 섞기 전 인덱스의 반복 시작점 정하는 변수

    String[] beforeMixed, afterMixed;

    public static void main(String[] args) throws IOException{
        new TrumpCard1();
    }
    TrumpCard1() throws IOException{
        StringTokenizer token = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 섞기전
        beforeMixed = br.readLine().split(" ");
        // 섞은 후
        afterMixed = br.readLine().split(" ");

        // 1. afterMixed[]의 값을 발견 (afterMixed[인덱스])
        for(int i=0; i<afterMixed.length; i++){
            // 2.	beforeMixed[]의 값과 afterMixed[]와 일치하는 인덱스부터 반복문 시작.
            // B[인덱스+1] 와 1.1에서 설정된 A[인덱스] 부터 A[length]까지 반복시켜서
            setM(i, ind_Bef_aft);
            // 3. M값이 max값보다 크면 max = M
            if(M>=max)  max = M;
        }
        // 4. max값 출력
        System.out.println("max값 - " + max);
    }

    public void setM(int i, int ind_Bef_aft){
        for(int j=ind_Bef_aft; j<beforeMixed.length; j++){
            if(afterMixed[i].equals(beforeMixed[j])){
                // 2.1 beforeMixed[]의 인덱스는 : beforeMixed[]의 값과 afterMixed[]와 일치하는 인덱스로 이동시킴.
                this.ind_Bef_aft = j;
                // 2.2 일치하는 값이 있으면 M+1
                M++;
                break;
            }
            if(j==(beforeMixed.length-1)){
                // 시작 인덱스(ind_Bef_aft)가 배열 끝자리면, 시작 인덱스를 0으로 초기화하여여 처음부터 다시 탐색
               // M 도 따라서 0으로 초기화
                M = 0;
                setM(i, 0);
            }
        }
    }
}
