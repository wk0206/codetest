package leetcode.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q041 {
	public static int firstMissingPositive(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		
		for(int i : nums) {
			set.add(i);
		}
		
		for(int i = 1; i < Integer.MAX_VALUE; i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		int[] input = new int[] {7,8,9,11,12};
		
		int res = firstMissingPositive(input);
		
		System.out.println(res);
		
	}

}
