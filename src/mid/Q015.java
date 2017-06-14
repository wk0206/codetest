package mid;
import java.util.*;
import java.util.Map.Entry;

public class Q015 {

    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();

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
    			List<Integer> key = new ArrayList<>();
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
		
		int[] nums = {-1, 0, 1, 2, -1, -4};
		instance.threeSum(nums);
		
		

	}

}
