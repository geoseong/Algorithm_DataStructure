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

        /** 시작 : 입력된 값 만큼 LinkedList 링크작업하기 **/
        // LinkedList 첫 생성 : value 1을 명시적으로 생성
        root = new ElementNode(1);
        // LinkedList의 다음 포인터 내용을 넣을 객체
        ElementNode nodeBuf = new ElementNode();
        // LinkedList의 다음 포인터는 새로 만든 객체 nodeBuf라는 것을 정의
        root.next = nodeBuf;
        
        // 1과 n을 제외한 값을 반복문으로 링크작업
        for(i=2;i<n;i++){
            nodeBuf.index = i;
            nodeBuf.next = new ElementNode();
            nodeBuf = nodeBuf.next;
        }
        // 마지막 LinkedList 정의
        // n 값을 index로
        nodeBuf.index = n;
        // 마지막 LinkedList의 next는 null이 아니라 맨 처음 생성한 LinkedList로 지정.
        nodeBuf.next =root;
        /** 끝 : 입력된 값 만큼 LinkedList 링크작업하기 **/

        System.out.print("<");
        deleteNode();
        System.out.print(">");
    }

    public void deleteNode(){
        ElementNode node = root;
        ElementNode nodeBuf = null;
        if(m != 1){
            while(n>1){
                    for(int i=0;i<this.m-1;i++){		// 0부터 m까지만 반복. LinkedList의 모든 
                    	// 1씩 증가하는 i가 m의 패턴과 같아질 때
                    	if(i == this.m-2){			// if m=3, m-2=1
                            nodeBuf = node;		// nodeBuf 객체에 node정보를 삽입
                            node = node.next;		// 다음 포인터로 이동
                            continue;					// 밑의 코드 skip하고 i 증가된 for문 처음부터..
                        }
                    	// 다음 포인터로 이동
                        node = node.next;
                    }
                    // m까지 반복해서 얻은 제거노드정보를 출력.
                    System.out.print(node.index+", ");
                    // 제거노드(nodeBuf)의 다음 포인터는 현재노드(node)의 다음으로 지정.
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