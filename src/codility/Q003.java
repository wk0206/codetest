package codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q003 {
	public static int solution(int N) {
		// write your code in Java SE 8

		Map<String, Integer> tenNumbers = new HashMap();

		String sOfN = String.valueOf(N);
		int Nsize = sOfN.length();

		for (int i = 0; i < sOfN.length(); i++) {
			String x = String.valueOf(sOfN.charAt(i));
			tenNumbers.put(x, tenNumbers.get(x) == null ? 1 : tenNumbers.get(x) + 1);
		}

		int size = tenNumbers.size();
		System.out.println(tenNumbers.toString());
		
		Long res = multi(Nsize);
		for(Map.Entry<String, Integer> e:tenNumbers.entrySet()) {
			e.getValue();
		}

		return 1;
	}

	public static Long multi(int num) {
		if (num == 1)
			return 1L;
		else {
			if (num > 1) {
				return num * multi(num - 1);
			}
			return 1L;
		}
	}
	
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null || nums.length==0) { return ans; }
        permute(ans, nums, 0);
        return ans;
    }
    
    private static  void permute(List<List<Integer>> ans, int[] nums, int index) {
        if (index == nums.length) { 
            List<Integer> temp = new ArrayList<>();
            for (int num: nums) { temp.add(num); }
            ans.add(temp);
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i=index; i<nums.length; ++i) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                permute(ans, nums, index+1);
                swap(nums, index, i);
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }
    

	public static void main(String[] args) {

		permuteUnique(new int[] {1,1,2,3});
		//solution(1123);
	}
}
