package baekjoon.IntArrays_10871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
���� N���� �̷���� ���� A�� ���� X�� �־�����. �� ��, A���� X���� ���� ���� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

# �Է�
ù° �ٿ� N�� X�� �־�����. (1 �� N, X �� 10,000)
��° �ٿ� ���� A�� �̷�� ���� N���� �־�����. �־����� ������ ��� 1���� ũ�ų� ����, 10,000���� �۰ų� ���� �����̴�.

# ���
X���� ���� ���� �Է¹��� ������� �������� ������ ����Ѵ�. X���� ���� ���� ��� �ϳ� �����Ѵ�.

* ���� �Է�
10 5
1 10 4 9 2 3 8 5 7 6

* ���� ���
1 4 2 3
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strinput=null;
		StringBuilder sb = new StringBuilder();
		// line 1.
		strinput = br.readLine();
		int n = Integer.parseInt(strinput.split(" ")[0]);
		int champion = Integer.parseInt(strinput.split(" ")[1]);
		// line 2.
		strinput = br.readLine();
		String[] strArrays = strinput.split(" ");
		for(int i=0; i<n; i++){
			int challenger = Integer.parseInt(strArrays[i]);
			if(challenger<champion){
				sb.append(strArrays[i]+" ");
			}
		} //end for
		System.out.println(sb.toString());
	}
}
