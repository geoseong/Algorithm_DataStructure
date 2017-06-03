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
class XorY{
	float x;
	float y;
}

public class Main_old {

	/** start : ���� ���� ���� */
		// �� ������ �湮�ߴ���
		boolean[] isVisit;
		// �����~������ x,y��ǥ ����Ʈ
		XorY[] loclist;
		XorY start;
		XorY end;
		// �ش� �������� �ִ� �Ÿ��� �����ϴ� �迭
		double[] distances;
		// �����~���������� �ɸ��� �ð�
		static double leadtime;
	/** end : ���� ���� ���� */
	
	Main_old() throws IOException{
		/** �ӷ� = �Ÿ� / �ð�, �ð� = �Ÿ� / �ӷ� */
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String strinput=null;
			
			// 1��° �� �Է°� �ҷ����� : �����ġ
			strinput = br.readLine();
			start = new XorY();
			start.x = Float.parseFloat(strinput.split(" ")[0]);
			start.y = Float.parseFloat(strinput.split(" ")[1]);
			
			// 2��° �� �Է°� �ҷ����� : ������ġ
			strinput = br.readLine();
			end = new XorY();
			end.x = Float.parseFloat(strinput.split(" ")[0]);
			end.y = Float.parseFloat(strinput.split(" ")[1]);
			
			// ��� �ð� ��� ����
			leadtime=0;
				
			// 3��° �� �Է°� �ҷ����� : ���� ��
			strinput=br.readLine();
			int qtycannon = Integer.parseInt(strinput);
			
			/** ����,������,������ġ ���� ũ�⸸ŭ isVisit �迭ũ�� ���� */
			isVisit = new boolean[2+qtycannon];
			// ������� ���� ���� �����Ƿ�.
			isVisit[0] = true;
			
			/** ��������� ���� ����ŭ x,y��ǥ �����ϴ� �迭 */
			loclist = new XorY[2+qtycannon];
			// ����� ������ �ε���0�� �ִ´�.
			loclist[0] = start;	
			for(int i=1; i<qtycannon+1; i++){
				// 4��° ~ ���� ����ŭ �ݺ��ϸ� �ҷ�����
				strinput=br.readLine();
				loclist[i] = new XorY();
				loclist[i].x=Float.parseFloat(strinput.split(" ")[0]);
				loclist[i].y=Float.parseFloat(strinput.split(" ")[1]);
			} //end for : ���� x,y ��ǥ���
			// ���������� �ε����� �ֱ�.
			loclist[loclist.length-1] = end;
			
			/** �� ���������� �Ÿ� */
			distances = new double[qtycannon+1];
			
			
			int currentindex = 0;
			while(true){
				// �ּҰŸ��� ���ϱ� ���� ����.
				double max = 10000000;
				// loclist�迭�� �� ������ �ڸ����� ���� ��� true�� �Ǿ�����(qtycannon+2 -1) ī��Ʈ
				int isBreak=1;	// �����[0]�� �̹� true�̹Ƿ�.
				// ��������� ��� ���������� �Ÿ��� �� ���ؼ� �迭�� ���Ҵ�. && isVisit=false�� ���ؼ�
				for(int i=0; i<loclist.length-1; i++){
					if(i==0 || isVisit[i] == false){
						distances[i] = 10000000;
						distances[i] = getDistance(loclist[currentindex].x, loclist[i].x, loclist[currentindex].y, loclist[i].y);
					}else{
						distances[i] = 10000000;
						isBreak++;
					}
					if(isVisit[i] == false && max>distances[i]){
						max = distances[i];
					}
				} //end for : ��� ���� �Ÿ�
				
				// ����� ~ ����x���� �ִܰŸ��� ���Ѵ�.
				for(int i=0; i<distances.length; i++){
					if(isVisit[i] == false && max == distances[i]){
						isVisit[i]=true;	// �湮 ���� �� �߿� �ּҰŸ��� �����ִ� �ڸ��� �湮�Ѵ�.
						currentindex = i;	// ��� �湮�� index ǥ��
						
						// �ӷ� = �Ÿ� / �ð�, �ð� = �Ÿ� / �ӷ�
						// ����ġ���� �ּҰŸ����������� �Ÿ��� 50m���� �ƴ��� ���ϱ�.
						if(distances[i] >= 50){	// �Ÿ��� 50m�� ������ ����Ÿ�� ������ 
							leadtime = leadtime+getTime("cannon", distances[i]);
						}else{	// 50m�� �ȵǸ� �ٴ°� ����
							leadtime = leadtime+getTime("run", distances[i]);
						}
					}
				} //end for : �ִܰŸ�
				
				if(isBreak==5)	break;
			} //end while
			
			
			// ������� isVisit=true�Ѵ�.
			
			// ��������� ��� ���������� �Ÿ��� �� ���ؼ� �迭�� ���Ҵ�. && isVisit=false�� ���ؼ�
			// ����� ~ ����x���� �ִܰŸ��� ���Ѵ�.
			// ����x�� isVisit=true�Ѵ�.
			
			//// ���� ����x���� �ִܰŸ��� ������ ã�´�.
			// ����x���� ��� ���������� �Ÿ��� �� ���ؼ� �迭�� ���Ҵ�. && isVisit=false�� ���ؼ�
			// ����x ~ ����y���� �ִܰŸ��� ���Ѵ�.
			// ����y�� isVisit=true�Ѵ�. ...
			
			//// ���� ����y���� �ִܰŸ��� ������ ã�´�.
			// ����y���� ��� ���������� �Ÿ��� �� ���ؼ� �迭�� ���Ҵ�. && isVisit=false�� ���ؼ�
	} //end Main_1()
	
	public static void main(String[] args) throws IOException {
		// TODO 10473. ����
		long startTime = System.currentTimeMillis();
		new Main_old();
		long endTime = System.currentTimeMillis();
		System.out.println("leadtime : " + leadtime);
		System.out.println("##  �ҿ�ð�(ms) : " + ( endTime - startTime ) + "(ms)"); 
	}
	
	double getDistance(float x_from, float x_to, float y_from, float y_to){
		float dist_x = Math.abs(x_to - x_from);
		float dist_y = Math.abs(y_to - y_from);
		double distance = Math.sqrt(dist_x*dist_x + dist_y*dist_y);		
		return distance;
	}
	
	double getTime(String mode, double distance){
		double leadtime=0L;
		switch (mode) {
		case "run":
			leadtime = Math.min(2+((50-distance)/5), distance/5);		// �޸��� �ð��� ���� Ż���� ��.. (��??)
//			leadtime = distance / 5;			
			break;
		case "cannon":
			leadtime = 2 + ((distance-50)/5);	// ����Ż�� �ð�
			break;
		}
		return leadtime;
	}
	
}
