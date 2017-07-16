package baekjoon.array_8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
# 입력 
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX

# 결과 
10
9
7
55
30
 */
public class OX_8958 {

	public static void main(String[] args) throws IOException {
		new OX_8958();
	}
	
	OX_8958() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		int totalScore=0;
		int tempScore=0;
		
		while(loop-->0){
			String oxs = br.readLine();
			
			for(int i=0; i<oxs.length(); i++){
				char singlechar = oxs.charAt(i);
				if(singlechar=='O'){
					tempScore++;
					totalScore += tempScore;
				}else if(singlechar=='X'){
					tempScore = 0;
				}
			} //end for
			System.out.println(totalScore);
			totalScore = 0;	tempScore = 0;
		} //end while
	} //end Main

}
