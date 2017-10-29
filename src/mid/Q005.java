package mid;

public class Q005 {

	public String LP(String S){
		
		//input check
		if(S.length()==0)return S;
		if(S.length()==1)return S;
		int start = 0; 
		int end = 0;
		
		//single core
		int resP = 0;
		int resR = 0;
		int P=0, R=0;
		String res = S.substring(0,1);
		
		
		for(int i = 0; i < S.length(); i++){
			while(i-R>=0&&i+R<S.length()){
				if(S.charAt(i-R)!=S.charAt(i+R)){
					if(R-1>resR){
						resP =  i;
						resR = R-1;
					}
					break;
				}else{
					if(R>resR){
						resP =  i;
						resR = R;
					}
					R++;
				}
			}
			R=0;
		}
		start = resP-resR;
		end = resP+resR;
		int len1 = end-start;
		
		//double core
		R=0;
		int core = 0;
		int resR2 =-1;
		for (int i = 0; i < S.length()-1;i++){
			int j = i+1;
			while(i-R>=0&&j+R<S.length()){
				if(S.charAt(i)==S.charAt(j)){
					if(S.charAt(i-R)!=S.charAt(j+R)){
						if(R>resR2){
							core =  i;
							resR2=R-1;
						}
						R=0;
						break;
					}else{
						if(R>resR2){
							core =  i;
							resR2 = R;
						}
						R++;
					}
				}else break;
				
			}
			R=0;
			
		}
		
		int len2 = core+resR2+1-(core-resR2);
		
		if(len1<len2){
			start = core-resR2;
			end = core + 1 + resR2;
		}
		
		res =  S.substring(start, end+1);
		return res;
	}
	
	public static void main(String[] args){
		Q005 instance = new Q005();
		System.out.println(instance.LP("abb"));
		
	}
}
