package baekjoon.Tiling_2xn_11726;
/*
# 입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
1. 2
2. 9

# 출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
1. 2
2. 55
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tile_x = Integer.parseInt(br.readLine());
		
		// Dynamic array : 입력된 숫자만큼의 크기 배열 정의
		int[] dynamicArr = new int[tile_x];
		
		// 2x1 : 1 , 2x2 : 2 , 2x3 : 3 , 2x4 : 5, 2x5 : 8
		// 2xn : 2x(n-1)x(n-2)
		
		for(int n=0; n<tile_x; n++){
			int cal=0;
			if(n<1){
				cal = 1;
			}
			else if(n < 2){
				cal = dynamicArr[n-1] + 1;
			}
			else{
				cal = dynamicArr[n-1] + dynamicArr[n-2];				
			}
			// 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지
			dynamicArr[n] = cal % 10007;
		}
		System.out.println(dynamicArr[tile_x-1]);
		
	}

}
