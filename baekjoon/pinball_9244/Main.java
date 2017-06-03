package baekjoon.pinball_9244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* Sweep board as ball falls
* Event queue, sorted by y
    - Events: Add/erase segment, possible ball hit
* Search tree with segments, sorted by x at current y
    - Query: which segment would the ball hit?
    - Update: add/erase segment
* Insight: No intersections =⇒ order in the tree independent of y
*/
class Line{
//    Line leftNode;
//    Line rightNode;
    int topX, topY;
    int bottomX, bottomY;
//    boolean checked;

    public Line() {
    }

    public Line(int topX, int topY, int bottomX, int bottomY) {
        this.topX = topX;
        this.topY = topY;
        this.bottomX = bottomX;
        this.bottomY = bottomY;
    }
}

class SegTree{
    SegTree leftTree;
    SegTree rightTree;
    Line locationInfo;
    int locationX;

    public SegTree(int locationX) {
        this.locationX = locationX;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        new Main();
    } //end main()

    Main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        // Line 1
        int lineqty = Integer.parseInt(br.readLine());
        // 선분 정보와 그 정보들을 저장하는 배열 정의.
        Line line = null;
        Line[] lines = new Line[lineqty];

        // Line[] 완성.
        for(int i=0; i<lineqty; i++){
            // 입력된 라인갯수(lineqty) 중 한 라인
            token = new StringTokenizer(br.readLine(), " ");

            // Line 객체에 들어갈 top, bottom int를 판별하여 입력
            int x0 = Integer.parseInt(token.nextToken());
            int y0 = Integer.parseInt(token.nextToken());
            int x1= Integer.parseInt(token.nextToken());
            int y1= Integer.parseInt(token.nextToken());
            if(y0>y1){
                // (x0, y0) is top
                line = new Line(x0, y0, x1, y1);
            }else{
                // (x1, y1) is top
                line = new Line(x1, y1, x0, y0);
            }
            // 선분 i 번째에 top과 bottom이 분류된 Line객체를 저장
            lines[i] = line;
        } //end while

        // y축 기준으로 순서대로 선분 Queue에 넣기
        Queue<Line> lineQueue = null;
        lineQueue = insertLineQueue(lines, lineQueue);

        // x축 기준으로 SegmentTree 넣기
        // 공의 시작 x좌표
        int ball_x0 = Integer.parseInt(br.readLine());
        SegTree segTree = new SegTree(ball_x0);
//        segTree = insertSegmentTree(segTree, lineQueue);

        int final_x=insertSegmentTree(ball_x0, lineQueue);

        System.out.println(final_x);
    } //end Main()


    public Queue<Line> insertLineQueue(Line[] lines, Queue<Line> lineQueue){
        lineQueue = new LinkedList<>();
        // Line 자리 바꾸기 위한 변수 temp.
        Line temp;
        for(int i=0; i<lines.length; i++){
            for(int n=0; n<lines.length-1; n++){
                if(lines[n].bottomY < lines[n+1].topY) {
                    temp = lines[n+1];
                    lines[n+1] = lines[n];
                    lines[n] = temp;
                } //end if
            } //end for n
        } //end for i

        for(int i=0; i<lines.length; i++){
            lineQueue.add(lines[i]);
        }
        return lineQueue;
    } //end insertSegmentTree

    public int insertSegmentTree(int ball_x0, Queue<Line> lineQueue){
//        segTree rootNode = new Line();
//        int final_x=ball_x0;
        while(lineQueue.size() > 0){
            Line lineNow = lineQueue.poll();
            // 큐의 선분의 x범위 포함 x0
            int x_from=0;
            int x_to=0;
            if (lineNow.topX > lineNow.bottomX) {
                x_from = lineNow.bottomX;
                x_to = lineNow.topX;
            }else if(lineNow.topX < lineNow.bottomX) {
                x_from = lineNow.topX;
                x_to= lineNow.bottomX;
            }

            if(x_from <= ball_x0 && ball_x0<= x_to){
                ball_x0 = lineNow.bottomX;
            }else{
                //  if (큐의 선분의 x범위 미포함 x0)
                continue;
            }
        } //end while

        return ball_x0;
    } //end insertSegmentTree
} //end Main