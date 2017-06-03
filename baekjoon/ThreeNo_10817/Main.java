package baekjoon.ThreeNo_10817;
/*
30 20 10

 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오. 
		long startTime = System.currentTimeMillis();
		
		List<Integer> numberList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		Integer number_1=scan.nextInt();
		Integer number_2=scan.nextInt();
		Integer number_3=scan.nextInt();
		numberList.add(number_1);
		numberList.add(number_2);
		numberList.add(number_3);
		
		Collections.sort(numberList);
//		for(Integer no : numberList){
//			System.out.println(no);
//		}
		
		System.out.println(numberList.get(1));
		long endTime = System.currentTimeMillis();
//		System.out.println("##  소요시간(ms) : " + ( endTime - startTime ) + "(ms)"); 
	}

}
