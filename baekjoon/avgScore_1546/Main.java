/*
�����̴� �⸻��縦 ���ƴ�. �����̴� ������ �����ؼ� ���� ��������� �ߴ�. �ϴ� �����̴� �ڱ� ���� �߿� �ִ밪�� �����. 
�� ���� M�̶�� �Ѵ�. �׸��� ���� ��� ������ ����/M*100���� ���ƴ�.
���� ���, �������� �ְ����� 70�̰�, ���������� 50�̾����� ���������� 50/70*100�� �Ǿ� 71.43���� �ȴ�.
�������� ������ ���� ������ ���� ������� ��, ���ο� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

# �Է�
ù° �ٿ� ���� �� ������ ���� N�� �־�����. �� ���� 1000���� �۰ų� ����. 
��° �ٿ� �������� ���� ������ �־�����. �� ���� 100���� �۰ų� ���� ���� �ƴ� �����̰�, ��� �ϳ��� ���� 0���� ũ��.

# ���
ù° �ٿ� ���ο� ����� �Ҽ��� ��° �ڸ����� �ݿø��� ��°�ڸ����� ����Ѵ�.

 * ���� �Է�
3
40 80 60

 * ���� ���
75.00
 */
package baekjoon.avgScore_1546;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;	// ���� �� ������ ����
		float maxScore=0;	// ���� ���� ����
		float sum=0;	// ���� ����
		float score;	// ���
		
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
		
		// ���� : ����/M*100
		for(int i=0; i<n; i++){
			float newScore = (scores[i] / maxScore)*100;
			sum = sum+newScore;
		}
		score = sum/n;
		score = Math.round(score*100f)/100f;
		System.out.printf("%.2f\n",score);
	}
}
