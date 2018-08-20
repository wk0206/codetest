package leetcode.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q638 {
	// public static List<List<Integer>> special = new ArrayList<>();
	public static List<Integer> price = new ArrayList<>();
	public static List<Integer> needs = new ArrayList<>();
	int sum = 0;
	public static Map<List<Integer>, Integer> DPMap = new HashMap<>();

	public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

		for(int i = 0 ; i < price.size(); i ++) {
			List<Integer> temp =price.stream().map(x->0).collect(Collectors.toList());
			temp.add(0);
			temp.set(i, 1);
			temp.set(price.size(), price.get(i));
			special.add(temp);
		}
		for(List<Integer> lst :special) {
			int value = lst.get(lst.size()-1);
			List<Integer> temp = lst;
			
			Collections.copy(temp, lst);
			temp.remove(temp.size()-1);
			DPMap.put(temp, value);
		}

		int res = DP(DPMap, special, needs);
		System.out.println(res);
		return 0;
	}

	public static Integer DP(Map<List<Integer>, Integer> dpmap, List<List<Integer>> special, List<Integer> key) {
		if (dpmap.containsKey(key))
			return dpmap.get(key);

		for (List<Integer> specialOrder : special) {
			// if equals to 0 , then will be contained in dp already.
			// if(checkListEqualsToZero(arrayMinus(key,specialOrder))==0) {
			// dpmap.put(key, value)
			// }else
			if (checkListEqualsToZero(arrayMinus(key, specialOrder)) > 0) {
				int res = DP(dpmap, special, arrayMinus(key, specialOrder)) + dpmap.get(specialOrder);
				dpmap.put(key, res);
				return res;
			}
			// can leave it here if this special order is too much.
			// will not enter dp.
			// else {
			// spec.remove(specialOrder);
			// }
		}

		return 0;

	}

	// [1,2,3]-[1,1,3]=[[0,1,0]
	public static List<Integer> arrayMinus(List<Integer> key1, List<Integer> key2) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < key2.size(); i++) {
			res.add(key1.get(i) - key2.get(i));
		}

		return res;
	}

	// [0,0,0] =0
	// [-1,0,0] =1
	// [1,0,0] =-1
	public static int checkListEqualsToZero(List<Integer> keys) {
		for (Integer key : keys) {
			if (key < 0)
				return -1;
		}

		for (Integer key : keys) {
			if (key > 0)
				return 1;
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> price = Arrays.asList(new Integer[] {2,5});
		List<List<Integer>> special = new ArrayList<List<Integer>> ();
		special.add(Arrays.asList(new Integer[] {3,0,5}));
		special.add(Arrays.asList(new Integer[] {1,2,10}));
		List<Integer> needs = Arrays.asList(new Integer[] {3,2});
		//[], [[3,0,5],[1,2,10]], [3,2]

		shoppingOffers(price, special, needs);
	}

}
