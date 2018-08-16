package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q132 {

	public static void solution() {

	}
	
    public int minCut(String s) {
        
    	return 0;
    }
    
    public void doPartition(String s, int index) {
    	
    }
    
    private boolean checkPalindrome(String s) {
    	int i = 0;
    	int j = s.length()-1;
    	while(i<j) {
    		if(s.charAt(i)==s.charAt(j)) {
    			i++;
    			j--;
    		}else {
    			return false;
    		}
    	}
    	
    	return true;
    }
    

	public static void main(String[] args) {

	}

}
