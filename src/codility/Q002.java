package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Q002 {
    public static int solution(int A) {
        // write your code in Java SE 8
    	//input check
    	
    	if(A<0) return 0;
    	if(A<10) return A;
   
    	String s = String.valueOf(A);
    	ArrayList<String> res = new ArrayList<>();
    	
    	int start = 0; 
    	int end = s.length()-1;
    	
    	while(start<end) {
    		res.add(String.valueOf(s.charAt(start)));
    		res.add(String.valueOf(s.charAt(end)));
    		start++;
    		end--;
    	}
    	


    	if(start== end){
    	    res.add(String.valueOf(s.charAt(start)));
    	}
    	
    	
//    	int size = s.length();
//    	StringBuilder sb = new StringBuilder();
//    	for(int i = 0 ;i < size/2; i++) {
//    		int x = s.charAt(i);
//    		int y = A%10;
//    		
//    		A
//    	}
//    	
//    	while(A!=0) {
//    		int x = A%10;
//    		A=A/10;
//    		sb.append(x);
//    	}
    	
    	

//    	String b = test.toString();
//    	
//    	String a = res.toString();
    	//res.stream().forEach(System.out::println);;
    	String x = res.stream().collect(Collectors.joining(""));
    	//String t = Stream.of(res).collect(Collectors.joining(", "));
    	Integer.valueOf(x);
    	
    	return A;
    }
    
    public static int test(int A) {
//    	
//    	    if (vec.length <= 1) return vec;
//    	    int low = 0, high = vec.size() - 1;
//    	    vector<int> ret;
//    	    while (low < high) {
//    	        ret.push_back(vec[low]);
//    	        ret.push_back(vec[high]);
//    	        low++, high--;
//    	    }
//
//    	    if (low == high)
//    	        ret.push_back(vec[low]);
//
//    	    return ret;
//    	}
    	
    	return A;
    }
    
    public static void main(String[] args) {
    	
    	int res  = solution(100000000);
    	
    	
    }

}
