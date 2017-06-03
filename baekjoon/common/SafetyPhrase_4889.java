package baekjoon.common;
/* input
}{
{}{}{}
{{{}
---

* output
1. 2
2. 0
3. 1
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SafetyPhrase_4889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = new char[2000];
		boolean isEnd=true;
		int lineno=1;

		while(isEnd){
			
			// ��ȣ�� ¦������ �ԷµǾ�߰ڱ�
			// ���ڿ��� ���̰� 2000�� �Ѵ� ���� ����
			// 1. ù° �ε����� { �̿��� ��.
			// 2. �迭�� �����鼭 {, }�� �����ϸ� ���� count�� �ο��ؾ� �� ��. 
			// 3-1. { �� count �� } �� count ���� ũ�ų� �۴ٸ�, output�� ǥ���� count 1�� �߰�
			// 3-2. { �� count �� } �� count �� ���ٸ�, output�� ǥ���� count�� 0. 
			int cntParenthesisOpen=0;
			int cntParenthesisClose=0;
			int cntCalc=0;
			charArr = br.readLine().toCharArray();
			for(int i=0; i<charArr.length; i++){
				Character ch = charArr[i];
				if(ch.equals('{'))	cntParenthesisOpen++;
				else if(ch.equals('}'))	cntParenthesisClose++;
				else if(ch.equals('-')){
					isEnd=false;
					System.out.println("isEnd is false");
					break;
				}
//				System.out.printf("charArr[%d] : %s\n", i, ch);
				System.out.printf("cntParenthesisOpen : %d, cntParenthesisClose : %d\n", cntParenthesisOpen, cntParenthesisClose);
			}
			if(!isEnd)	break;
			if(cntParenthesisOpen==cntParenthesisClose){
				cntCalc = 0;
			}else{
				cntCalc = Math.abs(cntParenthesisOpen-cntParenthesisClose);
			}
			System.out.println(lineno+". " + cntCalc);
			lineno++;
			
		};
	}

}
