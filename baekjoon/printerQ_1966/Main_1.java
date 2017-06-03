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
import java.util.*;

public class Main_1 {

	public static void main(String[] args) throws IOException{
		new Main_1();
	} //end main()

	Main_1() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		PriorityQueue<Integer> documentQ = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		// m번째 문서정보
		int docuM = 0;

		StringBuilder sb = new StringBuilder();

		// Line testcase
		String strinput=br.readLine();
		int testcase = Integer.parseInt(strinput);

		while(testcase-- > 0){

			// testcase n > 1
			strinput = br.readLine();
			token = new StringTokenizer(strinput, " ");
			int num_of_docu = Integer.parseInt(token.nextToken());
			int position_docu = Integer.parseInt(token.nextToken());

			// testcase n > 2
			strinput = br.readLine();
			token = new StringTokenizer(strinput, " ");
			for(int n=0; n<num_of_docu; n++){
				if(n==position_docu)	docuM = n;
				int docu = Integer.parseInt(token.nextToken());
				documentQ.add(docu);
			}

			int time = printTime(docuM, documentQ);
			sb.append(time+"\n");

		} //end while

		// Print Result
		System.out.print(sb.toString());
	} //end Main_1()
	
	public int printTime(int docuM, PriorityQueue<Integer> documentQ){
		int time = 0;
		int cnt = 1;
		int sizeQ = documentQ.size();
		int prev = 200;

		for(int i=0; i<sizeQ; i++){
			int now = documentQ.poll();
			if(prev == 200)		prev = now;
			if(prev >= now)		time++;
			if(prev != now)		cnt++;
			if(cnt == docuM)	break;
		}
		return time;
	} //end printTime
}
