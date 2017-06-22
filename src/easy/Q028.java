package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Q028 {
	public int solution(String W, String T){
		if(W==null||T==null)return -1;
		if(W.length()<T.length()){
			return -1;
		}
		if(W.length()==0){
			if(T.length()==0){
				return 0;
			}else{
				return -1;
			}
		}else{
		    if(T.length()==0)return 0;
		}
		
		
		if(W.indexOf(T)>=0)
		{
			return W.indexOf(T);
		}
		else 
		{
			return -1;
		}
		
	}
	
	public int BF(String W, String T){
		if(W==null||T==null)return -1;
		if(W.length()<T.length()){
			return -1;
		}
		if(W.length()==0){
			if(T.length()==0){
				return 0;
			}else{
				return -1;
			}
		}else{
		    if(T.length()==0)return 0;
		}
		
		for(int i = 0; i < W.length()-T.length()+1; i++){
			for (int j = 0; j < T.length(); j++){
				if(W.charAt(i+j)==T.charAt(j)){
					if(j==T.length()-1){
						return i;
					}
				}else{
					break;
				}
				
			}
		}
		
		return -1;
	}
	
	public int Sample(String haystack,String needle){
		for (int i = 0; ; i++) {
		    for (int j = 0; ; j++) {
		      if (j == needle.length()) return i;
		      if (i + j == haystack.length()) return -1;
		      if (needle.charAt(j) != haystack.charAt(i + j)) break;
		    }
		  }
	}
	
	public int KMP(String S, String W){
		int m = 0, i = 0;
		
		if(inputCheck(S,W)<=0){
			//return inputCheck(S,W);
		}
		//build table T
		int[] T = buildTable2(W);	
		System.out.println(Arrays.toString(T));
		while(m<S.length()-W.length()+1){
			
			if(S.charAt(m+i)==W.charAt(i)){
				if(i==W.length()-1) return m;
				//m++;
				i++;
			}else if(T[i]==-1){
				//m++;
				m++;
				i=0;
				//i=1;
			}else if(T[i]==0){
				m=m+i+1;
				i=0;
			}else if(T[i]>0){
				m = m+i+T[i]+1;
				i=T[i];
			}
		}		
		return -1;
	}
	
	private int[] buildTable2(String W){
		int i =1, j = 0;
		int[] res = new int[W.length()];
		
        while(i <  W.length()) {
            if( W.charAt(i) ==  W.charAt(j)) {
                res[i] = j+1;
                i++; j++;
            } else if (j > 0) {
                j = res[j-1];
            } else {
                res[i] = 0;
                i++;
            }
        }
        return res;
        
	}
	private int[] buildTable(String W){
		int i=1, j = 0;
		int[] res = new int[W.length()];
		res[0]=-1;
		
		for(;i < W.length(); i++){			
			if(W.charAt(i)!=W.charAt(j)){

				res[i]=j;
				j=0;				
			}else if(j>0){
				res[i]=j;
				j++;
				
			}else{
				res[i] = j;
				j=1;
			}
		}
		
		
		return res;
	}
	
	private int inputCheck(String W, String T){
		if(W==null||T==null)return -1;
		if(W.length()<T.length()){
			return -1;
		}
		if(W.length()==0){
			if(T.length()==0){
				return 0;
			}else{
				return -1;
			}
		}else{
		    if(T.length()==0)return 0;
		}
		return 1;
	}
	
	public static void main(String[] args){
		
		Q028 instance = new Q028();
		
		//String S="ABC BCDE ABCDEF ABCDBCDF";
		//String W = "BCDBCDF";
		//String W= "ABCDABD";
		//String W = "PARTICIPATE IN PARACHUTE";
		String W = "ABACABABC";
		//String S = "a";
		//String W = "";
		String S = "mississippi";
		//String W = "issip";
		//List<Map<Character, Integer>> T = new ArrayList<HashMap<Character, Integer>>();
		//T.add('A',-1);
		System.out.println(String.valueOf(instance.KMP(S, W)));
		
	}

}
