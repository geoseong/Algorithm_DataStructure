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
			
			// 괄호가 짝수개가 입력되어야겠군
			// 문자열의 길이가 2000을 넘는 경우는 없고
			// 1. 첫째 인덱스는 { 이여야 함.
			// 2. 배열을 훑으면서 {, }가 등장하면 각각 count를 부여해아 할 듯. 
			// 3-1. { 의 count 가 } 의 count 보다 크거나 작다면, output에 표시할 count 1씩 추가
			// 3-2. { 의 count 와 } 의 count 가 같다면, output에 표시할 count는 0. 
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
