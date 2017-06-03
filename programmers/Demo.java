package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;

public class Demo {
    Demo() throws IOException {
        StringTokenizer token = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String array1 = br.readLine();
        String array2 = br.readLine();

        System.out.println(array1);
        System.out.println(array2);

    }

    public static void main( String argv[] ) throws IOException {
        new Demo();
    }
}
