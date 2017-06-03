package baekjoon.Tiling_2xn_11726;
/*
# �Է�
ù° �ٿ� n�� �־�����. (1 �� n �� 1,000)
1. 2
2. 9

# ���
ù° �ٿ� 2��n ũ���� ���簢���� ä��� ����� ���� 10,007�� ���� �������� ����Ѵ�.
1. 2
2. 55
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tile_x = Integer.parseInt(br.readLine());
		
		// Dynamic array : �Էµ� ���ڸ�ŭ�� ũ�� �迭 ����
		int[] dynamicArr = new int[tile_x];
		
		// 2x1 : 1 , 2x2 : 2 , 2x3 : 3 , 2x4 : 5, 2x5 : 8
		// 2xn : 2x(n-1)x(n-2)
		
		for(int n=0; n<tile_x; n++){
			int cal=0;
			if(n<1){
				cal = 1;
			}
			else if(n < 2){
				cal = dynamicArr[n-1] + 1;
			}
			else{
				cal = dynamicArr[n-1] + dynamicArr[n-2];				
			}
			// ���簢���� ä��� ����� ���� 10,007�� ���� ������
			dynamicArr[n] = cal % 10007;
		}
		System.out.println(dynamicArr[tile_x-1]);
		
	}

}
