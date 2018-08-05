package codility;

import java.util.Arrays;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Q01 {

	public static int solution(int[] A) {
		// input check
		if (A.length == 0)
			return 1;
		if (A.length == 1) {
			return (A[0] !=1) ? 1:2;
		}

		int max, min;
		int[] resA = new int[A.length];

		Arrays.fill(resA, 0);

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0 && A[i] <= A.length) {
				resA[A[i]-1] += 1;
			}
		}

		for (int i = 0; i < resA.length; i++) {
			if (resA[i] == 0) {
				return i + 1;
			}
		}

		return resA.length+1;

	}
	
	public static void main(String[] args) {
		int[] A = new int[] {1,2,3,4};
		System.out.println(solution(A));
		
		int[] B = new int[] {-1,2,3,4};
		System.out.println(solution(B));
		
		int[] C = new int[] {1,2,3,40};
		System.out.println(solution(C));
		
		int[] D = new int[] {-100,100};
		System.out.println(solution(D));
		
		int[] E = new int[] {1};
		System.out.println(solution(E));
		
	}
}