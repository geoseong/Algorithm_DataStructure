package baekjoon.numTri_1932;

public class Tree {
	int value;
	Tree leftChild;
	Tree rightChild;
	
	public Tree() {
		
	}

	public Tree(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	
}
/*
# 예제 입력
5
7
3 8
8 1 0 
2 7 4 4
4 5 2 6 5

# 예제 출력
30
*/