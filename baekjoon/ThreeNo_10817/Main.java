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
		// �� ��°�� ū ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
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
//		System.out.println("##  �ҿ�ð�(ms) : " + ( endTime - startTime ) + "(ms)"); 
	}

}
