package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q001 {
	
	public boolean inputCheck(int[] nums){
	
		if(nums==null) return false;
		if(nums.length==1) return false;
		return true;
	}
	
	public boolean inputCheck(int target){
		
		return true;
	}
	
	public int[] bruteForce(int[] nums, int target){
		
		if(!inputCheck(nums)) return new int[2];
		if(!inputCheck(target)) return new int[2];

		int[] result = new int[2];
		
		//loop two times to find the result
		for(int i = 0; i < nums.length; i ++){
			for (int j = 0; j < nums.length; j ++){
				if(nums[i]+nums[j]==target){
					result[0] = i;
					result[1] = j;
					return result;
				}
				
			}
		}
		
		
		return nums;
	}
	
	public int[] betterOne(int[] nums, int target){
		if(!inputCheck(nums)) return new int[2];
		if(!inputCheck(target)) return new int[2];

		int[] result = new int[2];
		
		//sort the array first
		int[] copyOfResult = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copyOfResult);
		
		//do a binary search on the array
		for(int i = 0; i < nums.length; i ++){
			if(Arrays.binarySearch(copyOfResult, (target - nums[i]))>0){
				//result[0] = copyOfResult.;
				result[1] = i;
				
				break;
			}
		}
		
		//locate target-nums[i] in nums
		for(int i = 0; i < nums.length; i ++){
			if(nums[i]==(target - nums[result[1]])){
				result[0] = i;
			}
		}
		
		return result;
	}

	
	public int[] bestOne(int[] nums, int target){
		if(!inputCheck(nums)) return new int[2];
		if(!inputCheck(target)) return new int[2];

		int[] result = new int[2];
		
		//use a Map to store scaned index&number
		Map<Integer, Integer> map = new HashMap<Integer , Integer>();
		
		//find the result in the Map, if not in the map, put it in.
		
		for(int i = 0; i < nums.length; i ++){
			if(map.containsKey(nums[i])){
				
			}
		}
		
		
		return nums;
	}
	
	public void main(String[] args){
		
	}
}
