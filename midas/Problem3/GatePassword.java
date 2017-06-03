package midas.Problem3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GatePassword {
    public int passwordcount=0;

    GatePassword() throws IOException {
        Scanner sc = new Scanner(System.in);
        // line 1.
        int A = sc.nextInt();
        int B = sc.nextInt();
        // line 2.
        int[] nums = new int[B];
        for(int i=0; i<B; i++){
            nums[i] = sc.nextInt();
        }
        sc.close();

        // 배열 출력순서 인덱스 정보를 담는 배열 정의
        int[] indexcollection = new int[B];
        combination(nums, indexcollection, 0, B, A, 0);

        System.out.println(this.passwordcount);
    }
    public static void main(String argv[] ) throws IOException {
        new GatePassword();
    } //end main()

    public void combination(int[] nums, int[] arr, int index, int n, int r, int target) {
        if (r == 0) {
            print(nums, arr, index);
        }
        else if (target == n) {
            return;
        }
        else {
            arr[index] = target;
            combination(nums, arr, index + 1, n, r - 1, target + 1);
            combination(nums, arr, index, n, r, target + 1);
        }
    } //end combination()

    public void print(int[] nums, int[] arr, int length) {
        List<Integer> password = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            password.add(nums[arr[i]]);
        }
        int odd=0, even=0;
        for(int i=0; i<password.size(); i++){
            int element = password.get(i);
            if((element % 2) == 0){
                even++;
            }else{
                odd++;
            }
        }
        Collections.sort(password);
        if(odd>0 && even>0){
            this.passwordcount++;
        }
    } //end print()
}
