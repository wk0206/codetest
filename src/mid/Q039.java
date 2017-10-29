package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q039 {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	     
		 Arrays.sort(candidates);
		 List<Integer> res = new ArrayList<Integer>();
		 calculate(candidates,target, res);
		 
		 
		 
		 return null;
	 }
	 
	 
	 public int[] calculate(int[] nums, int target,List<Integer> res){
		 int[] output = new int[nums.length];
		 res.add(target);
		 
		 for(int i = 0; i < nums.length; i ++){
			 output[i]=target-nums[i];
			 if(output[i]>nums[0]){
				 calculate(nums,output[i],res);
				 return output;
			 }
			 else output[i] = -1;
			 return output;
		 }
		 
		 return nums;
	 }
	
		 
}
