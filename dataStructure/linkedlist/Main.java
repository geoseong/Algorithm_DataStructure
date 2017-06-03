package dataStructure.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("넣고자 하는 LinkedList의 번호를 입력하세요.(숫자중복안됨)");
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int length = token.countTokens();
		
		// Node 정보 얻는 클래스 인스턴스화 : size 0부터 시작
		NodeCRUD nodeCRUD = new NodeCRUD();
		
//		// 시작 시간
//        long startTime = System.currentTimeMillis();
 
        // 숫자중복체크로직 1
//        int[] intArr = new int[length];
//        for(int n=0; n<length; n++){
//        	intArr[n] = Integer.parseInt(token.nextToken());
//        }
//        for(int one = 0; one < intArr.length; one++){
//        	int compare = intArr[one];
//        	for(int two = 0; two < intArr.length; two++){
//        		if(one != two && compare == intArr[two]){
//        			System.out.printf("값이 중복되었습니다. (중복값 : %d)\n", compare);
//        			break;
//        		}
//        	}
//        }
        
        // 숫자중복체크로직 2
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> setlist = new ArrayList<Integer>();
        for(int n=0; n<length; n++){
        	int element =  Integer.parseInt(token.nextToken());
        	list.add(element);
        }
        for (Integer intval : list) {
            if(setlist.contains(intval)){
            	System.out.printf("값이 중복되었습니다. (중복값 : %d)\n------- 프로그램을 종료합니다.", intval);
            	System.exit(0);
            }else{
            	setlist.add(intval);
            }
        }
        
//        // 종료 시간
//        long endTime = System.currentTimeMillis();
//        // 시간 출력
//        System.out.println("##  소요시간(ms) : " + ( endTime - startTime ) + "(ms)"); 
		
        // 1. 노드에 데이터 삽입
        for(int n=0; n<list.size(); n++){
			int element = list.get(n);
			nodeCRUD.insertNode(element);
		}
		
        // 2. 입력값을 갖고있는 노드 검색
        System.out.println("검색하고자 하는 노드의 값을 입력하시오.");
        token = new StringTokenizer(br.readLine(), " ");
        int wantsearchVal = Integer.parseInt(token.nextToken());
        int searchedVal = (int)nodeCRUD.searchNode(wantsearchVal);
        System.out.println((searchedVal==-1)? "못찾음" : "찾음");
        
        // 3. 제거하고자 하는 노드 제거
        System.out.println("제거하고자(해당노드이후 연결끊김) 하는 노드의 값을 입력하시오.");
        token = new StringTokenizer(br.readLine(), " ");
        int wantremoveVal = Integer.parseInt(token.nextToken());
        int isRemoved = (int)nodeCRUD.deleteNode(wantremoveVal);
        System.out.println((isRemoved==-1)? "못지움" : "지움");
        
        // 4. 노드 사이즈 확인
        int size=(int)nodeCRUD.getNodeSize();
        System.out.println("현재 노드 사이즈 : " + size);
        
        // 5. 모든 노드 제거
        nodeCRUD.deleteAll();
        size=(int)nodeCRUD.getNodeSize();
        System.out.println("모든 노드 제거 후 노드 사이즈 : " + size);
        
		System.out.println("완료");
	}

}
class NodeCRUD{
	private int size;
	private Node node;
	
	// 0. Constructor
	public NodeCRUD() {
		this.size = 0;
	}

	// 1. insert
	void insertNode(Object val){
		if(size==0){
			this.node = new Node(val);
			size++;
		}else{
			/** 이렇게 하지말것..
			 * [1]
			 * while문에서 node 전역변수가 null일때까지 돌리고, 전역변수가 null이 되기 때문에 
			 * null인 클래스변수의 어떤 메소드를 돌려도 null이 나올것이기 때문이다.
			do{
				node = node.getChildNode();
			}
			while(node != null);
			* [2]
			* 반복을 돌다보면 node클래스변수에는 현재 childNode값과, 새로운 값을 추가한 값 두개만 항상 들어있게 된다. 
			while(node.getChildNode() != null){
				node = node.getChildNode();
			}
			*/
			
			// 한번만 Node클래스를 인스턴스화 시키고, 그 인스턴스 변수의 공간을 공유하는 두개의 변수를 사용한다.
			Node temp = this.node;
			while(temp.getChildNode() != null){
				temp = temp.getChildNode();
			}
			// childNode에 새롭게 추가될 Node를 연결시킨다.
			temp.setChildNode(new Node(val));
			// 새로운 Node갯수가 하나 증가했으므로 size++
			size++;
		}
	}
	
	// 2. search
	Object searchNode(Object val){
		Object returnobj = null;
		Node temp = this.node;

		while(temp.getChildNode() != null){
			if(temp.getVal() == val){
				returnobj = val;
				break;
			}
			temp = temp.getChildNode();
		}
		return (returnobj==null) ? -1 : returnobj;
	}
	
	// 3. delete
	Object deleteNode(Object val){
		Object returnobj = null;
		Node temp = this.node;
		
		if(node.getVal() == val){
			deleteAll();	// 5. 모든 노드 제거 메소드로 Jump
			return 0;
		}
		while(temp.getChildNode() != null){
			if(temp.getChildNode().getVal() == val){
				temp.setChildNode(null);
				this.size--;
				return 0;
			}
			temp = temp.getChildNode();
		}
		return (returnobj==null) ? -1 : returnobj;
	}
	
	// 4. count
	Object getNodeSize(){
		return this.size;
	}
	
	// 5. deleteAll
	void deleteAll(){
		this.node = null;
		this.size = 0;
	}
	
} //end class NodeCRUD
