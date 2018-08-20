package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q039 {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		// calculate(candidates,target, res);
		res = combSum(candidates, target);
		
		res.forEach(i -> System.out.println(i));
		return null;
	}

	public static int[] calculate(int[] nums, int target, List<Integer> res) {
		int[] output = new int[nums.length];
		res.add(target);

		for (int i = 0; i < nums.length; i++) {
			output[i] = target - nums[i];
			if (output[i] > nums[0]) {
				calculate(nums, output[i], res);
				return output;
			} else
				output[i] = -1;
			return output;
		}

		return nums;
	}

	public static List<List<Integer>> calculate(int[] nums, int target, List<List<Integer>> res, int temp) {
		int[] output = new int[nums.length];
		// res.add(target);

		for (int i = 0; i < nums.length; i++) {
			output[i] = target - nums[i];
			if (output[i] > nums[0]) {
				// calculate(nums,output[i],res);
				// return output;
			} else
				output[i] = -1;
			// return output;
		}

		return res;
	}

	public static List<List<Integer>> combSum(int[] input, int target) {
		// input check

		// new res
		Set<List<Integer>> res = new HashSet<>();

		// put <List, Integer> entry
		Map<List<Integer>, Integer> map = new HashMap<>();

		// put R1 in map
		for (int i = 0; i < input.length; i++) {
			map.put(new ArrayList<>(Arrays.asList(Integer.valueOf(input[i]))), target - input[i]);
		}

		// repeat until map.size = 0

		while (true) {
			// TODO:
			if (map.size() > 0) {
				map = doSth(input, map, res);
			} else {
				break;
			}

		}
		return new ArrayList<>(res);
	}

	private static Map<List<Integer>, Integer> doSth(int[] input, Map<List<Integer>, Integer> map,
			Set<List<Integer>> res) {
		// get iterator
		Iterator<Map.Entry<List<Integer>, Integer>> it = map.entrySet().iterator();

		// for add all at last
		Map<List<Integer>, Integer> temp = new HashMap<List<Integer>, Integer>();

		while (it.hasNext()) {
			// current element
			Map.Entry<List<Integer>, Integer> ele = it.next();
			if(ele.getValue()==0) {
				res.add(ele.getKey());
			}
			for (int i = 0; i < input.length; i++) {
				List<Integer> K = new ArrayList<>(ele.getKey());
				int V = ele.getValue();
				if (V - input[i] == 0) {
					// DO output					
					K.add(input[i]);
					Collections.sort(K, new objCompare());
					res.add(K);
				} else if (V - input[i] < 0) {
					continue;
				} else {
					// add to temp, to next loop
					K.add(Integer.valueOf(input[i]));
					Collections.sort(K, new objCompare());

					
					if (!temp.containsKey(K)) {
						//System.out.println(K);
						temp.put(K, V - input[i]);
					}

				}
			}

			it.remove();
		}

		map.putAll(temp);

		return map;
	}

	public static void doSth(int[] input, List<String> map, List<List<Integer>> res) {

	}

	public static void main(String[] args) {
		int[] input = new int[] { 3, 4, 5, 6 };
		int target = 15;

		combinationSum(input, target);

	}

}

class objCompare implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Integer l1 = (Integer) o1;
		Integer l2 = (Integer) o2;
		if (o1.equals(o2)) {
			return 0;
		} else if (l1 == l2) {
			return 0;
		} else if (l1 > l2) {
			return 1;
		} else
			return -1;
	}

}
