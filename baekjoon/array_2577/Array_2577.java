package baekjoon.array_2577;

import java.io.IOException;
import java.util.Scanner;

/*
세 개의 자연수 A, B, C가 주어질 때 A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
150
266
427
 */
public class Array_2577 {

	public static void main(String[] args) throws IOException {
        new Array_2577();
    } //end main()

	Array_2577() throws IOException {
        Scanner scan = new Scanner(System.in);
        int[] number = new int[10];
        int repeat=3;
        int multiple=1;
        String val="";
        
        while(repeat-->0){
        	int value = scan.nextInt();
        	multiple *= value;
        }
        val = Integer.toString(multiple);
        
        for(int i=0; i<val.length(); i++){
        	int castint = Character.digit(val.charAt(i), 10);
        	number[castint]++;
        }
        for(int i : number){
        	System.out.println(i);
        }
    }
	
}
