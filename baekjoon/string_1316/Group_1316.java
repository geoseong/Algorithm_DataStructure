package baekjoon.string_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 
// 둘째줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
public class Group_1316 {
	public static void main(String[] args) throws IOException {
		new Group_1316();
	}
    public Group_1316() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int cntGrpWord = 0;								// 그룹단어갯수 세기.
		boolean isConsecutive = true;					// 연속단어가 맞다면 true, 이후에 같은단어가 반복해서 나오면 false
        char beforeCh = 0;								// 바로 앞단계에서 입력된 단어저장.

        // [ASCII]	65 : 'A' ~ 90 : 'Z', // 97 : 'a' ~ 122 : 'z'
        while(cases-->0){
        	beforeCh = 0;
        	isConsecutive = true;
        	char[] inputArrCh = br.readLine().toCharArray();
        	boolean[] arrBoolAlphabet = new boolean[26];	// 알파벳별 방문이력.
        	
        	for(char ch : inputArrCh){
        		ch = ((int)ch>90)?ch:(char)((int)ch+32);
        		int intCh = (int)ch;
        		int arrIdx = 0;
        		
    			if(64< intCh && intCh <91){	// 대문자.
    				arrIdx = intCh-65;	// 65 : 'A'
    				
    			}else{	// 소문자.
    				arrIdx = intCh-97;	// 97 : 'a'
    			}
    			
    			if(beforeCh == ch && arrBoolAlphabet[arrIdx]){
        			isConsecutive=true;
        		}else if(arrBoolAlphabet[arrIdx]){
        			isConsecutive=false;
        			break;
        		}
    			
    			arrBoolAlphabet[arrIdx]=true;
        		beforeCh = ch;
        	}
        	if(isConsecutive)	cntGrpWord++;	// 연속단어가 맞으므로 해당 케이스는 그룹단어갯수에 포함된다.
        } // end while
		System.out.println(cntGrpWord);
	} //end Main()

}
