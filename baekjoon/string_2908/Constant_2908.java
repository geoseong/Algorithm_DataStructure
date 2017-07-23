package baekjoon.string_2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
[입력]
1. 첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 
2. 두 수는 같지 않은 세 자리 수이며, 
3. 0이 포함되어 있지 않다.
> 734 893
 */
public class Constant_2908 {
	public static void main(String[] args) throws IOException {
		new Constant_2908();
	}

	Constant_2908() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStr = br.readLine().split(" ");
		String reverseInputStr0 = "";
		String reverseInputStr1 = "";
		
		for(int i=inputStr[0].length()-1; i>=0; i--){
			char ch1 = inputStr[0].charAt(i);
			char ch2 = inputStr[1].charAt(i);
			reverseInputStr0 += ch1;
			reverseInputStr1 += ch2;
		}
		
		int toInt1 = Integer.parseInt(reverseInputStr0);
		int toInt2 = Integer.parseInt(reverseInputStr1);
		
		if(toInt1 > toInt2){
			System.out.println(toInt1); 
		}else{
			System.out.println(toInt2);
		}
		
	} //end Main
}