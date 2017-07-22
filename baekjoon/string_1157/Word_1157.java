package baekjoon.string_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
[입력]
Mississipi

[출력]
?
 */
public class Word_1157 {

	public static void main(String[] args) throws IOException {
		new Word_1157();
	}
	public Word_1157() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputCh = br.readLine().toCharArray();
		int startAscii = 65;    // 97: a, 65: A 
        int endAscii = 122;     // 122: z, 90: Z
		int[] arrAscii = new int[endAscii-startAscii+1];
		Arrays.fill(arrAscii, 0);  // 모든 배열을 0으로 초기화
		
		for(char ch: inputCh){
			int inputAsciiInt = (int)ch;
			arrAscii[inputAsciiInt-startAscii]++;
		}
		System.out.println("the end");
	}
}
