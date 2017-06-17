package baekjoon.primeMulti_2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by TSPark on 2017-06-17.
 */
public class e2014 {
    public e2014() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        HashMap<Integer,PriorityQueue<Long>> map = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        Integer num;
        for(int i=0;i<k;i++){
            num = Integer.parseInt(st.nextToken());
            map.put(num, new PriorityQueue<Long>());
            map.get(num).add(num.longValue());
        }
        Iterator<Integer> iterator;
        long minNum = 0;
        int numBuf,keyBuf = 0;
        while(n>0){

            iterator = map.keySet().iterator();
            numBuf = iterator.next();
            minNum = map.get(numBuf).peek();
            keyBuf = numBuf;

            // 최소값 검색
            while(iterator.hasNext()){
                numBuf = iterator.next();
                if(minNum > map.get(numBuf).peek()){
                    minNum = map.get(numBuf).peek();
                    keyBuf = numBuf;
                }
            }

            iterator = map.keySet().iterator();

            // 숫자 전부 곱하기
            while(iterator.hasNext()){
                numBuf = iterator.next();
                if(numBuf >= keyBuf){
                    map.get(numBuf).add(numBuf * minNum);
                }
            }
            map.get(keyBuf).poll();
            n--;
        }

        System.out.println(minNum);
    }

    public static void main(String[] args) throws IOException {
        new e2014();
    }
}
