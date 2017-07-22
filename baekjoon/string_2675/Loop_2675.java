package baekjoon.string_2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
[입력]
2
3 ABC
5 /HTP

[출력]
AAABBBCCC
/////HHHHHTTTTTPPPPP
 */
public class Loop_2675 {
	public static void main(String[] args) throws IOException {
		new Loop_2675();
	}

	Loop_2675() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loopCase = Integer.parseInt(br.readLine());
		while(loopCase-->0){
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			int loopTimes = Integer.parseInt(token.nextToken());
			char[] inputCh = token.nextToken().toCharArray();
			for(char ch : inputCh){
				for(int i=0; i<loopTimes; i++){
					System.out.print(ch);
				}
			} //end for
			System.out.println();
		} //end while
		
	} //end Main
}
