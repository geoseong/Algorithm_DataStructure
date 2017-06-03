/*
# 문제
먼저 요청된 것을 먼저 인쇄하는데,
현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
예)를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C(4)를 인쇄하고, 다음으로 D(3)를 인쇄하고 A(2), B(1)를 인쇄하게 된다.

현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다. 
예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.

# 입력
: 첫 줄에 test case의 수
: 문서의 수 N(100이하) / 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue의 어떤 위치에 있는지를 알려주는 M(0이상 N미만)이 주어진다. 
n is the number of jobs in the queue (1 ≤ n ≤ 100) // m is the position of your job (0 ≤ m ≤ n − 1)
: 다음줄에 N개 문서의 중요도 ( 0 to 9 )
3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1

# 출력
: 각 test case에 대해 문서가 몇 번째로 인쇄되는지 출력한다.
; the number of minutes until your job is completely printed
1
2
5
 */
package baekjoon.printerQ_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2 {

	public static void main(String[] args) throws IOException{
		new Main_2();
	} //end main()

	Main_2() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		Queue<Integer> documentQ = new LinkedList<>();
		/*// m번째 문서정보
		int docuM = 0;*/

		StringBuilder sb = new StringBuilder();

		// Line testcase
		String strinput=br.readLine();
		int testcase = Integer.parseInt(strinput);

		while(testcase-- > 0){
			// Queue 내용 초기화
			documentQ.clear();

			// testcase n > 1
			strinput = br.readLine();
			token = new StringTokenizer(strinput, " ");
			int num_of_docu = Integer.parseInt(token.nextToken());
			int position_docu = Integer.parseInt(token.nextToken());
			int target_docu = 0;	// 입력된 숫자위치(m)에 대한 문서의 우선순위.

			// testcase n > 2
			strinput = br.readLine();
			token = new StringTokenizer(strinput, " ");

			// 현존하는 입력값 중 최대값(우선순위, max)를 구하기
			int max=0;
			for(int n=0; n<num_of_docu; n++){
				int docu = Integer.parseInt(token.nextToken());
				if(n==position_docu)	target_docu = docu;
				if(max < docu)	max = docu;
				documentQ.add(docu);
			}
			// 입력된 숫자위치(m)에 대한 문서의 우선순위가 제일 높은지 판별 후 원하는 문서의 인쇄순서 출력
			boolean isMax = true;
			if(max > target_docu){
				isMax = false;
				int time = printTime(position_docu, target_docu, max, documentQ);
				sb.append(time+"\n");
			}else{
				sb.append(1+"\n");
			}

		} //end while

		// Print Result
		System.out.print(sb.toString());
	} //end Main_1()
	
	public int printTime(int position_docu, int target_docu, int max, Queue<Integer> documentQ){
		Queue<Integer> temp = documentQ;
		int cnt = 0;
		// target_docu와 같은 우선순위를 갖고 있으면 카운트
		int same = 0;

		// max값의 요소가 queue에서 빠져나가게 되면 target_docu보다 또 높은 우선순위의 요소가 있을 수 있다.
		// 그래서 아래의 getMax() 추가.

		int index=0;
		while(!documentQ.isEmpty()){
			int now = documentQ.poll();
			if(max > now){
				if(index > position_docu && target_docu == now)	same++;
				documentQ.offer(now);
			}else if(max==now && now >= target_docu){
				cnt++;
			}
			max = getMax(documentQ);
			index++;
		}
		return cnt-same;
	} //end printTime

	public int getMax(Queue<Integer> documentQ){
		Queue<Integer> temp = new LinkedList<>();
		temp.addAll(documentQ);
		int max=0;
		int sizeQ = temp.size();

		for(int n=0; n<sizeQ; n++){
			int now = temp.poll();
			if(max < now)	max = now;
		}
		return max;
	} //end getMax
}
