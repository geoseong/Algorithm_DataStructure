/*
# ����
â���̴� �������� ��й�ȣ�� ��ġ�� ���ؼ� �����̰� ����ϴ� ��ǻ�Ϳ� Ű�ΰŸ� ��ġ�ߴ�. 
��ĥ�� ��ٸ� ���� â���̴� �����̰� ��й�ȣ â�� �Է��ϴ� ���ڸ� ���´�. 
������, Ű�ΰŴ� ����ڰ� Ű���带 ���� ����� ��� ����Ѵ�. 
����, �����̰� ��й�ȣ�� �Է��� ��, ȭ��ǥ�� �齺���̽��� �Է��ϸ� ��Ȯ�� ��й�ȣ�� �˾Ƴ� ���� ����.
�� �����̰� ��й�ȣ â���� �Է��� Ű�� �־����� ��, �������� ��й�ȣ�� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.

# �Է�
ù° �ٿ� �׽�Ʈ ���̽��� ������ �־�����. 
�� �׽�Ʈ ���̽��� ���ٷ� �̷���� �ְ�, �����̰� �Է��� ������� ���̰� L�� ���ڿ��� �־�����. (1 �� L�� ���� �� 1,000,000)
 �����̰� �齺���̽��� �Է��ߴٸ�, '-'�� �־�����. 
 �� ���� Ŀ���� ��ġ �ٷ� �տ� �ִ� ���ڸ� �����. ȭ��ǥ�� �Է��� '<'�� '>'�� �־�����.
 �� ���� Ŀ���� ��ġ�� ������ �� �ִٸ�, ���� �Ǵ� ���������� 1��ŭ �����δ�. 
 ������ ���ڴ� ��й�ȣ�� �Ϻ��̴�. ����, ���߿� �齺���̽��� ���ؼ� ���� ���� �ִ�. 
 ���� Ŀ���� ��ġ�� ���� �������� �ƴ϶��, �� ���ڸ� �Է��ϰ�, Ŀ���� ���������� �� ĭ �̵��Ѵ�. 
 ��� ������ �б⺸�ٴ� �޸����� �Ѽ� �����ϴ� ���� ��õ�Ѵ�.

# ���
�� �׽�Ʈ ���̽��� ���ؼ�, �������� ��й�ȣ�� ����Ѵ�. ��й�ȣ�� ���̴� �׻� 0���� ũ��.

# ���� �Է�
2
<<BP<A>>Cd-
ThIsIsS3Cr3t

# ���� ���
BAPC
ThIsIsS3Cr3t

# �˰��� �з�
����
�迭
�ùķ��̼�
��ũ�� ����Ʈ

# Comment
- ���� A, B�� �����Ѵ�.
	����A : ������ºκ�
	����B : < �� > �� ������ ������ �̵��� �Ϸ�ɶ����� �ش� ���ÿ� �ӽ÷� ������ ���Ҵٰ� ������ �̵��� �Ϸ�Ǹ� ������ºκп� �߰���ų �� �ְ� �ϴ� �뵵.
- '<' ��ȣ�� ������, 
	����A.pop() -> ����B.push()
- '>' ��ȣ�� ������,
	����B.pop -> ����A.push()
- '-' ��ȣ�� ������,
	����A.pop()
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
			// Stack �ʱ�ȭ
			mainStack.clear();
			tempStack.clear();
			
			// Line n
			char[] inputkeys = br.readLine().toCharArray();
			
			// <, >, - �� �Ǻ��Ͽ� �����(mainStack)�� ���� �ֱ�
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
			// mainStack�� ����� �߰�
			for(char prt : mainStack){
				sb.append(prt);
			}
			// tempStack ������ ������ �߰��Ѵ�.
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
