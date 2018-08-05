package CTCI.BItOperation;

public class Q5_6 {
	public static int solution(int A, int B) {

		int num = (A ^ B);

		int res = Integer.bitCount(num);

		return res;
	}
	
	public static int solution(String A, String B) {

		int num = (Integer.parseInt(A, 2) ^ Integer.parseInt(B, 2));

		int res = Integer.bitCount(num);

		return res;
	}
	

	public static void main(String[] args) {
		int res = solution(999,888);

		System.out.println(res);
		System.out.println(solution("11101","01111"));
	}
}
