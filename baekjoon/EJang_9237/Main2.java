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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 내림차순 : Comparator
class Desc implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
}

public class Main2 {

	Main2(){
		Scanner scan = new Scanner(System.in);
		int recur = scan.nextInt();
		List<Integer> trees = new ArrayList<Integer>();
		Desc desc = new Desc();
		
		
		// 입력된 값 내림차순하는구간
		// 나무 자라는 기간이 제일 긴 것을 가장 빨리 심어야 하므로.
		for(int i=0; i<recur; i++){
			int element = scan.nextInt();
			trees.add(element);
		}
		Collections.sort(trees, desc);
		
		int growday=0;		// 나무 자라는 기간
		int maxday=0;
		for(int i=0; i<recur; i++){
			growday = (i+1) + trees.get(i);
			if(maxday<growday)	maxday = growday;
		} //end for
		
		System.out.println((maxday+1));
	}
	
	public static void main(String[] args) {
		new Main2();
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
	
	public int setSort(Node tree){
		int leadtime=0;
		if(tree.child.child != null){
			return getNode(tree.child);
		}else{
			leadtime = tree.child.leadtime;
			tree.child = null; 
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
}