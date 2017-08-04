package baekjoon.function_1065;

import java.util.Scanner;

/*
 * . 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
 * N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 [입력]
 첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
 [출력]
 첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
 */
public class Hansoo_1065 {

	public static void main(String[] args) {
		new Hansoo_1065();
	}
	Hansoo_1065() {
		Scanner scan = new Scanner(System.in);
		int inputInt = scan.nextInt();
		int cnt=0;
		int num1=0, num10=0, num100=0, num1000=0;	// 1의 자릿수, ~ 1000의 자릿수
		
		if(inputInt<100){
			cnt=inputInt;
			System.out.println(cnt);
			return;
		}else{
			cnt=99;
		}
		for(int num=100; num<inputInt+1; num++){
			num1000=(num/1000>=10?num/1000-10:num/1000);
			num100=(num/100>=10?num/100-10:num/100);
			num10=(num/10>=10?num/10-10*(num100):num/10);
			num1=num%10;
			
			int int1000diff100 = num1000-num100;
			int int100diff10 = num100-num10;
			int int10diff1 = num10-num1;
			
			if((int1000diff100 == int100diff10) && (int100diff10 == int10diff1)){
				cnt++;
			}else if(int100diff10 == int10diff1){
				cnt++;
			}
			
		} //end for
		System.out.println(cnt);
	}
}
