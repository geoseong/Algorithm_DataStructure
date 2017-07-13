package baekjoon.phoneNo_5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 각 테스트 케이스에 대해서, 일관성 있는 목록인 경우에는 YES, 아닌 경우에는 NO를 출력한다. */

class TreeNode{
    private Integer data;
    private TreeNode parent;
    private List<TreeNode> children;	// LinkedList<TreeNode>
    private boolean isLast;
    
    TreeNode(Integer data) {
        this.data = data;
        this.children = new LinkedList<TreeNode>();
    }
    public TreeNode addChild(Integer child) {
        TreeNode childNode = new TreeNode(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }
    
    public TreeNode getParent(){
    	return this.parent;
    }
    
    public List<TreeNode> getChildren(){
    	return this.children;
    }
    public int getValue(){
    	return this.data;
    }
    
    public boolean areYouLastNode(){
    	return this.isLast;
    }
    public void youAreLastNode(){
    	this.isLast = true;
    }
}


public class PhoneNo_5052 {

	public static void main(String[] args) throws IOException {
		new PhoneNo_5052();
	}

	PhoneNo_5052() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int qtyTestcase = Integer.parseInt(br.readLine());
		boolean stop = false;
		
		while(qtyTestcase-- > 0){
			TreeNode trie = null;
			TreeNode temp = null;
			int testCase = Integer.parseInt(br.readLine());
			String result = null;
			
			// get max length
			for(int i=0; i<testCase; i++){
				String phoneNo = br.readLine();
				
				temp = trie;
				
				for(int j=0; j<phoneNo.length(); j++){
					Character ch = phoneNo.charAt(j);
					int ele = Integer.parseInt(ch.toString());
					
					// 전화번호 입력 처음일때 
					if(i==0 && trie == null){
						trie = new TreeNode(ele);
						temp = trie;
						if(j == phoneNo.length()-1){
							temp.youAreLastNode();	// 마지막노드라고 표시
						}
						continue;
					}else if(i==0){
						temp = temp.addChild(ele);		// 밑으로 가지뻗기
						if(j == phoneNo.length()-1){
							temp.youAreLastNode();	// 마지막노드라고 표시
						}
						continue;
					}
					
					// 자식들은 여러명일 수 있는데 어느 방향으로 노드 포인터를 이동해야 할지 결정.
					List<TreeNode> children = temp.getChildren();
					// 기존 자식의 마지막노드면 isLast=true지만,
					// 새로 입력될 폰번호가 이 마지막노드의 라인을 타고가다가 isLast인 노드의 값과 같다면 NO.
					if(children.size() == 0){
						if(temp.getValue() == ele && temp.areYouLastNode()){
							// 전화번호 트리의 마지막노드에 도달했는데 새로입력된 노드value가 그 마지막노드와 같다면..
							result = "NO";
							stop=true;
							break;
						}
						if(j == phoneNo.length()-1){
							temp = temp.addChild(ele);
							temp.youAreLastNode();	// 마지막노드라고 표시
							continue;
						}else{	// 현재 노드value와 새로 입력된 value가 같지 않다면 가지 새로 만듦.
							temp = temp.addChild(ele);
							continue;
						}
					}
					// 입력된 번호 1자리(ele)와 자식노드값(val)을 비교.
					for(int k=0; k<children.size(); k++){
						if(temp.getValue() == ele && temp.areYouLastNode()){
							// 전화번호 트리의 마지막노드에 도달했는데 새로입력된 노드value가 그 마지막노드와 같다면..
							result = "NO";
							stop=true;
							break;
						}else if(temp.getValue() == ele && j < phoneNo.length()-1){	// 현재 트리단계의 value가 새로 입력된 value와 같다면
							// 자식들은 여러명일 수 있는데 어느 방향으로 노드 포인터를 이동해야 할까..
							// 그냥 입력된 폰번호의 다음자리로 포인터를 이동시키는 것이..
							int val = children.get(k).getValue();	// 자식 값 구하기
							Character nextch = phoneNo.charAt(j+1);	// 입력된 폰번호의 다음자리로 포인터를 (잠시)이동
							int nextele = Integer.parseInt(nextch.toString());	// 어느 자식노드로 빠질 지 결정하기 위한 로직. 폰번호의 다음 인덱스.
							if(val == nextele){	// 자식단계의 value가 새로 입력된 value와 같다면
								temp = children.get(k);		// 포인터를 이 자식에 해당하는 단계로 이동
								break;
							}else{
								temp = temp.addChild(ele);
							}
							continue;
						}else if(temp.getValue() == ele && j == phoneNo.length()-1){
							result = "NO";
							stop=true;
							break;
						}else if(j == phoneNo.length()-1){
							temp = temp.addChild(ele);
							temp.youAreLastNode();	// 마지막노드라고 표시
							break;
						}else{	// 현재 노드value와 새로 입력된 value가 같지 않다면 가지 새로 만듦.
							temp = temp.addChild(ele);
							break;
						}
					} // end for (children)
					
				} //end for (phoneNo)
				if(stop)	break;	// for문에서 break걸었을때 종료시키는 명령 
			} //end for (testCase)
			
			if(stop){
				System.out.println(result);
				result = null;
				stop = false;
			}else{
				System.out.println("YES");
				result = null;
			}
			
		} //end while
	}	// end Main
	
} // end class
