package baekjoon.pinball_9244;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Line_old{
//    Line rootNode;
    Line leftNode;
    Line rightNode;
    int topX, topY;
    int bottomX, bottomY;
    boolean checked;

    public Line_old() {
    }

    public Line_old(int topX, int topY, int bottomX, int bottomY) {
        this.topX = topX;
        this.topY = topY;
        this.bottomX = bottomX;
        this.bottomY = bottomY;
    }
}

public class Main_old {
    public static void main(String[] args) throws IOException{
        new Main();
    } //end main()

    Main_old() throws IOException{
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

    long startTime = System.currentTimeMillis();
        // SegmentTree에 데이터 넣기
        Line segTree = null;
        segTree = insertSegmentTree(lines, segTree);

        // SegmentTree검색 후 맨윗선분부터 Queue에 추가
        Queue<Line> lineQueue = null;
        lineQueue = searchTreeAndEnQueue(segTree, lineqty);

        // 공의 시작 x좌표
        int ball_x0 = Integer.parseInt(br.readLine());
        int final_x=ball_x0;
//        x의 범위 : x1~x2
//        공 떨어뜨리기 시작하는 x좌표가( x0 )
//        큐에 저장되어있는 가장 첫 선분의 x범위에 포함이 안 되어있다면,
//        다음 큐의 선분에다가 x0를 대입 해 봐서 해당 선분의 x범위에 포함이 되는지 확인 한다.
        while(lineQueue.size() > 0){
            Line lineNow = lineQueue.remove();
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

            if(x_from <= final_x && final_x<= x_to){
                final_x = lineNow.bottomX;
            }else{
                //  if (큐의 선분의 x범위 미포함 x0)
                continue;
            }
        } //end while
        System.out.println(final_x);
    long endTime = System.currentTimeMillis();
    System.out.println("## 소요시간(ms) : " + ( endTime - startTime ) + "(ms)");
    } //end Main()


    public Line insertSegmentTree(Line[] lines, Line segTree){
        Line rootNode = new Line();
        for(int i=0; i<lines.length; i++){
            // rootNode 정보를 담는 변수 저장하기.
            if(segTree == null){
                rootNode = lines[i];
                segTree = rootNode;
                continue;
            }
//            * 좌측트리 = 하위계층 선분 / 우측트리 = 상위계층 선분
//            * 이미존재 = rootNode
            while(true){
                // y비교
                if(rootNode.bottomY >= lines[i].topY) {
                    // (새로입력 = 하위계층 선분)
                    // if(이미존재.좌측트리 != null)
                    if (rootNode.leftNode != null) {
                        rootNode = rootNode.leftNode;
                        continue;
                    } else {
                        //이미존재.좌측트리 = new Node(새로입력)
                        rootNode.leftNode = lines[i];
                        break;
                    }
                }else{
                    // (새로입력 = 상위계층 선분)
                    //if (이미존재.좌측트리 != null)
                    if(rootNode.rightNode != null){
                        rootNode = rootNode.rightNode;
                        continue;
                    }else{
                        //이미존재.우측트리 = new Node(새로입력)
                        rootNode.rightNode = lines[i];
                        break;
                    }
                } //end if
            } //end while

        } //end for

        return segTree;
    } //end insertSegmentTree

    public Queue<Line> searchTreeAndEnQueue(Line segTree, int lineqty){
        Queue<Line> lineQueue = new LinkedList<>();
//        SegmentTree의 맨 우측이 가장 상위계층의 선분
//        Queue에다가 하나씩 추가시키자
//        (가장 상위노드 정보를 담는 변수는 임시로 갖고있기)
        Line temp = segTree;
        // (checked 플래그가 false인 것 확인할때마다 cnt가 올라가게..)
        int cnt=0;
//        while(true) {
//            segTree.rootNode = temp;
            while (true) {
                if (segTree.checked == false){
                    cnt++;
                    // 맨 우측부터 찾아야 하므로.
                    if (segTree.rightNode != null) {
                        segTree = segTree.rightNode;
                        continue;
                    } else if (segTree.rightNode == null && segTree.leftNode != null) {
                        lineQueue.add(segTree);
                        segTree.checked = true;
                        segTree = segTree.leftNode;
                        continue;
                    } else if (segTree.rightNode == null && segTree.leftNode == null) {
                        lineQueue.add(segTree);
                        segTree.checked = true;
                    }
                }else{
                    break;
                }
                if(cnt==0 || cnt==lineqty) break;
            } //end while
//        } //end while
        return lineQueue;
    } //end searchTreeAndEnQueue
} //end Main
*/