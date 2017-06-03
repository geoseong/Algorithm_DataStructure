/*
# ����
���л� ��������� 90%�� �ڽ��� �ݿ��� ����� �Ѵ´ٰ� �����Ѵ�. ����� �׵鿡�� ���� ������ �˷���� �Ѵ�.

# �Է�
ù° �ٿ��� �׽�Ʈ���̽� C�� �־�����.
��° �ٺ��� �� �׽�Ʈ���̽� ���� ù ���� ���� N(1 <= N <= 1000)���� �л��� �־����� 
�� �������� N���� 0���� 100 ������ ������ �̾ �־�����.

# ���
�� ���̽����� ���پ� ����� �Ѵ� �л����� ������ �Ҽ��� ��°�ڸ����� �ݿø��Ͽ� ����Ѵ�.

* ���� �Է�
5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91

* ���� ���
40.000%
57.143%
33.333%
66.667%
55.556%
*/
package baekjoon.beyondavg_4344;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase = scan.nextInt();
		
		while(testcase-->0){
			// n��° �� �л� : ����� �Ѵ� �л����� ����
			int ppls = scan.nextInt();
			int[] scores = new int[ppls];
			int sum=0;
			float avg;
			float pplpercent;
			int cnt=0;
			
			for(int i=0; i<ppls; i++){
				scores[i] = scan.nextInt();
				sum = sum+scores[i];
			}
			avg = sum/ppls;
			for(int i=0; i<ppls; i++){
				if(scores[i]>avg){
					cnt++;
				}
			}
			pplpercent = (float)cnt/ppls*100;
			pplpercent = Math.round(pplpercent*1000f)/1000f;
			System.out.printf("%.3f%%\n", pplpercent);
		}
	}
}
