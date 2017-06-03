package baekjoon.numTri_1932;

public class LineData {
	int[] datas;
	
	public LineData(int length) {
		this.datas = new int[length];
	}
}
/*
# ???? ???
5
7
3 8
8 1 0 
2 7 4 4
4 5 2 6 5

# ???? ???
30
*/

/*
 ??? -> ?? -> ??
 
[0] -> [0] -> [0] -> [0] ->[0]
[1] -> [0] or [1] -> [0] or [1] -> [0] or [1]
[2] -> [1] or [2] -> ([0] or [1]) or ([1] or [2])
*/