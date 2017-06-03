package baekjoon.ChocoSlice_2163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strinput=br.readLine();
		int n = Integer.parseInt(strinput.split(" ")[0]);
		int m = Integer.parseInt(strinput.split(" ")[1]);
		int result=0;
        
		if(n>m || n==m){
			result = getSplitcnt(n, m);
		}else{
			result = getSplitcnt(m, n);
		}
        
        System.out.println(result);
	}

	public static int getSplitcnt(int big, int small){
		int splitcnt=0;
		splitcnt = 2*big + small - 3;
		return splitcnt;
	}
}
