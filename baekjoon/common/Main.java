package baekjoon.common;

public class Main {
	int count;
	void func2(){
		System.out.printf("In func2=%d\n", count);
	}
	void func1(){
		int count=20;
		func2();
	}
	Main(){
		func1();
	}
	public static void main(String[] args) {
/*
|\_/|
|q p|   /}
( 0 )"""\
|"^"`    |
||_/=\\__|
 
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		*/
		new Main();
	}
}
