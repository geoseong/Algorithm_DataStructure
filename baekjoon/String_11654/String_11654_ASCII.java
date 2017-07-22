package baekjoon.String_11654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_11654_ASCII {

	public static void main(String[] args) throws IOException {
		new String_11654_ASCII();
	}
	
	String_11654_ASCII() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputMsg = br.readLine().toCharArray();
		
		System.out.println((int)inputMsg[0]);
	} //end Main

}