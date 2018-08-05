package CTCI.ArraysAndStrings;

import java.util.HashMap;

public class Q1_5 {
	
	public static boolean solution(String s1, String s2) {
		HashMap<Character , Integer> cSet = new HashMap<>();
		
		for(Character c: s1.toCharArray()) {
			if(cSet.containsKey(c)) {
				cSet.put(c, cSet.get(c)+1);
			}else {
				cSet.put(c, 1);
			}
			
		}
		
		for(Character c: s2.toCharArray()) {
			if(cSet.containsKey(c)) {
				cSet.put(c, cSet.get(c)-1);
			}else {
				cSet.put(c, -1);
			}
			
		}
		
		int flag = 0;
		int sum =0;
		
		for(int i : cSet.values()) {
			sum+=i;
			if(i!=0) {
				flag++;
			}
		}
		
		if((flag ==1 && (sum==1||sum==-1))||(flag==2 && sum==0)) {
			return true;
		}else return false;
		
	}

	
	public static void main(String[] args) {
		String s1 = "pale";
		String s2 = "pales";
		
		System.out.println(solution(s1,s2)?"true":"false");
	}
}
