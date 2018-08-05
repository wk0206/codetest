package CTCI.RecursionAndDP;

import java.util.Arrays;

public class fibonacci {

	public Long brute(int n) {
		// this method up to 46 only
		if (n == 0)
			return 0L;
		if (n == 1)
			return 1L;
		if (n == 2)
			return 1L;
		Long sum = brute(n - 1) + brute(n - 2);
		// System.out.println(n+"th : " + sum);
		return sum;
	}

	public static long[] mem = new long[100];

	public long DP(int n) {
		//this method up to 92,
		//limited by long data structure
		if (n == 0) {
			mem[0] = 0;
			return 0L;
		}

		if (n == 1) {
			mem[1] = 1;
			return 1L;
		}
		if (n == 2) {
			mem[2] = 1;
			return 1L;
		}

		long n1;
		long n2;
		if (mem[n - 1] >= 0) {
			n1 = mem[n - 1];
		} else {
			n1 = DP(n - 1);
		}

		if (mem[n - 2] >= 0) {
			n2 = mem[n - 2];
		} else {
			n2 = DP(n - 2);
		}
		Long sum = n1 + n2;
		System.out.println(n + "th : " + sum + " = " + n1 + "+" + n2);
		mem[n] = sum;
		return sum;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fibonacci instance = new fibonacci();
		// System.out.println(instance.brute(46));

		Arrays.fill(mem, -1);
		System.out.println(instance.DP(92));

	}

}
