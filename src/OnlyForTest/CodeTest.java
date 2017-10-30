package OnlyForTest;

import java.util.Hashtable;

public class CodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("test");
		
		//test: hold all key and value
		Hashtable <String , Integer> test = new Hashtable<String, Integer>();
		
		//put first value
		test.put("1", 1);
		
		//repeat put value, from 0 to 100
		for(int i=0 ; i<100 ; i++){
			test.put(String.valueOf(i), i);
		}
		
		char str = 'a';
		String str2 = "bd";
		System.out.println("a\u0022);
		System.out.println("a\u0022.length()+\u0022b".length());   
		
		//output
		//System.out.println(test.toString());
		//System.out.println(test.size());
		
		
	}
	
	public int lengthOfHashtable(Hashtable H){
		return H.size();
	}


}
