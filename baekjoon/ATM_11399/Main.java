package baekjoon.ATM_11399;

/*
- ���� [2, 5, 1, 4, 3] ������ ���� ����,  ( 1, 2, 3, 3, 4 )
2�� ����� 1�и���, 5�� ����� 1+2 = 3��, 1�� ����� 1+2+3 = 6��, 4�� ����� 1+2+3+3 = 9��, 3�� ����� 1+2+3+3+4 = 13���� �ɸ��� �ȴ�. 
�� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� 1+3+6+9+13 = 32���̴�. �� ������� �� �ʿ��� �ð��� ���� �ּҷ� ���� ���� ����.

# �Է�
ù° �ٿ� ����� �� N(1 �� N �� 1,000)�� �־�����. ��° �ٿ��� �� ����� ���� �����ϴµ� �ɸ��� �ð� Pi�� �־�����. (1 �� Pi �� 1,000)
5
3 1 4 3 2

# ���
ù° �ٿ� �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� �ּҰ��� ����Ѵ�.
32

# comment
�ð��� �ߺ����� ���� �ּҷ� �ؾ߰ڳ�...
�Էµ� ����� ����ð��� �������� ��Ų��.
DP�迭���ٰ� [0]~[n] �ߺ��� ���� �����Ѵ�
DP[0]~DP[n] ���� ���Ѵ�.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	Main() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// line 1.
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int ppls = Integer.parseInt(token.nextToken());
		int[] atmLeadtime = new int[ppls];
		
		// line 2.
		token = new StringTokenizer(br.readLine(), " ");
		
		// ����ð����� �迭�� ������ �ֱ�
		for(int i=0; i<ppls; i++){
			int atomInt = Integer.parseInt(token.nextToken());
			atmLeadtime[i] = atomInt;
		} //end for
		
		// ����ð����� �迭 ��������
		setArrayAsc(atmLeadtime);
		
		// �ߺ��� ���� �����ϴ� �迭 ���� �� ������ �ֱ�
		int[] dupSum = new int[atmLeadtime.length];
		for(int i=0; i<atmLeadtime.length; i++){
			int sum = 0;
			for(int j=0; j<=i; j++){
				 sum += atmLeadtime[j];
			}
			dupSum[i] = sum;
		}
		
		// �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� �ּҰ��� ����Ѵ�.
		int totsum=0;
		for(int i=0; i<dupSum.length; i++){
			totsum += dupSum[i];
		}
		
		System.out.println(totsum);
	} //end Main_1()
	
	public static void main(String[] args) throws IOException {
		new Main();
	} //end main()
	
	public void setArrayAsc(int[] intArray){
		int temp=0;
		for(int x=0; x<intArray.length; x++){
			for(int i=1; i<intArray.length; i++){
				// ���� �ڸ� ����ġ.
				if(intArray[i-1] > intArray[i]){
					temp = intArray[i-1];
					intArray[i-1] = intArray[i];
					intArray[i] = temp;
				}
			} //end for i
		} //end for x
	} //end setArrayAsc()
}
