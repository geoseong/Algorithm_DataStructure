package baekjoon.JosePerth_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// ��� ��� �����
	StringBuilder sb = new StringBuilder();
	// index : ��Ź�� �ѷ����� ��� ��ȣ�� �ű�
	int index=0;
	
	public static void main(String[] args) throws IOException {
		new Main();
	} //end main()
	
	Main() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		// line 1.
		token = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		// Linked List : ȯ�� LinkedList��. ��Ź�� �ɾ������Ƿ�..
		Node node = null;
		Node temp = null;
		
		for(int i=1; i<n+1; i++){
			if(node==null){
				node = new Node(i);
				temp = node;
			}else{
				temp.setNext(new Node(i));
				temp = temp.getNext();
			}
		} //end for
		temp.setNext(node);
		
		sb.append("<");
		setIndex_removeNode(node, n, m);
		sb.replace(sb.length()-2, sb.length(), ">");
		System.out.println(sb.toString());
	} //end Main_1()

	public void setIndex_removeNode(Node node, int n, int m){
		// ȯ�� LinkedList�̹Ƿ� ������ ��� ���� �����͸� ���� �Ҵ� �� ���´�.
        // �ֳ��ϸ� ������ ���� �ǳʶٰ� �����ϱ� ���ؼ� ���� �����͸� ���� ������ ��尡 �ʿ��ϱ� ����(����Ż��;)
        Node printprevNode = null;
		
		// �ݺ��п��� m��°�� ���� �ٷ� ���ܰ迡�� ���� node�����ʹ�
        // printprevNode ��������Ϳ� ���� �������� node�� ���� �����ͷ� �Ѿ��. 

		while(n-- > 0){
            if(m==1){
                sb.append(node.getValue()+", ");
                node = node.getNext();
            }else{
		    	for(int loop=1; loop<m; loop++){
		    		if(loop == m-1){
		    		    printprevNode = node;	// �̶����� node�� printprevNode�� HashCode�� �����Ǵ°���.
                        node = node.getNext();
    				}else{
    					node = node.getNext();		
    				}
    			} //end for
    			sb.append(node.getValue()+", ");
    			printprevNode.setNext(node.getNext());			// printNode�� ���������ʹ� �Ѵܰ� �ռ��ִ� node�� ���������Ϳ� �����Ŵ.
    			node = node.getNext();							// node�� ���� �����ͷ� �̵� : 
    		} //end if
        } //end while
	} //end setIndex_removeNode()
	
} //end class Main_1

class Node{
	private int value;
	private Node next;
	
	public Node(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
} //end class Node