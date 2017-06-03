package baekjoon.common;

import java.util.Scanner;

public class ConsoleTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int recur = scan.nextInt();
        
        for(int i=0; i<recur; i++){
            for(int j=0; j<=i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}

