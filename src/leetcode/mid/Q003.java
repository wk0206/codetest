package leetcode.mid;

import java.util.HashMap;

public class Q003 {

	public int SL(String S){
		
		//input check
		if(S.length()==0)return 0;
		if(S.length()==1)return 1;
		
		StringBuilder tempStr=new StringBuilder();
		int maxCount = 0;
		
		for (int i = 0; i < S.length(); i++){
			char x = S.charAt(i);
			if(tempStr.indexOf(String.valueOf(x))==-1){
				tempStr.append(x);
				if(tempStr.length()>maxCount){
					maxCount = tempStr.length();
				}
			}else{
					tempStr.delete(0, tempStr.indexOf(String.valueOf(x))+1);
					tempStr.append(x);
					if(tempStr.length()>maxCount){
						maxCount = tempStr.length();
					}
			}
		}
		
		return maxCount;
	}
	
	public int TP(String S){
		HashMap<Character, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0, j = 0; i < S.length(); i++){
			if(map.containsKey(S.charAt(i))){
				j = Math.max(j, map.get(S.charAt(i))+1);	
			}
			map.put(S.charAt(i), i);
			max = Math.max(max, i-j+1);
		}

		return max;
	}
	
	public static void main(String[] args){
		
		Q003 instance = new Q003();
		int res = instance.TP("abcdaaabcdef");
		System.out.println(res);
	}
	
}
