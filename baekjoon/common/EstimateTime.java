package baekjoon.common;

public class EstimateTime {

	public static void main(String[] args) {
		// ���� �ð�
        long startTime = System.currentTimeMillis();
 
        // ���� �ð� üũ�� �༮��...
        for(int i=0; i<100000000; i++){
            ;
        }
         
        // ���� �ð�
        long endTime = System.currentTimeMillis();
 
        // �ð� ���
        System.out.println("##  ���۽ð� : " + (startTime));
        System.out.println("##  ����ð� : " + (endTime));
        System.out.println("##  �ҿ�ð�(ms) : " + ( endTime - startTime ) + "(ms)"); 
        System.out.println("##  �ҿ�ð�(��.0f) : " + ( endTime - startTime )/1000.0f +"��"); 
/*
# Copy
// ���� �ð�
long startTime = System.currentTimeMillis();
// ���� �ð�
long endTime = System.currentTimeMillis();
System.out.println("##  �ҿ�ð�(ms) : " + ( endTime - startTime ) + "(ms)"); 
 */
	}

}
