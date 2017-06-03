package baekjoon.ChocoSlice_2163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 초콜릿을 계속 쪼개서 총 N×M개의 조각으로 쪼개려고 한다. 
 초콜릿을 쪼갤 때에는 초콜릿 조각을 하나 들고, 적당한 위치에서 초콜릿을 쪼갠다.
 이제 다시 이 중에서 초콜릿 조각을 하나 들고, 쪼개는 과정을 반복하면 된다.
 # input
	 두 정수 N, M(1≤N, M≤300)
	 ex) 2 2
 # output
	 1×1 크기의 초콜릿으로 쪼개기 위한 최소 쪼개기 횟수
	 ex) 3
 */
/* 2163번.
1. n, m 비교해서 가장 큰 int를 고른다.
	4 x 3일때 4행이 가장 크므로 4x1 이 나오도록 한번 자른다.
	- 횟수 = 1
2. 나머지도 같은 방식으로 자른다. (잘린조각으로 자른다.)
	행은 유지시키고, 열을 1의 단위가 나올때까지 계속 쪼갠다.
	- 횟수 = (m-1) -1	// 끝에 -1은 1.번의 횟수를 덧붙힘
3. 자르던 조각은 냅둔다. 미리 계산하라면 계산할 수 있다. 4 x 1을 나누려면 3번..
	- 횟수 = (n-1)
4. 이제 자르던 조각과 같은 스틱으로 행단위로 쪼갠다. 3.번의 자르던 조각과 같은 스틱으로 자른다.
	- 횟수 = (n-1)
1~4 횟수 
= 1 + {(m-1)-1} + (n-1) + (n-1)
= (m-1) + 2n-2 
= 2n + m - 3
 */
public class Main_old1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strinput=br.readLine();
		int n = Integer.parseInt(strinput.split(" ")[0]);
		int m = Integer.parseInt(strinput.split(" ")[1]);
		int splitcnt=0;
		int[] cntsum = new int[3];
		
		for(int i=0; i<cntsum.length; i++){
			if(n>m || n==m){
				cntsum[i] = getSplitcnt(i, n, m);
			}else{
				cntsum[i] = getSplitcnt(i, m, n);
			}
			splitcnt = splitcnt + cntsum[i];
		}
		
		System.out.printf("%d\n", splitcnt);
	}
	
	public static int getSplitcnt(int index, int big, int small){
//		int splitcnt=0;
//		int[] cntsum = new int[3];
		
//		for(; index<3; index++){
			if(index==0){
				return (small-1);
			}
//			else if(index<3){
//				getSplitcnt(index, big, small);
//			}
//		}
		/*
		// 1~2 : Column or Row
		cntsum[0] = (small-1);
		// 3 : Row or Column
		cntsum[1] = (big-1);
		// 4 : Slice thing
		cntsum[2] = (big-1);
		 */
		
		return (big-1);
	}
}
