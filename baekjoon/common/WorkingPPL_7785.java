package baekjoon.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class WorkingPPL_7785 {

	public static void main(String[] args) throws IOException {
		// Condition
		// n : 2 <= n <= 10^6
		// Print the person's name who has "enter" status
/* input
8
Baha enter
Askar enter
Baha leave
Artem enter
Baha enter
Askar enter
Baha leave
Artem enter
*/
//		Scanner scan = new Scanner(System.in);
//        int numppl = scan.nextInt();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        int numppl = Integer.parseInt(br.readLine());
        Map<String, String> workingppl = new HashMap<String, String>();
		String text0 = "";
		String text1 = "";
        
        for(int i=0; i < numppl; i++){
        	token = new StringTokenizer(br.readLine(), " ");
		    text0 = token.nextToken();
		    text1 = token.nextToken();
		    if(text1.equals("enter"))    workingppl.put(text0, text1);
            if(text1.equals("leave"))    workingppl.remove(text0);
		}
		
        List<String> list = new ArrayList<String>();
        list.addAll(workingppl.keySet());
        Collections.sort(list);
        Collections.reverse(list);
        
        StringBuilder sb = new StringBuilder();
        for(String s : list){
           sb.append(s+"\n");
        }
        System.out.println(sb.toString());
	}

}
