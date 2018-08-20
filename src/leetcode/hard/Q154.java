package leetcode.hard;

import java.util.Arrays;

public class Q154 {
	public static int findMin(int[] nums) {
//		if (nums == null)
//			return 0;
//		if (nums.length == 1)
//			return nums[0];
//
//		int head = nums[0];
//		int tail = nums[nums.length - 1];
//
//		int i = 0;
//		int j = nums.length - 1;
//		if (head < tail) {
//			return nums[head];
//		}
//
//		while ( i + 1 <= j &&(head == tail)) {
//			head = nums[++i];
//
//		}
//
//		while (head == tail && i + 1 <= j) {
//			tail = nums[--j];
//		}
//		
//		if (head < tail) {
//			return head;
//		} else {
//			while ((j >= 1) && (nums[j] >= nums[j - 1])) {
//				j--;
//			}
//			return nums[j];
//		}

		for(int i = 0 ; i < nums.length-1; i++) {
			if(nums[i]<=nums[i+1]) {
				continue;
			}else {
				return nums[i+1];
			}
		}
		
		return nums[0];
	}

	public static void main(String[] args) {

		int[] input = new int[] { 2, 0, 0, 0, 1, 2 };

		int res = findMin(input);
		String[] s =new String[] {""};
		Arrays.asList(s).forEach(i->System.out.println(i));

		System.out.println(res);

	}
}
