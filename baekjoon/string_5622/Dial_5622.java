package baekjoon.string_5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
숫자 1을 걸려면 총 2초가 필요하다. 
1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다. 즉, 어떤 단어를 걸 때, 각 알파벳에 해당하는 숫자를 걸면 된다. 
예를 들어, UNUCIC는 868242와 같다.
할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 시간을 구하는 프로그램을 작성하시오.
[입력]
첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어는 2글자~15글자로 이루어져 있다.
> UNUCIC
[출력]
> 36
8 : 9s
6 : 7s
8 : 9s
2 : 3s
4 : 5s
2 : 3s
= 9 + 7 + 9 + 3 + 5 + 3 = 36s
 */
//[ASCII]	65 : 'A' ~ 90 : 'Z', // 97 : 'a' ~ 122 : 'z'
public class Dial_5622 {

	public static void main(String[] args) throws IOException {
		new Dial_5622();
	}
	Dial_5622() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputArr = br.readLine().toCharArray();
		int totalTime = 0;
		for(char ch : inputArr){
			if(64<(int)ch && (int)ch<68){	// 'C' : 67
				totalTime += 3;
			}else if(67<(int)ch && (int)ch<71){	// 'F' : 70
				totalTime += 4;
			}else if(70<(int)ch && (int)ch<74){	// 'I' : 73
				totalTime += 5;
			}else if(73<(int)ch && (int)ch<77){	// 'L' : 76
				totalTime += 6;
			}else if(76<(int)ch && (int)ch<80){	// 'O' : 79
				totalTime += 7;
			}else if(79<(int)ch && (int)ch<84){	// 'S' : 83
				totalTime += 8;
			}else if(83<(int)ch && (int)ch<87){	// 'V' : 86
				totalTime += 9;
			}else if(86<(int)ch && (int)ch<91){	// 'Z' : 90
				totalTime += 10;
			}
//			System.out.println("ch:" + ch + ", (int)ch:" + (int)ch + ", totalTime:" + totalTime);
		} //end for
		System.out.println(totalTime);
	} // end Main

} //end Class