package baekjoon.rule_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * [문제]
 * 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산
 	ex) 13까지는 3개, 58까지는 5개를 지난다.
[벌집 규칙]
-1단계 : 1개(1)
-2단계 : 6개(2~7)
-3단계 : 12개(8~19)
-4단계 : 18개(20~37)
-5단계 : 24개(38~61)
[반례]
7
 */
public class Hive_2292 {

	public static void main(String[] args) throws IOException {
		new Hive_2292();
	}
	Hive_2292() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = 6;
		int step = 1;
		int i = 0, min = 0, max = 0;
		int inputInt = Integer.parseInt(br.readLine());
		
		while(true){
//		for(int i=0;i<(inputInt/size)+1; i++){
			if(i < 1){
				min = 1;
			}else{
				min = step+1;
			}
			step = step + i*size;	// 1, 1+6, 7+12
			max = step;
			
			System.out.println("["+i+"]min="+min+"/max="+max+"/step="+step);
		
			if(min <= inputInt && inputInt <= max){
				System.out.println("inputInt="+inputInt+"/I="+(i+1));
				break;
			}
			i++;
		}
	}
}
