package baekjoon.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/* input
2
3 3
3 1 1
5 3
4 4 5
-----------------------
2           <- number of TestCases
3 3         <- TestCase1) Have , Will See
3 1 1       <- TestCase1) MovieNo[] that he want to see that moment
5 3         <- TestCase2)) Have , Will See
4 4 5       <- TestCase2)) MovieNo[] that he want to see that moment
*/
/* output
2 1 0
3 0 4
-----------------------
2 1 0       <- TestCase1) Qty of movie above picked MovieNo.
3 0 4       <- TestCase2)) Qty of movie above picked MovieNo.
*/
public class MovieStack_3653 {

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int count=0;
		
		// Line 1
		while(testcase-->0){
			token = new StringTokenizer(br.readLine(), " ");
			int qtymoviehave = Integer.parseInt(token.nextToken());
			int qtymoviewillsee = Integer.parseInt(token.nextToken());
			
			int[] movieList = new int[qtymoviehave];
			for(int i=0; i<qtymoviehave; i++){
				movieList[i]=(i+1);
			}
		// Line 2
			token = new StringTokenizer(br.readLine(), " ");
			while(qtymoviewillsee-->0){
				int pickmovieno = Integer.parseInt(token.nextToken());
//				MovieStack_3653 main = new MovieStack_3653();
				
				for(int i=0; i<qtymoviehave; i++){
					System.out.printf("movieList[%d]=%d, pickmovieno=%d\n", i, movieList[i], pickmovieno);
					if(movieList[i]==pickmovieno){
						count = i;
						sb.append(count+ " ");
					}
				}
				
				changeloc(movieList, count);
				System.out.println();
			} //end while m
			sb.append("\n");
		} //end while t
		System.out.println(sb.toString());
	} //end main
	
	public static void changeloc(int[] movieList, int count){
		//int[] movieList=new int[3];
		int temp=0;
		
		
		// 지목한 숫자보다 앞에있는 갯수만큼 loop반복?
		for(int i=count; i >= 1; i--){		// (배열길이-1) 부터 1까지 ... 1씩 감소하며 반복
			System.out.printf("-----------------\nmovieList[%d]=%d, movieList[%d]=%d, temp=%d\n",i, movieList[i], i-1, movieList[i-1], temp);
			temp = movieList[i];
			movieList[i]=movieList[i-1];
			movieList[i-1]=temp;
			System.out.println("중간점검");
			for(int j=0; j<movieList.length; j++)	System.out.printf("movieList[%d] = %d\n", j, movieList[j]);
		}
		
		System.out.printf("지목된 영화번호 앞에 있는 갯수: %d\n", count);
		
	}
}
