package baekjoon.string_2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Croatia_2941 {

	public static void main(String[] args) throws IOException {
		new Croatia_2941();
	}
	Croatia_2941() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
		int croatiaCnt = 0;
		int inputLen = 0;
		boolean isDetected = true;
		String[] croatiaArr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		while (isDetected) {
//			for(String alphabet : croatiaArr){
			if(inputStr.contains("c=")){
				croatiaCnt++;
//				inputLen += inputStr.indexOf("c=");
//				inputStr = inputStr.substring(inputStr.indexOf("c="), inputStr.length());
				inputStr = inputStr.replaceFirst("c=", "");
				
			}
			if(inputStr.contains("c-")){
				croatiaCnt++;
				inputLen += inputStr.indexOf("c-");
				inputStr = inputStr.substring(inputStr.indexOf("c-"), inputStr.length());
				inputStr = inputStr.replaceFirst("c-", "");
				
			}
			if(inputStr.contains("dz=")){
				croatiaCnt++;
				inputLen += inputStr.indexOf("dz=");
				inputStr = inputStr.substring(inputStr.indexOf("dz="), inputStr.length());
				inputStr = inputStr.replaceFirst("dz=", "");
				
			}
			if(inputStr.contains("d-")){
				croatiaCnt++;
				inputStr = inputStr.substring(inputStr.indexOf("d-"), inputStr.length());
				inputStr = inputStr.replaceFirst("d-", "");
				inputLen += inputStr.indexOf("d-");
			}
			if(inputStr.contains("lj")){
				croatiaCnt++;
				inputLen += inputStr.indexOf("lj");
				inputStr = inputStr.substring(inputStr.indexOf("lj"), inputStr.length());
				inputStr = inputStr.replaceFirst("lj", "");
				
			}
			if(inputStr.contains("nj")){
				croatiaCnt++;
				inputLen += inputStr.indexOf("nj");
				inputStr = inputStr.substring(inputStr.indexOf("nj"), inputStr.length());
				inputStr = inputStr.replaceFirst("nj", "");
				
			}
			if(inputStr.contains("s=")){
				croatiaCnt++;
				inputLen += inputStr.indexOf("s=");
				inputStr = inputStr.substring(inputStr.indexOf("s="), inputStr.length());
				inputStr = inputStr.replaceFirst("s=", "");
				
			}
			if(inputStr.contains("z=")){
				croatiaCnt++;
				inputLen += inputStr.indexOf("z=");
				inputStr = inputStr.substring(inputStr.indexOf("z="), inputStr.length());
				inputStr = inputStr.replaceFirst("z=", "");
				
			}else{
				isDetected = false;
			}
//			} //end for
//			if(!isDetected)	break;
		} //end while
		croatiaCnt += inputStr.trim().length();
		System.out.println(croatiaCnt);
	} //end Main()
} //end Class