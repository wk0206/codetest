package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class hashTest {
	
	static String test = "s";
	
	public class serializeTest implements  java.io.Serializable{
		public String id;
		
		private serializeTest() {
			this.id= "";
		}
		
		private serializeTest(String id) {
			this.id = id;
		}
	}
	
	static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
	
	
	
	public static void main(String[] args) {
		
		hashTest instance = new hashTest();
		
		serializeTest st = new hashTest().new serializeTest();
		
		String id = st.id;
		st.toString();
		if(st instanceof serializeTest) {
			
		}
		
		//int x = tableSizeFor((int)(Math.pow(2,20)-1));
		int x = tableSizeFor((1<<20)+1);
		
		
		//type Object
		Object o = new Object();
		o.hashCode();
		
		//type String
		test.equals("test");
		test.hashCode();
		
		//type warp Type
		Integer i = 100;
		i.hashCode();
		
		//type int
		int ii = 100;
		//autowarp
		
		Map<String,String> m = new HashMap<>();
		
		Set<String> s = new HashSet<>();
		
		
		Set<String> treeSetTest = new TreeSet<>();
		
		List<String> listTest = new ArrayList<>();
		
	}

}
