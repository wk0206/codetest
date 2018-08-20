package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q217 {
	public boolean containsDuplicate(int[] nums) {
        if(nums == null) {
            return false;
        }
        final int length = nums.length;
        for(int i = 1 ; i <length; i++) {
            for(int j= i-1 ; j >= 0 ;j--) {
                if(nums[i] > nums[j]) {
                    break;
                }
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

	public boolean solution1(int[] nums) {
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])// if there is same
				return true;

		}
		return false;

	}

	
	public boolean solution2(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums)
			if (!set.add(i))// if there is same
				return true;
		return false;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
