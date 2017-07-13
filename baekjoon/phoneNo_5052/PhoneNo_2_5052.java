package baekjoon.phoneNo_5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 각 테스트 케이스에 대해서, 일관성 있는 목록인 경우에는 YES, 아닌 경우에는 NO를 출력한다. */


public class PhoneNo_2_5052 {

	public static void main(String[] args) throws IOException {
		new PhoneNo_2_5052();
	}

	PhoneNo_2_5052() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int qtyTestcase = Integer.parseInt(br.readLine());
		boolean stop = false;
		
		while(qtyTestcase-- > 0){
			int testCase = Integer.parseInt(br.readLine());
			String result = null;
			
			// get max length
			for(int i=0; i<testCase; i++){
				String phoneNo = br.readLine();
				
				for(int j=0; j<phoneNo.length(); j++){
					Character ch = phoneNo.charAt(j);
					int ele = Integer.parseInt(ch.toString());
				}
			}
		} //end while
	}	// end Main
	
} // end class
