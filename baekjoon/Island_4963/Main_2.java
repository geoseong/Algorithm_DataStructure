package baekjoon.Island_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * # 입력
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다.
 * 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다.
 * w와 h는 50보다 작거나 같은 양의 정수이다.
 * <p>
 * 둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
 * <p>
 * 입력의 마지막 줄에는 0이 두 개 주어진다.
 * <p>
 * # 출력
 * 각 테스트 케이스에 대해서, 섬의 개수를 출력한다.
 */
public class Main_2 {
    // 섬과바다 표시배열
    int[][] island;
    // 섬과바다 검사여부배열
    boolean[][] isCheck;

    public static void main(String[] args) throws IOException {
        new Main_2();
    } //end main()

    Main_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();


        while (true) {
            String inputLine = br.readLine();
            if (inputLine.equals("00") || inputLine.equals("0 0")) break;
            // line 1.
            token = new StringTokenizer(inputLine, " ");
            int width = Integer.parseInt(token.nextToken());
            int height = Integer.parseInt(token.nextToken());
            // 주어진 입력범위 밖은 모두 바다 (value = 0) 라는 정보를 넣기위해
            // 섬이 붙어있는 지 검사 시에 검사대상 주위를 둘러싼 인덱스를 구하기위해 IndexOutofBounds가 안 나게 하기위해
            island = new int[height+2][width+2];
            isCheck = new boolean[height+2][width+2];

            // line x(2~height)
            // island[][] 배열값 채워넣기
            for (int n = 1; n < height+1; n++) {
                token = new StringTokenizer(br.readLine(), " ");
                int tokenIndex=1;
                while(token.hasMoreTokens()){
                    int element = Integer.parseInt(token.nextToken());
                    island[n][tokenIndex] = element;
                    tokenIndex++;
                }
            } //end for
            // * 검사대상을 둘러싼 인덱스를 한번에 검색하여 해당 범위 중 하나라도 1이 있으면 그거슨 하나의 섬.
            // then 섬 갯수를 카운트하지 않는다.
            // * 같은 크기의 2차원배열을 만들어서 발견된 인덱스의 Flag를 true표시한다.
            // so 다음에 검사대상에 true 플래그인 요소는 검사를 하지 않는다.
            int islands = getIslands(island);
            sb.append(islands+"\n");
        } //end while

        // 결과출력
        System.out.println(sb.toString());
    } // end Main_2()

    public int getIslands(int[][] array){
        // 대상을 둘러싸는 인덱스
        // ex) [1,1] : [0,0] [0,1] [0,2] / [1,0] [1,2] / [2,0] [2,1] [2,2]
        int[] search_x = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] search_y = {-1, -1, -1, 0, 0, 1, 1, 1};
        // 섬갯수
        int islands = 0;

        // 섬바다 배열의 맨 첫째 자리(둘러싼 바다 제외)가 섬이면 카운트
        if(array[1][1]==1){
            islands++;
        }
        for(int z=1; z<array.length-1; z++){    // 행
            for(int a=1; a<array[0].length-1; a++){     // 열
                // 검사대상도 검사했다는 Flag 표시.
                isCheck[z][a]=true;
                // 한 대상을 감싸는 영역 안에서 섬이 존재하는 Flag를 정의해야 대각선이나 붙어있는 1이 있을 때 섬 갯수 추가 안할 수 있으므로..
                boolean isCount=false;
                for(int i=0; i<search_x.length; i++){
                    int x = a + search_x[i];
                    int y = z + search_y[i];

                    if(!isCheck[y][x] && array[z][a]==0 && array[y][x]==1){
                        if(!isCount) islands++;
                        isCheck[y][x] = true;
                        isCount=true;
                    }else if(array[y][x]==1){
                        isCheck[y][x] = true;
                        isCount=true;
                    } //end if


                } //end for

            } //end for
        } //end for
        return islands;
    } //end getIslands()
}
