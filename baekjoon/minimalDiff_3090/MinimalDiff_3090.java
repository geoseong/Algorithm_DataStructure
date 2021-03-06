package baekjoon.minimalDiff_3090;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimalDiff_3090 {

/*
배열 A 탐색해서
A[i] <-> A[i+1] 의 차이값들을 저장하는 배열을 하나 더 만들고 저장? 이름은 배열 D
배열D 탐색해서 제일 수가 작은 요소를 고른다
예를 들어 D[0]=2, D[1]=1, D[2]=4, D[3]=2 이면,
배열 D를 탐색해가며 배열 D의 최소값과 비교해서 최소값보다 같거나 크다면 D배열에 해당하는 A배열을 선택해서 값을 하나씩 줄여나간다.
>>
D[2]는 기존 배열 A[2] <-> A[3]
A[2] 와 A[3]을 비교해서 큰 수 선택
A[3]이 크므로 A[3] - 1

* 입력
5 5
4 2 3 7 6

* 출력
3 2 3 4 5
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 line 1
		String[] line_one = br.readLine().split(" ");
        int N = Integer.parseInt(line_one[0]);	// 입력정수갯수 
        int T = Integer.parseInt(line_one[1]);	// 연산횟수 
        // 입력 Line 2
        String[] line_two = br.readLine().split(" ");
        int[] A = new int[N];	// 입력 수 저장하는 정수배열 
        int[] D = new int[N-1];	// A 인접값의 차이를 저장하는배열: 우선순위값 저장하는.
        
        // 배열 A 데이터 완성 : String.split()으로 저장된 배열 int타입으로 변환 
        for(int i=0; i<line_two.length; i++){
        	A[i] = Integer.parseInt(line_two[i]);
        }
        
	    while(T-->0){
	    	// 배열 D 데이터 완성 : A인접값의 차이값 배열 데이터 넣기 
	        for(int i=0; i<D.length; i++){
	        	D[i] = Math.abs(A[i] - A[i+1]);
	        }
	    	// 인접배열의 차이값들 중 최소값 구해놓기
	        int maxDiff = Integer.MIN_VALUE;
		    for(int val : D){
			   if(val > maxDiff){
				   maxDiff = val;
			   }
		    }
		    // 
		    int targetA=-1;
		    for(int i=0; i<D.length; i++){
		    	if(D[i] == maxDiff){	// 인접배열 차이값 탐색 시 차이값의 최소값보다 작거나 같다면 
		    		targetA = i;	// 배열 A에서 건드려야 할 인덱스를 찍어둠.
		    		
		    		if(A[targetA] > A[targetA+1]){	// A[2] 와 A[3]을 비교해서 큰 수 선택 후 -1
		    			A[targetA]--;
		    		}else{
		    			A[targetA+1]--;
		    		}
		    		D[targetA] = Math.abs(A[targetA] - A[targetA+1]);
		    		break;
		    	}
		    }        	
        } //end while
	    for(int i : A){
	    	System.out.print(i+" ");
	    }
	}

}
/* 틀린 케이스
이 코딩 결과의 A[10] = 65가 나와버림..
A[9] = 74, A[10] = 66
D[9] = 8
차이값 최대는 D[49]
# in 1
71 236
106 98 97 92 88 88 87 84 77 74 66 58 53 51 22 52 55 28 43 27 49 46 26 43 39 57 42 50 33 43 41 46 23 38 28 48 35 22 24 26 43 43 31 31 35 24 27 55 57 57 22 27 31 36 42 50 36 25 51 57 58 60 63 67 68 74 75 75 89 104 107
# out 1
모범 / 디벅
106 98 97 92 88 88 87 84 77 74 /66/ 55 44 33 22 33 39 28 38 27 38 37 26 37 39 50 42 44 33 43 41 34 23 34 28 39 33 22 24 26 37 42 31 31 35 24 27 38 44 33 22 27 31 36 42 47 36 25 36 47 58 60 63 67 68 74 75 75 86 97 107
106 98 97 92 88 88 87 84 77 74 /65/ 55 44 33 22 33 39 28 38 27 38 37 26 37 39 50 42 44 33 43 41 34 23 34 28 39 33 22 24 26 37 42 31 31 35 24 27 38 44 33 22 27 31 36 42 47 36 25 36 47 58 60 63 67 68 74 75 75 86 97 107
미세하게 1씩 다르다..

 */