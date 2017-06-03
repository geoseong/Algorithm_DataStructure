/*
# 문제
창영이는 강산이의 비밀번호를 훔치기 위해서 강산이가 사용하는 컴퓨터에 키로거를 설치했다. 
며칠을 기다린 끝에 창영이는 강산이가 비밀번호 창에 입력하는 글자를 얻어냈다. 
하지만, 키로거는 사용자가 키보드를 누른 명령을 모두 기록한다. 
따라서, 강산이가 비밀번호를 입력할 때, 화살표나 백스페이스를 입력하면 정확한 비밀번호를 알아낼 수가 없다.
└ 강산이가 비밀번호 창에서 입력한 키가 주어졌을 때, 강산이의 비밀번호를 알아내는 프로그램을 작성하시오.

# 입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 
각 테스트 케이스는 한줄로 이루어져 있고, 강산이가 입력한 순서대로 길이가 L인 문자열이 주어진다. (1 ≤ L의 길이 ≤ 1,000,000)
 강산이가 백스페이스를 입력했다면, '-'가 주어진다. 
 이 때는 커서의 위치 바로 앞에 있는 글자를 지운다. 화살표의 입력은 '<'와 '>'로 주어진다.
 이 때는 커서의 위치를 움직일 수 있다면, 왼쪽 또는 오른쪽으로 1만큼 움직인다. 
 나머지 문자는 비밀번호의 일부이다. 물론, 나중에 백스페이스를 통해서 지울 수는 있다. 
 만약 커서의 위치가 줄의 마지막이 아니라면, 그 문자를 입력하고, 커서는 오른쪽으로 한 칸 이동한다. 
 사실 설명을 읽기보다는 메모장을 켜서 이해하는 것을 추천한다.

# 출력
각 테스트 케이스에 대해서, 강산이의 비밀번호를 출력한다. 비밀번호의 길이는 항상 0보다 크다.

# 예제 입력
2
<<BP<A>>Cd-
ThIsIsS3Cr3t

# 예제 출력
BAPC
ThIsIsS3Cr3t

# 알고리즘 분류
스택
배열
시뮬레이션
링크드 리스트

# Comment
- 스택 A, B를 정의한다.
	스택A : 메인출력부분
	스택B : < 나 > 가 나오면 포인터 이동이 완료될때까지 해당 스택에 임시로 저장해 놓았다가 포인터 이동이 완료되면 메인출력부분에 추가시킬 수 있게 하는 용도.
- '<' 기호가 나오면, 
	스택A.pop() -> 스택B.push()
- '>' 기호가 나오면,
	스택B.pop -> 스택A.push()
- '-' 기호가 나오면,
	스택A.pop()
 */
package baekjoon.keyLogger_5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	Main() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Line 1.
		int testcase = Integer.parseInt(br.readLine());
		// Stack A(mainStack)
		Stack<Character> mainStack = new Stack<>(); 
		// Stack B(tempStack)
		Stack<Character> tempStack = new Stack<>();
		
		while(testcase-- > 0){
			// Result StringBuilder
			StringBuilder sb = new StringBuilder();
			// Stack 초기화
			mainStack.clear();
			tempStack.clear();
			
			// Line n
			char[] inputkeys = br.readLine().toCharArray();
			
			// <, >, - 을 판별하여 결과물(mainStack)에 문자 넣기
			for(Character c : inputkeys){
				// [cond1] main.pop() & temp.push()
				if(c.equals('<')){
					if(!mainStack.isEmpty()){
						char temp =mainStack.pop();
						tempStack.push(temp);
					}
				}
				// [cond2] temp.pop() & main.push()
				else if(c.equals('>')){
					if(!tempStack.isEmpty()){
						char temp = tempStack.pop();
						mainStack.push(temp);
					}
				}
				// [cond3] main.pop()
				else if(c.equals('-')){	
					if(!mainStack.isEmpty())	mainStack.pop();
				}
				// [cond etc] main.push()
				else{		
					mainStack.push(c);
				}
			} //end for
			
//			// Case 1. : Wrong
//			for(char prt : mainStack){
//				sb.append(prt);
//			}

//			// Case 2. : Wrong
//			Queue<Character> resultQ = new LinkedList<>();
//			resultQ.addAll(mainStack);
//			for(char prt : resultQ){
//				sb.append(prt);
//			}
			
			// Case 3 : Correct!!
			// mainStack을 결과에 추가
			for(char prt : mainStack){
				sb.append(prt);
			}
			// tempStack 내용이 있으면 추가한다.
			if(!tempStack.isEmpty()){
				while(!tempStack.isEmpty()){
					char addsb = tempStack.pop();
					sb.append(addsb);
				}
			}
			
			System.out.println(sb.toString());
		} // end while
		
	}
	public static void main(String[] args) throws IOException{
		new Main();
	}
}
