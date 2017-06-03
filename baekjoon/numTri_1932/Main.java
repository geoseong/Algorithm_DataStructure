package baekjoon.numTri_1932;
/*
# ����
�� �׸��� ũ�Ⱑ 5�� ���� �ﰢ���� �� ����̴�.
�� ���� 7���� �����ؼ� �Ʒ��� �ִ� �� �� �ϳ��� �����Ͽ� �Ʒ������� ������ ��, 
�������� ���õ� ���� ���� �ִ밡 �Ǵ� ��θ� ���ϴ� ���α׷��� �ۼ��϶�. 
�Ʒ����� �ִ� ���� ���� ������ ���õ� ���� �밢�� ���� �Ǵ� �밢�� �����ʿ� �ִ� �� �߿����� ������ �� �ִ�.
�ﰢ���� ũ��� 1 �̻� 500 �����̴�. �ﰢ���� �̷�� �ִ� �� ���ڴ� ��� �����̸�, ������ 0 �̻� 99 �����̴�.

# �Է�
ù° �ٿ� �ﰢ���� ũ�� n(1��n��500)�� �־�����, ��° �ٺ��� n+1�ٱ��� ���� �ﰢ���� �־�����.

# ���
ù° �ٿ��� �ִ밡 �Ǵ� ���� ����Ѵ�.

# ���� �Է�
5
7
3 8
8 1 0 
2 7 4 4
4 5 2 6 5

# ���� ���
30
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	Main() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// line 1.
		StringTokenizer token = new StringTokenizer(br.readLine());
		int lines = Integer.parseInt(token.nextToken());
		LineData[] linedatas = new LineData[lines];
		
		// line 2 ~ : �� ����ֱ�
		// �ڽ�Ʈ�� �¿� �� �� ū ��� �����ؼ� �� ���� �������鼭 ����� ���� sum�� ���س����� �� ���������� ������������ ������ sum�� ��.
		for(int line = 0; line < lines; line++){
			// line X��°.
			token = new StringTokenizer(br.readLine());
			int countToken = token.countTokens();		// token.nextToken()�� �ϸ� countTokens()�� ���� �پ���..
			
			// Ŭ�����迭�� �̿��ؼ� ���� int���������͸� ����ִ´�.
			// ����Ŭ����[]
			linedatas[line] = new LineData(countToken);
			
			//	�� ���� Int�迭[] = token.countTokens��ŭ ũ��� �߰� �� ������ ����ֱ�.
			for(int i=0; i<countToken; i++){
				linedatas[line].datas[i] = Integer.parseInt(token.nextToken());
			}
		} //end for
		
		// ������� ������ �� ���̽��� sum ���س���
		// sums�迭�� ���̴� �ﰢ�� ������ ���丮���ε�.
		// 0 1 2 , 1 2 3 || 0 1 2 3 , 1 2 3 4
//		int[] sums = new int[getFactorial(lines)];
		int sum = 0;
		int[][] dsums = new int[lines][lines];
		
//		for(int n=0; n<lines; n++){
//			for(int m=0; m<linedatas[n].datas.length; m++){
//				if(linedatas[n].datas.length==1){
//					dsums[n][m] = linedatas[n].datas[m];
//					continue;
//				}else if(m+1==linedatas[n].datas.length){
//					break;
//				}
//				int index_alt = 0;
//				if(linedatas[n-1].datas.length==1 || m == 0){
//					index_alt = m;
//				}else{
//					index_alt = m-1;
//				}
//				if(linedatas[n].datas[m] < linedatas[n].datas[m+1]){
//					sum = linedatas[n-1].datas[index_alt] + linedatas[n].datas[m+1];
//				}else{
//					sum = linedatas[n-1].datas[index_alt] + linedatas[n].datas[m];
//				}
//				dsums[n][m] = sum;
//			}
//		}
		for(int n=0; n<lines; n++){
			for(int m=0; m<linedatas[n].datas.length; m++){
				// n���� �ڸ��� üũ����
				if(linedatas[n].datas.length==1){
					dsums[n][m] = linedatas[n].datas[m];
					continue;
				}
				// �� ù�ڸ� ���
				if(m==0){
					dsums[n][m] = linedatas[n].datas[m] + dsums[n-1][m];
				}
				// �߰� ��ġ ���
				else if(m>0 && m < linedatas[n].datas.length-1){
					if(dsums[n-1][m-1] < dsums[n-1][m]){
						dsums[n][m] = linedatas[n].datas[m] + dsums[n-1][m];
					}else{
						dsums[n][m] = linedatas[n].datas[m] + dsums[n-1][m-1];
					}
				}
				// �� ���ڸ� ��� : ���� ���� ���̴� ���� �� ���̺��� ª���ϱ�..
				else{
					dsums[n][m] = linedatas[n].datas[m] + dsums[n-1][m-1];
				}
			}
		}
		
		int max=0;
		for(int i=0; i<dsums.length; i++){
			if(dsums[lines-1][i] > max){
				max = dsums[lines-1][i];
			}
		}
		System.out.println(max);
//		// �ٴں��� ����.
//		// n��°�� �θ�� n-1�� n �߿� �ϳ� ��� �ö󰣴�.
//		int cnt=0;
//		for(int n=linedatas.length; n>=0; n--){
//			sum = linedatas[n-1].datas[cnt];
//			
//			// if(cnt==0) linedatas[n-1].datas[cnt]
//			// else
//			// if(cnt > 0) linedatas[n-1].datas[cnt] or linedatas[n-1].datas[cnt-1]
//			
//			// if(cnt==linedatas[n].datas.length-1) linedatas[n-1].datas[cnt-1]
//		}
		
		
//		// Line n ��°���� datas[] �ε����� ��¦ �ٲٰ� ���� ������ datas[]�ε������� ������ ���� �Ϸ���???
//		for(int line = 0; line < lines; line++){
//			for(int index=0; index<linedatas[line].datas.length; index++){
//				if(linedatas[line].datas.length==1){
//					sum = linedatas[line].datas[0];
//					continue;
//				}
//			
//			// index 1�����Ҷ����� sum[] �ڸ����� ����
//			// [index] <-> [index+1] �� ���ؼ� ū ���� sum, ������
//			// 		�ٵ� ���϶�� ���� ������...
//			// n��° ���� �迭 length�� index+1�� ������ continue
//			// ??? sum�� �����ߴ� ���ڴ� flag�� �޾ƾ��ϳ�.. �׷����� �ߺ����� �� ���� ���� �ִ� ���ڵ��̴�... ???
//			
//				if(index+1 >= linedatas[line].datas.length)	break;
//				if(linedatas[line].datas[index] > linedatas[line].datas[index+1]){
//					sum = sum + linedatas[line].datas[index];
//					break;
//				}else{
//					sum = sum + linedatas[line].datas[index+1];
//					break;
//				}
//
//			} //end for
//		} //end for
		
//		sums[0] = sum;
//		for(int res : sums){
//			System.out.println(res);
//		}
	} //end Main_1()
	
	public static void main(String[] args) throws IOException {
		new Main();
	} //end main()

	public int getFactorial(int height){
		if(height==1){
			return 1;
		}
		return height*getFactorial(height-1);
	}
}
