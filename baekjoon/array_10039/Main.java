package baekjoon.array_10039;

import java.util.Scanner;

/* 보충학습은 거부할 수 없기 때문에, 40점 미만인 학생들은 항상 40점을 받게 된다.
 * 학생 5명의 점수가 주어졌을 때, 평균 점수를 구하는 프로그램을 작성하시오. 
[입력]
10
65
100
30
95
[출력]
68
*/
public class Main {

	public static void main(String[] args) {
		new Main();
	}
	Main(){
		Scanner scan = new Scanner(System.in);
		int loop = 5;
		int temp = loop;
		int totalSum=0;
		
		while(temp-->0){
			int valueNow = scan.nextInt();
			if(valueNow<=40)	valueNow=40;
			totalSum += valueNow;
		} //end while
		
		System.out.println(totalSum/loop);
	} //end Main
}
