package baekjoon.function_2448;

import java.util.Scanner;

/*
[입력]
첫째 줄에 N이 주어진다. N은 항상 3*2^k 수이다. (3, 6, 12, 24, 48, ...) (k<=10)
[출력]
첫째 줄부터 N번째 줄까지 별을 출력한다.
1 :3*2^0=3
2 :3*2^1=6
3 :3*2^2=12
#공백 :
[0] 0
[1] 5/3/1
[2] 11/9/7
[3] 5/3/1
...
1/3/5//7/9/11/...//13/15/17//19/21/23
#별갯수 : 사이클1~4
[0]1,2,5
[1]2,4,10
[2]2,4,10
[3]4,8,20

 */
public class Star_2448 {

	public static void main(String[] args) {
		new Star_2448();
	}

	Star_2448(){
		Scanner scan = new Scanner(System.in);
		int line = scan.nextInt();
		int max = line;
//		int empty=0;
//		int[] empty = {0,1,0,  5,3,1,  11,9,7, 5,3,1,  23,21,19, 17,15,13, 11,9,7, 5,3,1};
		int[] emptybetween = {0,1,0,5,3,1,11,9,7,5,3,1,23,21,19,17,15,13,11,9,7,5,3,1};
//		int star=0;
//		int[] star = {1,2,5, 2,4,10,  2,4,10, 4,8,20,  2,4,10, 4,8,20, 4,8,20, 8,16,40};
		int[] star = {1,2,5,2,4,10,2,4,10,4,8,20,2,4,10,4,8,20,4,8,20,8,16,40};
//		2^0, 2^1, 2^2, 2^3
		
//		nnSnn
//		nSnSn
//		SSSSS
		while(line-->0){
			for(int i=0; i<line; i++){
				System.out.print(" ");
			}
			for(int i=0; i<star[max-(line+1)]; i++){
				System.out.print("*");
			}
			System.out.println();
		} // end while
	}
}
