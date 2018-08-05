package CTCI.ArraysAndStrings;

import java.util.HashMap;

public class Q1_2 {
	
	public static boolean solution(String input1, String input2) {
		if(input1.length()!=input2.length())return false;
		HashMap<Character , Integer> cSet = new HashMap<>();

		for(char c: input1.toCharArray()) {
			if(cSet.containsKey(c)) {
				cSet.put(c, cSet.get(c)+1);
			}
			else {
				cSet.put(c, 1);
			}
			System.out.println(cSet);
		}
		
		
		for(char c: input2.toCharArray()) {
			if(!cSet.containsKey(c)) {
				return false;
			}else {
				if(cSet.get(c)==0) {
					return false;
				}else {
					cSet.put(c, cSet.get(c)-1);
				}
			}
			System.out.println(cSet);
		}
		
		
		
		return true;
	}

	
	public static void main(String[] args) {
		
		String s1 = "testtask";
		String s2 = "tasktest";	
		solution(s1,s2);
		
		System.out.println(solution(s1,s2)?"true":"false");
	}
}
