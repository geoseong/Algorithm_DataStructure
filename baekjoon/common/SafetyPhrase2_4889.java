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
			// 괄호가 짝수개가 입력되어야겠군
			// 문자열의 길이가 2000을 넘는 경우는 없고
			// 1. 첫째 인덱스는 { 이여야 함.
			// 2. ArrayList에 각 자리의 문자 때려넣음
			// 3. 다시 탐색하면서 { 와 } 쌍이 맞으면 remove하기.
			List<Character> list = new ArrayList<Character>();
			int cntCalc=0;
			charArr = br.readLine().toCharArray();
			Character charTmp = charArr[0];

			//1. 입력값 자릿수 괄호 아구가 맞으면 리스트에 넣지 않음.
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
			
			//2. 나머지들로 괄호 아구 맞추기
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
