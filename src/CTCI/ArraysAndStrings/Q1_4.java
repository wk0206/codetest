package CTCI.ArraysAndStrings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Q1_4 {

	public static boolean solution(String input) {
		HashMap<Character , Integer> cSet = new HashMap<>();
		for(char c : input.toLowerCase().toCharArray()) {
			if(cSet.containsKey(c)) {
				cSet.put(c, cSet.get(c)+1);
			}else {
				cSet.put(c, 1);
			}
		}
		
		int count = 0;
		for (Iterator<Entry<Character, Integer>> iterator = cSet.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry e = iterator.next();
			if((Integer)e.getValue()%2 !=0 && (char) e.getKey()!=' ') {
				count++;
			}
		}
		
		if(count<=1)return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		String s = "Tact Coa";
		
		System.out.println(solution(s)?"true":"false");
	}
}
