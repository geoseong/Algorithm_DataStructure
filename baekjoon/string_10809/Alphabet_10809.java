package baekjoon.string_10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alphabet_10809 {
    public static void main(String[] args) throws IOException {
        new Alphabet_10809();
    } //end main()

    Alphabet_10809() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        char[] charArr = inputStr.toCharArray();
        int startAscii = 97;    // a
        int endAscii = 122;     // z
        int[] arrAscii = new int[endAscii-startAscii+1];
        Arrays.fill(arrAscii, -1);  // 모든 배열을 -1 로 초기화

        for(char ch : charArr){
            int inputAsciiInt = (int)ch;
            arrAscii[inputAsciiInt-startAscii] = inputStr.indexOf(ch);
        } //end for

        for(int i : arrAscii){
            System.out.printf(i + " ");
        }
    }
}
