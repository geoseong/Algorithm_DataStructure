import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeSum {
    public static void main( String argv[] ) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();
        int result = 0;

        ArrayList<Integer> prime = new ArrayList<Integer>();
        for(int i=N; i < M; i++){
            if(isPrime(i)){ prime.add(i);   }
        }

        int sumofPrime=0;
        for(int n=0; n<prime.size(); n++){
            sumofPrime += prime.get(n);
        }

        if(prime.size()==0){
            result = -1;
        }else{
            result = sumofPrime;
        }

        System.out.println(result);
    } //end main()

    public static boolean isPrime(int num){
        if(num<2){  return false;   }
        for(int i=2; (i*i) <= num ; i++){
            if(num % i == 0){
               return false;
            }
        }
        return true;
    } //end isPrime()
}
