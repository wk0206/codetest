package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q001 {
	
	public boolean inputCheck(int[] nums){
	
		if(nums==null) return false;
		if(nums.length==0) return false;
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
		
		
		return result;
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
			int k = target - nums[i];
			if (k == nums[i])continue;
			if(Arrays.binarySearch(copyOfResult, k)>0){
				//result[0] = copyOfResult.;
				result[1] = i;
				
				break;
			}
		}
		
		//locate target-nums[i] in nums
		for(int i = 0; i < nums.length; i ++){
			if(nums[i]==(target - nums[result[1]])){
				result[0] = i;
				break;
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
			int k = target - nums[i];
			if(map.containsKey(k)){
				result[0] = map.get(k);
				result[1] = i;
				return result;
			}
			map.put(nums[i], i);
		}
		
		
		return result;
	}
		
	public static void main(String[] args){
		//prepare input
		int[] nums = new int[] {2,7,9,11,13};
		int target = 9;
		
		//prepare output
		int[] result = new int[2];
		
		//instance
		Q001 instance = new Q001();
		
		//method1
		result = instance.bruteForce(nums, target);
		System.out.println(Arrays.toString(result));
		//method2
		result = instance.betterOne(nums, target);
		System.out.println(Arrays.toString(result));
		//method3
		result = instance.bestOne(nums, target);
		System.out.println(Arrays.toString(result));
		
	}
}
