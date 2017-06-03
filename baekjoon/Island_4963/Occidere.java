package baekjoon.Island_4963;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Occidere{
    public static int ISLAND[][], W, H;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int i, j; String line[]; StringBuilder res = new StringBuilder();
        while(true){
            int num = 0;
            line = in.readLine().split(" ");
            W = Integer.parseInt(line[0]); H = Integer.parseInt(line[1]);
            ISLAND = new int[H][W];
            if(W==0 && H==0) break;
            for(i=0;i<H;i++){
                line = in.readLine().split(" ");
                for(j=0;j<W;j++) ISLAND[i][j] = Integer.parseInt(line[j]);
            }
            for(i=0;i<H;i++)
                for(j=0;j<W;j++)
                    if(ISLAND[i][j]>0) {
                        num++;
                        search(i, j);
                    }
            res.append(num+"\n");
        }
        out.write(res.toString());
        out.close();
        in.close();
    }
    private static void search(int x, int y){
        ISLAND[x][y] = 0;
        int i, ax[] = {0,1,1,1,0,-1,-1,-1}, ay[] = {1,1,0,-1,-1,-1,0,1}, dx, dy;
        for(i=0;i<8;i++){
            dx = x+ax[i]; dy = y+ay[i];
            if(isInRange(dx, dy) && ISLAND[dx][dy]>0) search(dx, dy);
        }
    }
    private static boolean isInRange(int x, int y){
        return (0<=x&&x<H)&&(0<=y&&y<W);
    }
}