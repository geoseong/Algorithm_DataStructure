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
import java.util.ArrayList;
import java.util.List;

public class SafetyPhrase2_4889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = new char[2000];
		boolean isEnd=true;
		int lineno=1;
		
		while(isEnd){
			// ��ȣ�� ¦������ �ԷµǾ�߰ڱ�
			// ���ڿ��� ���̰� 2000�� �Ѵ� ���� ����
			// 1. ù° �ε����� { �̿��� ��.
			// 2. ArrayList�� �� �ڸ��� ���� ��������
			// 3. �ٽ� Ž���ϸ鼭 { �� } ���� ������ remove�ϱ�.
			List<Character> list = new ArrayList<Character>();
			int cntCalc=0;
			charArr = br.readLine().toCharArray();
			Character charTmp = charArr[0];

			//1. �Է°� �ڸ��� ��ȣ �Ʊ��� ������ ����Ʈ�� ���� ����.
			for(Character ch : charArr){
				if(ch.equals('-')){
					isEnd=false;
					break;
				}
				if(list.size()==0 || list.get(0)=='}'){
					list.add(ch);
				}else if(list.get(0)=='{'){
					if(charTmp.equals(ch)){
						list.add(ch);
						charTmp = ch;
					}else if(list.size()==0){
						list.add(ch);
					}else{
						list.remove(list.size()-1);
					}
				}
			}
			
			//2. ��������� ��ȣ �Ʊ� ���߱�
			while(list.size()>0){
				if(list.get(0).equals('}')){
					cntCalc++;
					list.set(0, '{');
					list.remove(0);
				}
				
				if(list.get(0).equals('{')){
					cntCalc++;
					list.set(0, '}');
				}
				if(list.get(0).equals('}')){
					list.remove(0);
				}
			} //end while
			
			if(!isEnd)	break;
			
			System.out.printf("%d. %d\n", lineno, cntCalc);
			lineno++;
		};
	}

}
