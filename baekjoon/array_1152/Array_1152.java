package baekjoon.array_1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* The Curious Case of Benjamin Button */
public class Array_1152 {
    public static void main(String[] args) throws IOException {
        new Array_1152();
    } //end main()

    Array_1152() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        System.out.println(token.countTokens());
    }
}
