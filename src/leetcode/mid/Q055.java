package leetcode.mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 */

/*Example 1:

	Input: [2,3,1,1,4]
	Output: true
	Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/

/*Example 2:

	Input: [3,2,1,0,4]
	Output: false
	Explanation: You will always arrive at index 3 no matter what. Its maximum
	jump length is 0, which makes it impossible to reach the last index.           
*/

public class Q055 {

	public static void solution() {

	}

	public static boolean canJump(int[] nums) {

		if (nums == null || nums.length == 0)
			return false;

		if (nums.length == 1)
			return nums[0]>=1;
		
		// int[] res = new int[nums.length];
		
		//point to the index
		//index start from 0
		//length = 6
		//index = 0- 5
		int furthest = nums[0];
		
		for (int i = 1; i < nums.length && i <= furthest; i++) {
			if (furthest >= nums.length-1)
				return true;
			// if(nums[furthest]==0) return false;
			if (nums[i] < nums[i - 1]) {
				//res[i] = res[i - 1];
				continue;
			}else {
				furthest = (furthest>i+nums[i])?furthest:i + nums[i] ;	
			}
			//furthest = i + nums[i] + 1;
			//res[i] = furthest;

		}

		return false;
	}

	public static void main(String[] args) {
		canJump(new int[] { 2,3,1,1, 4 });
	}

}
