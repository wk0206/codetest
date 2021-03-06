package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Q412 {

	public List<String> fizzBuzz(int n) {

		List<String> result = new ArrayList<String>();

		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				result.add(i - 1, "BF");
			} else if (i % 3 == 0) {
				result.add(i - 1, "F");
			} else if (i % 5 == 0) {
				result.add(i - 1, "B");
			} else
				result.add(i - 1, String.valueOf(i));
		}
		return result;
	}

	public List<String> fizzBuzz2(int n) {

		List<String> result = new ArrayList<String>();

		int pointer = 0;
		int c3 = 1;
		int c5 = 1;

		while (pointer < n) {
			if (c3 == 3 && c5 == 5) {
				result.add("BF");
				c3 = 1;
				c5 = 1;
			} else if (c3 == 3) {
				result.add("F");
				c3 = 1;
				c5++;
			} else if (c5 == 5) {
				result.add("B");
				c3++;
				c5 = 1;
			} else {
				c3++;
				c5++;
				result.add(String.valueOf(pointer + 1));
			}

			pointer++;
		}

		return result;
	}

	public List<String> fizzBuzz3(int n) {

		List<String> result = new ArrayList<String>();

		for (int i = 1; i <= n; i++) {
			// result.add((i % 3 == 0) || (i % 5 == 0) ? String.valueOf(i) :
			// String.valueOf(0));
			result.add(bf(i));
		}
		return result;
	}

	public String bf(int x) {
		String res = "";
		// res = ((x % 3 == 0)?String.valueOf("Fizz"):"") +((x % 3 ==
		// 0)?String.valueOf("Buzz"):"") ;
		if (x % 3 == 0) {
			res += "Fizz";
		}

		if (x % 5 == 0) {
			res += "Buzz";
		} else {
			res += String.valueOf(x);
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q412 instance = new Q412();

		System.out.println(instance.fizzBuzz3(15));
		
		int value = 10;
		value +=3.14;
		
		System.out.println(value);

	}

}
