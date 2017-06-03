package baekjoon.Island_4963;

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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 섬과바다 표시배열
    int[][] island;
    // 섬과바다 검사여부배열
    boolean[][] isCheck;

    public static void main(String[] args) throws IOException {
        new Main();
    } //end main()

    Main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        int islands = 0;

        while (true) {
            // TestCase마다 섬 갯수 초기화
            islands = 0;
            String inputLine = br.readLine();
            if (inputLine.equals("00") || inputLine.equals("0 0")) break;
            // line 1.
            token = new StringTokenizer(inputLine, " ");
            int width = Integer.parseInt(token.nextToken());
            int height = Integer.parseInt(token.nextToken());
            // 주어진 입력범위 밖은 모두 바다 (value = 0) 라는 정보를 넣기위해
            // 섬이 붙어있는 지 검사 시에 검사대상 주위를 둘러싼 인덱스를 구하기위해 IndexOutofBounds가 안 나게 하기위해
            island = new int[height+2][width+2];

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

            // * 배열을 탐색해 가며 1인 요소는 0을 만들고, 주위에 1인 요소를 발견하면 같은방식으로 1이 끊기는 위치까지 탐색한다.
            for(int h=1; h<height+1; h++){    // 행
                for(int w=1; w<width+1; w++){     // 열
                    if(island[h][w]==1){
                        islands++;
                        getIslands(h, w);
                    }
                } //end for
            } //end for
            sb.append(islands+"\n");
        } //end while

        // 결과출력
        System.out.println(sb.toString());
    } // end Main_2()

    public void getIslands(int h, int w){
        // 검사대상. 즉 1이 표시된 위치에 대해서 0으로 바꿈
        island[h][w] = 0;

        // 대상을 둘러싸는 인덱스
        // ex) 대상 [1,1] : 주위 [0,0] [0,1] [0,2] / [1,0] [1,2] / [2,0] [2,1] [2,2]
        int[] search_h = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] search_w = {-1, 0, 1, -1, 1, -1, 0, 1};

        for(int i=0; i<search_h.length; i++){
            int around_h = h + search_h[i];
            int around_w = w + search_w[i];
            // 주위에 1인 위치를 발견하면 재귀호출하여 그 위치에서도 근처에 1이 있는지 탐색.
            if(island[around_h][around_w]==1){
                getIslands(around_h, around_w);
            }
        } //end for
    } //end getIslands()
}
