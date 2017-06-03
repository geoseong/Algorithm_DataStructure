package baekjoon.Tree_1068;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class e1068 {
	
    int tree[];
    Vector<Integer> childTree[];
    int treeSize;
    int aryIndex;
    int root;
    boolean checkMeet[];

    e1068() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /** Line 1. Ʈ�� ���� */
        treeSize = Integer.parseInt(br.readLine());
        // �Ʒ� �� ���� �迭 : Ʈ�� ���̸�ŭ �迭���̸� ������
        // tree(���� �� �θ�������)
        // , childTree(�θ�� �ڽ�Ʈ������)
        // , checkMeet(�θ���迭�� ���� �����Ϸ��� ����� ���� ������(true/false) üũ.)
        tree = new int[treeSize];
        childTree = new Vector[treeSize];
        checkMeet = new boolean[treeSize];

        // childTree : �� �迭��Ҹ��� ���Ͱ�ü �Ҵ� 
        for(int i=0;i<treeSize;i++){
            childTree[i] = new Vector<Integer>(10);
        }

        // intBuf : tree[]�� ���� �� �� tree[] ���� ���� ����
        int intBuf;
        // aryIndex : tree[] �ε��� ���
        aryIndex = 0;
        /** Line 2. ����ȣ�� ���� ��忬������ �ֱ� */
        StringTokenizer st = new StringTokenizer(br.readLine(),	" ");

        // tree[]�迭�� 2��° ���ο� �Էµ� ���ϴ� �θ��尪�� ���� ���� �ֱ�.
        while(st.hasMoreTokens()){
            intBuf = Integer.parseInt(st.nextToken());
            tree[aryIndex] = intBuf;
            aryIndex++;
        }

        // treeSize : Ʈ�����̸�ŭ �ݺ�
        for(int i=0;i<treeSize;i++){
        	// ���ϴ� �θ��尪�� ���� �迭�� �ε����� �ϳ��� �����鼭..
            intBuf = tree[i];
            // 1. �θ��� Ʈ���� Root�� �˾Ƴ���
            if(intBuf == -1){
                root = i;
                continue;
            }
            // 2. �θ��尡 �����ִ� �ڽĳ�带 �ִ´�.
            childTree[tree[i]].add(i);
           }

        /** Line 3. �����ϰ��� �ϴ� ����� �� */
        int deleteAryNum = Integer.parseInt(br.readLine());

        // DFS�޼ҵ忡��..
        // 1. ��尪 ����
        // 2. ������� �˾Ƴ���.
        
        // DFS�޼ҵ� - 1. ���� : �����ϰ����ϴ� ����ȣ
        DFS(deleteAryNum);
    	
        // DFS�޼ҵ� - 2. ���� :  �ֻ��� ����� root�� ��
        System.out.println(DFS(root));

    }

    public int DFS(int deleteAryNum){
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;	// ������� ��Ƹ��� ����

        // �ش� �ε����� ��尡 ����������� �ɹ�������, Ȥ�� �������ɹ��� �ʿ䰡 ���ٸ�(������ŵ� �ε���) true, �ƴϸ� false 
        if(checkMeet[deleteAryNum]){
            return 0;
        }

        // �θ���迭 �� �����Ϸ��� Ȥ�� Root ����ȣ �ε����� boolean�� true�� ��ȯ
        // ���� �����󿡼� �ٷ� ����ȣ�� �ѹ� ���İ��� true�� ��ȯ��.
        checkMeet[deleteAryNum] = true;
        // ť�� �ɹ��Ϸ��� ����ȣ�� �ְ�, while������ �� ����ȣ�� ����������� �����Ѵ�.
        queue.add(deleteAryNum);

        boolean flag;	// ������带 ���� ���� boolean

        while(!queue.isEmpty()){	// �ɹ��ϰ��� �ϴ� ��尡 ������ while�� ����
            deleteAryNum = queue.poll();
            flag = false;
            for (int aryNum : childTree[deleteAryNum]) {	// childTree(�θ�� �ڽ�Ʈ������)
                if(!checkMeet[aryNum]){
                    flag = true;
                    queue.add(aryNum);		// �ش� ��� �ȿ� �ڽĳ�尡 �ִ��� �����ϱ� ���� ť�� �߰�
                    checkMeet[aryNum] = true;	// �̹� �ݺ��п��� �ٷ� ����ȣ�� true�� ��ȯ.
                }

            }
            if(!flag){

                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        new e1068();
    }

}