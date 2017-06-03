package baekjoon.score_9498;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Scanner scan = new Scanner(System.in);
//		int score = scan.nextInt();
		int score = 90;
		String result=null;
		
		// 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F
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
		System.out.println("##  소요시간(ms) : " + ( endTime - startTime ) + "(ms)"); 
	}

}
