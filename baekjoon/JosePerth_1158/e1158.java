package baekjoon.JosePerth_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class e1158 {
    int n;
    int m;
    int i;
    ElementNode root;
    
    e1158() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        /** ���� : �Էµ� �� ��ŭ LinkedList ��ũ�۾��ϱ� **/
        // LinkedList ù ���� : value 1�� ��������� ����
        root = new ElementNode(1);
        // LinkedList�� ���� ������ ������ ���� ��ü
        ElementNode nodeBuf = new ElementNode();
        // LinkedList�� ���� �����ʹ� ���� ���� ��ü nodeBuf��� ���� ����
        root.next = nodeBuf;
        
        // 1�� n�� ������ ���� �ݺ������� ��ũ�۾�
        for(i=2;i<n;i++){
            nodeBuf.index = i;
            nodeBuf.next = new ElementNode();
            nodeBuf = nodeBuf.next;
        }
        // ������ LinkedList ����
        // n ���� index��
        nodeBuf.index = n;
        // ������ LinkedList�� next�� null�� �ƴ϶� �� ó�� ������ LinkedList�� ����.
        nodeBuf.next =root;
        /** �� : �Էµ� �� ��ŭ LinkedList ��ũ�۾��ϱ� **/

        System.out.print("<");
        deleteNode();
        System.out.print(">");
    }

    public void deleteNode(){
        ElementNode node = root;
        ElementNode nodeBuf = null;
        if(m != 1){
            while(n>1){
                    for(int i=0;i<this.m-1;i++){		// 0���� m������ �ݺ�. LinkedList�� ��� 
                    	// 1�� �����ϴ� i�� m�� ���ϰ� ������ ��
                    	if(i == this.m-2){			// if m=3, m-2=1
                            nodeBuf = node;		// nodeBuf ��ü�� node������ ����
                            node = node.next;		// ���� �����ͷ� �̵�
                            continue;					// ���� �ڵ� skip�ϰ� i ������ for�� ó������..
                        }
                    	// ���� �����ͷ� �̵�
                        node = node.next;
                    }
                    // m���� �ݺ��ؼ� ���� ���ų�������� ���.
                    System.out.print(node.index+", ");
                    // ���ų��(nodeBuf)�� ���� �����ʹ� ������(node)�� �������� ����.
                    nodeBuf.next = node.next;
                    node = node.next;
                    n--;
            }
        }else{
            while(n>1){
                System.out.print(node.index+", ");
                nodeBuf = node;
                node = node.next;
                n--;
            }
        }
        System.out.print(node.index);
    }


    public static void main(String[] args) throws IOException {
        new e1158();
    }

}
class ElementNode{
    int index;
    ElementNode next;
    public ElementNode(){

    }
    public ElementNode(int index){
        this.index = index;
    }
}