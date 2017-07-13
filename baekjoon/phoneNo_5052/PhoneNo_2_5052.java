package baekjoon.phoneNo_5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


class Trie{	
	HashMap<Integer,Object> root;
	public Trie(){
		this.root = new HashMap<>();
	}
	
	public boolean insert(String str){
		HashMap<Integer,Object> mapBuf = root;
		String strBuf = str;
		int numBuf;
		while(strBuf.length() > 0){
			if(mapBuf.get(10) != null){
				return false;
			}
			numBuf = Character.getNumericValue(strBuf.charAt(0));
			if(mapBuf.get(numBuf) == null){
				mapBuf.put(numBuf, new HashMap<Integer,Object>());
			}
			mapBuf = (HashMap<Integer,Object>)mapBuf.get(numBuf);
			strBuf = strBuf.substring(1);
		}
		mapBuf.put(10, new ArrayList<Object>());
		return true;
	}
}

public class PhoneNo_2_5052 {
	
	public static void main(String[] args) throws IOException {
		new PhoneNo_2_5052();
	}

	PhoneNo_2_5052() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int qtyTestcase = Integer.parseInt(br.readLine());
		String result = "";
		
		String[] strAry;
		Trie trie;
		boolean flag;
		
		while(qtyTestcase-- > 0){
			int caseLines = Integer.parseInt(br.readLine());
			
			strAry = new String[caseLines];
			trie = new Trie();
			flag = false;
			
			// 입력된 번호 배열에 넣고 
			for(int i=0;i<caseLines;i++){
				strAry[i] = br.readLine();	// 폰번호.
			}
			// 배열의 길이별 내림차순 정렬.
			Arrays.sort(strAry, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length() > o2.length()){
						return 1;
					}else if(o1.length() == o2.length()){
						return 0;
					}else{
						return -1;
					}
				}
			});
			
			for(int i=0;i<caseLines;i++){
				if(trie.insert(strAry[i]) == false){
					System.out.println("NO");
					flag = true;
					break;
				}
			}
			if(!flag){
				System.out.println("YES");
			}
		} //end while
		
	} // end Main
	
} // end class
