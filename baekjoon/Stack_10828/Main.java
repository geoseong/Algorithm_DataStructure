/*
# ����
    push X: ���� X�� ���ÿ� �ִ� �����̴�.
    pop: ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
    size: ���ÿ� ����ִ� ������ ������ ����Ѵ�.
    empty: ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
    top: ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.

# �Է�
ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. 
��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. 
�־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.
ex)
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top

# ���
����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.
ex)
2
2
0
2
1
-1
0
1
-1
0
3
 */
package baekjoon.Stack_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		new Main();
	}
	
	Main() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		// line 1.
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int testcase = Integer.parseInt(token.nextToken());
		
		while(testcase-- > 0){
			// line n.
			token = new StringTokenizer(br.readLine(), " ");
			String word = token.nextToken();
			String nextline = "\n";
			
			if(word.equals("push")){
				int element = Integer.parseInt(token.nextToken());
				stack.push(element);
			}else if(word.equals("pop")){
				if(stack.size()==0){
					sb.append("-1"+nextline);
				}
				else{
					sb.append(stack.pop()+nextline);
				}
			}else if(word.equals("size")){
				sb.append(stack.size()+nextline);
			}else if(word.equals("empty")){
				if(stack.size()==0)	sb.append("1"+nextline);
				else	sb.append("0"+nextline);
			}else{	// "top"
				if(stack.size()==0)	sb.append("-1"+nextline);
				else	sb.append(stack.peek()+nextline);
			}
		} //end while
		System.out.println(sb.toString());
	} // end Main_1()
}
