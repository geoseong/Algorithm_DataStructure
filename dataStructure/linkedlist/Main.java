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
		System.out.println("�ְ��� �ϴ� LinkedList�� ��ȣ�� �Է��ϼ���.(�����ߺ��ȵ�)");
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		int length = token.countTokens();
		
		// Node ���� ��� Ŭ���� �ν��Ͻ�ȭ : size 0���� ����
		NodeCRUD nodeCRUD = new NodeCRUD();
		
//		// ���� �ð�
//        long startTime = System.currentTimeMillis();
 
        // �����ߺ�üũ���� 1
//        int[] intArr = new int[length];
//        for(int n=0; n<length; n++){
//        	intArr[n] = Integer.parseInt(token.nextToken());
//        }
//        for(int one = 0; one < intArr.length; one++){
//        	int compare = intArr[one];
//        	for(int two = 0; two < intArr.length; two++){
//        		if(one != two && compare == intArr[two]){
//        			System.out.printf("���� �ߺ��Ǿ����ϴ�. (�ߺ��� : %d)\n", compare);
//        			break;
//        		}
//        	}
//        }
        
        // �����ߺ�üũ���� 2
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> setlist = new ArrayList<Integer>();
        for(int n=0; n<length; n++){
        	int element =  Integer.parseInt(token.nextToken());
        	list.add(element);
        }
        for (Integer intval : list) {
            if(setlist.contains(intval)){
            	System.out.printf("���� �ߺ��Ǿ����ϴ�. (�ߺ��� : %d)\n------- ���α׷��� �����մϴ�.", intval);
            	System.exit(0);
            }else{
            	setlist.add(intval);
            }
        }
        
//        // ���� �ð�
//        long endTime = System.currentTimeMillis();
//        // �ð� ���
//        System.out.println("##  �ҿ�ð�(ms) : " + ( endTime - startTime ) + "(ms)"); 
		
        // 1. ��忡 ������ ����
        for(int n=0; n<list.size(); n++){
			int element = list.get(n);
			nodeCRUD.insertNode(element);
		}
		
        // 2. �Է°��� �����ִ� ��� �˻�
        System.out.println("�˻��ϰ��� �ϴ� ����� ���� �Է��Ͻÿ�.");
        token = new StringTokenizer(br.readLine(), " ");
        int wantsearchVal = Integer.parseInt(token.nextToken());
        int searchedVal = (int)nodeCRUD.searchNode(wantsearchVal);
        System.out.println((searchedVal==-1)? "��ã��" : "ã��");
        
        // 3. �����ϰ��� �ϴ� ��� ����
        System.out.println("�����ϰ���(�ش������� �������) �ϴ� ����� ���� �Է��Ͻÿ�.");
        token = new StringTokenizer(br.readLine(), " ");
        int wantremoveVal = Integer.parseInt(token.nextToken());
        int isRemoved = (int)nodeCRUD.deleteNode(wantremoveVal);
        System.out.println((isRemoved==-1)? "������" : "����");
        
        // 4. ��� ������ Ȯ��
        int size=(int)nodeCRUD.getNodeSize();
        System.out.println("���� ��� ������ : " + size);
        
        // 5. ��� ��� ����
        nodeCRUD.deleteAll();
        size=(int)nodeCRUD.getNodeSize();
        System.out.println("��� ��� ���� �� ��� ������ : " + size);
        
		System.out.println("�Ϸ�");
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
			/** �̷��� ��������..
			 * [1]
			 * while������ node ���������� null�϶����� ������, ���������� null�� �Ǳ� ������ 
			 * null�� Ŭ���������� � �޼ҵ带 ������ null�� ���ð��̱� �����̴�.
			do{
				node = node.getChildNode();
			}
			while(node != null);
			* [2]
			* �ݺ��� ���ٺ��� nodeŬ������������ ���� childNode����, ���ο� ���� �߰��� �� �ΰ��� �׻� ����ְ� �ȴ�. 
			while(node.getChildNode() != null){
				node = node.getChildNode();
			}
			*/
			
			// �ѹ��� NodeŬ������ �ν��Ͻ�ȭ ��Ű��, �� �ν��Ͻ� ������ ������ �����ϴ� �ΰ��� ������ ����Ѵ�.
			Node temp = this.node;
			while(temp.getChildNode() != null){
				temp = temp.getChildNode();
			}
			// childNode�� ���Ӱ� �߰��� Node�� �����Ų��.
			temp.setChildNode(new Node(val));
			// ���ο� Node������ �ϳ� ���������Ƿ� size++
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
			deleteAll();	// 5. ��� ��� ���� �޼ҵ�� Jump
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
