package baekjoon.if_1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
 * 사이클 길이 구하기 *
 * 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만든다.
26부터 시작한다. 2+6 = 8이다. 새로운 숫자는 68이다. 6+8 = 14이다. 
새로운 숫자는 84이다. 8+4 = 12이다. 새로운 숫자는 42이다. 4+2 = 6이다. 새로운 숫자는 26이다.

위의 예는 4번만에 원래 숫자로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
*/
public class PlusCycle_1110 {

	public static void main(String[] args) throws IOException{
		new PlusCycle_1110();
	}

	PlusCycle_1110() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		
		int nextInt=Integer.parseInt(inputStr);
		int original =Integer.parseInt(inputStr);
		int cycle=0;
		int number1=0, number2=0;
		
		while(true){
			cycle++;			
			if(nextInt < 10){
				number1 = 0;
				number2 = nextInt;
			}else{
				number1 = nextInt / 10;
				number2 = nextInt % 10;
			}
			nextInt = number1+number2;
			nextInt = number2*10 + (nextInt % 10);
			
			if(nextInt == original){
				System.out.println(cycle);
				break;
			}
		} //end while
	}
}
