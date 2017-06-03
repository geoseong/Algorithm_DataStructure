/*
# 문제
독일 로또는 {1, 2, ..., 49}에서 숫자 6개를 고른다.
로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 숫자 중 k(k>6)개의 숫자를 골라 집합 S를 만든 다음 그 숫자만 가지고 번호를 선택하는 것이다.
예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 숫자를 고를 수 있는 경우의 수는 총 28가지이다.
	([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
집합 S와 k가 주어졌을 때, 숫자를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
# 입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있다.
첫 번째 숫자는 k (6 < k < 13)이고, 다음 k개 숫자는 집합 S에 포함되는 수이다.
S의 원소는 오름차순으로 주어진다.
입력의 마지막 줄에는 0이 하나 주어진다.
# 출력
각 테스트 케이스 마다 숫자를 고르는 모든 방법을 출력한다. 이 때, 사전 순으로 출력한다.
각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.
# 예제입력
7 1 2 3 4 5 6 7
8 1 2 3 5 8 13 21 34
0
# 예제출력
1 2 3 4 5 6
1 2 3 4 5 7
1 2 3 4 6 7
1 2 3 5 6 7
1 2 4 5 6 7
1 3 4 5 6 7
2 3 4 5 6 7
 */
package baekjoon.Lotto_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main();
	} //end main()

	Main() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		// 스택 : 집합S에서 추첨해서 발표할 리스트 저장하는 곳.
		Stack<Integer> stack = new Stack<>();

		while(true){
			// Line x
			String lineContext = br.readLine();
			// 입력받은 Line의 내용이 '0' 이면 종료
			if(lineContext.equals("0"))	System.exit(0);
			token = new StringTokenizer(lineContext, " ");
			// k : 집합 S의 요소갯수
			int k = Integer.parseInt(token.nextToken());
			// 집합 S
			int[] arrS = new int[k];

			for(int n=0; n<k; n++){
				// 입력된 수를 k자리만큼 집어넣기.
				arrS[n] = Integer.parseInt(token.nextToken());
			} //end for

			for (int i = 0; k - i >= 6; i++)
			{
				stack.push(arrS[i]);
				DFS(arrS, stack, i);
				stack.pop();
			}
			System.out.println();
		}
	} //end Main()

	public void DFS(int[] arr, Stack<Integer> stack, int from){
		// 스택에 6개가 남기면 발표할 시점이 된 것이므로 print시킴.
		if (stack.size() == 6)
		{
			for (int i = 0; i < 6; i++){
				System.out.printf("%d ", stack.get(i));
			}
			System.out.println();
			return;
		}
		// 스택에 6개가 안 채워졌다면 push()로 입력된 집합S의 i번째 요소를 추가.
		else {
			// 1차 - i : 1~5, 5번 반복, stack.size() = 2
			// 2차(1차 안의 for) - i : 2~5, 4번 반복, stack.size() = 3
			// 3차(1차 안의 2차 안의 for) - i : 3~5, 3번 반복, stack.size() = 4
			// 4차(1차 안의 2차 안의 3차 안의 for) - i : 4~5, 2번 반복, stack.size() = 5
			// 5차(1차 안의 2차 안의 3차 안의 4차 안의 for) - i : 5, 1번 반복, stack.size() = 6
			// 6차(1차 안의 ... 5차 안의 for) - stack.size() = 6, 출력.
			// 우선 1차~6차 까지 for문은 1번씩 실행이 된 것임.
			// 이후 6차부터 stack에 있는 요소들이 한커풀씩 벗겨지며 stack 은 pop됨.
			// ex) 5차 for문의 stack.pop() 까지 완료된 이후에는 4차 for문의 실행코드는 stack.pop()이니까
			//    stack의 요소가 두개연속 pop된것이 되므로 stack.size는 4가 되고,
			//    그 남은 갯수만큼 arr의 다음 요소가 stack에 추가된다.
			for (int i = from + 1; i < arr.length; i++) {
				stack.push(arr[i]);
				DFS(arr, stack, i);
				stack.pop();
			}
		}
	} //end getTestCase()
}