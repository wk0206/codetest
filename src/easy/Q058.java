package easy;

public class Q058 {
    public int lengthOfLastWord(String s) {
    	if(s.indexOf(" ")<0)return s.length();
        
    	StringBuilder S = new StringBuilder(s);
    	while(S.charAt(S.length()-1)==' '){
    		//S.deleteCharAt(S.length()-1);
    		S.setLength(S.length()-1);
    	}
    	
    	
    	int lastSpace = S.lastIndexOf(" ");
    	
    	int res = S.length()-lastSpace-1;
    	return res;
    }
    
    
    
    public static void main(String[] args){
    	Q058 instance = new Q058();
    	
    	String s = "a ";
    	int res = instance.lengthOfLastWord(s);
    	
    	System.out.println(res);
    	System.out.println("a".indexOf(" "));
    }
}
