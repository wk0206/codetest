package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q442 {
	 public static List<Integer> findDuplicates(int[] nums) {
	        int[] countArray = new int[nums.length];
	        Arrays.fill(countArray,0);
	        int index =1;
	        int csindex = 0;
	        int value = 0;
	        int i = 0;
	        
	        while(i>=0 && i<nums.length){
	            index = nums[i];
	            csindex = index -1;
	            value = nums[i];
	            if(index == 0 ) {
	            	i++;
	            	continue;
	            }
	            if(i==csindex){
	                countArray[csindex]=countArray[csindex]-1;
	                i++;
	                continue;
	            }
	            countArray[csindex]=countArray[csindex]-1;
	            swap(nums, i, csindex);
	            
	            if(nums[i]==0){
	                i++;
	                //continue;
	            }
	            
	            nums[csindex]=0;
	        }
	        
	        List<Integer> res = new ArrayList<>();
	        for(int j = 0; j < nums.length; j ++){
	            if(countArray[j]<-1){
	                res.add(j+1);
	            }
	        }
	        
	      return res;
	        
	    }
	    
	    public static void swap(int[] array, int i, int j){
	        int temp = array[i];
	        array[i] = array[j];
	        array[j]=temp;
	    }
	    
	    
	    public static List<Integer> solution2(int[] nums){
	    	List<Integer> res = new ArrayList<Integer>();
	    	int[] arr = new int[nums.length+1];
	    	for(int i = 0; i < nums.length; i ++) {
	    		arr[nums[i]]++;
	    	}
	    	for(int i = 0; i < arr.length; i ++) {
	    		if(arr[i]==2) {
	    			res.add(i);
	    		}
	    	}

	    	return res;
	    }
	    public static void main(String[] args) {
	    	int[] input = new int[] {2,2};
	    	//int[] input = new int[] {4,3,2,7,8,2,3,1};
	    	solution2(input);
	    }
}
