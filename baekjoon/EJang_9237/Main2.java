package baekjoon.EJang_9237;
/*
# input_1
4
2 3 4 3
# output_1
7
- ???? ??? ?? 1????

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

// ???????? : Comparator
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
		
		
		// ???? ?? ??????????¡¾???
		// ???? ???? ???? ???? ?? ???? ???? ???? ???? ????.
		for(int i=0; i<recur; i++){
			int element = scan.nextInt();
			trees.add(element);
		}
		Collections.sort(trees, desc);
		
		int growday=0;		// ???? ???? ??
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

	// ??? ?? Node.child?? ????? ??????
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