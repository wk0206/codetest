package CTCI.ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

public class Q1_1 {
	
	public static boolean solution(String input) {
		
		HashMap<Character,Integer> cSet = new HashMap<>();
		for(Character c: input.toCharArray()) {
			if(cSet.containsKey(c)) {
				
				return false;
			}else {
				cSet.put(c, 1);
			}
		}
		
		return true;
		
	}

	public static boolean solution_without_datastructure(String input) {
		char[] temp = input.toCharArray();
		
		Arrays.sort(temp);
		for(int i = 1; i < temp.length; i++) {
			if(temp[i]==temp[i-1]) {
				return false;
			}
		}
		
		//System.out.println(temp);
		
		
		return true;
	}
	
	public static void main(String[] args) {
		
		String s = "taskojwher";
		
		System.out.println(solution(s)?"true":"false");
		
		System.out.println(solution_without_datastructure(s)?"true":"false");
	}

}
