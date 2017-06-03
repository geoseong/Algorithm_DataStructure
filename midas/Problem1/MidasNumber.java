package midas.Problem1;

import java.io.IOException;
import java.util.Scanner;

public class MidasNumber {
    public static void main( String argv[] ) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        int midascnt=0;
        for(int i=2; i < N; i++){
            int max_soinsoo = getSoInSoo(i);
            if(max_soinsoo <= M){   midascnt++; }
        }

        System.out.println(midascnt);
    } //end main()

    public static int getSoInSoo(int num) {
        int divide = 2;
        int max=0;
        int numforloop = num;
        for(int i=0; (i*i) <= numforloop; i++){
            if (num % divide == 0 && num != 1) {
                if(max<divide){ max = divide;   }
                num = num / divide;
            }else{
                divide++;
            }
        }
        return (max==0)?numforloop : max;
    } //end getSoInSoo()

}
