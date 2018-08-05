package CTCI.ArraysAndStrings;

import java.util.Arrays;

public class Q1_3 {

	public static char[] solution(String url, int length) {
		int count = 0;
		for(char c : url.toCharArray()) {
			if(c==' ')count++;
		}
		
		int finalLength = url.trim().length()+count*2;
		
		char[] urlArray = new char[1000];
		Arrays.fill(urlArray, ' ');
		System.arraycopy(url.toCharArray(), 0, urlArray, 0, url.length());
		
		for(int i = length-1; i>=0 ; i--) {
			if(urlArray[i]!=' ') {
				urlArray[finalLength-1] = urlArray[i];
				finalLength--;
			}else {
				urlArray[--finalLength] = '0';
				urlArray[--finalLength] = '2';
				urlArray[--finalLength] = '%';
			}
		}
		
		return urlArray;
	}
	
	public static void main(String[] args) {
		String url = "Mr John Smith";
		int length = 13;
		
		System.out.println(String.valueOf(solution(url, length)));
		
	}
}
