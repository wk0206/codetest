package OnlyForTest;

import java.util.Hashtable;
//import static net.Mildview.util.Range.*;

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
		System.out.println("--------------");
		char str = 'a';
		String str2 = "bd";
		System.out.println("a\u0022);
		System.out.println("a\u0022.length()+\u0022b".length());   
		
		System.out.println("--------------");
		String S = "test";
		System.out.println("T".codePointAt(0));
		System.out.println("t".codePointAt(0));
		System.out.println(S.compareTo("tesT"));
		System.out.println(S.compareToIgnoreCase("TEST"));
		
		System.out.println("--------------");
		System.out.println("contentEquals");
		System.out.println(S.contentEquals("test"));
		System.out.println(S.contentEquals("tesT"));
		
		
		System.out.println("--------------");
		for(int i =84 ; i < 116;i++){
//			/int codepoint=Integer.parseInt(yourString.substring(2),16);
			String s = Character.toString((char)i);
			
			System.out.print(s);
			System.out.println(" "+s.hashCode());
		}
		System.out.println("");
		System.out.println("hash code");
		System.out.println("T".hashCode());
		
		//output
		//System.out.println(test.toString());
		//System.out.println(test.size());
		
		
	}
	
	public int lengthOfHashtable(Hashtable H){
		return H.size();
	}


}
