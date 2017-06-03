package baekjoon.EJang_9237;
/*
# input_1
4
2 3 4 3
# output_1
7
- 나무 심는 데 1일소요

# input_2
6
39 38 9 35 39 20
# output_2
42
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	Main() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strinput=null;
		strinput = br.readLine();
		int recur=Integer.parseInt(strinput);
		
		strinput = br.readLine();
		String[] strarr = strinput.split(" ");
		int treegrow=0;		// 나무를 심는 기간 : +1
		int growday=0;		// 나무 자라는 기간
		
		// 내림차순 한 상태로 int[] 삽입
		Node tree = null;
		for(int i=0; i<strarr.length; i++){
//			int min=1000000;
//			int minindex=0;
			int max=0;
			int maxindex=0;
			for(int j=0; j<strarr.length; j++){
				int element = Integer.parseInt(strarr[j]);
				if(max<element){
					max = element;
					maxindex = j;
				}
			} //end for
			tree = new Node(max, tree);
			strarr[maxindex]="0";
		} //end for
		
		int maxday=0;
		for(int i=0; i<recur; i++){
			if(tree != null){
				treegrow++;
				int leadtime=0;
				if(tree.child!=null){
					leadtime = getNode(tree);
				}else{
					leadtime = tree.leadtime;
				}
				growday = treegrow + leadtime;
				if(maxday<growday)	maxday = growday;
			}
		} //end for
		
		System.out.println((maxday+1));
	}
	
	public static void main(String[] args) throws IOException {
		// TODO 9237. 이장님 묘목
		new Main();
	} //end main

	// 이건 왜 Node.child가 제거가 안될까??
	public int getLeadtime(Node tree){
		int leadtime=0;
		if(tree.child != null){
			return getLeadtime(tree.child);
		}else{
			leadtime = tree.leadtime;
			tree = null;
		}
		return leadtime;
	}
	
	public int getNode(Node tree){
		int leadtime=0;
		if(tree.child.child != null){
			return getNode(tree.child);
		}else{
			leadtime = tree.child.leadtime;
			tree.child = null; 
		}
		return leadtime;
	}
	/*
	leadtime = tree.child.leadtime;
	tree.child = null;
	 */
}