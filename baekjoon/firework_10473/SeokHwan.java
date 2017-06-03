package baekjoon.firework_10473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SeokHwan {
    //시작점과 끝점
    Pos startPos;
    Pos endPos;

    float[] diak;
    boolean[] diakToken;

    public SeokHwan() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        startPos = new Pos();
        endPos = new Pos();

        startPos.x = Float.parseFloat(st.nextToken());
        startPos.y = Float.parseFloat(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        endPos.x = Float.parseFloat(st.nextToken());
        endPos.y = Float.parseFloat(st.nextToken());

        int countCircle = Integer.parseInt(br.readLine());
        Pos[] circleAry = new Pos[countCircle+2];


        float[][] timePos = new float[countCircle+2][countCircle+2];
        diak = new float[countCircle+2];
        diakToken = new boolean[countCircle+2];
        float distanceBuf;


        circleAry[0] = startPos;

        //원 정보 배열에 넣기
        for(int i=1;i<countCircle+1;i++){
            circleAry[i] = new Pos();

            st = new StringTokenizer(br.readLine(), " ");
            circleAry[i].x = Float.parseFloat(st.nextToken());
            circleAry[i].y = Float.parseFloat(st.nextToken());
            timePos[i][i] = 0;
        }
        circleAry[countCircle+1] = endPos;

       //각지점에 도착하는 최소 시간
       for(int i=0;i<circleAry.length;i++){
           for(int j=0;j<circleAry.length;j++){
               if(i != j){
                   distanceBuf = calcPos(circleAry[i],circleAry[j]);

                   if( i==0 || i== circleAry.length-1){
                       timePos[i][j] = (distanceBuf)/5;
                   }else{
                           //클때는 대포탐
                       if(distanceBuf >= 50){
                           timePos[i][j] = 2+((distanceBuf - 50)/5);

                           //작을때는 뛰어가는 것과 대포타는것 값 비교
                       }else{
                           timePos[i][j] = Math.min(2+((50-distanceBuf)/5), distanceBuf/5);

                       }
                   }
               }
           }
       }

       //초기화
       for(int i=0;i<diak.length;i++){
           diak[i] = timePos[0][i];
       }
       diakToken[0] = true;

       int k;
       //다익스트라 알고리즘
       for(int i=1;i<diak.length;i++){
           k = findMinIndex();
           diakToken[k] = true;
           for(int j=1;j<diak.length;j++){
               if(diakToken[j] == true){
                   continue;
               }else{
                   diak[j] = Math.min(diak[j], diak[k]+timePos[k][j]);

               }
           }

       }
       System.out.println(diak[countCircle+1]);


    }
    //find min ary
    int findMinIndex(){
        int index = 0;
        float min;
        int j = 0;
        while(diakToken[j] == true){j++;}
        min = diak[j];
        for(int i=0;i<diak.length;i++){
            if(min >= diak[i] && diakToken[i] == false){
                min = diak[i];
                index = i;
            }
        }
        return index;
    }


    //Calculate distance
    float calcPos(Pos a,Pos b){
        return (float) Math.sqrt(((a.x-b.x)*(a.x-b.x))+((a.y-b.y)*(a.y-b.y)));
    }


    public static void main(String[] args) throws IOException {

        new SeokHwan();
    }

}
class Pos{
    float x;
    float y;
}
