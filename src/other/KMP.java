package other;

public class KMP {
	
	public int[] FF(String W){
		int i = 2;
		int j = 0;
		
		int[] T = new int[W.length()];
		T[0]=-1;
		T[1]=0;
		
		while(i<W.length()){
			//equal, continue
			if(W.charAt(i-1)==W.charAt(j)){
				T[i]=j+1;
				i++;
				j++;
			}else if(j>0){
				j=T[i-1];
				
			}else{
				T[i]=0;
				i++;
			}
		}
		
		System.out.println(T.toString());
		return T;
	}

	public int KMP(String S, String W){
		int[] T = FF(W);
		int pS = 0;
		int pW = 0;
 
		while(pS+pW <= S.length()){
			if(S.charAt(pS+pW)==W.charAt(pW)){
				pW++;
				if(pW==W.length()) return pS;
			}else {
				//not equal, where to start again
				pS=pS+pW-T[pW];
				if(pW>0){
					pW=T[pW];
				}
			}
		}
		
		return -1;
	}
	
	
	public void main(String[] args){
		
		String W="ABCDABD";
		String S="ABCD ABCABCDABDE";
		int i = KMP(S,W);
		
		System.out.println(i);
	}
}
