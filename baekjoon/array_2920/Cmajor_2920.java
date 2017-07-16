package baekjoon.array_2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
c d e f g a b C, 총 8개 음이 있다.
이 8개 음을 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로..

1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
*/
public class Cmajor_2920 {

	public static void main(String[] args) throws IOException {
		new Cmajor_2920();
	}
	
	Cmajor_2920() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		Map<String, String> map = new HashMap<>();
		map.put("c", "1");	map.put("d", "2");	map.put("e", "3");
		map.put("f", "4");	map.put("g", "5");	map.put("a", "6");
		map.put("b", "7");	map.put("C", "8");
		
		String asc = "12345678";
		String desc = "87654321";
		String inputCombination = "";
		
		while(token.hasMoreTokens()){
			String major = token.nextToken();
			String value = map.get(major);
			inputCombination += value;
		} //end while
		
		if(inputCombination.equals(asc)){
			System.out.println("ascending");
		}else if(inputCombination.equals(desc)){
			System.out.println("descending");
		}else{
			System.out.println("mixed");
		}
	}
}
