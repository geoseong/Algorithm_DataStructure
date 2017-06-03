package programmers;

/**
 * Created by TSPark on 2017-05-20.
 */

public class Recursion_fail {
    int[] array = {1, 2, 3, 4};
    int[] position = {1111, 1111, 1111};
    int sum=0;
    int prime=0;
    boolean brandnew=false;
    int smallest = 0;   // 서로다른 숫자를 저장하는 배열의 시작인덱스

    Recursion_fail(){
        setPrime(0, 0, 3);
        System.out.println(prime);
    }
    public static void main(String argv[]){
        new Recursion_fail();
    } //end main()

    // param1 : pos, param2 : index
    public int[] setPrime(int pos, int index, int pick) {
//        if(index == array.length)   {
//            if(pos==3)  pos--;
//            setPrime(pos-1, position[pos-1]+1, pick);
//        }
        for(int entire=0; entire<array.length; entire++) {
            if (pick <= 0) {
                // * calc sum
                for (int j = 0; j < position.length; j++) {
                    sum += array[position[j]];
                }
                // * isPrime
                if (isPrime(sum)) prime++;
                sum = 0;    // 다음 케이스에서 배열의 합을 구해서 소수 판별해야하므로 초기화.
                if(index == array.length){
                    index = position[pos-1]+1;
                    pos = pos-1;
                }
                return new int[]{pos, index};
            } else {

                if(!brandnew)   brandnew = true;
                else {
                    smallest=0;
                    for (int n = 0; n < position.length; n++) {
                        if (position[n] < 1111) {
                            smallest++;
                        }
                    }
                }
                for (int i = smallest; i < position.length; i++) {
                    position[i] = index;
                    // param1 : pos, param2 : index
                    int[] returnarr = setPrime(i, index + 1, pick - 1);
                    index = returnarr[1];
                    position[returnarr[0]] = 1111;
                    smallest = returnarr[0];
                    brandnew = false;
                    setPrime(i, index, pick);
                }

            }
        }
        return new int[]{pos, index};
    }

    public boolean isPrime(int num){
        if(num>=2){
            for(int i=2; i < num ; i++){
                if(num % i == 0 && num != i){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }

}
