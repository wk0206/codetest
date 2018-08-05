package CTCI.BItOperation;

public class Q5_3 {
	public static int solution(int num) {
		int max = 0;
		String s = Integer.toBinaryString(num);
		System.out.println(s);
		int bitLength  = s.length();
		for(int i = bitLength-1; i >=0 ; i --) {
			if(s.charAt(i)=='0') {
				
				String temp = Integer.toBinaryString((num | (1<<(bitLength-i-1))));
				System.out.println(temp);
				max = checkLen(temp);
			}
		}
		
		return max;
	}
	
	
	public static int checkLen(String s) {
		int len = s.length();
		int count = 0;
		int res = 0;
		for(int i = 0; i < len ; i ++) {
			if(s.charAt(i)!='0') {
				count++;
				res = res>count?res:count;
			}
			else {
				count = 0;
			}
		}
		
		return res;
	}
	public static void main(String[] args ) {
		
		int res = solution(9999);
		System.out.println(res);
	}

}
