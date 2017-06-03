package baekjoon.common;

public class EstimateTime {

	public static void main(String[] args) {
		// 시작 시간
        long startTime = System.currentTimeMillis();
 
        // 실행 시간 체크될 녀석들...
        for(int i=0; i<100000000; i++){
            ;
        }
         
        // 종료 시간
        long endTime = System.currentTimeMillis();
 
        // 시간 출력
        System.out.println("##  시작시간 : " + (startTime));
        System.out.println("##  종료시간 : " + (endTime));
        System.out.println("##  소요시간(ms) : " + ( endTime - startTime ) + "(ms)"); 
        System.out.println("##  소요시간(초.0f) : " + ( endTime - startTime )/1000.0f +"초"); 
/*
# Copy
// 시작 시간
long startTime = System.currentTimeMillis();
// 종료 시간
long endTime = System.currentTimeMillis();
System.out.println("##  소요시간(ms) : " + ( endTime - startTime ) + "(ms)"); 
 */
	}

}
