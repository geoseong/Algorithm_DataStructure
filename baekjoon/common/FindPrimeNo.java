package baekjoon.common;

import java.util.Scanner;

public class FindPrimeNo {
	/*
	 �Ҽ��� ������ ����ϱ�
	 - ù �ٿ� ���� ���� N�� �־�����. N�� 100�����̴�. �������� N���� ���� �־����µ� ���� 1,000 ������ �ڿ����̴�.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int primeNo[] = new int[4];
        primeNo[0] = 2;	primeNo[1] = 3;	primeNo[2] = 5;	primeNo[3] = 7;
        int cnt = 0;
        
        while(N-->0){
        	int num = scan.nextInt();
        	boolean isPrimeNo = false;
        	
        	if(num == 1)		continue;
        	if(num > 1 && num <= 3)	{
        		cnt++;
        		continue;
        	}
        	for(int i=0; i < primeNo.length; i++){
        		if(num == primeNo[i]){
        			isPrimeNo = true;
        			break;
        		}
        		if((num % primeNo[i]) == 0){
        			isPrimeNo = false;
        			break;
        		}else{
        			isPrimeNo = true;
        		}
        	} //end for
        	if(isPrimeNo)		cnt++;
        } //end while
        
        System.out.println(cnt);
	}

}
