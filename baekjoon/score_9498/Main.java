package baekjoon.score_9498;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
//		int score = scan.nextInt();
		int score = 90;
		String result=null;
		
		// 90 ~ 100���� A, 80 ~ 89���� B, 70 ~ 79���� C, 60 ~ 69���� D, ������ ������ F
		if(90<=score && score<=100){
		    result="A";
		}
		else if(80<=score && score<90){
		    result="B";
		}
		else if(70<=score && score<80){
		    result="C";
		}
		else if(60<=score && score<70){
		    result="D";
		}
		else{
		    result="F";
		}
		System.out.println(result);
		long endTime = System.currentTimeMillis();
		System.out.println("##  �ҿ�ð�(ms) : " + ( endTime - startTime ) + "(ms)"); 
	}

}
