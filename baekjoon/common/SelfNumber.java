package baekjoon.common;
public class SelfNumber{
    public static void main(String[]t){
    	int c=9994,a[]=new int[c],i=1;
    	for(;i<c;i++){
    		int b=i+i/1000+i%1000/100+i%100/10+i%10;
    		if(b<c)a[b]=1;
		}
    	for(i=1;i<c;i++)
    		if(a[i]!=1)	System.out.println(i);
    	}
}
/*public class SelfNumber {

	public static int calcLen(int param){
        //System.out.println("param = "+param);
        if (param>=10){
           return calcLen(param/10) + (param%10);
        }else{
           return param;
        }
    }
	// Get Self Number
    // Self Number is the number that doesn't have constructor
    // 33 is constructor of 39, 39 is constructor of 51, 51 is constructor of 57
    // n is constructor of d(n)
    // when input param is 97, doesn't have constructor.(=return nothing)
    // Self Number until 100 : 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
    public static int getSelfNum(int param){
        int cnt = 0;
        
        for(int p=1; p <= param; p ++){
            int calcLen = calcLen(p);
            if(p + calcLen == param){
                //System.out.println("[baam] {");
                //System.out.println("   p + calcLen = param\n"+"   p : " + p + ", calcLen(p) : " + calcLen + ", param : " + param+"\n}");
                cnt++;
            }
        }
        return cnt;
    }
	public static void main(String[] args) {
		int count=0;
        for(int i=1; i<=10000; i++){
            count = getSelfNum(i);
            if(count==0){
                System.out.println(i + " is Self Number!");
            }else{
                //System.out.println(i + " is Not SelfNumber...");
            }
        }
	}

}
*/