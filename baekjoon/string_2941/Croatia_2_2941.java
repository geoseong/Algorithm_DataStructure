package baekjoon.string_2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Croatia_2_2941 {

	public static void main(String[] args) throws IOException {
		new Croatia_2_2941();
	}
	Croatia_2_2941() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = br.readLine();
        String tempStr = inputStr;		
        int idxCroatia = 0;
		String[] croatiaArr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		while (idxCroatia < croatiaArr.length) {
            inputStr = inputStr.replaceFirst(croatiaArr[idxCroatia], ".");
            if(inputStr.equals(tempStr)){
				idxCroatia++;
			} else {
				tempStr = inputStr;
			}
		} //end while
		System.out.println(inputStr.length());
	} //end Main()
} //end Class