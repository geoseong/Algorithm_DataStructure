/*
세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최대값을 골랐다. 
이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.

# 입력
첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 
둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.

# 출력
첫째 줄에 새로운 평균을 소수점 셋째 자리에서 반올림해 둘째자리까지 출력한다.

 * 예제 입력
3
40 80 60

 * 예제 출력
75.00
 */
package baekjoon.avgScore_1546;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;	// 시험 본 과목의 개수
		float maxScore=0;	// 가장 높은 점수
		float sum=0;	// 점수 총합
		float score;	// 평균
		
		// line 1.
		n = scan.nextInt();
		float[] scores = new float[n];
		
		// line 2.
		for(int i=0; i<n; i++){
			scores[i] = scan.nextFloat();
			if(maxScore < scores[i]){
				maxScore = scores[i];
			}
		}
		
		// 계산법 : 점수/M*100
		for(int i=0; i<n; i++){
			float newScore = (scores[i] / maxScore)*100;
			sum = sum+newScore;
		}
		score = sum/n;
		score = Math.round(score*100f)/100f;
		System.out.printf("%.2f\n",score);
	}
}
