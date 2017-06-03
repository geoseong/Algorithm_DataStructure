package baekjoon.ChocoSlice_2163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 ���ݸ��� ��� �ɰ��� �� N��M���� �������� �ɰ����� �Ѵ�. 
 ���ݸ��� �ɰ� ������ ���ݸ� ������ �ϳ� ���, ������ ��ġ���� ���ݸ��� �ɰ���.
 ���� �ٽ� �� �߿��� ���ݸ� ������ �ϳ� ���, �ɰ��� ������ �ݺ��ϸ� �ȴ�.
 # input
	 �� ���� N, M(1��N, M��300)
	 ex) 2 2
 # output
	 1��1 ũ���� ���ݸ����� �ɰ��� ���� �ּ� �ɰ��� Ƚ��
	 ex) 3
 */
/* 2163��.
1. n, m ���ؼ� ���� ū int�� ����.
	4 x 3�϶� 4���� ���� ũ�Ƿ� 4x1 �� �������� �ѹ� �ڸ���.
	- Ƚ�� = 1
2. �������� ���� ������� �ڸ���. (�߸��������� �ڸ���.)
	���� ������Ű��, ���� 1�� ������ ���ö����� ��� �ɰ���.
	- Ƚ�� = (m-1) -1	// ���� -1�� 1.���� Ƚ���� ������
3. �ڸ��� ������ ���д�. �̸� ����϶�� ����� �� �ִ�. 4 x 1�� �������� 3��..
	- Ƚ�� = (n-1)
4. ���� �ڸ��� ������ ���� ��ƽ���� ������� �ɰ���. 3.���� �ڸ��� ������ ���� ��ƽ���� �ڸ���.
	- Ƚ�� = (n-1)
1~4 Ƚ�� 
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
