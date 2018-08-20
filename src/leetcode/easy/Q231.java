package leetcode.easy;

public class Q231 {

	private boolean inputCheck(int n){
		return (n>0);
	}
	//use bitCount
	public boolean method1(int n){
		if(!inputCheck(n))return false;
		return (Integer.bitCount(n)==1);
	}
	
	//use n&(n-1)
	public boolean method2(int n){
		if(!inputCheck(n))return false;
		
		return ((n&(n-1))==0);
	}
	
	
	//brute force
	public boolean method3(int n){
		if(!inputCheck(n))return false;
		
		if(n==1)return true;
		
		while(n!=1){
			//System.out.println("n is "+ n);
			if(n%2!=0)return false;
			n=n/2;
		}
		return true;
	}
	
	
	public static void main(String[] args) {

		Q231 instance = new Q231();
		
		System.out.println("M1+0  "+instance.method1(0));
		System.out.println("M1+9  "+instance.method1(9));
		System.out.println("M1+16 "+instance.method1(16));
		
		System.out.println("M2+0  "+instance.method2(0));
		System.out.println("M2+9  "+instance.method2(9));
		System.out.println("M2+16 "+instance.method2(16));
		
		System.out.println("M3+16 "+instance.method3(16));
	}

}
