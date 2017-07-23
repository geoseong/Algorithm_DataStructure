package baekjoon.string_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Word_1157{
    public static void main(String[] args) throws IOException {
		new Word_1157();
	}
    public Word_1157() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer strBuf = new StringBuffer(br.readLine());
//		if(strBuf.length()==0)	strBuf = new StringBuffer(br.readLine());
        int[] arrAscii = new int[26];

		for(int i=0; i<strBuf.length(); i++){
			int intCh = (int)strBuf.charAt(i);
			if(64< intCh && intCh <91){	// 대문자.
				arrAscii[intCh-65]++;	// 65 : 'A'
			}else{	// 소문자.
				arrAscii[intCh-97]++;	// 97 : 'a'
			}
		} //end for
		
		// 최대값을 가진 이 둘 이상이면 '?'(63) 출력
		int max=0;
		int resultInt=0;
		for(int i=0; i<arrAscii.length; i++){
			if(max < arrAscii[i]){
				max = arrAscii[i];
				resultInt = i;
			}else if(max == arrAscii[i]){
				resultInt = 63;    // 63: '?'
			}
		} //end for
		char resultCh = (resultInt==63)?(char)resultInt:(char)(resultInt+65);
		System.out.println(resultCh);
	} //end Main()
} //end class

/*
[input]
1.

ABCCC
(v)
2.

DDDDddddd
*/