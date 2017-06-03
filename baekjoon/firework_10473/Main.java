package baekjoon.firework_10473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
25.0 100.0
190.0 57.5
4
125.0 67.5
75.0 125.0
45.0 72.5
185.0 102.5

# input
25.0 100.0	// ���� �ִ� ��ǥ
190.0 57.5	// ������ ��ǥ
4				// ���� ���� ( 0 �̻� 100 ���� )
125.0 67.5	// ���������� �Էµ� ��ŭ ���� ��ġ ǥ��
75.0 125.0
45.0 72.5
185.0 102.5

# output
�� �ٿ� ���� �������� �ٴٸ��� ���� ���� ���� �ð��� ����϶�
19.984901

- ����� 5m/s�� �ӵ��� �޸���
- ��� ������ ����� ����� ���ϴ� ������ �������� 50m ������ �� �ִ�. = 25m/s
- ������ �ö�Ÿ�� �߻�ǰ� �����ϱ������ ��Ȯ�� 2�ʰ� �ɸ���
 */
class Loc_XY{
	float x;
	float y;
}

public class Main {
	/** start : ���� ���� ���� */
		// �� ������ �湮�ߴ���
		boolean[] isVisit;
		// �����~������ x,y��ǥ ����Ʈ
		Loc_XY[] loclist;
		Loc_XY start;
		Loc_XY end;
		// �ش� �������� �ִ� �Ÿ��� �����ϴ� �迭
		float[][] leadtimes;
		float[] distancebetween;
	/** end : ���� ���� ���� */
	
	Main() throws IOException{
		/** �ӷ� = �Ÿ� / �ð�, �ð� = �Ÿ� / �ӷ� */
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String strinput=null;
			
			// 1��° �� �Է°� �ҷ����� : �����ġ
			strinput = br.readLine();
			start = new Loc_XY();
			start.x = Float.parseFloat(strinput.split(" ")[0]);
			start.y = Float.parseFloat(strinput.split(" ")[1]);
			
			// 2��° �� �Է°� �ҷ����� : ������ġ
			strinput = br.readLine();
			end = new Loc_XY();
			end.x = Float.parseFloat(strinput.split(" ")[0]);
			end.y = Float.parseFloat(strinput.split(" ")[1]);
				
			// 3��° �� �Է°� �ҷ����� : ���� ��
			strinput=br.readLine();
			int qtycannon = Integer.parseInt(strinput);
			
		/** ����,������,������ġ ���� ũ�⸸ŭ isVisit �迭ũ�� ���� */
			isVisit = new boolean[2+qtycannon];
			// ������� ���� ���� �����Ƿ�.
			isVisit[0] = true;
			
		/** ��������� ���� ����ŭ x,y��ǥ �����ϴ� �迭 */
			loclist = new Loc_XY[2+qtycannon];
			// ����� ������ �ε���0�� �ִ´�.
			loclist[0] = start;	
			for(int i=1; i<qtycannon+1; i++){
				// 4��° ~ ���� ����ŭ �ݺ��ϸ� �ҷ�����
				strinput=br.readLine();
				loclist[i] = new Loc_XY();
				loclist[i].x=Float.parseFloat(strinput.split(" ")[0]);
				loclist[i].y=Float.parseFloat(strinput.split(" ")[1]);
			} //end for : ���� x,y ��ǥ���
			// ���������� �ε����� �ֱ�.
			loclist[loclist.length-1] = end;
		
		/** �� ���������� �Ÿ�(x, �Ÿ��� ���� �ð�) 2�����迭 ���� */
			leadtimes = new float[2+qtycannon][2+qtycannon];
			float dist_temp=0;
			for(int i=0; i<loclist.length; i++){
				for(int j=0; j<loclist.length; j++){
					if(i != j){
						dist_temp = getDistance(loclist[i].x, loclist[j].x, loclist[i].y, loclist[j].y);
						// ����ġ���� �ּҰŸ����������� �Ÿ��� 50m���� �ƴ��� ���ϰ� �ð� ���ϱ�.
						if(i==0 || j==0){
							leadtimes[i][j] = dist_temp/5;
						}else{
							leadtimes[i][j] = getTime(dist_temp);
						}
					}
				}
			}
		
		// �̳��� ���� Ȱ���ؾ� ���� �� �־���..
		/** ��������� ������ ���� ���������� �ּҰŸ�  ���������� ����� : distancebetween */
			distancebetween = new float[2+qtycannon];
			for(int i=0; i<distancebetween.length; i++){
				distancebetween[i]=leadtimes[0][i];
			}
			
		/** �������� leadtime ���ϱ� */
			int curindex=0;
			for(int x=0; x<loclist.length-1; x++){
				float min;
				int i=0;
				while(isVisit[i] == true){
                    i++;
                } //end while
				min = distancebetween[i];
				for(int j=1; j<loclist.length; j++){
					if(isVisit[j]==false && min>=distancebetween[j]){
						min = distancebetween[j];
						curindex = j;		// ���� Step���� �ּҰŸ��� �������������� ���ؾ��ϹǷ�..
					}
				} //end for
				if(isVisit[curindex]==false){
					isVisit[curindex] = true;		// �ּҰŸ��� ���������� �����ߴٰ� �����ϹǷ�.. 
					for(int j=1;j<distancebetween.length;j++){
		               if(isVisit[j] == true){
		                   continue;
		               }else{
		            	   distancebetween[j] = Math.min(distancebetween[j], distancebetween[curindex]+leadtimes[curindex][j]);
		               }
					} //end for
				} //end if
			} //end for

			System.out.println(distancebetween[loclist.length-1]);
	} //end Main_1()
	
	public static void main(String[] args) throws IOException {
		// TODO 10473. ����
//		long startTime = System.currentTimeMillis();
		new Main();
//		long endTime = System.currentTimeMillis();
//		System.out.println("##  �ҿ�ð�(ms) : " + ( endTime - startTime ) + "(ms)"); 
	}
	
	float getDistance(float x_from, float x_to, float y_from, float y_to){
		float dist_x = Math.abs(x_to - x_from);
		float dist_y = Math.abs(y_to - y_from);
		float distance = (float) Math.sqrt(dist_x*dist_x + dist_y*dist_y);		
		return distance;
	}
	
	float getTime(float distance){
		float leadtime=0L;
			if(distance >= 50){	// �Ÿ��� 50m�� ������ ����Ÿ�� ������ 
				leadtime = 2 + ((distance-50)/5);		// ����Ż�� �ð�
			}else{	// 50m�� �ȵǸ� �ٴ°� ����
				leadtime = Math.min(2+((50-distance)/5), distance/5);
			}
		return leadtime;
	}
	
}
