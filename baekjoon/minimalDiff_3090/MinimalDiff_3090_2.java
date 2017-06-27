package baekjoon.minimalDiff_3090;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by TSPark on 2017-06-27.
# 이진 탐색
1. 우선 첫번째 과정으로는 데이터 집합의 중앙 요소를 선택합니다.
2. 두번째 과정으로는 중앙 요소의 값과 찾으려는 값을 서로 비교
    if 찾으려는 값이 중앙 요소의 값보다 작다면 중앙 요소의 왼편에서 중앙 요소를 다시 택하고,
    else 찾으려는 값이 중앙 요소의 값보다 크다면 오른편에서 중앙 요소를 다시 택하게 됩니다.
3. 다시 이진 탐색(Binary Search)를 거치는 것

 # 해설 PDF 설명..
 T : line 1, param[1].   : 연산횟수
 D : maximal absolute    : A[i]과 A[i+1]의 가장 큰 차이값 D
 difference of any two neighbouring numbers in your solution
 > A[i]과 A[i+1]의 가장 큰 차이값 D 보다 같거나 작을때까지 가장 작은 숫자를 골라서 줄여 나가라...?
 ... 가장 작은 숫자는 분명 A[]의 가장 큰 차이값보다 작지 않을까? ...

 # my comment
 실제로는 이진탐색을 하며
 1. ans에 값을 중첩시키고,
 2. a배열의 값을 바꾼 이후에,
 2-*. llint m, res를 알아야할듯..
 3. 중첩된 ans가 m과 비교했을때 작냐 같냐 판별 boolean을 리턴 ( 가운데값보다 작냐 같냐 )
 4. 리턴된 boolean으로 다음 이진 탐색을 가운데 기준 좌측으로 갈지 우측으로 갈지 결정 ( lo, hi 값 변화로 )
 */
public class MinimalDiff_3090_2 {
    int N, T, rem, m;
    int MAXN = 100005;
    int[] A = new int[MAXN];
    int[] D = new int[MAXN];


    public static void main(String[] args) throws IOException{
        new MinimalDiff_3090_2();
    }

    MinimalDiff_3090_2() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 line 1
        String[] line_one = br.readLine().split(" ");
        N = Integer.parseInt(line_one[0]);    // 입력정수갯수
        T = Integer.parseInt(line_one[1]);    // 연산횟수
        // 입력 Line 2
        String[] line_two = br.readLine().split(" ");
//        A = new int[N];    // 입력 수 저장하는 정수배열
//        D = new int[N];    // A 인접값의 차이를 저장하는배열: 우선순위값 저장하는.

        // 배열 A 데이터 완성 : String.split()으로 저장된 배열 int타입으로 변환
        for (int i = 0; i < line_two.length; i++) {
            D[i] = Integer.parseInt(line_two[i]);
        }

        // 이진 탐색
        int lo = 0, hi = 1000000000;
        while( lo < hi ) {    // 이진탐색
            int mid = (lo+hi)/2;
            if( go(mid) ){  // go() : A[] 값을 조작하는 곳.
                hi = mid;   // 좌측 탐색을 위한 hi 값 변경
            } else{
                lo = mid+1; // 우측 탐색을 위한 lo 값 변경
            }
        }

        go(lo); // go() : A[] 값을 조작하는 곳.
        // 결과 출력
        for(int res : A){
            System.out.print(res + " ");
        }
    } //end Main

    boolean go( int d ) {
        // 이진탐색에서 지적되는 배열의 중간값을 이용해서 A배열의 값을 조정하는 듯..
        for( int i = 0; i < N; ++i )
            A[i] = D[i];
        int ans = 0;
        for( int i = 0; i+1 < N; ++i )    // 0부터 순차적으로 인덱스 탐색
        {
            if (A[i + 1] > A[i] + d) {
                ans += A[i + 1] - (A[i] + d);
                A[i + 1] = A[i] + d;
            }
        }
        for( int i = N-1; i > 0; --i )    // n부터 역으로 인덱스 탐색
        {
            if (A[i - 1] > A[i] + d) {
                ans += A[i - 1] - (A[i] + d);
                A[i - 1] = A[i] + d;
            }
        }
        rem = m-ans;    // rem, m, ans 모두 llint다... 그냥 int같긴하다 초기값이 0인..
        return ans <= m;  // boolean 리턴.
    }
}
