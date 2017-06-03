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
import java.util.Stack;

public class SafetyPhrase3_4889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = new char[2000];
		boolean isEnd=true;
		int lineno=1;
		
		while(isEnd){
			Stack<Character> stack = new Stack<Character>();
			int cntCalc=0;
			charArr = br.readLine().toCharArray();

			//1. 입력값 자릿수 괄호 아구가 맞으면 리스트에 넣지 않음.
			for(Character ch : charArr){
				if(ch.equals('-')){
					isEnd=false;
					break;
				}
				if(stack.size()==0){
					stack.push(ch);
				}else{
					if(stack.peek().equals('{') && ch.equals('}')){
						stack.pop();
					}else{
						stack.push(ch);
					}
				}
			}
			
			//2. 나머지들로 괄호 아구 맞추기
			while(stack.size()>0){
				boolean parenthesisOpen=false;
				boolean parenthesisClose=false;
				if(stack.pop().equals('{'))	parenthesisOpen=true;
				if(stack.pop().equals('}'))	parenthesisClose=true;
				
				if(parenthesisOpen && parenthesisClose)	cntCalc+=2;
				else if(parenthesisOpen || parenthesisClose)	cntCalc++;
			} //end while
			
			if(!isEnd)	break;
			
			System.out.printf("%d. %d\n", lineno, cntCalc);
			lineno++;
		};
	}

}
