package leetcode.easy;

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
		int[] T = buildTable(W);	
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
			/*}else if(T[i]==0){
				m=m+i+1;
				i=0;
				*/
			}else if(T[i]>=0){
				m = m+i-T[i];
				i=T[i];
			}
		}		
		return -1;
	}
	
	public int KMPLeetCode(String S, String W){
		int m = 0, i = 0;
		
		if(inputCheck(S,W)<=0){
			//return inputCheck(S,W);
		}
		//build table T
		int[] T = buildTableLeetCode(W);	
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

	
	public int KMPWiki(String S, String W){
		int m = 0, i = 0;
		
		if(inputCheck(S,W)<=0){
			//return inputCheck(S,W);
		}
		//build table T
		int[] T = buildTableWiki(W);	
		System.out.println(Arrays.toString(T));
		while(m+i<S.length()){
			
			if(S.charAt(m+i)==W.charAt(i)){
				i++;
				if(i==W.length()) return m;
				//m++;
			}else if(T[i]>-1){
				//m++;
				m=m+i-T[i];
				i=T[i];
				//i=1;
			}else {
				m = m + i + 1;
				i=0;
			}
		}		
		return -1;
	}

	public void search(String original, String find) {  
	    int j = 0;  
	    int[] next = getNext(find);
	    System.out.println(Arrays.toString(next));
	    for (int i = 0; i < original.length(); i++) {  
	        while (j > 0 && original.charAt(i) != find.charAt(j))  
	            j = next[j];  
	        if (original.charAt(i) == find.charAt(j))  
	            j++;  
	        if (j == find.length()) {  
	            System.out.println("find at position " + (i - j));  
	            System.out.println(original.subSequence(i - j + 1, i + 1));  
	            j = next[j];  
	        }  
	    }  
	}

	private int[] buildTable(String W){
		int i=1, j = 0;
		int[] T = new int[W.length()];
		T[0]=0;
		//System.out.println(i+" of "+W.length());
		//System.out.println(W);
		int[] A = {i,j,T[0]};
		//log(W,A);
		while(i < W.length()){	
			
			
			if(W.charAt(i)!=W.charAt(j)){
				System.out.println(W.substring(0,i)+"["+W.charAt(i)+"]"+W.substring(i+1)+":"+W.substring(0,j)+"["+W.charAt(j)+"]"+W.substring(j+1));		
				if(j>0){
					T[i]=j;
					j=T[j];
				}else{
					T[i]=j;
				}
			}
			
			if(W.charAt(i)==W.charAt(j)){
				System.out.println(W.substring(0,i)+"["+W.charAt(i)+"]"+W.substring(i+1)+":"+W.substring(0,j)+"["+W.charAt(j)+"]"+W.substring(j+1));
				//System.out.println(W.charAt(i)+":"+W.charAt(j));
				if(j>0){
					T[i]=j;
					j++;

					
				}else if (j==0){
					T[i] = j;
					j++;

				}
				//System.out.println(i+":"+j+":"+T[i]);
			}
			i++;
			/*
			if(W.charAt(i)!=W.charAt(j)){

				res[i]=j;
				i=j;
				j=0;		

			}else if(W.charAt(i)==W.charAt(j)){
				if(j>0){
					res[i]=j;
					j++;
					i++;
					
				}else if (j==0){
					res[i] = j;
					j=1;
					i++;
				}
			}
			*/
			A[0] = i;
			A[1] = j;
			//A[2] = T[i];
			//log(W,A);
		}
		
		
		return T;
	}	
	
	
	private int[] buildTableLeetCode(String W){
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
	
	private int[] buildTableWiki(String W){
		int pos =1, cnd  = 0;
		int[] T = new int[W.length()];
		T[0]=-1;
		
		int[] A = {pos,cnd,T[pos]};
		//log(W,A,T);
		while(pos  < W.length()){			
			if(W.charAt(pos )==W.charAt(cnd )){

				//T[pos ]=cnd ;
				T[pos] = T[cnd];
				pos++;
				cnd++;				
			}else {
				T[pos]=cnd;
				cnd = T[cnd];
				while(cnd >= 0 && W.charAt(pos )!=W.charAt(cnd )){
					cnd = T[cnd];
				}
				pos = pos + 1;
				cnd = cnd + 1;
				/*
				if(cnd >0){
					T[pos ]=cnd ;
					cnd ++;
					
				}else{
					T[pos ] =cnd ;
					cnd =1;
				}
				*/
			}
			A[0] = pos;
			A[1] = cnd;
			//A[2] = T[i];
			//log(W,A,T);
			
		};
		
		
		return T;
	}
	
	private int[] getNext(String b)  
	{  
	    int len=b.length();  
	    int j=0;  
	          
	    int next[]=new int[len+1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始
	    next[0]=next[1]=0;  
	          
	    for(int i=1;i<len;i++) //i表示字符串的下标，从0开始 
	    {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置 
	    	System.out.println(b.substring(0,i)+"["+b.charAt(i)+"]"+b.substring(i+1)+":"+b.substring(0,j)+"["+b.charAt(j)+"]"+b.substring(j+1));
	        while(j>0&&b.charAt(i)!=b.charAt(j))j=next[j];  
	        
	        if(b.charAt(i)==b.charAt(j))j++;  
	        
	        next[i+1]=j;
	        
	    }  
	          
	    return next;  
	}

	public void log(String W, int[] A,int[] T){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		StringBuilder perfix = new StringBuilder("");
		int i = A[0];
		int j = A[1];
		int k = i-j;
		while(A[0]>0){
			perfix.append(" ");
			A[0]=A[0]-1;
		}
		
		StringBuilder surfix = new StringBuilder("");
		while(k>0){
			surfix.append(" ");
			k=k-1;
		}
		String TS = Arrays.toString(T).replaceAll(",","");
		TS=TS.replaceAll(" ","");
		TS=TS.replaceAll("-1","X").substring(1, TS.length()-3);
		String message = String.join(" ", Arrays.toString(T));
		  
		System.out.println(perfix.toString()+"��"+"i="+i);
		System.out.println(W.toCharArray());

		System.out.println(surfix.toString()+"" +W);
		//System.out.println(surfix.toString()+"" +TS);
		System.out.println(perfix.toString()+"��"+"j="+j);
		
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
		
		//String S="ABC BCDE ABCDEF ABCDBCDF ADESASDFGDSDF";//answer 17
		//String W = "BCDBCDF";
		String S = "aabaaabaaac";
		String W = "aabaaac";
		//String W= "ABCDABD";
		//String W = "PARTICIPATE IN PARACHUTE";
		//String W = "ABACABABC";
		//String S = "a";
		//String W = "";
		//String S = "mississippi";//answer 4
		//String W = "issip";
		//List<Map<Character, Integer>> T = new ArrayList<HashMap<Character, Integer>>();
		//T.add('A',-1);
		System.out.println(String.valueOf(instance.KMP(S, W)));
		System.out.println(String.valueOf(instance.KMPWiki(S, W)));
		instance.search(S, W);
		
	}

}
