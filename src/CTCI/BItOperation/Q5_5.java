package CTCI.BItOperation;

public class Q5_5 {

	public static void solution(int num) {
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(num-1));
		System.out.println(Integer.toBinaryString(num & (num-1)));
		System.out.println((num & (num-1))==0);
	}
	
	
	public static void main(String[] args ) {
		
		//check power of 2
		solution(593100);
		solution(128);
	}
}
