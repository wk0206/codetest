package leetcode.mid;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Q015 {

    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();

    	//step1 sort
    	Arrays.sort(nums);
    	
    	//step2 loop
    	for(int i = 0; i < nums.length-2; i ++){
    		//pointer
    		int j = i+1;
    		int k = nums.length-1;
    		if(i>0&&nums[i]==nums[i-1])continue;
    		
    		while(k>j){
    			System.out.println(nums[i]+","+nums[j]+","+nums[k]+";"+i+","+j+","+k);
    			if(nums[i]+nums[j]+nums[k]==0){
    				//output one row
    				List<Integer> row = new ArrayList<Integer>();
    				row.add(nums[i]);
    				row.add(nums[j]);
    				row.add(nums[k]);
    				res.add(row);
    				j++;
    				k--;
    				while(nums[j]==nums[j-1])j++;
    				while(nums[k]==nums[k+1])k--;
    			}
    			else if(nums[i]+nums[j]+nums[k]>0){
    				k--;
    			}
    			else if(nums[i]+nums[j]+nums[k]<0){
    				j++;
    			}
    		}
    		
    	}
    	
    	return res;
    }
    
    public List<List<Integer>> threeSumFailed1(int[] nums) {
    	Map<int[],int[]> tempArray = new HashMap<int[],int[]>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int[] key = {i,j};
                int[] value = new int[2];
                value[0] = nums[i];
                value[1] = nums[j];
                tempArray.put(key, value);
                //System.out.println(nums[i]+","+nums[j]);
            }
        }  
    
        for(Map.Entry<int[],int[]> tep:tempArray.entrySet()){
        	System.out.println(tep.getValue()[0]+","+tep.getValue()[1]);
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for(Map.Entry<int[], int[]> temp:tempArray.entrySet()){
        	int[] key = temp.getKey();
        	int[] value = temp.getValue();
        	for (int num :nums){
        		if(num!=key[0]&&num!=key[1]){
            		if(value[0]+value[1]+num == 0){
            			List<Integer> row = new ArrayList<Integer>();
            			row.add(num);
            			row.add(value[0]);
            			row.add(value[1]);
            			res.add(row);
            			//System.out.println(num+","+value[0]+","+value[1]);
            		}
        		}

        	}
        }
        

        
        return res;
    }
    
    public List<List<Integer>> threeSumFailed2(int[] nums) {
    	//step1 step2
    	Map<List<Integer>, Integer[]>matrix = new HashMap<List<Integer>, Integer[]>();
    	for (int i = 0; i < nums.length; i ++){
    		for (int j = i+1; j < nums.length; j ++){
    			List<Integer> key = new ArrayList<Integer>();
    			key.add(Math.min(nums[i],nums[j]));
    			key.add(Math.max(nums[i], nums[j]));
	    		Integer[] vaule = {i, j};
	    		//System.out.println(matrix.containsKey(key));
	    		//if(!matrix.containsKey(key)){
	    			matrix.put(key, vaule);
	    		//}
	    		//System.out.println(key.get(0)+","+key.get(1));
	    		//System.out.println(matrix.keySet());
    		}
    	}
    	
    	//step3
    	Map<Integer,Integer> numsMap = new HashMap<Integer,Integer>();
    	for (int i = 0; i < nums.length; i ++){
    		numsMap.put(nums[i], i);
    	}
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	for (Map.Entry<List<Integer>, Integer[]> temp : matrix.entrySet()){
    		List<Integer> key = temp.getKey();
    		Integer[] value = temp.getValue();
    		if(numsMap.containsKey(-key.get(0)-key.get(1))){
    			int index = numsMap.get(-key.get(0)-key.get(1));
    			if(index!= value[0]&& index!= value[1]){
    				ArrayList<Integer> row = new ArrayList<Integer>();
    				row.add(nums[index]);
    				row.add(key.get(0));
    				row.add(key.get(1));
    				res.add(row);
    				System.out.println(nums[index]+","+key.get(0)+","+key.get(1));
    			}
    		}
    	}
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Q015 instance = new Q015();
		
		int[] nums = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
		List<List<Integer>> res = instance.threeSum(nums);
		
		for(List<Integer> list : res){
			System.out.println(list.get(0)+","+list.get(1)+","+list.get(2));
		}

	}

}
