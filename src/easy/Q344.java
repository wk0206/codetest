package easy;

import java.util.Arrays;

public class Q344 {

	public String ReverseString(String s){
		char[] temp = s.toCharArray();
		char[] newTemp = Arrays.copyOf(temp, temp.length);
		
		for(int i = s.length()-1; i >= 0 ; i--){
			newTemp[s.length()-i-1] = temp[i];
		}

		
		String result = new String(newTemp);

		return result;
	}
	
	public static void main(String[] args){
		Q344 instance = new Q344();
		
		String res = instance.ReverseString("hello");
		
		System.out.println(res);
	}
}
