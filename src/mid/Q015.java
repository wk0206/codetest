package mid;
import java.util.*;
import java.util.Map.Entry;

public class Q015 {

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,int[]> tempArray = new HashMap<Integer,int[]>();
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                int sum = nums[i]+nums[j];
                int[] ary = new int[2];
                ary[0] = nums[i];
                ary[1] = nums[j];
                tempArray.put(sum, ary);
                System.out.println(nums[i]+","+nums[j]);
            }
        }  
    
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for(Map.Entry<Integer, int[]> temp:tempArray.entrySet()){
        	Integer key = temp.getKey();
        	int[] value = temp.getValue();
        	for (int num :nums){
        		if(num+key == 0){
        			List<Integer> row = new ArrayList<Integer>();
        			row.add(num);
        			row.add(value[0]);
        			row.add(value[1]);
        			res.add(row);
        			System.out.println(num+","+value[0]+","+value[1]);
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
