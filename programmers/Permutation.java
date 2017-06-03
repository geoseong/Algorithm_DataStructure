package programmers;

/**
 * Created by TSPark on 2017-05-20.
 */
// 순열. nPr
public class Permutation {
    public static void main(String argv[]){
        int[] array = {1, 2, 3, 4, 5};
        int n = array.length;   // n : 전체 원소의 수
        int[] picked = new int[array.length];   // picked : 지금까지 고른 원소들의 번호
        int toPick=4;   // toPick : 더 고를 원소의 수
        // picked변수값 초기화
        for(int i=0; i<picked.length; i++){
            picked[i] = 1000;
        }
        // 모든 조합 만들기
        pick(n, picked, toPick);
    }

    public static void pick(int n, int[] picked, int toPick){
        if(toPick==0){
            String chars="";
            for(int i=0; i<picked.length; i++){
                if (picked[i] < 1000) {
                    chars += picked[i];
                }
                if(chars.length()==4) {
                    System.out.println(chars);
                    chars="";
                }
            }
            return;
        }
        int smallest=0; // int smallest = picked.isEmpty() ? 0 : picked.get(picked.size()-1) + 1;
        for (int i = 0; i < picked.length; i++) {
            if (picked[i] < 1000) {
                smallest++;
            }
        }
        for(int next = smallest; next < n; next++){
            picked[next] = next;    //picked.add(next);
            pick(n, picked, toPick-1);  //pick(n, new ArrayList<integer>(picked), toPick - 1);
            picked[next] = 1000;    //picked.remove(picked.size()-1);
        }
    } //end pick()
}
