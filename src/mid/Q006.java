package mid;

import java.util.ArrayList;
import java.util.List;

public class Q006 {

	public String SL(String S, int N){
		if(N==1)return S;
		if(N==2){
			StringBuilder A= new StringBuilder();
			StringBuilder B= new StringBuilder();
			for(int i = 0; i < S.length();i+=2){
				A.append(S.charAt(i));
				if(i+1<S.length()){
					B.append(S.charAt(i+1));	
				}
				
			}
			return A.toString()+B.toString();
		}
		List<String> lst = new ArrayList<String>();
		List<String> res = new ArrayList<String>();
		
		int LoopNumber = N+N-2;
		
		//cut string
		StringBuilder T = new StringBuilder();
		for (int i = 0; i < S.length(); i ++){
			
			if((i==0||i%(LoopNumber)!=0)&&i!=S.length()-1){

				T.append(S.charAt(i));
				
			}
			else{
				if(i==0&&i!=S.length()-1){
					continue;
				}
				if(i==S.length()-1)T.append(S.charAt(i));
				if(T.length()<2*N-2){
					T.setLength(2*N-2);					
				}
				T.insert(N, " ");
				T.append(" ");
				//TODO
				//make last string lenth = 2n;
				
				lst.add(T.toString());
				T.setLength(0);
				T.append(S.charAt(i));
			}
		}
		
		//
		T.setLength(0);
		for(int i = 0; i < N; i++){
			
			if (i==0 || i ==N-1){
				for(int j = 0; j < lst.size(); j++){
					T.append(lst.get(j).charAt(i));
				}
			}else{
				for(int j = 0; j < lst.size(); j++){
					T.append(lst.get(j).charAt(i));
					T.append(lst.get(j).charAt(i+N));
				}
			}
			res.add(T.toString().trim());
			T.setLength(0);
		}
		
		T.setLength(0);
		for (String s : res){
			T.append(s);
		}
		
		
		return T.toString().trim();
	}
	
	public static void main(String[] args){
		Q006 instance = new Q006();
		String res = instance.SL("ABCDE", 3);
		
		System.out.print(res);
		//PAHNAPLSIIGYIR
		//PAHNAPLSIIGYIR
		//PAHNASLSISGSYIR
		//PAHNPAHNASLSIS
	}
}
