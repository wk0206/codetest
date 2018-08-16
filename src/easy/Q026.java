package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q026 {

	public static void solution() {

	}

	public static int removeDuplicates(int[] nums) {

		if(nums==null || nums.length==0) return 0;
		if(nums.length==1) return 1;
		int val = nums[0];
		int count = 1;
		
		for(int i = 1; i < nums.length;i++) {
			if(val<nums[i]) {
				
				val = nums[i];
				nums[count]=val;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		removeDuplicates (new int[] {0,0,1,1,1,2,2,3,3,4});

	}

}
