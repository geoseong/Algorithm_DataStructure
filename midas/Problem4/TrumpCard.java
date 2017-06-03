package midas.Problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/*
Case 1
2 3 4 5 6 7 8 9 10 J Q K A
3 J 2 Q 10 K 4 9 5 8 6 A 7
Case 2
7 5 6 10 4 Q 8 J K 3 2 9 A
3 2 5 8 A Q 9 J 10 4 6 K 7
 */
public class TrumpCard {
    // 0. int M, int max(M의 max값 판별)하는 변수 정의
    int M=0,
        max=0,
        duplicate_call=0;  // setM 메소드 중첩횟수 구하기

    String[] beforeMixed, afterMixed;
    Stack<String> sameOrder;

    public static void main(String[] args) throws IOException{
        new TrumpCard();
    }
    TrumpCard() throws IOException{
        StringTokenizer token = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 섞기전
        beforeMixed = br.readLine().split(" ");
        // 섞은 후
        afterMixed = br.readLine().split(" ");
        // 섞은 후에도 순서가 같은 배열요소를 저장
        sameOrder = new Stack<>();
        // 섞기 전 인덱스의 반복 시작점 정하는 변수
        int ind_Bef_aft=0;

        // 1. afterMixed[]의 값을 발견 (afterMixed[인덱스])
        for(int i=0; i<afterMixed.length; i++){
            // 2.	beforeMixed[]의 값과 afterMixed[]와 일치하는 인덱스부터 반복문 시작.
            setM(i, 0);
        }
        // 4. max값 출력
        System.out.println("max값 - " + max);
    } // end TrumpCard()

    // 3. 최대 연속요소 M 구하는 기능
    public int setM(int i, int ind_Bef_aft){
        for(int j=ind_Bef_aft; j<beforeMixed.length; j++){
            if(afterMixed[i].equals(beforeMixed[j])){
                // 연속된 요소를 배열에 넣고, 배열의 길이를 M으로 계산.
                sameOrder.add(afterMixed[i]);
                // afterMixed와 beforeMixed값이 일치 && 그 beforeMixed의 index가 맨 끝이라면,
                // 해당 재귀호출 메소드를 리턴
                if(j==(beforeMixed.length-1)){
                    getM(sameOrder);
                    return ind_Bef_aft+1;   // break;
                }else{
                    // 반복을 시작할 섞기전 배열의 인덱스는 : 섞기전 배열의 값과 섞은후 배열이 일치하는 인덱스로 세팅.
                    ind_Bef_aft = j;
                    // 재귀호출.
                    setM(i+1, ind_Bef_aft+1);
                    getM(sameOrder);
                }
            }
            // 섞인 이후의 요소가 섞기전 요소의 순서와 같지 않으면서 끝까지 비교 했다면
            // 해당 재귀호출 메소드를 리턴하고, 섞기전 배열의 반복시작 인덱스를 내뱉음.
            // └ 상위메소드에서 섞은후 배열의 다음 인덱스와 비교하기 위함.
//            if(j==(beforeMixed.length-1)){
//            }
        }
        setM(i+1, ind_Bef_aft);
        return ind_Bef_aft+1;
    } //end setM()

    // M의 사이즈를 구하고 역대 M을 비교해서 최대값 설정.
    public void getM(Stack<String> sameOrder){
        int M = sameOrder.size();
        if(M>=this.max)  this.max = M;
        if(M>0) sameOrder.pop();
    } //end getM(0
}
