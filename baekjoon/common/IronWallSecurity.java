package baekjoon.common;

import java.util.Scanner;

public class IronWallSecurity {
	/* input
		2		<- number of testcase
		4		<- Quantity of keys (testcase 1)
		A B C D		-- public key 1
		D A B C		-- public key 2
		C B A P		-- security key
		3		<- Quantity of keys (testcase 2)
		SECURITY THROUGH OBSCURITY		-- public key 1
		OBSCURITY THROUGH SECURITY		-- public key 2
		TOMORROW ATTACK WE				-- security key
	*/
	/* output
		B A P C							<- Normal Key of testcase 1( Reverse way from public key 1 to public key 2 with security Key )
		WE ATTACK TOMORROW		<- Normal Key of testcase 2( Reverse way from public key 1 to public key 2 with security Key )
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] pubkey1=null;
		String[] pubkey2=null;
		String[] securityKey=null;
		int[] distances=null;
		
		int testCase = scan.nextInt();
		while(testCase-- > 0){
			int qtyKeys = scan.nextInt();
			pubkey1 = new String[qtyKeys];
			pubkey2 = new String[qtyKeys];
			securityKey = new String[qtyKeys];
			distances = new int[qtyKeys];
			
			int routineKey = qtyKeys;
			while(qtyKeys-- > 0){
//				System.out.println("scan delimiter : " + scan.delimiter());	// 기본 구분자는 스페이스바
				pubkey1[pubkey1.length-(qtyKeys+1)] = scan.next();
//				System.out.println("pubkey1 scan next() : " + pubkey1[pubkey1.length-(qtyKeys+1)]);
			}
			qtyKeys = routineKey;
			while(qtyKeys-- > 0){
				pubkey2[pubkey2.length-(qtyKeys+1)] = scan.next();
//				System.out.println("pubkey2 scan next() : " + pubkey2[pubkey2.length-(qtyKeys+1)]);
			}
			qtyKeys = routineKey;
			while(qtyKeys-- > 0){
				securityKey[securityKey.length-(qtyKeys+1)] = scan.next();
//				System.out.println("securityKey scan next() : " + securityKey[securityKey.length-(qtyKeys+1)]);
			}
			
		//// START : 규칙 알아내기
			int cntdistance = 0;
			for(int i=0; i < pubkey1.length ; i++){
				for(int j=0; j < pubkey2.length ; j++){
					if(pubkey1[i].equals(pubkey2[j])){
//						System.out.printf("잡았다 요놈 - pubkey1[%d] = %s , pubkey2[%d] = %s\t", i , pubkey1[i] , j , pubkey2[j]);
						distances[cntdistance] = i - j;
						cntdistance++;
//						System.out.println("distance between pubkey1 and pubkey2 = " + (i-j));
					}
				}
			}
			//// END : 규칙 알아내기
//			System.out.println("끋");
			
			for(int i=0; i < securityKey.length ; i++){
				int placeInt = i - distances[i];
				if( placeInt < 0 ){
					System.out.print(securityKey[securityKey.length + placeInt] + " ");
					continue;
				}
//				else if( placeInt > 3 ){
//					System.out.println(securityKey[securityKey.length + placeInt]);
//				}
				else{
					System.out.print(securityKey[placeInt] + " ");
				}
			}
		} //end while testCase
		
		
	} //end main Method

}
