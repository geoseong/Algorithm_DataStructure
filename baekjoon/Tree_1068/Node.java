package baekjoon.Tree_1068;

public class Node {
	int val;
	Node left;
	Node right;
	
	public Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

/*
# �Է�
5
-1 0 0 1 1
2

2.
3
-1 0 0
0

# ���
2

2.
0
# �����
n : 4
//j : 0
elementVal : 1
elementVal > -1
nodeArr[j].child = nodeArr[n];
-> nodeArr[1].child = nodeArr[4];
*/